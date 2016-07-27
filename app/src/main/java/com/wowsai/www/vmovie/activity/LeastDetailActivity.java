package com.wowsai.www.vmovie.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.bean.LeastDetailEntity;
import com.wowsai.www.vmovie.utils.MyCallback;

import org.xutils.http.RequestParams;
import org.xutils.x;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class LeastDetailActivity extends MyBaseActivity implements View.OnClickListener, View
        .OnTouchListener {

    private static final String TAG = LeastDetailActivity.class.getSimpleName();
    private int h, w;
    private TextView tv_playingTime;
    private SeekBar mSeekBar;
    TextView tv_totalTime;
    ImageView iv_fullScreen;
    LeastDetailEntity.DataBean data;
    ImageView iv_start;
    MediaPlayer mMediaPlayer;

    private String qiniu_url;
    VideoView mVideoView;
    LinearLayout ll_down;

    @Override
    public void initView() {
        setContentView(R.layout.activity_least_detail);
        mVideoView = (VideoView) findViewById(R.id.vedioView);
        Vitamio.isInitialized(this);//初始化
//        MediaController mediaController = new MediaController(this);
//        mVideoView.setMediaController(mediaController);
        tv_playingTime = (TextView) findViewById(R.id.tv_playingTime);
        ll_down = (LinearLayout) findViewById(R.id.ll_leastDetail);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar_leastDetail);
        tv_totalTime = (TextView) findViewById(R.id.tv_totalTime);
        iv_fullScreen = (ImageView) findViewById(R.id.iv_fullScreen);
        iv_start = (ImageView) findViewById(R.id.iv_start);
        tv_playingTime.setVisibility(View.GONE);
        ll_down.setVisibility(View.GONE);
    }

    @Override
    public void loadData() {
        String postid = getIntent().getStringExtra("postid");
        RequestParams requestParams = new RequestParams(com.wowsai.www.vmovie.uri.Uri
                .LEAST_DETAIL_VIEDIO);
        requestParams.addBodyParameter("postid", postid);
        x.http().post(requestParams, new MyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "======onSuccess: ");
                 data = new Gson().fromJson(result, LeastDetailEntity
                        .class).getData();
                qiniu_url = data.getContent().getVideo().get(0).getQiniu_url();
                Log.d(TAG, "======onSuccess: " + qiniu_url);
                mVideoView.setVideoURI(Uri.parse(qiniu_url));
                mVideoView.start();
                String duration =  data.getContent().getVideo().get(0).getDuration();
                duration =  Integer.parseInt(duration)/60+""+Integer.parseInt(duration)%60;
                tv_totalTime.setText(duration);

            }
        });
    }

    @Override
    public void setOnListener() {
        mVideoView.setOnTouchListener(this);
        iv_start.setOnClickListener(this);

    }
    public String long2String(long time){
        String m = "";
        String s = "";
        long mm = time/1000/60;
        if (mm<10){
            m= "0"+mm;
        }
        long ss = time/1000%60 ;
        if(ss<10){
            s = "0"+s;
        }

        return m+":"+s;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_start://开始播放

                break;

        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return false;
    }
}
