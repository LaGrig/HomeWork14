package com.mobile.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity {

    @JsonProperty
    int id;

    @JsonProperty
    String title;

    @JsonProperty
    String dueDate;

    @JsonProperty
    boolean completed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed='" + completed +
                '}';
    }
}
