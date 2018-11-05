package com.jdayssol.tennis.after;

import static java.lang.Math.*;
import com.jdayssol.tennis.tennisgame.TennisGame;

public class TennisGame2 implements TennisGame {
	public int pointP1 = 0;
	public int pointP2 = 0;
	String result = "";
	String resultP2 = "";
	private String player1Name;
	private String player2Name;

	private final static String[] TENNIS_SCORE = { "Love", "Fifteen", "Thirty", "Forty" };

	public TennisGame2(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public String getScore() {
		String score = "";
		if (isScoreEquals()) {
			score = getScoreEquals();
		} else if (isScoreDifferent()) {
			score = getScoreDifferent();
		} else if (isOneScoreIsLove()) {
			score = getScoreWhenOneIsLove();
		} else if (isScoreWinOrAdvantage()) {
			score = getScoreWhenWinOrAdvantage();
		}
		return score;
	}

	private boolean isScoreEquals() {
		return pointP1 == pointP2;
	}
	
	private boolean isScoreDifferent() {
		return pointP1 < 4 && pointP2 < 4 && pointP1 != pointP2;
	}
	
	private boolean isOneScoreIsLove() {
		return ((pointP1 == 0 || pointP2 == 0) && pointP1 < 3 && pointP2 < 3);
	}

	private boolean isScoreWinOrAdvantage() {
		return pointP1 >= 4 || pointP2 >= 4;
	}

	private String getScoreWhenWinOrAdvantage() {
		String score = "";
		int gap = pointP1 - pointP2;
		if (abs(gap) == 1)
			score = "Advantage ";
		if (abs(gap) > 1)
			score = "Win for ";
		if (gap > 0)
			score += player1Name;
		else
			score += player2Name;
		return score;
	}

	private String getScoreWhenOneIsLove() {
		String score = "";
		if (pointP2 == 0) {
			score = TENNIS_SCORE[pointP1] + "-Love";
		} else if (pointP1 == 0) {
			score = "Love-" + TENNIS_SCORE[pointP2];
		}
		return score;
	}

	private String getScoreEquals() {
		return (pointP1 < 3) ? TENNIS_SCORE[pointP1] + "-All" : "Deuce";
	}

	private String getScoreDifferent() {
		return TENNIS_SCORE[pointP1] + "-" + TENNIS_SCORE[pointP2];
	}

	public void wonPoint(String player) {
		if (player.equals(player1Name))
			pointP1++;
		else
			pointP2++;
	}
}