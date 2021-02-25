package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    public Button replay;
    private Button exit;
    private TextView scoretext;
    private TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        replay=(Button)findViewById(R.id.replayButton);
        exit=(Button)findViewById(R.id.exitButton);
         scoretext = (TextView) findViewById(R.id.scoreText);
         score=(TextView)findViewById(R.id.score);
        final String correct=getIntent().getStringExtra("correct");
        score.setText(correct +" /10");
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);

                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(i);
            }
        });

    }
}