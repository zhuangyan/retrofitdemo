package cn.zhuangyan.retrofitdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import cn.zhuangyan.retrofitdemo.R;
import cn.zhuangyan.retrofitdemo.model.LoginBean;
import cn.zhuangyan.retrofitdemo.model.LoginReturn;
import cn.zhuangyan.retrofitdemo.network.Network;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhuangyan.retrofitdemo.utils.ShaPreUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhuangyan.
 */
public class LoginActivity extends BaseActivity {

    @Bind(R.id.edt_email)
    EditText edtEmail;
    @Bind(R.id.edt_password)
    EditText edtPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.tv_response)
    TextView tvResponse;

    Observer<LoginReturn> observer = new Observer<LoginReturn>() {
        @Override
        public void onCompleted() {
            //Toast.makeText(LoginActivity.this,"onCompleted", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable e) {
            dismissLoadingView();
            Toast.makeText(LoginActivity.this, "onError:"+e.toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNext(LoginReturn result) {
            dismissLoadingView();
            if(result.getUser_id()!=""){
                ShaPreUtils.setParam(getApplicationContext(), "token", result.getToken());
                startActivity(new Intent(LoginActivity.this, MailListActivity.class));
            }
        }
    };

    private void login(String email, String password) {
        LoginBean bean = new LoginBean();
        bean.setPassword(password);
        bean.setUsername(email);
        Gson gson=new Gson();
        String loginstr = gson.toJson(bean);
        RequestBody body= RequestBody.create(MediaType.parse("application/json; charset=utf-8"),loginstr);
        subscription = Network.getloginApi()
                .login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                showLoadingView();
                excuteLogin();
                break;
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void excuteLogin() {
        String email = edtEmail.getText().toString().trim();
        String pwd = edtPassword.getText().toString().trim();
        login(email, pwd);
    }
}
