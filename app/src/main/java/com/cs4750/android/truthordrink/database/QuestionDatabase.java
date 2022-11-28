package com.cs4750.android.truthordrink.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cs4750.android.truthordrink.Question;

@Database(entities = {Question.class}, version = 1)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
}
