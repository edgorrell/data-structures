import java.util.*;

public class QueueGrid{
    private static final int SIZE = 10;
    int[][] grid = new int[SIZE][SIZE];
    Queue<int[]> q = new LinkedList<int[]>();
    int num = 0;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void fill(int row, int col){
        if(q.size() > 0){q.remove(q.peek());}
        if(grid[row][col] < 1){
            num++;
            grid[row][col] = num;
        }
        int[] ro = {1,0,-1,0};
        int[] co = {0,1,0,-1};
        for(int i = 0; i < 4; i++){
            if(row + ro[i] < 0 || row + ro[i] >= SIZE ||
               col + co[i] < 0 || col + co[i] >= SIZE){
                continue;
            }
            if(grid[row + ro[i]][col + co[i]] == 0){
                grid[row + ro[i]][col + co[i]] = -1;
                q.add(new int[] {row + ro[i], col + co[i]});
            }
        }
        if(q.size() > 0){
            fill(q.peek()[0], q.peek()[1]);
        }
    }

    public String toString(){
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", grid[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
