package com.swd.ttt.entity;

/**
 * Represents the score of the current game in terms of a Players' wins.
 */
public class Score {

    private final int xWins;
    private final int oWins;
    private final int cats;

    public static Score newScore(){
        return new Score(0,0,0);
    }

    public Score plusX(){
        return new Score(xWins + 1, oWins, cats);
    }

    public Score plusO(){
        return new Score(xWins, oWins + 1, cats);
    }

    public Score plusCats(){
        return new Score(xWins , oWins, cats +1);
    }

    public int getxWins() {
        return xWins;
    }

    public int getoWins() {
        return oWins;
    }

    public int getCats() {
        return cats;
    }

    private Score(int xWins, int oWins, int cats) {
        this.xWins = xWins;
        this.oWins = oWins;
        this.cats = cats;
    }


}
