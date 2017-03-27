package cn.zhuangyan.retrofitdemo.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhuangyan.retrofitdemo.R;
import cn.zhuangyan.retrofitdemo.model.LoginReturn;
import cn.zhuangyan.retrofitdemo.model.MailListReturn;
import cn.zhuangyan.retrofitdemo.network.Network;
import cn.zhuangyan.retrofitdemo.utils.ShaPreUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MailListActivity extends BaseActivity {
    private static final String TAG = "MailListActivity";
    private Context context;
    String token = "";
    @Bind(R.id.btn_get)
    Button btnGet;
    @Bind(R.id.tv_keyword)
    TextView tv_keyword;

    @Bind(R.id.msg_list_view)
    ListView mailListViews;
    MailListAdapter mailListAdapter;


    Observer<MailListReturn> observer = new Observer<MailListReturn>() {
        @Override
        public void onCompleted() {
            //Toast.makeText(LoginActivity.this,"onCompleted", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable e) {
            dismissLoadingView();
            Log.i(TAG, "onError: "+e.toString());
            Toast.makeText(MailListActivity.this, "onError:"+e.toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNext(MailListReturn result) {
            dismissLoadingView();
//            Toast.makeText(MailListActivity.this,String.valueOf(result.getCount()), Toast.LENGTH_SHORT).show();
            mailListAdapter.refreshMailLists(result.getResults());
            mailListAdapter.notifyDataSetInvalidated();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);
        context = getApplicationContext();
        token = (String) ShaPreUtils.getParam(getApplicationContext(), "token", "");
        ButterKnife.bind(this);
        mailListAdapter = new MailListAdapter();
        mailListViews.setAdapter(mailListAdapter);

    }

    @OnClick({R.id.btn_get})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                showLoadingView();
                excuteMailList();
                break;

        }
    }

    private void excuteMailList() {
        if(!token.equals("")){
            subscription = Network.getMailListApi()
                    .maillist("JWT "+token, tv_keyword.getText().toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }
    class MailListAdapter extends BaseAdapter {
        List<MailListReturn.ResultsBean> mailLists;

        public MailListAdapter() {
        }

        public void refreshMailLists(List<MailListReturn.ResultsBean> mailLists) {
            Log.d(TAG, "MailListAdapter size():" + mailLists.size());
            this.mailLists = mailLists;
        }

        @Override
        public int getCount() {
            if (mailLists == null) {
                mailLists = new ArrayList<MailListReturn.ResultsBean>();
            }
            return mailLists.size();
        }

        @Override
        public Object getItem(int position) {
            return mailLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            final MailListReturn.ResultsBean bean = this.mailLists.get(position);
            view = LayoutInflater.from(context).inflate(R.layout.activity_maillist_item, null);
            String mobile = bean.getMobile();
            String realname = bean.getRealname();
            TextView maillistNameView = (TextView) view.findViewById(R.id.mail_list_realname);
            TextView maillistMobileView = (TextView) view.findViewById(R.id.mail_list_mobile);
            maillistNameView.setText(realname);
            maillistMobileView.setText(mobile);
            return view;
        }
    }
}
