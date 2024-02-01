package zw.co.afrosoft;
import java.util.Scanner;
public class GameSetup {


    public char[][][] startGame(char[][] player1, char[][] player2) {

            char[][] displayBoard= {
                    {' ' , 'A' , 'B' , 'C'},
                    {'1' , '-' , '-' , '-'},
                    {'2' , '-' , '-' , '-'},
                    {'3' , '-' , '-' , '-'},
                    {'4' , '-' , '-' , '-'}
            };


            int columnA=1;
            int columnB=2;
            int columnC=3;

            System.out.println("Welcome to the game of Battleships");
            System.out.println("Here is what the board looks like: ");
            System.out.println();

            //Printing the DisplayBoard
            for (int i=0;i<5;i++)
            {
                for (int j=0;j<4;j++)
                {
                    System.out.print(displayBoard[i][j] + " ");
                }

                System.out.println();
            }

            //Skipping a line
            System.out.println();

            System.out.println("When you shoot a spot with no ship, you will be shown a blank space.\n" +
                    "When you shoot a spot with a ship, you will be shown an X. ");

            //Skipping a line
            System.out.println();


            //Player 1 Initialization
            for(int i=1;i<=3;i++)
               {
                   Scanner scanner=new Scanner(System.in);

                   //Obtaining column letter
                   System.out.println(); //Skipping a line
                   System.out.println("Player 1, Please enter the coordinates of ship " + i + ":");
                   System.out.println("Column: ");
                   String input1Column=scanner.nextLine();
                   input1Column= input1Column.toUpperCase();

                   //Error check to make sure the set column letters are picked
                   while(!input1Column.equals("A") && !input1Column.equals("B") && !input1Column.equals("C"))
                   {
                       System.out.println("That column doesn't exist!\nPlease re-input a valid column letter");
                       System.out.println("Column: ");
                       input1Column=scanner.nextLine();
                       input1Column= input1Column.toUpperCase();
                   }

                   //Changing column input into integer
                   int ship1Column=0;

                   switch (input1Column)
                   {
                       case "A": ship1Column=columnA; break;
                       case "B": ship1Column=columnB; break;
                       case "C": ship1Column=columnC; break;
                   }

                   //Obtaining row number
                   System.out.println("Row: ");
                   int ship1Row=scanner.nextInt();
                   scanner.nextLine();  //For clearing scanner

                   //Error check to make sure the set row numbers are picked. It's not working though
                   while(ship1Row<1 || ship1Row>4)
                   {
                       System.out.println("That row doesn't exist!\nPlease re-input a valid row number");
                       System.out.println("Row: ");
                       ship1Row=scanner.nextInt();
                       scanner.nextLine();  //For clearing scanner
                   }


                   //Placing the ship on the board
                   if(player1[ship1Row][ship1Column]=='X')
                       {
                           System.out.println("There is a ship there already!");
                           i--;
                       }

                   else{
                           player1[ship1Row][ship1Column]='X';
                       }


               }

            //Skipping some lines to hide player 1 inputs from player 2
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


            //Player 2 Initialization
            for(int i=1;i<=3;i++)
            {
                Scanner scanner=new Scanner(System.in);

                System.out.println("Player 2, Please enter the coordinates of ship " + i + ":");
                System.out.println("Column: ");
                String input1Column=scanner.nextLine();
                input1Column=input1Column.toUpperCase();

                //Error check to make sure the set column letters are picked
                while(!input1Column.equals("A") && !input1Column.equals("B")&& !input1Column.equals("C") )
                {
                    System.out.println("That column doesn't exist!\nPlease re-input a valid column letter");
                    System.out.println("Column: ");
                    input1Column=scanner.nextLine();
                    input1Column= input1Column.toUpperCase();
                }

                //Changing column input into integer
                int ship1Column=0;

                switch (input1Column)
                {
                    case "A": ship1Column=columnA; break;
                    case "B": ship1Column=columnB; break;
                    case "C": ship1Column=columnC; break;
                }

                //Obtaining row number
                System.out.println("Row: ");
                int ship1Row=scanner.nextInt();
                scanner.nextLine();  //For clearing scanner

                //Error check to make sure the set row numbers are picked
                while(ship1Row<1 || ship1Row>4)
                {
                    System.out.println("That row doesn't exist!\nPlease re-input a valid row number");
                    System.out.println("Row: ");
                    ship1Row=scanner.nextInt();
                    scanner.nextLine();  //For clearing scanner
                }


                //Placing the ship on the board
                if(player2[ship1Row][ship1Column]=='X')
                    {
                        System.out.println("There is a ship there already!");
                        i--;
                    }

                else{
                        player2[ship1Row][ship1Column]='X';
                    }

            }

            //Skipping a line
            System.out.println();

            System.out.println("The Game Is Now Beginning!");

            //Skipping a line
            System.out.println();
            
            char[][][] result= {player1,player2};
            return result;

        }


    public String winCondition(char[][] player1Board, char[][] player2Board) {

        //These are local variables which will be used to check of any player has destroyed all of the opponent's ships
        int player1ShipsDestroyed=0;
        int player2ShipsDestroyed=0;
        boolean didPlayer1Win= false;
        boolean didPlayer2Win= false;

        //Code to search through the player1 board
        for (int i=0;i<5;i++)
        {
            for (int j=0;j<4;j++)
            {
                if (player1Board[i][j]=='X')
                {
                    player1ShipsDestroyed++;
                }
            }

        }

        //Code to check if player2 won
        if(player1ShipsDestroyed == 3)
        {
            didPlayer2Win=true;
        }


        //Code to search through the player2 board
        for (int i=0;i<5;i++)
        {
            for (int j=0;j<4;j++)
            {
                if (player2Board[i][j]=='X')
                {
                    player2ShipsDestroyed++;
                }
            }

        }

        //Code to check if player 2 won
        if(player2ShipsDestroyed == 3)
        {
            didPlayer1Win=true;
        }

        //Checking if anyone won
        String winner="None";

        if(didPlayer1Win)
        {
            winner="Player 1";
        }
        else if (didPlayer2Win)
        {
            winner="Player 2";
        }

        return winner;
    }

