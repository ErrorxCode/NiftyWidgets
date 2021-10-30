package com.easywidgets.radio;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.easywidgets.R;

public class EasyRadioUtils {
    private static boolean correct;
    private static boolean wrong;
    private static SoundPool soundPool;
    private static int soundCorrect;
    private static int soundWrong;

    public static void setSoundEffect(RadioGroup group,boolean selection, boolean correct, boolean wrong) {
        EasyRadioUtils.correct = correct;
        EasyRadioUtils.wrong = wrong;
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        int id = soundPool.load(group.getContext(),R.raw.select,1);
        if (correct)
            soundCorrect = soundPool.load(group.getContext(),R.raw.right,1);
        if (wrong)
            soundWrong = soundPool.load(group.getContext(),R.raw.wrong,1);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (selection)
                    soundPool.play(id,1,1,1,0,1);
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static void setWrong(RadioButton button){
        if (wrong)
            soundPool.play(soundWrong,1,1,1,0,1);
        if (button.getTag().equals("classic")){
            button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
        } else if (button.getTag().equals("modern")){
            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke(2,Color.RED);
            button.setBackground(drawable);
        } else
            throw new RuntimeException("Unfortunately, you can't use tag attribute on this radio button");
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static void setCorrect(RadioButton button){
        if (correct)
            soundPool.play(soundCorrect,1,1,1,0,1);
        if (button.getTag().equals("classic")){
            button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF00C308")));
        } else if (button.getTag().equals("modern")) {
            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke(2,Color.parseColor("#FF00C308"));
            button.setBackground(drawable);
        } else
            throw new RuntimeException("Unfortunately, you can't use tag attribute on this radio button");
    }
}
