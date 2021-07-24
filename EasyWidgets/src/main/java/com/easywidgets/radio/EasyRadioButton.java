package com.easywidgets.radio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.easywidgets.lists.R;

/**
 * This is an extended version of {@link RadioButton}. This radiobutton include 2 textview, one for title & second for description.
 */
public class EasyRadioButton extends FrameLayout {

    private final Context context;
    private TextView title;
    private TextView description;
    private RadioButton button;
    private FrameLayout layout;
    private boolean isHighlight;

    public EasyRadioButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EasyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.EasyRadioButton);
        setTitle(array.getString(R.styleable.EasyRadioButton_title));
        setDescription(array.getString(R.styleable.EasyRadioButton_description));
        setHidden(array.getBoolean(R.styleable.EasyRadioButton_isButtonHidden,false));
        setRtl(array.getBoolean(R.styleable.EasyRadioButton_isR2L,false));
        array.recycle();
    }

    public EasyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public EasyRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init();
    }

    private void init() {
        inflate(context, R.layout.radio, this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        button = findViewById(R.id.radio);
        layout = findViewById(R.id.root);
    }

    /**
     * Sets the text for second textview of {@link EasyRadioButton}.
     * @param Description The text to set as description
     */
    public void setDescription(String Description) {
        description.setText(Description);
    }

    /**
     * Sets the text for first textview of {@link EasyRadioButton}.
     * @param Title The text to set as title
     */
    public void setTitle(String Title) {
        title.setText(Title);
    }

    /**
     * Define weather the radio button (only check-circle) has to show at right side.
     * @param isRtl <code>true</code> if you want to use rtl layout direction. <code>false</code> otherwise
     */
    public void setRtl(boolean isRtl) {
        button.setLayoutDirection(isRtl ? LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR);
    }

    /**
     * Set the visibility of the radiobutton (check-circle).
     * @param isHidden <code>true</code> if you want to hide it. <code>false</code> otherwise.
     */
    public void setHidden(boolean isHidden) {
        if (isHidden) {
            button.setButtonDrawable(android.R.color.transparent);
        } else {
            button.setButtonTintList(ColorStateList.valueOf(Color.BLACK));
        }
    }

    /**
     * Sets the checked state for the radiobutton.
     * @param isChecked <code>true</code> if checked, <code>false</code> otherwise.
     */
    public void setChecked(boolean isChecked){
        button.setChecked(isChecked);
    }

    @Override
    public void setEnabled(boolean isEnabled){
        button.setEnabled(isEnabled);
    }

    /**
     * @return <code>true</code> if radiobutton is checked, <code>false</code> otherwise.
     */
    public boolean isChecked(){
        return button.isChecked();
    }

    /**
     * Sets the callback which is invoked when the radiobutton get checked or unchecked.
     * @param listener The callback to be registered
     */
    public void setOnCheckChangeListener(CompoundButton.OnCheckedChangeListener listener){
        button.setOnCheckedChangeListener(listener);
    }

    protected RadioButton getRadioButton(){
        return button;
    }

    /**
     * This method should not be used. This will only throw a {@link UnsupportedOperationException}
     */
    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        throw new UnsupportedOperationException("onClick callback is not available right now, It might get fixed in further release. Use OnCheckedChangeListener for now.");
    }

}
