import java.util.*;

public class TicTacToe{
    private static String[] board;
    private static String turn;

    private static String checkWinner(){
        for (int a = 0; a < 8; a++){
            String line = null;

            switch (a){
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            } //switch case that checks for winning conditions
            
            if (line.equals("XXX")) return "X";
            else if (line.equals("OOO")) return "O";
            //determines whether X or O won
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) break;
            else if (a == 8) return "draw";
        } //checks if the game ended in a draw

        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    } //determines the winner

    private static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                        + board[1] + " | " + board[2]
                        + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                        + board[4] + " | " + board[5]
                        + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                        + board[7] + " | " + board[8]
                        + " |");
        System.out.println("|---|---|---|");
    } //prints the board, shown below
    /* |---|---|---|
    | 1 | 2 | 3 |
    |-----------|
    | 4 | 5 | 6 |
    |-----------|
    | 7 | 8 | 9 |
    |---|---|---|*/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++){
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null){
            int numInput;

            try{
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)){
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            } //try-catch block that checks for an InputMismatchException (if input is not a number between 1-9)

            if (board[numInput - 1].equals(String.valueOf(numInput))){
                board[numInput - 1] = turn;

                if (turn.equals("X")) turn = "O";
                else turn = "X";

                printBoard();
                winner = checkWinner();
            }else System.out.println("Slot already taken; re-enter slot number:"); //handles whether it's player X's or player O's turn
        } //runs while there is no winner

        if (winner.equalsIgnoreCase("draw"))System.out.println("It's a draw! Thanks for playing."); //displays if the game ends in a draw
        else System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing."); //otherwise, the winner is displayed
    in.close();
    }
} //class TicTacToe