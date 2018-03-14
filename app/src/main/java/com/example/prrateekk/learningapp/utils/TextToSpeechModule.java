package com.example.prrateekk.learningapp.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

/**
 * Created by prrateekk on 22/1/18.
 */

public class TextToSpeechModule implements TextToSpeech.OnInitListener{
    private String text;
    private TextToSpeech tts;
    private boolean ttsOk;

    public TextToSpeechModule(String txt, Context context) {
        text = txt;
        tts = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            ttsOk = true;
            speakOut();
        }
        else {
            ttsOk = false;
        }
    }

    private void speakOut() {
        Log.i("SPEAK", text);
        if (ttsOk) {
            tts.setSpeechRate((float) 0.7);
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
