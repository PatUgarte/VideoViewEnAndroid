package digitalhouse.com.videoview;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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

        ViewPager miViewPager = findViewById(R.id.viewPager);
        TabLayout miTabLayout = findViewById(R.id.TabLayout);

        miViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),this));
        miTabLayout.setupWithViewPager(miViewPager);

    }
}
