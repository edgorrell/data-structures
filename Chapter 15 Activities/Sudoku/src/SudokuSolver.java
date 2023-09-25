import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver{
    // i guess assuming square grid
    private final int squareSize; // length of each square
    private final int size; // length of entire grid
    private final int area; // area of grid, idk if helpful
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName, int size){
        // read the puzzle file
        Scanner scan;
        String str;
        this.size = size;
        this.squareSize = (int)(Math.sqrt(size));
        area = size*size;

        try{
            scan = new Scanner(new File(fileName));
            scan = new Scanner(new File(fileName));
            this.grid = new int[size][size];
            for (int row = 0; row < size; row++) {
                String line = scan.next();
                for (int col = 0; col < size; col++) {
                    str = line.substring(col, col + 1);
                    int number;
                    if (str.equals("x")) {
                        number = -1;
                    } else {
                        number = Integer.parseInt(str);   
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
            System.exit(-1);
        }


        Set<Integer> tempSet;
        // create the list of sets for each row (this.rows)
        this.rows = new ArrayList<Set<Integer>>();
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(grid[i][j]);
            }
            this.rows.add(tempSet);
        }

        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<Set<Integer>>();
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(grid[j][i]);
            }
            this.cols.add(tempSet);
        }

        // create the list of sets for each square (this.squares)
        this.squares = new ArrayList<Set<Integer>>();
        int[] offsetX = {0,1,2,0,1,2,0,1,2};
        int[] offsetY = {0,0,0,1,1,1,2,2,2};
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(this.grid[squareSize*offsetY[j]+offsetY[j]][squareSize*offsetX[j]+offsetX[j]]);
            }
            this.squares.add(tempSet);
        }

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<Integer>();
        for(int i = 0; i < size; i++){
            this.nums.add(i);
        }
    }

    public boolean solve(){
        if(finished()){
            return true;
        }
    }

    public int[] nextEmpty(){
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (this.grid[row][col] == -1) {
                    nextRow = row;
                    nextCol = col;
                }
            }
        }
        if(nextRow == -1 || nextCol == -1){
            return null;
        }
        return new int[] {nextRow, nextCol};
    }

    public boolean finished(){
        for(Set<Integer> row : this.rows){
            if(!row.equals(this.nums)){
                return false;
            }
        }
        for(Set<Integer> col : this.cols){
            if(!col.equals(this.nums)){
                return false;
            }
        }
        for(Set<Integer> square : this.squares){
            if(!square.equals(this.nums)){
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName,9);
        System.out.println(solver);
        //if (solver.solve()) {
        //    System.out.println("Solved!");
        //    System.out.println(solver);
        //} else {
        //System.out.println("Unsolveable...");
        //}
    }
}