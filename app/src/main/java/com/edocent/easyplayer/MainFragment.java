package com.edocent.easyplayer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Button playButton;
    Button stopButton;
    AudioPlayer audioPlayer = new AudioPlayer();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(audioPlayer != null) {
            audioPlayer.stop();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        playButton = (Button) view.findViewById(R.id.playButtonId);
        stopButton = (Button) view.findViewById(R.id.stopButtonId);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioPlayer != null){
                    audioPlayer.play(getActivity());
                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.stop();
            }
        });

        return view;
    }


}
