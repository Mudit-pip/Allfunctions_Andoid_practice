package com.practice.Hardware;


import android.os.Bundle;

import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.R;


public class G15_TextToSpeech extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech tts;
    Button btnSpeak;
    EditText txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g15__text_to_speech);

        tts = new TextToSpeech(this, this);

        btnSpeak = findViewById(R.id.G15_btn_Speak);
        txtText = findViewById(R.id.G15_txtText);

        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);        //////////////////
                speakOut();
            }

        } else {
            Toast.makeText(this, "Initilization Failed!", Toast.LENGTH_SHORT).show();
        }

    }

    private void speakOut() {
        String text = txtText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}