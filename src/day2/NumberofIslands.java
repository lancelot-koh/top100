package day2;

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int ROW = grid.length;
        int COL = grid[0].length;

        int numIslands = 0;

        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid,r,c);
                }
            }
        }
        return numIslands;
    }

    void dfs(char[][] grid, int r, int c) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (r < 0 || r >= ROW || c < 0 || c >= COL || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
