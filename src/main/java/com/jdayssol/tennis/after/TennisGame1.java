package com.jdayssol.tennis.after;

import com.jdayssol.tennis.tennisgame.TennisGame;

public class TennisGame1 implements TennisGame {

	private int score1 = 0;
	private int score2 = 0;
	
	private String p1Name;
	private String p2Name;

	private final static String[] TENNIS_SCORE = { "Love", "Fifteen", "Thirty", "Forty" };
	private final static String[] TENNIS_EQUALS_SCORE = { "Love-All", "Fifteen-All", "Thirty-All", "Deuce" };

	public TennisGame1(String player1Name, String player2Name) {
		this.p1Name = player1Name;
		this.p2Name = player2Name;
	}

	public void wonPoint(String playerName) throws Exception {
		if (playerName.equals(p1Name))
			score1++;
		else if (playerName.equals(p2Name))
			score2++;
		else
			throw new Exception("Wrong player name");
	}

	public String getScore() {
		if (score1 == score2) {
			return getScoreWhenEquals();
		} else if (score1 >= 4 || score2 >= 4) {
			return getScoreWhenAdvOrWin();
		} else {
			return getScoreWhenDifferent();
		}
	}

	private String getScoreWhenDifferent() {
		return TENNIS_SCORE[score1] + "-" + TENNIS_SCORE[score2];
	}

	private String getScoreWhenAdvOrWin() {
		String score;
		int gap = score1 - score2;
		if (gap == 1)
			score = advantageFor(p1Name);
		else if (gap == -1) {
			score = advantageFor(p2Name);
		} else if (gap >= 2)
			score = winFor(p1Name);
		else {
			score = winFor(p2Name);
		}
		return score;
	}

	private String winFor(String leading) {
		return "Win for " + leading;
	}

	private String advantageFor(String leading) {
		return "Advantage " + leading;
	}

	private String getScoreWhenEquals() {
		// score1 = (score1 > 3)? 3 : score1;
		if (score1 > 3)
			score1 = 3;
		return TENNIS_EQUALS_SCORE[score1];
	}
}
