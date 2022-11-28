package com.cs4750.android.truthordrink.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cs4750.android.truthordrink.Question;

@Database(entities = {Question.class}, version = 1)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
    private static QuestionDatabase INSTANCE;

    static QuestionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuestionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            QuestionDatabase.class,
                            "question_table"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
