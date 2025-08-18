package com.fristandroidproject.qizzz.modelclass;

public class subScreenModel {
    String title , description,category;

    public subScreenModel() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public subScreenModel(String category, String description, String title) {
        this.category = category;
        this.description = description;
        this.title = title;
    }
}
