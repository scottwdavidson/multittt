package com.swd.ttt.dao;

import com.swd.ttt.entity.play.Player;

/**
 * Represents the score of the current game in terms of a Players' plusWins.
 */
public class Score {

    private int xWins;
    private int oWins;
    private int cats;

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

    @Override
    public String toString() {
        return "Score{" +
                "xWins=" + xWins +
                ", oWins=" + oWins +
                ", cats=" + cats +
                '}';
    }
}
