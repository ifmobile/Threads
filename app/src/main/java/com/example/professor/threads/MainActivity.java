package com.example.professor.threads;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtStatus;
    private Button btnProcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtStatus = findViewById(R.id.txtStatus);
        btnProcessar = findViewById(R.id.btnProcessar);

        btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtStatus.setText(R.string.processando);
        executarAlgoDemorado();
        txtStatus.setText(R.string.finalizado);
    }


    private void executarAlgoDemorado() {
        SystemClock.sleep(15000);
    }
}
