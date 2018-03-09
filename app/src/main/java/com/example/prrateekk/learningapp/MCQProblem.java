package com.example.prrateekk.learningapp;

import java.io.Serializable;

/**
 * Created by prrateekk on 8/3/18.
 */

// POJO for MCQ Type Quiz

public class MCQProblem implements Serializable{
    private int id;
    private String statement;
    private String options[];
    private String correctAnswer;
    private String tag;
    private int levelDifficulty;

    public MCQProblem() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return this.statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String[] getOptions() {
        return this.options;
    }

    public void setOptions(String options[])  {
        this.options = options.clone();
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLevelDifficulty() {
        return this.levelDifficulty;
    }

    public void setLevelDifficulty(int levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }
}
