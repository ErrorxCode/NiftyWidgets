package com.easywidgets.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * An extended version {@link ArrayAdapter} used for making custom listviews. You can make 2 types of listview using this adapter.
 * @see R.layout#list
 */
public class ListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private String[] titles;
    private String[] headings;
    private String[] summaries;
    private ArrayList<ListAdapterObject> objects;
    private int[] images;
    private final int LIST;

    /**
     * Creates an adapter with 2 textview, one for heading & another for summery.
     * @param context The context of activity
     * @param line1 The text to set as heading
     * @param line2 The text to set as summery
     */
    public ListAdapter(@NonNull Context context, String[] line1, String[] line2) {
        super(context, android.R.layout.simple_list_item_2);
        this.titles = line1;
        this.headings = line2;
        this.context = context;
        LIST = 0;
    }

    /**
     * Creates an adapter with 3 textview & a imageview, 1st two for title & heading and another one for some meta data. You can pass
     * <code>null</code> if you don't want 3rd textview.
     * @param context The context of activity
     * @param images The image resource id to set as drawableStart or icon.
     * @param titles The text array to set as titles
     * @param headings The text array to set as headings
     * @param meta The text array to set as meta information
     */
    public ListAdapter(@NonNull Context context, int[] images, String[] titles, String[] headings, @Nullable String[] meta){
        super(context,R.layout.list);
        this.titles = titles;
        this.headings = headings;
        this.summaries = meta;
        this.images = images;
        this.context = context;
        LIST = 1;
    }

    /**
     * Creates an adapter with 3 textview & a imageview, 1st two for title & heading and another one for some meta data. You can pass
     * <code>null</code> if you don't want 3rd textview.
     *
     * @param objects A {@link ListAdapterObject} POJO to set parameters of the listview
     */
    public ListAdapter(@NonNull Context context, ArrayList<ListAdapterObject> objects){
        super(context,R.layout.list);
        this.objects = objects;
        this.context = context;
        LIST = 1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (LIST == 0){
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2,parent,false);
            TextView title = view.findViewById(android.R.id.text1);
            TextView heading = view.findViewById(android.R.id.text2);

            title.setText(titles[position]);
            heading.setText(headings[position]);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.list,parent,false);
            TextView title = view.findViewById(R.id.title);
            TextView heading = view.findViewById(R.id.heading);
            TextView summary = view.findViewById(R.id.summery);
            ImageView icon = view.findViewById(R.id.icon);

            if (objects == null){
                title.setText(titles[position]);
                heading.setText(headings[position]);
                summary.setText(summaries != null ? summaries[position] : "");
                icon.setImageResource(images[position]);
            } else {
                ListAdapterObject object = objects.get(position);
                title.setText(object.getTitle());
                heading.setText(object.getHeading());
                summary.setText(object.getSummary() != null ? object.getSummary() : "");
                icon.setImageResource(object.getIcon());
            }
        }
        return view;
    }

    @Override
    public int getCount() {
        return objects != null ? objects.size() : titles.length;
    }
}
