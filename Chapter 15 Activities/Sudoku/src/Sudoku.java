import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Sudoku{
    // i guess assuming square grid, grid[row][col] is standard
    private final int squareSize; // length of each square
    private final int size; // length of entire grid
    private final int area; // area of grid, idk if helpful
    private int[][] board;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;
    private int[] colOffset = {0,1,2,0,1,2,0,1,2};
    private int[] rowOffset = {0,0,0,1,1,1,2,2,2};

    public Sudoku(String fileName, int size){
        // read the puzzle file
        Scanner scan = new Scanner(System.in);
        String str;
        this.size = size;
        this.squareSize = (int)(Math.sqrt(size));
        area = size*size;

        try{
            scan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
            System.exit(-1);
        }

        this.board = new int[size][size];
        for (int row = 0; row < size; row++) {
            String line = scan.next();
            for (int col = 0; col < size; col++) {
                str = line.substring(col, col + 1);
                int num;
                if (str.equals("x")) {
                    num = 0;
                } else {
                    num = Integer.parseInt(str);   
                }
                this.board[row][col] = num;
            }
        }

        compileSets();
    }

    public Sudoku(Sudoku s){
        this.size = s.size; this.squareSize = s.squareSize; this.area = s.area;
        this.board = s.board;
        this.rows = s.rows; this.cols = s.cols; this.squares = s.squares;
        compileSets();
    }

    public boolean solve(){
        int[] coords = getEmpty();

        for (int num = 1; num < 10; num++) {
            if (check(coords, num)) {
                this.board[coords[0]][coords[1]] = num;
                compileSets();
                if (new Sudoku(this).solve())
                    return true;
            }
            this.board[coords[0]][coords[1]] = 0;
            compileSets();
        }
        return false;
    }

    public Set<Integer> getRow(int[] coords){
        return this.rows.get(coords[0]);
    }

    public Set<Integer> getCol(int[] coords){
        return this.cols.get(coords[1]);
    }

    public Set<Integer> getSquare(int[] coords){
        int squareX = (int)(coords[1]/squareSize);
        int squareY = (int)(coords[0]/squareSize);
        return this.squares.get(squareX + squareY*squareSize);
    }

    public Set<Integer> getOptions(int[] coords){
        Set<Integer> options = new HashSet<Integer>(this.nums);
        options.removeAll(getRow(coords));
        options.removeAll(getCol(coords));
        options.removeAll(getSquare(coords));
        return options;
    }

    public int[] getEmpty(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (this.board[row][col] == 0) {
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    public boolean check(int[] coords, Integer num){
        try{
            if(getRow(coords).contains(num))){
                return false;
            }
            if(getCol(coords).contains(num)){
                return false;
            }
            if(getSquare(coords).contains(num)){
                return false;
            }
        } catch (Exception e){
            System.out.println(this);
            System.exit(-1);
        }
        return true;
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

    public void compileSets(){
        Set<Integer> tempSet;
        // create the list of sets for each row (this.rows)
        this.rows = new ArrayList<Set<Integer>>();
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(board[i][j]);
            }
            this.rows.add(tempSet);
        }

        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<Set<Integer>>();
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(board[j][i]);
            }
            this.cols.add(tempSet);
        }

        // create the list of sets for each square (this.squares)
        this.squares = new ArrayList<Set<Integer>>();
        for(int i = 0; i < size; i++){
            tempSet = new HashSet<Integer>();
            for(int j = 0; j < size; j++){
                tempSet.add(this.board[squareSize*rowOffset[j]+rowOffset[j]][squareSize*colOffset[j]+colOffset[j]]);
            }
            this.squares.add(tempSet);
        }

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<Integer>();
        for(int i = 0; i < size; i++){
            this.nums.add(i);
        }
    }

    public int[][] getBoard(){
        return this.board;
    }

    public String toString() {
        String str = "";

        for (int[] row : board) {
            for (int val : row) {
                str += val + " ";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        Sudoku solver = new Sudoku(fileName,9);
        System.out.println(solver);
        if(solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}
