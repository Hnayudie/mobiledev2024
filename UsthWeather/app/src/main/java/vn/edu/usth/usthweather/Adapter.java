package vn.edu.usth.usthweather;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vn.edu.usth.usthweather.ForecastFragment;
import vn.edu.usth.usthweather.WeatherActivity;
import vn.edu.usth.usthweather.WeatherAndForecastFragment;
public class Adapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String[] titles = new String[] {"HaNoi", "Paris", "SaiGon"};

    public Adapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return WeatherFragment.newInstance();
            case 1:
                return ForecastFragment.newInstance();
            case 2:
                return WeatherAndForecastFragment.newIstance();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
