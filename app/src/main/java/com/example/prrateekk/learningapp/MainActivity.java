package com.example.prrateekk.learningapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MCQHandler mcqHandler;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcqHandler = new MCQHandler(this);
//        MCQProblem mcqProblem = new MCQProblem();
//        mcqProblem.setId(121);
//        mcqProblem.setStatement("What's up everybody?");
//        String options[] = {"a", "b", "c"};
//        mcqProblem.setOptions(options);
//        mcqProblem.setCorrectAnswer("a");
//        mcqProblem.setTag("lolswami");
//        mcqProblem.setLevelDifficulty(101);
//        mcqHandler.insertMCQ(mcqProblem);
//
        textView = (TextView)findViewById(R.id.textView);
        textView.setText(mcqHandler.getAllMCQ().get(1).getStatement() + mcqHandler.getAllMCQ().get(1).getTag());
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText(mcqHandler.getAllMCQ().get(0).getStatement() + mcqHandler.getAllMCQ().get(0).getTag());


    }
}
