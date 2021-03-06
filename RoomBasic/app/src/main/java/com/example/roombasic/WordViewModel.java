package com.example.roombasic;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);

    }

    LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }
    void insertWords(Word...words) {
       wordRepository.InsertWords(words);
    }
    void DeleteWords(Word...words) {
        wordRepository.DeleteWords(words);
    }
    void UpdateWords(Word...words) {
        wordRepository.UpdateWords(words);
    }
    void DeleteAllWords() {
        wordRepository.DeleteAllWords();
    }
}
