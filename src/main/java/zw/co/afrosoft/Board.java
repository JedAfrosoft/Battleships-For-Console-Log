package zw.co.afrosoft;

public class Board {

    private final char[][] Board= {
            {' ' , 'A' , 'B' , 'C'},
            {'1' , '-' , '-' , '-'},
            {'2' , '-' , '-' , '-'},
            {'3' , '-' , '-' , '-'},
            {'4' , '-' , '-' , '-'}
    };


    public char[][] getBoard() {
        return Board;
    }

}
