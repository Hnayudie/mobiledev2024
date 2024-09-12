package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;

import java.nio.BufferUnderflowException;

public class WeatherAndForecastFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.weather_and_forecast_fragment, container, false);
    }

    public static WeatherAndForecastFragment newIstance() {
        WeatherAndForecastFragment frag_layout1 = new WeatherAndForecastFragment();
        return frag_layout1;
    }
}
