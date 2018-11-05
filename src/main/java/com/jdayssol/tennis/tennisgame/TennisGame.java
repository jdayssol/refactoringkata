package com.jdayssol.tennis.tennisgame;

public interface TennisGame {
    void wonPoint(String playerName) throws Exception;
    String getScore();
}