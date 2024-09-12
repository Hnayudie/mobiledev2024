package vn.edu.usth.usthweather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;


public class ForecastFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);



        //view.setBackgroundColor(0x2000FF00);



       /* LinearLayout weather = new LinearLayout(getContext());
        weather.setOrientation(LinearLayout.VERTICAL);
        TextView t1 = new TextView(getContext());
        t1.setText("Thursday");
        ImageView i1 = new ImageView(getContext());
        i1.setImageResource(R.drawable.weather_123);

        weather.addView(t1);
        weather.addView(i1);

        return weather;*/
        return view;
    }

    public static ForecastFragment newInstance() {
        ForecastFragment frag_layout3 = new ForecastFragment();
        return frag_layout3;
    }


}