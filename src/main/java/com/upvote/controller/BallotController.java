package com.upvote.controller;

import com.upvote.dto.BallotListItem;
import com.upvote.service.BallotService;
import com.upvote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ballots")
public class BallotController {

    private BallotService ballotService;
    private UserService userService;

    @Autowired
    public BallotController(BallotService ballotService, UserService userService) {
        this.ballotService = ballotService;
        this.userService = userService;
    }

    /*@GetMapping("/all")
    public List<BallotListItem> getAllBallots() {

    }

    @GetMapping
    public List<BallotListItem> getApprovedBallots() {


    }

    @PutMapping("/{title}")
    public void addVote(@PathVariable String title) {
        ballotService.addVote(title);
    }*/




}
