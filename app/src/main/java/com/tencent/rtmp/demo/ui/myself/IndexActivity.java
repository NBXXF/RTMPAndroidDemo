package com.tencent.rtmp.demo.ui.myself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.tencent.rtmp.demo.R;
import com.tencent.rtmp.demo.ui.MainActivity;

/**
 * Description
 * <p>
 * <p>
 * 推流
 * <p>
 * mob_live_01
 * rtmp://3043.livepush.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a?bizid=3043
 * <p>
 * mob_live_02
 * rtmp://3043.livepush.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a?bizid=3043
 * <p>
 * 拉流
 * <p>
 * mob_live_01
 * http://3043.liveplay.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a.flv
 * http://3043.liveplay.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a_900.flv
 * http://3043.liveplay.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a_550.flv
 * <p>
 * mob_live_02
 * http://3043.liveplay.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a.flv
 * http://3043.liveplay.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a_900.flv
 * http://3043.liveplay.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a_550.flv
 * Company Beijing guokeyuzhou
 * author  youxuan  E-mail:xuanyouwu@163.com
 * date createTime：16/6/27
 * version
 */
public class IndexActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                MainActivity.launch(
                        IndexActivity.this,
                        0,
                        "rtmp://3043.livepush.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a?bizid=3043");
                break;
            case R.id.button2:
                MainActivity.launch(
                        IndexActivity.this,
                        0,
                        "rtmp://3043.livepush.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a?bizid=3043");
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                MainActivity.launch(
                        IndexActivity.this,
                        2,
                        "http://3043.liveplay.myqcloud.com/live/3043_ca271c40310811e6a2cba4dcbef5e35a_550.flv");
                break;
            case R.id.button5:
                MainActivity.launch(
                        IndexActivity.this,
                        2,
                        "http://3043.liveplay.myqcloud.com/live/3043_ed529d823c5c11e6a2cba4dcbef5e35a_550.flv");
                break;
            case R.id.button6:
                break;
        }
    }
}
