package day2;

public class WordSearch {
    char[][] board;
    int ROWS;
    int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(this.backtrack(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int row, int col, String word, int index) {
        if(index >= word.length()) {
            return true;
        }

        if (row < 0 || row == ROWS || col < 0 || col == COLS || this.board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean ret = false;
        this.board[row][col] = '#';

        int [] rowOffsets = {0, 1, 0, -1};
        int [] colOffsets = {1, 0, -1, 0};
        for(int d = 0; d < 4; d++) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret) {
                break;
            }
        }

        this.board[row][col] = word.charAt(index);
        return ret;
    }
}
