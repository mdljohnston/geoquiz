package com.bignerd.geoquiz;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

public class GeoQuiz extends Activity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TrueFalseQuestion[] mQuestionBank = new TrueFalseQuestion[]
            {
                    new TrueFalseQuestion(R.string.question1, true),
                    new TrueFalseQuestion(R.string.question2, true),
                    new TrueFalseQuestion(R.string.question3, true),
                    new TrueFalseQuestion(R.string.question4, false)
            };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton = (Button)findViewById(R.id.next_button);
        mQuestionTextView = (TextView)findViewById(R.id.question_test_view);
        mQuestionTextView.setText(mQuestionBank[currentIndex].getQuestion());

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionBank[currentIndex].isTrueQuestion())
                {
                    Toast.makeText(GeoQuiz.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    Log.v("MATT","True pressed: Answer was true");
                }
                else
                {
                    Toast.makeText(GeoQuiz.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    Log.v("MATT","True pressed: Answer was false");

                }
                incrementCounterUpdateQuestion();
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mQuestionBank[currentIndex].isTrueQuestion())
                {
                    Toast.makeText(GeoQuiz.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    Log.v("MATT","False pressed: Answer was false");
                }
                else
                {
                    Toast.makeText(GeoQuiz.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    Log.v("MATT","False pressed: Answer was true");

                }

                incrementCounterUpdateQuestion();

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            incrementCounterUpdateQuestion();
            }
        });
    }

    private void incrementCounterUpdateQuestion()
    {
        GeoQuiz.this.currentIndex ++;
        if (currentIndex >= GeoQuiz.this.mQuestionBank.length)
        {
            currentIndex = 0;
        }

        mQuestionTextView.setText(mQuestionBank[currentIndex].getQuestion());

        Log.v("MATT", "next pressed, new index: "+currentIndex);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.geo_quiz, menu);
        return true;
    }
    
}
