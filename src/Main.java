import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] cells = new char[3][3];
        for (int i = 0; i < 3; i++) {                           //initializing all elements as empty cells
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
        print(cells);
        int a;
        int b;
        boolean flag = true;
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                a = scan.nextInt();
                b = scan.nextInt();
                if (a > 3 || b > 3 || a < 1 || b < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (cells[3 - b][a - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    cells[3 - b][a - 1] = flag ? 'X' : 'O';     //changing the player
                    flag = !flag;
                    print(cells);
                    if (state(cells)) {
                        break;                                  //if someone wins or there is a draw loop breaks
                    }
                }
            } catch (InputMismatchException e) {                //catch an exception when input is not a number
                System.out.println("You should enter only numbers!");
            }
        }
    }

    public static void print(char[][] cells) {                  //function prints gaming table
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean state(char[][] cells) {               //function prints winner's name if there is a winner
        if (Wins(cells, 'X')) {                            //or prints "draw" if no one wins
            System.out.println("X wins");                       //if the game isn't over yet it returns false
            return true;                                        //otherwise returns true
        }
        if (Wins(cells, 'O')) {
            System.out.println("O wins");
            return true;
        }
        if (!hasEmptyCells(cells)) {
            System.out.println("Draw");
            return true;
        }
        return false;

    }
    public static boolean Wins(char[][] cells, char chr) {      //function returns if the given character wins
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == chr && cells[1][i] == chr && cells[2][i] == chr ||
                    cells[i][0] == chr && cells[i][1] == chr && cells[i][2] == chr) {
                return true;
            }
        }
        return cells[0][0] == chr && cells[1][1] == chr && cells[2][2] == chr ||
                cells[0][2] == chr && cells[1][1] == chr && cells[2][0] == chr;
    }

    public static boolean hasEmptyCells(char[][] cells) {       //function returns if there are empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' '){
                    return true;
                }
            }
        }
        return false;
    }
}
