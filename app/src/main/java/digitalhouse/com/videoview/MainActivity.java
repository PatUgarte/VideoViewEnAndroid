package digitalhouse.com.videoview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView unVideoView = findViewById(R.id.miVideoView);
        final Button botonPlay = findViewById(R.id.unBoton);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.caida;
        unVideoView.setVideoURI(Uri.parse(path));

        botonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(unVideoView.isPlaying()){
                    unVideoView.pause();
                    botonPlay.setText("PLAY");
                }else{
                    unVideoView.start();
                    botonPlay.setText("PAUSE");
                }
            }
        });

        unVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                botonPlay.setText("REPETIR");
            }
        });
    }
}
