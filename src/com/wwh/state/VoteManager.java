package com.wwh.state;

import java.util.HashMap;
import java.util.Map;
/*
 * 状态模式允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
 * 状态模式用类来代表不同的状态，Context会将行为委托给当前状态
 * 以下的VoteManager就是一个Context，它持有内部状态
 */
public class VoteManager {

	//持有状体处理对象
    private VoteState state = null;
    //记录用户投票的结果
    private Map<String,String> mapVote = new HashMap<String,String>();
    //记录用户投票次数
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();

    VoteState normalVoteState=new NormalVoteState();
    VoteState repeatVoteState=new RepeatVoteState();
    VoteState spiteVoteState=new SpiteVoteState();
    VoteState blackVoteState=new BlackVoteState();
    
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    
    public void vote(String user,String voteItem){
        //为该用户增加投票次数
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //判断该用户的投票类型，就相当于判断对应的状态
        if(oldVoteCount == 1){
            state = normalVoteState;
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = repeatVoteState;
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){
            state = spiteVoteState;
        }
        else if(oldVoteCount > 8){
            state = blackVoteState;
        }
        //然后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }
}
