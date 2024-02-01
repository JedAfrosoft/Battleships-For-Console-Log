package zw.co.afrosoft;

public class Player2 extends GameSetup{

    public char[][] player2Board= {
            {' ' , 'A' , 'B' , 'C'},
            {'1' , '-' , '-' , '-'},
            {'2' , '-' , '-' , '-'},
            {'3' , '-' , '-' , '-'},
            {'4' , '-' , '-' , '-'}
    };

    public char[][] player2Ships= {
            {' ' , 'A' , 'B' , 'C'},
            {'1' , '-' , '-' , '-'},
            {'2' , '-' , '-' , '-'},
            {'3' , '-' , '-' , '-'},
            {'4' , '-' , '-' , '-'}
    };

    public char[][] getPlayer2Board() {
        return player2Board;
    }

    public void setPlayer2Board(char[][] player2Board) {
        this.player2Board = player2Board;
    }

    public char[][] getPlayer2Ships() {
        return player2Ships;
    }

    public void setPlayer2Ships(char[][] player2Ships) {
        this.player2Ships = player2Ships;
    }
}
