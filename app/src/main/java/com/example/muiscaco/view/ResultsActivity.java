package com.example.muiscaco.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.muiscaco.R;

public class ResultsActivity extends AppCompatActivity {
    TextView mGrade, mFinalScore;
    Button mRetryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mFinalScore.setText("Tu puntaje es " + score + " de " + QuizBook.questions.length);

        if (score == 12){
            mGrade.setText("Felicidades has respuesto todo correctamente");
        }else if (score == 11){
            mGrade.setText("Buen trabajo, te falto muy poco para acertar todo");
        }else if (score == 10) {
            mGrade.setText("Gran esfuerzo, estuviste cerca de acertar todo");
        }else {
            mGrade.setText("Por favor te recomiendo que vuelvas a estudiar los textos");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}
