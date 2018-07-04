package com.ptp.phamtanphat.asyntask0405;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnDownload;
    ProgressBar progressBar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDownload = findViewById(R.id.buttonDownload);
        progressBar = findViewById(R.id.progressbar);
        imageView = findViewById(R.id.imageview);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Xulytientrinh().execute();
            }
        });

    }
    class Xulytientrinh extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            btnDownload.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Bat dau down load", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            for (int i = 1 ; i <= 10 ; i++ ){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i * 10);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return R.mipmap.ic_launcher;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(integer);
            Toast.makeText(MainActivity.this, "Down load hoan tat", Toast.LENGTH_SHORT).show();
            super.onPostExecute(integer);
        }
    }
}
