package digitalhouse.com.videoview;


import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    public static final String KEY_TITULO = "titulo";
    public static final String KEY_PATH = "video";
    private String titulo;
    private String path;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        Bundle arguments = getArguments();

        titulo = arguments.getString(KEY_TITULO);
        path = arguments.getString(KEY_PATH);

        final VideoView unVideoView = view.findViewById(R.id.miVideoView);
        final Button botonPlay = view.findViewById(R.id.unBoton);

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
                botonPlay.setBackgroundColor(Color.parseColor("#00BCD4"));
            }
        });

        unVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                botonPlay.setText("REPETIR");
                botonPlay.setBackgroundColor(Color.parseColor("#3F51B5"));
            }
        });

        return view;
    }

    public VideoFragment dameUnFragmento(String titulo, String video){
        VideoFragment videoFragment = new VideoFragment();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITULO,titulo);
        bundle.putString(KEY_PATH,video);

        videoFragment.setArguments(bundle);

        return videoFragment;
    }

    public String getTitulo() {
        return titulo;
    }
}
