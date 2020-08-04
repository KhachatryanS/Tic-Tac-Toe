import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
        print(cells);
//        System.out.println(state(cells));
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
                    cells[3 - b][a - 1] = 'X';
                    print(cells);
                    if (state(cells)) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter only numbers!");
            }
        }
    }

    public static void print(char[][] cells) {
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

    public static boolean state(char[][] cells) {
        if (Wins(cells, 'X')) {
            System.out.println("X wins");
            return true;
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
    public static boolean Wins(char[][] cells, char chr) {
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == chr && cells[1][i] == chr && cells[2][i] == chr ||
                    cells[i][0] == chr && cells[i][1] == chr && cells[i][2] == chr) {
                return true;
            }
        }
        return cells[0][0] == chr && cells[1][1] == chr && cells[2][2] == chr ||
                cells[0][2] == chr && cells[1][1] == chr && cells[2][0] == chr;
    }

    public static boolean hasEmptyCells(char[][] cells) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' '){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean possibility(char[][] cells) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 'X') {
                    countX++;
                } else if (cells[i][j] == 'O') {
                    countO++;
                }
            }
        }
        return Math.abs(countX - countO) == 1 || Math.abs(countX - countO) == 0;
    }
}
