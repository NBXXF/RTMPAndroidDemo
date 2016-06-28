package com.tencent.rtmp.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.demo.R;


public class MainActivity extends FragmentActivity implements OnClickListener {

    public static final String key_index = "index";
    public static final String key_url = "url";

    public static void launch(Context context, int index, String url) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(key_index, index);
        intent.putExtra(key_url, url);
        context.startActivity(intent);
    }

    private static final String TAG = MainActivity.class.getSimpleName();

    private LinearLayout mMainTabLayout;
    private TextView mPlayerVodText, mPlayerAliveText, mLivePublisherText;
    private FragmentManager fragmentManager;
    private Fragment mPlayerVodFragment, mPlayerAliveFragment, mPublisherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        init();
    }

    private void init() {
        mMainTabLayout = (LinearLayout) findViewById(R.id.main_tab_layout);
        mPlayerVodText = (TextView) findViewById(R.id.text_play_vod);
        mPlayerAliveText = (TextView) findViewById(R.id.text_play_alive);
        mLivePublisherText = (TextView) findViewById(R.id.text_publish_rtmp);

        mPlayerVodText.setOnClickListener(this);
        mPlayerAliveText.setOnClickListener(this);
        mLivePublisherText.setOnClickListener(this);
        setDefaultFragment();

        EditText urlEdit = (EditText) findViewById(R.id.rtmpUrl);
        urlEdit.setText(getIntent().getStringExtra(key_url));
        int index = 1;
        switch (getIntent().getIntExtra(key_index, 0)) {
            case 0:
                if (mPublisherFragment == null) {
                    mPublisherFragment = new LivePublisherActivity();
                }
                replaceFragment(mPublisherFragment);
                index = 1;
                break;
            case 2:
                if (mPlayerAliveFragment == null) {
                    mPlayerAliveFragment = new LivePlayerActivity();
                    ((LivePlayerActivity) mPlayerAliveFragment).setPlayType(TXLivePlayer.PLAY_TYPE_LIVE_FLV);
                }
                replaceFragment(mPlayerAliveFragment);
                index = 3;
                break;
        }
        setStatus(index);
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mPublisherFragment = new LivePublisherActivity();
        transaction.replace(R.id.content_layout, mPublisherFragment);
        transaction.commit();
    }

    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!newFragment.isAdded()) {
            transaction.replace(R.id.content_layout, newFragment);
            transaction.commit();
        } else {
            transaction.show(newFragment);
        }
    }

    private void setStatus(int index) {
        if (index == 1) {
            mLivePublisherText.setTextColor(Color.rgb(255, 255, 255));
            mPlayerVodText.setTextColor(Color.rgb(0, 0, 0));
            mPlayerAliveText.setTextColor(Color.rgb(0, 0, 0));

            mMainTabLayout.setBackgroundResource(R.drawable.main_tab_1);
        } else if (index == 2) {
            mLivePublisherText.setTextColor(Color.rgb(0, 0, 0));
            mPlayerVodText.setTextColor(Color.rgb(255, 255, 255));
            mPlayerAliveText.setTextColor(Color.rgb(0, 0, 0));

            mMainTabLayout.setBackgroundResource(R.drawable.main_tab_2);
        } else if (index == 3) {
            mLivePublisherText.setTextColor(Color.rgb(0, 0, 0));
            mPlayerVodText.setTextColor(Color.rgb(0, 0, 0));
            mPlayerAliveText.setTextColor(Color.rgb(255, 255, 255));

            mMainTabLayout.setBackgroundResource(R.drawable.main_tab_3);
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        int index = 1;
        switch (v.getId()) {
            case R.id.text_publish_rtmp:
                if (mPublisherFragment == null) {
                    mPublisherFragment = new LivePublisherActivity();
                }
                replaceFragment(mPublisherFragment);
                index = 1;
                break;
            case R.id.text_play_vod:
                if (mPlayerVodFragment == null) {
                    mPlayerVodFragment = new LivePlayerActivity();
                    ((LivePlayerActivity) mPlayerVodFragment).setPlayType(TXLivePlayer.PLAY_TYPE_VOD_FLV);
                }
                replaceFragment(mPlayerVodFragment);
                index = 2;
                break;
            case R.id.text_play_alive:
                if (mPlayerAliveFragment == null) {
                    mPlayerAliveFragment = new LivePlayerActivity();
                    ((LivePlayerActivity) mPlayerAliveFragment).setPlayType(TXLivePlayer.PLAY_TYPE_LIVE_FLV);
                }
                replaceFragment(mPlayerAliveFragment);
                index = 3;
                break;
        }
        setStatus(index);
    }
}
