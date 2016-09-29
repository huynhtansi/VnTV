package com.htsi.vntv;

import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import io.vov.vitamio.LibsChecker;

/**
 * Created by htsi.
 * Since: 9/29/16 on 2:44 PM
 * Project: VnTV
 */

public class PlayerActivity extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {

    private static final String TAG = "MediaPlayerDemo";
    private int mVideoWidth;
    private int mVideoHeight;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    private String path = "http://htvlive.1c656bad.cdnviet.com/3cfb1b74adb5d85dc381e870fd4224101475182068/vtc7.360p.stream/playlist.m3u8";

    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_player);

        mPreview = (SurfaceView)findViewById(R.id.video_surface);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setFormat(PixelFormat.RGBA_8888);
    }

    private void playVideo() throws IOException {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setDataSource(path);
        mMediaPlayer.setDisplay(holder);
        mMediaPlayer.prepareAsync();
        mMediaPlayer.setOnBufferingUpdateListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnVideoSizeChangedListener(this);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    private void startVideoPlayback() {
        Log.v(TAG, "startVideoPlayback");
        holder.setFixedSize(mVideoWidth, mVideoHeight);
        mMediaPlayer.start();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer pMediaPlayer, int pI) {

    }

    @Override
    public void onCompletion(MediaPlayer pMediaPlayer) {

    }

    @Override
    public void onPrepared(MediaPlayer pMediaPlayer) {
        Log.d(TAG, "onPrepared called");
        mIsVideoReadyToBePlayed = true;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer pMediaPlayer, int width, int height) {
        Log.v(TAG, "onVideoSizeChanged called");
        if (width == 0 || height == 0) {
            Log.e(TAG, "invalid video width(" + width + ") or height(" + height + ")");
            return;
        }
        mIsVideoSizeKnown = true;
        mVideoWidth = width;
        mVideoHeight = height;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder pSurfaceHolder) {
        Log.d(TAG, "surfaceCreated called");
        try {
            playVideo();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder pSurfaceHolder, int pI, int pI1, int pI2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder pSurfaceHolder) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
        doCleanUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
        doCleanUp();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void doCleanUp() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        mIsVideoReadyToBePlayed = false;
        mIsVideoSizeKnown = false;
    }
}
