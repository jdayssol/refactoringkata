package com.jdayssol.tennis.after;

import com.jdayssol.tennis.tennisgame.TennisGame;

public class TennisGame3 implements TennisGame {
    
	private int pointP1;
	private int pointP2;
    
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isScoreInferiorOrEqualsToFortyThirty()) {
            final String[] TENNIS_SCORE = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            if(IsScoreAll())
            {
            	return TENNIS_SCORE[pointP1] + "-All";
            }else{
            	return TENNIS_SCORE[pointP1] + "-" + TENNIS_SCORE[pointP2];
            }            
        } else {
            if (IsScoreDeuce())
                return "Deuce";
            else{
            	String leaderName = pointP1 > pointP2 ? player1Name : player2Name;
                int gap = Math.abs(pointP1-pointP2);
                return (gap == 1) ? "Advantage " + leaderName : "Win for " + leaderName;
            } 
        }
    }

	private boolean IsScoreAll() {
		return pointP1 == pointP2 && (pointP1 + pointP2 < 5);
	}
	
	private boolean IsScoreDeuce() {
		return pointP1 == pointP2 && (pointP1 + pointP2 > 5);
	}

	private boolean isScoreInferiorOrEqualsToFortyThirty() {
		return pointP1 < 4 && pointP2 < 4 && (pointP1 + pointP2 < 6);
	}
    
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            pointP1 ++;
        else
            pointP2 ++;
    }

}
