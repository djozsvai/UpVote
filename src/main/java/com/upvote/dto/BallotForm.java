package com.upvote.dto;

import com.upvote.domain.User;

public class BallotForm {

    private String title;

    private User creator;

    private String description;

    public BallotForm() {
    }

    public BallotForm(String title, User creator, String description) {
        this.title = title;
        this.creator = creator;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
