package com.example.prrateekk.learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

// Home Activity for Learning App
public class MainActivity extends AppCompatActivity {
    MCQHandler mcqHandler;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcqHandler = new MCQHandler(this);
//        MCQProblem mcqProblem = new MCQProblem();
//        mcqProblem.setId(126);
//        mcqProblem.setStatement("What's up everybody?");
//        String options[] = {"lal", "b", "c"};
//        mcqProblem.setOptions(options);
//        mcqProblem.setCorrectAnswer("a");
//        mcqProblem.setTag("lull");
//        mcqProblem.setLevelDifficulty(101);
//        mcqHandler.insertMCQ(mcqProblem);
//
//        textView = (TextView)findViewById(R.id.textView);
//        textView.setText(mcqHandler.getAllMCQ().get(1).getStatement() + mcqHandler.getAllMCQ().get(1).getTag());
//        textView = (TextView)findViewById(R.id.textView2);
//        textView.setText(mcqHandler.getAllMCQ().get(0).getStatement() + mcqHandler.getAllMCQ().get(0).getTag());

    }

    public void toMCQGameActivity(View view) {
        textView = (TextView)findViewById(R.id.textView2);
        List<MCQProblem> mcqProblemList = mcqHandler.getAllMCQ();
        textView.setText(mcqProblemList.get(0).getStatement() + mcqProblemList.get(0).getTag());

        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("LIST_MCQ", (Serializable) mcqProblemList);
        startActivity(intent);
    }
}
