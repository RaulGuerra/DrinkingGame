package com.cs4750.android.truthordrink.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cs4750.android.truthordrink.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert
    void insertQuestion(Question question);

    @Delete
    void deleteQuestion(Question target);

    @Query("SELECT * FROM question_table WHERE type = :target_type")
    List<Question> getAllQuestionByType(String target_type);
}
