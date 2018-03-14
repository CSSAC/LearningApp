package com.example.prrateekk.learningapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prrateekk.learningapp.utils.TextToSpeechModule;

import java.util.List;

public class GameActivity extends AppCompatActivity {
    private TextToSpeechModule ttsm;
    private static final String DRAWABLE = "drawable/";

    TextView idStatement;
    ImageView idOption1, idOption2, idOption3;
    private Drawable drawable;

    List <MCQProblem> mcqProblemList;
    int mcqCounter;
    String correctImage;

    Animation animationZoomIn;
    Animation animationZoomOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        idStatement = (TextView) findViewById(R.id.idStatement);
        idOption1 = (ImageView) findViewById(R.id.idOption1);
        idOption2 = (ImageView) findViewById(R.id.idOption2);
        idOption3 = (ImageView) findViewById(R.id.idOption3);

        animationZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animationZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);

        Intent intent = getIntent();
        mcqProblemList = (List<MCQProblem>) intent.getSerializableExtra("LIST_MCQ");

        mcqCounter = 0;
        nextMCQ();

        idOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ID", "idOption1");
                idOption1.startAnimation(animationZoomIn);
                idOption1.startAnimation(animationZoomOut);

                idStatement.setText(correctImage + "idOption1");
                if (correctImage=="idOption1") nextMCQ();
            }
        });

        idOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ID", "idOption2");
                idStatement.setText(correctImage + "idOption2");
                if (correctImage=="idOption2") nextMCQ();
            }
        });

        idOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ID", "idOption3");
                idStatement.setText(correctImage + "idOption3");
                if (correctImage=="idOption3") nextMCQ();
            }
        });

    }

    public void nextMCQ() {
        Log.i("TAG", "NEXT MCQ");
        if (mcqCounter<mcqProblemList.size()) {
            Log.i("TAG", "IN RANGE");
            String options[] = mcqProblemList.get(mcqCounter).getOptions();
            String correctAns = mcqProblemList.get(mcqCounter).getCorrectAnswer();
            idStatement.setText(mcqProblemList.get(mcqCounter).getStatement() + correctAns);

            int dr = getResources().getIdentifier(DRAWABLE + options[0], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption1.setImageDrawable(drawable);

            dr = getResources().getIdentifier(DRAWABLE + options[1], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption2.setImageDrawable(drawable);

            dr = getResources().getIdentifier(DRAWABLE + options[2], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption3.setImageDrawable(drawable);

            if (options[0].equals(correctAns)) {
                correctImage = "idOption1";
            }
            else if (options[1].equals(correctAns)) {
                correctImage = "idOption2";
            }
            else if (options[2].equals(correctAns)){
                correctImage = "idOption3";
            }

            idStatement.setText(correctAns + correctImage + " " + options[0] + options[1] + options[2]);

            ttsm = new TextToSpeechModule(mcqProblemList.get(mcqCounter).getStatement(), this);
            mcqCounter++;
        }
    }

    public void nextByButton(View view) {
        Log.i("TAG", "NEXT MCQ");
        if (mcqCounter<mcqProblemList.size()) {
            Log.i("TAG", "IN RANGE");
            String options[] = mcqProblemList.get(mcqCounter).getOptions();
            idStatement.setText(mcqProblemList.get(mcqCounter).getStatement());

            int dr = getResources().getIdentifier(DRAWABLE + options[0], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption1.setImageDrawable(drawable);

            dr = getResources().getIdentifier(DRAWABLE + options[1], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption2.setImageDrawable(drawable);

            dr = getResources().getIdentifier(DRAWABLE + options[2], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            idOption3.setImageDrawable(drawable);

            String correctAns = mcqProblemList.get(mcqCounter).getCorrectAnswer();
            if (options[0]==correctAns) {
                correctImage = "idOption1";
            }
            else if (options[1]==correctAns) {
                correctImage = "idOption2";
            }
            else {
                correctImage = "idOption3";
            }

            ttsm = new TextToSpeechModule(mcqProblemList.get(mcqCounter).getStatement(), this);
            mcqCounter++;
        }
    }
}
