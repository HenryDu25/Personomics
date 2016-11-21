package com.demo.personomics.personomics;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class Exercise {
    String name;
    int icon;
    String description;

    public Exercise(String name, int icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
