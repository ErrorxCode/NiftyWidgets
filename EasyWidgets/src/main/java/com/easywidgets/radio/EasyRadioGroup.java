package com.easywidgets.radio;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;

/**
 * This is an extended version of {@link RadioGroup}. This group should not be used by any other {@link RadioButton} excepts {@link EasyRadioButton}
 */
public class EasyRadioGroup extends RadioGroup {

    private final ArrayList<EasyRadioButton> buttons;
    private OnCheckedChangeListener listener;
    private boolean isHighlight;

    public EasyRadioGroup(Context context) {
        super(context);
        buttons = new ArrayList<>();
        setOnHierarchyChangeListener(new Listeners());
    }

    public EasyRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        buttons = new ArrayList<>();
        setOnHierarchyChangeListener(new Listeners());
    }


    private void unCheckAllExcept(RadioButton button) {
        for (EasyRadioButton radioButton : buttons) {
            if (radioButton.getRadioButton() != button)
                radioButton.setChecked(false);
        }
    }

    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener){
        this.listener = listener;
    }

    @Override
    public int getCheckedRadioButtonId(){
        for (EasyRadioButton button : buttons){
            if (button.isChecked())
                return button.getId();
        }
        return -1;
    }

    @Override
    public void clearCheck() {
        EasyRadioButton button = findViewById(getCheckedRadioButtonId());
        button.setChecked(false);
    }

    private void setHighlightOnCheckedChange(boolean isHighlighted) {  // Under construction
        isHighlight = isHighlighted;
    }

    private class Listeners implements ViewGroup.OnHierarchyChangeListener, CompoundButton.OnCheckedChangeListener {
        @Override
        public void onChildViewAdded(View parent, View child) {
            if (parent == EasyRadioGroup.this && child instanceof EasyRadioButton){
                EasyRadioButton button = (EasyRadioButton) child;
                buttons.add(button);
                button.setOnCheckChangeListener(this);
            }
        }

        @Override
        public void onChildViewRemoved(View parent, View child) {
            if (parent == EasyRadioGroup.this && child instanceof EasyRadioButton){
                buttons.remove(child);
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                unCheckAllExcept((RadioButton) buttonView);
            if (listener != null && !isChecked || getCheckedRadioButtonId() == -1) {
                listener.onCheckedChanged(EasyRadioGroup.this,getCheckedRadioButtonId());
            }
        }


        private void highlightChecked(int button,int color){  // Under construction
            EasyRadioButton radioButton = findViewById(button);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke(4,color);
            radioButton.setBackground(drawable);
            requestFocus();
            setElevation(10);
        }
    }
}