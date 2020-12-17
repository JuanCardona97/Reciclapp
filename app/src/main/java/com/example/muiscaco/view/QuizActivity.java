package com.example.muiscaco.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muiscaco.R;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private MediaPlayer gano, perdio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);

        gano = MediaPlayer.create(this, R.raw.ganar);
        perdio = MediaPlayer.create(this, R.raw.perder);

        updateQuestion();

        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == true) {
                    mScore++;
                    gano.start();
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        perdio.start();
                        updateQuestion();
                    }
                }
            }
        });

        //Logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == false) {
                    mScore++;
                    gano.start();
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        perdio.start();
                        updateQuestion();
                    }
                }
            }
        });

    }

    private void updateQuestion() {

        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("¿Estas seguro de que quieres volver a empezar el quiz?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
