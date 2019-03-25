package com.upvote.service;

import com.upvote.domain.Ballot;
import com.upvote.domain.User;
import com.upvote.dto.BallotForm;
import com.upvote.repository.BallotRepository;
import com.upvote.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BallotService {

    private static final Logger logger = LoggerFactory.getLogger(BallotService.class);

    private BallotRepository ballotRepo;
    private UserRepository userRepo;

    @Autowired
    public BallotService(BallotRepository ballotRepo, UserRepository userRepo) {
        this.ballotRepo = ballotRepo;
        this.userRepo = userRepo;
    }

    public void createBallot(BallotForm ballotForm, String creatorName) {
        Ballot ballot = new Ballot();
        User user = userRepo.getByName(creatorName);
        ballot.setCreator(user);
        ballot.setDescription(ballotForm.getDescription());
        ballot.setTitle(ballotForm.getTitle());

        ballotRepo.save(ballot);
    }

    public void addVote(String title) {
        Ballot ballot = ballotRepo.getByTitle(title);
        ballot.addVote();
    }

    public void approveBallot(String title) {
        Ballot ballot = ballotRepo.getByTitle(title);
        ballot.approve();
    }

    public void removeBallot(String title) {
        Ballot ballot = ballotRepo.getByTitle(title);
        ballotRepo.delete(ballot);
    }
}