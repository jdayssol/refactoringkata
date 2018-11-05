import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jdayssol.tennis.after.TennisGame1;
import com.jdayssol.tennis.after.TennisGame2;
import com.jdayssol.tennis.after.TennisGame3;
import com.jdayssol.tennis.tennisgame.TennisGame;

@RunWith(Parameterized.class)
public class TennisTest {

    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},
                
                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                
                { 0, 3, "Love-Forty"},
                { 4, 0, "Win for Nadal"},
                { 0, 4, "Win for Federer"}, 
                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Win for Nadal"},
                { 1, 4, "Win for Federer"},
                { 3, 2, "Forty-Thirty"},
                
                { 2, 3, "Thirty-Forty"}, 
                { 4, 2, "Win for Nadal"},
                { 2, 4, "Win for Federer"},   
                { 4, 3, "Advantage Nadal"},
                { 3, 4, "Advantage Federer"},
                
                { 5, 4, "Advantage Nadal"},
                { 4, 5, "Advantage Federer"},
                { 15, 14, "Advantage Nadal"},
                { 14, 15, "Advantage Federer"},
                { 6, 4, "Win for Nadal"},
                
                { 4, 6, "Win for Federer"},
                { 16, 14, "Win for Nadal"},
                { 14, 16, "Win for Federer"},
        });
    }

    public void checkAllScores(TennisGame game) throws Exception {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint("Nadal");
            if (i < this.player2Score)
                game.wonPoint("Federer");
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() throws Exception {
        TennisGame1 game = new TennisGame1("Nadal", "Federer");
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame2() throws Exception {
        TennisGame2 game = new TennisGame2("Nadal", "Federer");
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame3() throws Exception {
        TennisGame3 game = new TennisGame3("Nadal", "Federer");
        checkAllScores(game);
    }
    
    @Test(expected=Exception.class)
    public void wrongPlayerName() throws Exception {
    	TennisGame1 game = new TennisGame1("Nadal", "Federer");
    	game.wonPoint("Tst");
    }

}
