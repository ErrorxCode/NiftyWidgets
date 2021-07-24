package com.easywidgets.spinners;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.easywidgets.lists.R;

/**
 * An extended version of {@link ArrayAdapter} used to make custom spinner with {@link ImageView} & 2 {@link TextView}. This should not be used for simple spinner.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private final String[] titles;
    private String[] descriptions;
    private int[] icons;
    private final Context context;
    boolean isSimple;

    /**
     * Creates an adapter with 2 textview, one for title & another for description.
     * @param context The context of the activity
     * @param titles The text to set as title
     * @param descriptions The text to set as description
     */
    public SpinnerAdapter(@NonNull Context context,String[] titles,String[] descriptions) {
        super(context, R.layout.spinner);
        this.descriptions = descriptions;
        this.titles = titles;
        this.context = context;
        isSimple = true;
    }


    /**
     * Creates an adapter with a {@link ImageView} & {@link TextView}.
     * @param context The context of the activity
     * @param titles The text to set as title
     * @param icons The image resourceId to set as icon.
     */
    public SpinnerAdapter(@NonNull Context context,String[] titles,int[] icons) {
        super(context,R.layout.spinner_icon);
        this.titles = titles;
        this.context = context;
        this.icons = icons;
        isSimple = false;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,parent);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    private View init(int position, @NonNull ViewGroup parent){
        View view;
        if (isSimple){
            view = LayoutInflater.from(context).inflate(R.layout.spinner,parent,false);
            TextView heading = view.findViewById(R.id.heading);
            TextView description = view.findViewById(R.id.title);

            heading.setText(titles[position]);
            description.setText(descriptions[position]);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.spinner_icon,parent,false);
            TextView heading = view.findViewById(R.id.text);
            ImageView icon = view.findViewById(R.id.icon);

            heading.setText(titles[position]);
            icon.setImageResource(icons[position]);
        }
        return view;
    }
}
