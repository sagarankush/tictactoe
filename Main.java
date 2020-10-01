import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Main game = new Main();
        game.go();
    }

    void go() {
        boolean bool = true;
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        printBoard(board);
        while (bool) {
            board = getInput(board, 'X');
            System.out.println("Input Complete");
            printBoard(board);
            if (checkWin(board, 'X')) {
                System.out.println("X wins");
                break;
            }
            board = getInput(board, 'O');
            printBoard(board);
            if (checkWin(board, 'O')) {
                System.out.println("O wins");
                break;
            }
        }
    }

    boolean checkWin(char[][] board,char player) {
        int winAmount = 3 * player;
        for (int i = 0; i < 3; i++) {
            if(board[i][0] + board[i][1] + board[i][2] == winAmount) {
                return true;
            } else if (board[0][i] + board[1][i] + board[2][i] == winAmount) {
                return true;
            }
        }
        if ((board[0][0] + board[1][1] + board[2][2]) == winAmount || (board[0][2] + board[1][1] + board[2][0]) == winAmount) {
            return true;
        }
        return false;
    }

    char[][] getInput(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        boolean bool = true;
        while (bool) {
            System.out.print("Enter the coordinates: ");
            String userInput = scanner.nextLine();
            String[] inputStrings = userInput.split("\\s");

            try {
                x = Integer.parseInt(inputStrings[0]);
                y = Integer.parseInt(inputStrings[1]);
            } catch (NumberFormatException ex) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (!(x > 0 && x < 4 && y > 0 && y < 4)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (!(board[3-y][x-1] == ' ')) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                board[3-y][x-1] = player;
                break;
            }
        }
        return board;
    }

    void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}