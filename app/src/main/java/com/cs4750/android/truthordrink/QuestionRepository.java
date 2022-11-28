package com.cs4750.android.truthordrink;

import android.app.Application;

import com.cs4750.android.truthordrink.database.QuestionDao;
import com.cs4750.android.truthordrink.database.QuestionDatabase;

import java.util.List;

public class QuestionRepository {

    private QuestionDao questionDao;
    private QuestionDatabase db;

    public QuestionRepository(Application application) {
        db = QuestionDatabase.getDatabase(application);
        questionDao = db.questionDao();
    }

    void insertQuestion(Question question) {
        db.questionDao().insertQuestion(question);
    }

    void deleteQuestion(Question target) {
        db.questionDao().deleteQuestion(target);
    }

    List<Question> getAllQuestionByType(String target_type) {
        return db.questionDao().getAllQuestionByType(target_type);
    }

}
