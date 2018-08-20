package com.swd.ttt.entity.play;

public enum Player {
    X, O, None;

    public Player opponent(){
        if ( this == X ){
            return O;
        }
        else if (this == O ){
            return X;
        }
        else {
            return None;
        }
    }
}
