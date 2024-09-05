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

        ImageButton button1 = view.findViewById(R.id.button1);
        ImageButton button2 = view.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });


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


}