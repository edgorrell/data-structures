import java.util.*;

public class Grid{
    private static final int SIZE = 10;
    int[][] grid = new int[SIZE][SIZE];
    Stack<int[]> stack = new Stack<int[]>();
    int num = 0;
    /**
     * Flood fill, starting with the given row and column.
    */
    public void fill(int row, int col){
        if(this.num == 0){num = 1;}
        if(stack.size() > 0){stack.pop();}
        if(grid[row][col] == 0){
            grid[row][col] = num;
            num++;
        }
        int[] ro = {1,0,-1,0};
        int[] co = {0,1,0,-1};
        for(int i = 0; i < 4; i++){
            if(row + ro[i] < 0 || row + ro[i] >= SIZE ||
               col + co[i] < 0 || col + co[i] >= SIZE){
                continue;
            }
            if(grid[row + ro[i]][col + co[i]] == 0){
                stack.push(new int[] {row + ro[i], col + co[i]});
            }
        }
        if(stack.size() > 0){
            fill(stack.peek()[0], stack.peek()[1]);
        }
    }

    @Override
    public String toString(){
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", grid[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
