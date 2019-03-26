package com.upvote.controller;

import com.upvote.dto.BallotForm;
import com.upvote.dto.BallotListItem;
import com.upvote.service.BallotService;
import com.upvote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping("/pending")
    public List<BallotListItem> getPendingBallots() {
        return ballotService.listPendingBallots();
    }

    @GetMapping
    public List<BallotListItem> getApprovedBallots() {
        return ballotService.listApprovedBallots();
    }

    @PostMapping
    public ResponseEntity createBallot(@RequestBody BallotForm ballotForm, Principal principal) {
        ballotService.createBallot(ballotForm, principal.getName());
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{title}")
    public ResponseEntity addVote(@PathVariable String title) {
        ballotService.addVote(title);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/approved/{title}")
    public ResponseEntity approveBallot(@PathVariable String title) {
        ballotService.approveBallot(title);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity removeBallot(@PathVariable String title) {
        ballotService.removeBallot(title);
        return new ResponseEntity(HttpStatus.OK);
    }


}
