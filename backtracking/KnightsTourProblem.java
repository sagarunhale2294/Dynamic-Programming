package backtracking;

public class KnightsTourProblem {
    public static void main(String[] args) {
        int r = 0, c = 0;
        int chess[][] = new int[8][8];
        findKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int chess[][]) {
        int r=chess.length, c = chess[0].length;
        System.out.println(r+ " " +c );
        for (int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findKnightsTour(int chess[][], int r, int c, int move) {
        
        if(r<0 || c<0 || r >= chess.length || c>= chess.length || chess[r][c] > 0) {
            System.out.println(move + "move");
            return;
        } else if(move == chess.length * chess.length) {
            System.out.println(move + "move1");
            chess[r][c] = move;
            printKnightsTour(chess);
            chess[r][c] = 0;
            return;
        }
        System.out.println(move + "move2");
        chess[r][c] = move;
        findKnightsTour(chess, r-2 , c+1, move+1);
        findKnightsTour(chess, r-1, c+2, move+1);
        findKnightsTour(chess, r+1, c+2, move+1);
        findKnightsTour(chess, r+2, c+1, move+1);
        findKnightsTour(chess, r+2, c-1, move+1);
        findKnightsTour(chess, r+1, c-2, move+1);
        findKnightsTour(chess, r-1, c-2, move+1);
        findKnightsTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
    }
}
