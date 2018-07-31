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

    public Score plus(Player player){
        if(player == Player.X){
            return plusX();
        }
        else if (player == Player.O){
            return plusO();
        }
        else {
            return plusCats();
        }
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

    public boolean gameIsOver(){
        return (this.xWins + this.oWins + this.cats) == 9;
    }

    public Player winningPlayer(){
        if(!gameIsOver()){
            throw new IllegalStateException("Asking for a winning player when the game is not yet over!");
        }
        if(this.xWins > this.oWins){
            return Player.X;
        }
        else if (this.oWins > this.xWins){
            return Player.O;
        }
        else {
            return Player.None;
        }
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

    @Override
    public String toString() {
        return "Score{" +
                "xWins=" + xWins +
                ", oWins=" + oWins +
                ", cats=" + cats +
                '}';
    }

    private Score(int xWins, int oWins, int cats) {
        this.xWins = xWins;
        this.oWins = oWins;
        this.cats = cats;
    }


}
