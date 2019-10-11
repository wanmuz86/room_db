package com.itrainasia.roomwordssample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        editText = findViewById(R.id.nameEditText);
    }

    public void buttonPressed(View view) {

        Intent intent = new Intent();
        intent.putExtra("result",editText.getText().toString());
        setResult(1,intent);
        finish();

    }
}
