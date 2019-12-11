package ru.job4j.array;

/**
 * Class MatrixCheck
 *
 * @author Yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

public class MatrixCheck {
    static boolean isWin(char[][] board) {
        boolean result = false;
        int cellWin = 0;
        int countVer = 0;
        for (int row = board.length - 1; row >= 0; row--) {
            int countHor = 0;
            for (int cell = 0; cell < board.length; cell++) {
                if (board[row][cell] == 'X') {
                    countHor++;
                    if (board[row][cell] == board[0][cell]) {
                        cellWin = cell;
                        countVer++;
                    } else if (board[row][cell] == board[row][cellWin]) {
                        countVer++;
                    }
                }
            }
            if (countHor == board.length) {
                result = true;
            }
        }
        if (countVer == board.length) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}