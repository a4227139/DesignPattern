package com.wwh.state;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {

	//持有状体处理对象
    private VoteState state = null;
    //记录用户投票的结果
    private Map<String,String> mapVote = new HashMap<String,String>();
    //记录用户投票次数
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }
    
    public void vote(String user,String voteItem){
        //1.为该用户增加投票次数
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //2.判断该用户的投票类型，就相当于判断对应的状态
        if(oldVoteCount == 1){
            state = new NormalVoteState();
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = new RepeatVoteState();
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){
            state = new SpiteVoteState();
        }
        else if(oldVoteCount > 8){
            state = new BlackVoteState();
        }
        //然后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }
}
