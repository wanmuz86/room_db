package com.itrainasia.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;


    private LiveData<List<Word>> mAllWords;


    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word,Void,Void>{

        private WordDao mWordDao;

        insertAsyncTask(WordDao wordDao){
            this.mWordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.insert(words[0]);
            return null;
        }
    }

}
