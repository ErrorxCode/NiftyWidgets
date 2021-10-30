package com.easywidgets.lists;

import android.widget.Button;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EasyListObject {
    private String title;
    private String heading;
    private String summary;
    private int menu;
    private OnListMenuClickListener listener;
    private int icon;
    private int LIST;


    public EasyListObject(int icon, @NonNull String title, @NonNull String heading, @Nullable String summary){
        this.title = title;
        this.heading = heading;
        this.summary = summary;
        this.icon = icon;
        LIST = 1;
    }


    public EasyListObject(@NonNull String title, @NonNull String heading,@MenuRes int menuId, @Nullable OnListMenuClickListener listener){
        this.title = title;
        this.heading = heading;
        this.menu = menuId;
        this.listener = listener;
        LIST = 2;
    }


    public EasyListObject(){}  // Requires an empty constructor, in case if you are using firebase database.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public @Nullable String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public OnListMenuClickListener getListener() {
        return listener;
    }

    public void setListener(OnListMenuClickListener listener) {
        this.listener = listener;
    }

    public int getLIST() {
        return LIST;
    }
}
