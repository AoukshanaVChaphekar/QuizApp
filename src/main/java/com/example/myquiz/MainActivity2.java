package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public  int correct=0;
    public int checked;
    private RadioButton radioButtonT;
    private RadioButton radioButtonF;
    private TextView question;
    private ImageButton nextButton;
    private TextView questionNo;
    public int currntQIndex=0;
    private ImageButton prevButton;
    private RadioGroup radioGroup;
    private Question[] questions=new Question[]
            {
                    new Question(R.string.q1,true),
                    new Question(R.string.q2,false),
                    new Question(R.string.q3,true),
                    new Question(R.string.q4,false),
                    new Question(R.string.q5,false),
                    new Question(R.string.q6,false),
                    new Question(R.string.q7,true),
                    new Question(R.string.q8,true),
                    new Question(R.string.q9,true),
                    new Question(R.string.q10,true)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonT=(RadioButton)findViewById(R.id.RbuttonT);
        radioButtonF=(RadioButton)findViewById(R.id.RbuttonF);
        question=(TextView)findViewById(R.id.q1);
        nextButton= (ImageButton) findViewById(R.id.next);
        prevButton=(ImageButton)findViewById(R.id.prev);
        questionNo=(TextView)findViewById(R.id.question_1);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
    }
    public void next(View v)
    {

        if(!radioButtonT.isChecked() && !radioButtonF.isChecked())
            Toast.makeText(this, "Select any one option", Toast.LENGTH_SHORT).show();
        else {
            check(v);
            currntQIndex++;

            if (currntQIndex >= questions.length) {
                Toast.makeText(this, "Last question", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("correct",String.valueOf(correct));
                startActivity(intent);
            }
            else {
                questionNo.setText("Question " + (currntQIndex + 1));
                question.setText(questions[currntQIndex].getAnswerResId());
            }

        }
    }
    public void prev(View v)
    {
        currntQIndex--;
        correct--;
        if (currntQIndex <0) {
            Toast.makeText(this, "Last q", Toast.LENGTH_SHORT).show();
        }
        else {
            questionNo.setText("Question " + (currntQIndex+1));
            question.setText(questions[currntQIndex].getAnswerResId());
        }
    }
    public void check(View view) {
        if(!radioButtonT.isChecked() && !radioButtonF.isChecked())
            Toast.makeText(this, "Select any one option", Toast.LENGTH_SHORT).show();
        else if(currntQIndex>=0 && currntQIndex<questions.length) {
            if (questions[currntQIndex].isAnswerTrue() == radioButtonT.isChecked()) {
                correct++;
            }

        }
        else
        {
            if(currntQIndex<0) {
                currntQIndex = 0;
                check(view);
            }
            else{
                currntQIndex=questions.length-1;
                check(view);
            }
        }

    }
}
