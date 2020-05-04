package com.example.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDatabase wordDatabase;
    WordDao wordDao;
    Button buttonInsert, buttonUpdate, buttonClear, buttonDelete;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_database")
                       .allowMainThreadQueries().build();
        wordDao = wordDatabase.getWordDao();
        textView = findViewById(R.id.textView);
        updateView();

        buttonInsert =findViewById(R.id.buttonInsert);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello","你好");
                Word word2 = new Word("World","世界");
                wordDao.insertWords(word1,word2);
                updateView();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWords();
                updateView();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Word word = new Word("Hi","你好");
               word.setId(40);
               wordDao.updateWords(word);
               updateView();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hello","world");
                word.setId(40);
                wordDao.deleteWords(word);
                updateView();
            }
        });
    }

    void updateView(){
        List<Word> list = wordDao.getAllWords();
        String text = "";
        for(int i = 0;i<list.size();i++) {
            Word word = list.get(i);
            text += word.getId() + ":" +word.getWords() + "=" + word.getChineseMeaning()+ "\n";
        }
        textView.setText(text);
    }
}
