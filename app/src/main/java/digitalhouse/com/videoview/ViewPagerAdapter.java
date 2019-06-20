package digitalhouse.com.videoview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<VideoFragment> listaDeFragmentos = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        VideoFragment videoFragment = new VideoFragment();
        listaDeFragmentos.add(videoFragment.dameUnFragmento("Local","android.resource://" + context.getPackageName() + "/" + R.raw.caida    ));
        listaDeFragmentos.add(videoFragment.dameUnFragmento("Internet","http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"));
    }

    @Override
    public Fragment getItem(int i) {
        return listaDeFragmentos.get(i);
    }

    @Override
    public int getCount() {
        return listaDeFragmentos.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaDeFragmentos.get(position).getArguments().getString(VideoFragment.KEY_TITULO);
    }
}
