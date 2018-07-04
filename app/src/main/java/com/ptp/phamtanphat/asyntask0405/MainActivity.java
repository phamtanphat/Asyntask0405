package com.ptp.phamtanphat.asyntask0405;

import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtKetqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKetqua = findViewById(R.id.textviewKetqua);

        txtKetqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AnonymousClass
                new Xuly().execute();
            }
        });
    }
    class Xuly extends AsyncTask<Void,String,String>{

        //param : Tham so truyen vao de xu ly logic
        //progress : Tham so cap nhat len cho giao dien
        //result : Tham so tra ve sau khi su ly xong logic

        @Override
        protected void onPreExecute() {
            txtKetqua.setText("Bat dau cong viec");
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 1 ; i<=3 ; i++ ){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("\n" + "Cong viec " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ket thuc";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txtKetqua.append(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            txtKetqua.append("\n" + s);
            super.onPostExecute(s);
        }
    }
}
