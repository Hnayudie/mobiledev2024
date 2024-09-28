package vn.edu.usth.usthweather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import android.media.MediaPlayer;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "Weather Activity";
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "onCreate: ");

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewpager);
        PagerAdapter adapter = new Adapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Copy audio file to internal storage
        copyAudioFile();

        // Initialize and start MediaPlayer
        initializeMediaPlayer();
    }

    private void copyAudioFile() {
        try (InputStream inputStream = getResources().openRawResource(R.raw.audio);
             OutputStream outputStream = new FileOutputStream(new File(getFilesDir(), "audio.mp3"))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error copying media file", e);
        }
    }

    private void initializeMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(new File(getFilesDir(), "audio.mp3").getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.e(TAG, "Error playing media file", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.pref_activity) {
            Intent intent = new Intent(WeatherActivity.this, PrefActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.refresh) {
            // Use AsyncTask to simulate network request
            new RefreshData().execute("Simulating network refresh...");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class RefreshData extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(WeatherActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(1000); // Simulate work (1 second for each task)
                    publishProgress(i * 20); // Simulate progress (20%, 40%, 60%, ...)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Return a result to onPostExecute
            return "Data refreshed successfully!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Toast.makeText(WeatherActivity.this, "Progress: " + values[0] + "%", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }




    /*@Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }*/
}