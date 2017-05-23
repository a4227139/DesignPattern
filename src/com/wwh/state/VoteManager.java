package com.wwh.state;

import java.util.HashMap;
import java.util.Map;
/*
 * ״̬ģʽ����������ڲ�״̬�ı�ʱ�ı�������Ϊ���������������޸��������ࡣ
 * ״̬ģʽ����������ͬ��״̬��Context�Ὣ��Ϊί�и���ǰ״̬
 * ���µ�VoteManager����һ��Context���������ڲ�״̬
 */
public class VoteManager {

	//����״�崦�����
    private VoteState state = null;
    //��¼�û�ͶƱ�Ľ��
    private Map<String,String> mapVote = new HashMap<String,String>();
    //��¼�û�ͶƱ����
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();

    VoteState normalVoteState=new NormalVoteState();
    VoteState repeatVoteState=new RepeatVoteState();
    VoteState spiteVoteState=new SpiteVoteState();
    VoteState blackVoteState=new BlackVoteState();
    
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    
    public void vote(String user,String voteItem){
        //Ϊ���û�����ͶƱ����
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //�жϸ��û���ͶƱ���ͣ����൱���ж϶�Ӧ��״̬
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
        //Ȼ��ת��״̬������������Ӧ�Ĳ���
        state.vote(user, voteItem, this);
    }
}
