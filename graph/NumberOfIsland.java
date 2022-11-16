package graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        int grid[][] = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        int count = findNumberOfIsland(grid);
        System.out.println("Number of Island: "+count);
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findNumberOfIsland(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    count++;
                    System.out.println("here for i="+i+" and j="+j);
                    findNumberOfIslandRec(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void findNumberOfIslandRec(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        if(isValidPosition(grid, i, j-1)) {
            findNumberOfIslandRec(grid, i, j-1);
        }
        if(isValidPosition(grid, i-1, j)) {
            findNumberOfIslandRec(grid, i-1, j);
        }
        if(isValidPosition(grid, i, j+1)) {
            findNumberOfIslandRec(grid, i, j+1);
        }
        if(isValidPosition(grid, i+1, j)) {
            findNumberOfIslandRec(grid, i+1, j);
        }
    }

    private static boolean isValidPosition(int[][] grid, int i, int j) {
        int rows = grid.length, column = grid[0].length;
        if(i<0 || i>=rows || j<0 || j>=column || grid[i][j]==0) {
            return false;
        }
        return true;
    }


    
}
