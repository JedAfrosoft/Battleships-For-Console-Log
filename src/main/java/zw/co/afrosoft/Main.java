package zw.co.afrosoft;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creating instances
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        GameSetup gameSetup = new GameSetup();

        //Storing 2D arrays with ships and boards to be edited during gameplay
        char[][] player1Ships= player1.getPlayer1Ships();
        char[][] player1Board= player1.getPlayer1Board();
        char[][] player2Ships= player2.getPlayer2Ships();
        char[][] player2Board= player2.getPlayer2Board();


        /*This asks the players to place their ships and store them in their respective 2D arrays
        * The players input are returned here as a 3D array and then separated into their respective 2D arrays*/
        char [][][] shipsInputted=gameSetup.startGame(player1Ships,player2Ships);

        player1Ships=shipsInputted[0];
        player2Ships=shipsInputted[1];



        //It will run the gameplay code and store the winner here
        String winner= gameSetup.gameplay(player1Ships,player2Ships,player1Board,player2Board);


        System.out.println("The winner of the game is: " + winner);
        System.out.println("Congratulations!!!!!!!");


    }
}