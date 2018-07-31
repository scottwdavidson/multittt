package com.swd.ttt.resources;

/**
 * Represents the score of the current game in terms of a Players' plusWins.
 */
public class Score {

    private  int xWins;
    private  int oWins;
    private  int cats;

    public static Score newScore(int xWins, int oWins, int cats){

        Score newScore = new Score();
        newScore.setxWins(xWins);
        newScore.setoWins(oWins);
        newScore.setCats(cats);
        return newScore;
    }

    public int getxWins() {
        return xWins;
    }

    public void setxWins(int xWins) {
        this.xWins = xWins;
    }

    public int getoWins() {
        return oWins;
    }

    public void setoWins(int oWins) {
        this.oWins = oWins;
    }

    public int getCats() {
        return cats;
    }

    public void setCats(int cats) {
        this.cats = cats;
    }
}
