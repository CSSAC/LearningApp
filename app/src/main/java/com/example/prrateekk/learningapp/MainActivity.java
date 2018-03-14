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
//        mcqProblem.setId(3);
//        mcqProblem.setStatement("select blue");
//        String options[] = {"pink_splatter", "blue_splatter", "orange_splatter"};
//        mcqProblem.setOptions(options);
//        mcqProblem.setCorrectAnswer("blue_splatter");
//        mcqProblem.setTag("colour");
//        mcqProblem.setLevelDifficulty(1);
//        mcqHandler.insertMCQ(mcqProblem);

//
//        textView = (TextVlaliew)findViewById(R.id.textView);
//        textView.setText(mcqHandler.getAllMCQ().get(1).getStatement() + mcqHandler.getAllMCQ().get(1).getTag());
//        textView = (TextView)findViewById(R.id.textView2);
//        textView.setText(mcqHandler.getAllMCQ().get(0).getStatement() + mcqHandler.getAllMCQ().get(0).getTag());

    }

    public void toMCQGameActivity(View view) {
        textView = (TextView)findViewById(R.id.textView2);
        List<MCQProblem> mcqProblemList = mcqHandler.getAllMCQ();
        textView.setText(Integer.toString(mcqProblemList.size()));
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("LIST_MCQ", (Serializable) mcqProblemList);
        startActivity(intent);
    }
}
