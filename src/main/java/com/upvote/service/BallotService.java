package com.upvote.service;

import com.upvote.domain.Ballot;
import com.upvote.domain.User;
import com.upvote.dto.BallotForm;
import com.upvote.dto.BallotListItem;
import com.upvote.repository.BallotRepository;
import com.upvote.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        logger.info("############ one vote added #############");
        ballotRepo.save(ballot);
    }

    public void approveBallot(String title) {
        Ballot ballot = ballotRepo.getByTitle(title);
        ballot.approve();
    }

    public void removeBallot(String title) {
        Ballot ballot = ballotRepo.getByTitle(title);
        ballotRepo.delete(ballot);
    }

    public List<BallotListItem> listPendingBallots() {
        List pendingBallots = ballotRepo.getUnapprovedBallots();
        return getBallotListItems(pendingBallots);
    }

    private List<BallotListItem> getBallotListItems(List allBallots) {
        List<BallotListItem> result = new ArrayList<>();
        for (Object b : allBallots) {
            Ballot ballot = (Ballot) b;
            BallotListItem ballotListItem = new BallotListItem();
            ballotListItem.setCreator(ballot.getCreator().getName());
            ballotListItem.setTitle(ballot.getTitle());
            ballotListItem.setDescription(ballot.getDescription());
            ballotListItem.setVotes(ballot.getVotes());

            result.add(ballotListItem);
        }
        return result;
    }

    public List<BallotListItem> listApprovedBallots() {
        List allBallots = ballotRepo.getApprovedBallots();
        return getBallotListItems(allBallots);
    }
}