package com.easywidgets.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.easywidgets.R;

import java.util.ArrayList;

/**
 * An extended version {@link ArrayAdapter} used for making custom listviews. You can make 2 types of listview using this adapter.
 * @see R.layout#list
 */
public class EasyListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private String[] titles;
    private String[] metadata;
    private String[] description;
    private ArrayList<EasyListObject> objects;
    private int[] images;
    private int menu;
    private OnListMenuClickListener listener;
    private final int LIST;

    /**
     * Creates an adapter with 2 textview, one for heading & another for summery.
     * @param context The context of activity
     * @param titles The text to set as title
     * @param description The text to set as description
     */
    public EasyListAdapter(@NonNull Context context, String[] titles, String[] description) {
        super(context, android.R.layout.simple_list_item_2);
        this.titles = titles;
        this.description = description;
        this.context = context;
        LIST = 0;
    }

    /**
     * Creates an adapter with 3 textview & a imageview, 1st two for title & heading and another one for some meta data. You can pass
     * <code>null</code> if you don't want 3rd textview.
     * @param context The context of activity
     * @param images The image resource id to set as drawableStart or icon.
     * @param titles The text array to set as titles
     * @param description The text array to set as description
     * @param meta The text array to set as meta information
     */
    public EasyListAdapter(@NonNull Context context, String[] titles, String[] description, int[] images, @Nullable String[] meta){
        super(context,R.layout.list);
        this.titles = titles;
        this.metadata = meta;
        this.description = description;
        this.images = images;
        this.context = context;
        LIST = 1;
    }

    /**
     * Creates an adapter through object. The {@link EasyListObject} constructors arguments determines the type of list
     * @param objects A {@link EasyListObject} POJO to set parameters of the listview
     */
    public EasyListAdapter(@NonNull Context context, ArrayList<EasyListObject> objects){
        super(context,R.layout.list);
        this.objects = objects;
        this.context = context;
        LIST = objects.get(0).getLIST();
    }

    /**
     * Creates an adapter with 2 textview & a view at the right. The view can be button or an image view denoting menu options.
     * @param context The context of activity
     * @param menu The menu to show as more option of the item
     * @param titles The text array to set as titles
     * @param description The text array to set as headings
     * @param listener The callback on menu item click
     */
    public EasyListAdapter(@NonNull Context context, String[] titles, String[] description, @MenuRes int menu, @NonNull OnListMenuClickListener listener){
        super(context,R.layout.list);
        this.titles = titles;
        this.description = description;
        this.context = context;
        this.listener = listener;
        this.menu = menu;
        LIST = 2;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (LIST == 0) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
            TextView title = view.findViewById(android.R.id.text1);
            TextView heading = view.findViewById(android.R.id.text2);

            title.setText(titles[position]);
            heading.setText(description[position]);
        } else if (LIST == 1){
            view = LayoutInflater.from(context).inflate(R.layout.list,parent,false);
            TextView title = view.findViewById(R.id.title);
            TextView heading = view.findViewById(R.id.heading);
            TextView summary = view.findViewById(R.id.summery);
            ImageView icon = view.findViewById(R.id.icon);

            if (objects == null){
                title.setText(titles[position]);
                heading.setText(description[position]);
                summary.setText(metadata != null ? metadata[position] : "");
                icon.setImageResource(images[position]);
            } else {
                EasyListObject object = objects.get(position);
                title.setText(object.getTitle());
                heading.setText(object.getHeading());
                summary.setText(object.getSummary() != null ? object.getSummary() : "");
                icon.setImageResource(object.getIcon());
            }
        } else if (LIST == 2){
            view = LayoutInflater.from(context).inflate(R.layout.list_meta,parent, false);
            TextView title = view.findViewById(R.id.title);
            TextView heading = view.findViewById(R.id.heading);
            ImageView more = view.findViewById(R.id.menu);
            PopupMenu menu = new PopupMenu(context,more);
            menu.inflate(this.menu);
            menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    listener.onMenuItemClick(item.getItemId(),position);
                    return true;
                }
            });
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menu.show();
                }
            });
            if (objects == null){
                title.setText(titles[position]);
                heading.setText(description[position]);
            } else {
                EasyListObject object = objects.get(position);
                title.setText(object.getTitle());
                heading.setText(object.getHeading());
            }
        } else {
            throw new IllegalStateException("Impossible without using reflection !");
        }
        return view;
    }

    @Override
    public int getCount() {
        return objects != null ? objects.size() : titles.length;
    }
}
