package com.upvote.dto;

import com.upvote.domain.Ballot;

public class BallotListItem {

    private String title;

    private String creator;

    private String description;

    private Integer votes;

    public BallotListItem() {
    }

    public BallotListItem(Ballot ballot) {
        this.title = ballot.getTitle();
        this.creator = ballot.getCreator().getName();
        this.description = ballot.getDescription();
        this.votes = ballot.getVotes();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}