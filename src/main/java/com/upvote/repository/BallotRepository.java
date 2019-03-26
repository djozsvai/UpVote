package com.upvote.repository;

import com.upvote.domain.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallotRepository extends JpaRepository<Ballot, Long> {

    @Query("SELECT b FROM Ballot b WHERE b.isApproved = true")
    List<Ballot> getApprovedBallots();

    @Query("SELECT b FROM Ballot b WHERE b.isApproved = false")
    List<Ballot> getUnapprovedBallots();

    @Query("SELECT b FROM Ballot b WHERE b.title = ?1")
    Ballot getByTitle(String title);
}