    //There is a problem with playerTurn method. It also needs to return the boards so that they update
    //Problem is the player turn is a string whilst the boards are 2d character arrays
    public char[][][] playerTurn(char[][] player1Ships, char[][] player2Ships, char[][] player1Board, char[][] player2Board, char[][] turn){

        Scanner scanner=new Scanner(System.in);
        int columnA=1;
        int columnB=2;
        int columnC=3;
        char[][] whosTurn=turn;
        char[][] whosBoardWasChanged=new char[1][1];
        char[][] selectedPlayerBoard = new char[5][4];
        char[][] selectedPlayerShip= new char [5][4];
        String playerWhoIsShooting="";

        //Setting up a conditional statement that changes the board selected depending on who's turn it is
        if (whosTurn[0][0] == 'O')
           {
               selectedPlayerBoard=player2Board;
               selectedPlayerShip=player2Ships;
               playerWhoIsShooting="Player 1";
               whosBoardWasChanged[0][0]='T';
           }
        else if (whosTurn[0][0] == 'T')
                {
                    selectedPlayerBoard=player1Board;
                    selectedPlayerShip=player1Ships;
                    playerWhoIsShooting="Player 2";
                    whosBoardWasChanged[0][0]='O';
                }

        //Print Player Board
        for (int i=0;i<5;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.print(selectedPlayerBoard[i][j] + " ");
            }
            System.out.println();
        }


        //Obtaining column letter
        System.out.println(playerWhoIsShooting + ", please pick a coordinate to shoot: ");
        System.out.println("Column: ");
        String inputColumn=scanner.nextLine();
        inputColumn= inputColumn.toUpperCase();

        //Error check to make sure the set column letters are picked
        while(!inputColumn.equals("A") && !inputColumn.equals("B") && !inputColumn.equals("C"))
        {
            System.out.println("That column doesn't exist!\nPlease re-input a valid column letter");
            System.out.println("Column: ");
            inputColumn=scanner.nextLine();
            inputColumn= inputColumn.toUpperCase();
        }

        //Changing column input into integer
        int shipColumn=0;

        switch (inputColumn)
        {
            case "A": shipColumn=columnA; break;
            case "B": shipColumn=columnB; break;
            case "C": shipColumn=columnC; break;
        }

        //Obtaining row number
        System.out.println("Row: ");
        int shipRow=scanner.nextInt();
        scanner.nextLine();  //For clearing scanner

        //Error check to make sure the set row numbers are picked. It's not working though
        while(shipRow<1 || shipRow>4)
        {
            System.out.println("That row doesn't exist!\nPlease re-input a valid row number");
            System.out.println("Row: ");
            shipRow=scanner.nextInt();
            scanner.nextLine();  //For clearing scanner
        }

        if(selectedPlayerShip[shipRow][shipColumn] == 'X')
        {
            selectedPlayerBoard[shipRow][shipColumn]='X';
            System.out.println("It's a direct hit!!!!");
            System.out.println(); //Skipping a line
        }
        else
        {
            selectedPlayerBoard[shipRow][shipColumn]=' ';
            System.out.println("It's a miss");
            System.out.println(); //Skipping a line
            //If statement changes the turn
            if (whosTurn[0][0] == 'O')
            {
                whosTurn[0][0]='T';
            }
            else if (whosTurn[0][0] == 'T')
            {
                whosTurn[0][0]='O';
            }
        }

        char[][][] boardsAndTurn={selectedPlayerBoard,whosTurn,whosBoardWasChanged};

        return boardsAndTurn;
    }


    public String gameplay(char[][] player1Ships, char[][] player2Ships, char[][] player1Board, char[][] player2Board) {

            /*'O' represents Player 1, 'T' represents Player 2
            * It's like that because I was having trouble returning 3 values of different data types
            * If it were only 2 values of different data types it would have been easier by using the Pair tool */
            char[][] whosTurnIsIt=new char[1][1];
            whosTurnIsIt[0][0]='O';
            String finalWinner="None";
            char[][][] turnAndBoards;
            char[][] whosBoardWasChanged=new char[1][1];
            char[][] changedBoard=new char[5][4];

            //Loop for the game
            while(finalWinner.equals("None"))
            {
                //Checking if anyone won
                finalWinner=winCondition(player1Board,player2Board);
                if(finalWinner.equals("Player 1"))
                {
                    return "Player 1";
                }
                else if (finalWinner.equals("Player 2"))
                {
                    return "Player 2";
                }


                //Turn sequence
                //The first turn will go to player one
                turnAndBoards=playerTurn(player1Ships,player2Ships,player1Board,player2Board,whosTurnIsIt);

                changedBoard=turnAndBoards[0];
                whosTurnIsIt=turnAndBoards[1];
                whosBoardWasChanged=turnAndBoards[2];


                if (whosTurnIsIt[0][0] == 'O')
                {
                    changedBoard=player1Board;
                }
                else if (whosTurnIsIt[0][0] == 'T')
                {
                    whosTurnIsIt[0][0]='T';
                    changedBoard=player2Board;
                }

            }


                return finalWinner;

        }
}
