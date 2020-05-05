package com.example.roombasic;

import android.content.Context;
import android.os.AsyncTask;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {
    private LiveData<List<Word>>allWordsLive;
    private WordDao wordDao;

    WordRepository(Context context) {
        WordDatabase wordDatabase = WordDatabase.getDatabase(context.getApplicationContext());
        wordDao = wordDatabase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    void insertWords(Word...words) {
        new InsertAsyncTask(wordDao).execute(words);
    }
    void DeleteWords(Word...words) {
        new DeleteAsyncTask(wordDao).execute(words);
    }
    void UpdateWords(Word...words) {
        new UpdateAsyncTask(wordDao).execute(words);
    }
    void DeleteAllWords() {
        new DeleteAllAsyncTask(wordDao).execute();
    }

    LiveData<List<Word>>getAllWordsLive() {
        return  allWordsLive;
    }


    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }


        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }

        /*@Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }*/

        /*@Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }*/

        /*@Override
        protected void onPreExecute() {
            super.onPreExecute();
        }*/
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }


        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }

    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }


        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }

    }


    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao wordDao;

        DeleteAllAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
