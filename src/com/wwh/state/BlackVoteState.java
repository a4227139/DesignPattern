package com.wwh.state;

public class BlackVoteState implements VoteState{

	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("You have entered the blacklist");
    }
}
