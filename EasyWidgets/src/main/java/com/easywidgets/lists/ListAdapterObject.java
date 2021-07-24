package com.easywidgets.lists;

import androidx.annotation.Nullable;

public class ListAdapterObject {

    private String title;
    private String heading;
    private String summary;
    private int icon;

    public ListAdapterObject(int icon, String title, String heading, @Nullable String summary){
        this.title = title;
        this.heading = heading;
        this.summary = summary;
        this.icon = icon;
    }

    public ListAdapterObject(){}  // Requires an empty constructor, in case if you are using firebase database.

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
}
