package com.example.prrateekk.learningapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GameActivity extends AppCompatActivity {
    List <MCQProblem> mcqProblemList;
    private static final String DRAWABLE = "drawable/";
    TextView textView;
    ImageView imageView;
    private Drawable drawable;
    private int dr;
    int mcqCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = (TextView) findViewById(R.id.textView3);
        imageView = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        mcqProblemList = (List<MCQProblem>) intent.getSerializableExtra("LIST_MCQ");
        //MCQ SHOULD NOT BE EMPTY - NULL PTR EXCEPTION
        mcqCounter = 1;
        textView.setText(mcqProblemList.get(0).getStatement() + mcqProblemList.get(0).getTag());
        String options[] = mcqProblemList.get(0).getOptions();
        dr = getResources().getIdentifier(DRAWABLE + options[0], null, getPackageName());
        drawable = getResources().getDrawable(dr);
        imageView.setImageDrawable(drawable);
    }

    public void nextMCQ(View view) {
        Log.i("TAG", "NEXT MCQ");
        if (mcqCounter<mcqProblemList.size()) {
            Log.i("TAG", "IN RANGE");
            String options[] = mcqProblemList.get(mcqCounter).getOptions();
            textView.setText(mcqProblemList.get(mcqCounter).getStatement() + mcqProblemList.get(mcqCounter).getTag() + options[0]);
            dr = getResources().getIdentifier(DRAWABLE + options[0], null, getPackageName());
            drawable = getResources().getDrawable(dr);
            imageView.setImageDrawable(drawable);
            mcqCounter++;
        }
    }
}
