package com.edocent.easyplayer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by SRIVASTAVAA on 11/10/2015.
 */
public class AudioPlayer {

    MediaPlayer mediaPlayer;

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mediaPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mediaPlayer.start();
    }

    public void pause(){
        if(mediaPlayer !=  null) {
            mediaPlayer.pause();
        }
    }
}
