package com.itrainasia.roomwordssample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        WordRoomDatabase.class,"word_database")
                        .fallbackToDestructiveMigration()
                        .build();


            }
        }
        return INSTANCE;
    }


}
