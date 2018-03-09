package com.example.prrateekk.learningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prrateekk on 8/3/18.
 */

public class MCQHandler extends SQLiteAssetHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mcqManagerDB.db";

    private static final String MCQ_TABLE = "mcqProblem";

    private static final String MCQ_ID = "id";
    private static final String MCQ_STATEMENT = "statement";
    private static final String MCQ_OPTION1 = "option1";
    private static final String MCQ_OPTION2 = "option2";
    private static final String MCQ_OPTION3 = "option3";
    private static final String MCQ_CORRECT_ANSWER = "correctAnswer";
    private static final String MCQ_TAG = "tag";
    private static final String MCQ__LEVEL_DIFFICULTY = "levelDifficulty";

    public MCQHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MCQ_TABLE);
        onCreate(sqLiteDatabase);
    }

//    Change super class to SQLiteOpenHelper to run non-Asset DB and uncomment below to create DB
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        try {
//            String CREATE_USER_TABLE = "CREATE TABLE " + MCQ_TABLE + "("
//                    + MCQ_ID + " INTEGER PRIMARY KEY, "
//                    + MCQ_STATEMENT + " TEXT, "
//                    + MCQ_OPTION1 + " TEXT, "
//                    + MCQ_OPTION2 + " TEXT, "
//                    + MCQ_OPTION3 + " TEXT, "
//                    + MCQ_CORRECT_ANSWER + " TEXT, "
//                    + MCQ_TAG + " TEXT, "
//                    + MCQ__LEVEL_DIFFICULTY + " INT );";
//            sqLiteDatabase.execSQL(CREATE_USER_TABLE);
//        }
//        catch (Exception e) {
//
//        }
//    }

    // CRUD

    void insertMCQ(MCQProblem mcq) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MCQ_ID, mcq.getId());
        values.put(MCQ_STATEMENT, mcq.getStatement());
        values.put(MCQ_OPTION1, mcq.getOptions()[0]);
        values.put(MCQ_OPTION2, mcq.getOptions()[1]);
        values.put(MCQ_OPTION3, mcq.getOptions()[2]);
        values.put(MCQ_CORRECT_ANSWER, mcq.getCorrectAnswer());
        values.put(MCQ_TAG, mcq.getTag());
        values.put(MCQ__LEVEL_DIFFICULTY, mcq.getLevelDifficulty());

        sqLiteDatabase.insert(MCQ_TABLE, null, values);

        sqLiteDatabase.close();
    }

    public List<MCQProblem> getAllMCQ() {
        List<MCQProblem> listMCQ = new ArrayList<MCQProblem>();

        String SELECT_QUERY = "SELECT * from " + MCQ_TABLE;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                MCQProblem mcq= new MCQProblem();

                mcq.setId(Integer.parseInt(cursor.getString(0)));
                mcq.setStatement(cursor.getString(1));

                String options[] = new String[3];
                options[0] = cursor.getString(2);
                options[1] = cursor.getString(3);
                options[2] = cursor.getString(4);
                mcq.setOptions(options);

                mcq.setCorrectAnswer(cursor.getString(5));
                mcq.setTag(cursor.getString(6));
                mcq.setLevelDifficulty(Integer.parseInt(cursor.getString(7)));

                listMCQ.add(mcq);
            } while (cursor.moveToNext());
        }
        return listMCQ;
    }
}
