package com.upvote.domain;

import com.upvote.dto.BallotForm;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ballot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer votes = 0;

    private String description;

    private boolean isApproved = false;

    @ManyToOne
    private User creator;

    public Ballot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVotes() {
        return votes;
    }

    public void addVote() {
        System.out.println("########## number of votes before: " + this.votes);
        this.votes += 1;
        System.out.println("########## number of votes after: " + this.votes);

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approve() {
        this.isApproved = true;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ballot ballot = (Ballot) o;
        return isApproved == ballot.isApproved &&
                Objects.equals(id, ballot.id) &&
                Objects.equals(votes, ballot.votes) &&
                Objects.equals(description, ballot.description) &&
                Objects.equals(creator, ballot.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, votes, description, isApproved, creator);
    }

    @Override
    public String toString() {
        return "Ballot{" +
                "id=" + id +
                ", votes=" + votes +
                ", description='" + description + '\'' +
                ", isApproved=" + isApproved +
                ", creator=" + creator +
                '}';
    }
}
