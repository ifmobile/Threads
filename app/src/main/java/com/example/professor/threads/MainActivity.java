package com.example.professor.threads;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtStatus;
    private Button btnProcessar;
    private ProgressBar pgbProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtStatus = findViewById(R.id.txtStatus);
        btnProcessar = findViewById(R.id.btnProcessar);
        pgbProgresso = findViewById(R.id.pgbProgresso);

        btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //txtStatus.setText(R.string.processando);
        btnProcessar.setEnabled(false);
        pgbProgresso.setVisibility(View.VISIBLE);
        txtStatus.setVisibility(View.INVISIBLE);
        executarAlgoDemorado();
        //txtStatus.setText(R.string.finalizado);
    }


    private void executarAlgoDemorado() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(15000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pgbProgresso.setVisibility(View.INVISIBLE);
                        btnProcessar.setEnabled(true);
                        txtStatus.setText(R.string.finalizado);
                        txtStatus.setVisibility(View.VISIBLE);
                    }
                });

            }
        }).start();
    }
}
