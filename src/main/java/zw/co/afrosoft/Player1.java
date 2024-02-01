package zw.co.afrosoft;

public class Player1 extends GameSetup{

    public char[][] player1Board= {
            {' ' , 'A' , 'B' , 'C'},
            {'1' , '-' , '-' , '-'},
            {'2' , '-' , '-' , '-'},
            {'3' , '-' , '-' , '-'},
            {'4' , '-' , '-' , '-'}
    };

    public char[][] player1Ships= {
            {' ' , 'A' , 'B' , 'C'},
            {'1' , '-' , '-' , '-'},
            {'2' , '-' , '-' , '-'},
            {'3' , '-' , '-' , '-'},
            {'4' , '-' , '-' , '-'}
    };

    public char[][] getPlayer1Board() {
        return player1Board;
    }

    public void setPlayer1Board(char[][] player1Board) {
        this.player1Board = player1Board;
    }

    public char[][] getPlayer1Ships() {
        return player1Ships;
    }

    public void setPlayer1Ships(char[][] player1Ships) {
        this.player1Ships = player1Ships;
    }


}
