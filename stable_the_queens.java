// package n_queen_visualizer;
import java.util.Scanner;
public class stable_the_queens {
    public static boolean visited = false;
    static boolean isSafe(int row, int col, int[][] board, int n){
        // condition checking the row 
        for(int i=0; i<n; i++)
            if(board[row][i] == 1)
                return false;
        // condition checking the column
        for(int i=0; i<n; i++)
            if(board[i][col] == 1)
                return false;
        // checking for upper left diagonal, upper right diagonal
        int it = row;
        for(int i = col; i>=0 && it>=0; it--, i--)
            if(board[it][i] == 1)
                return false;
        it = row;
        for(int i=col; i<n && it>=0; i++, it--)
            if(board[it][i] == 1)
                return false;
        // checking for lower left diagonal, lower right diagonal
        it = row;
        for(int i=col; i>=0 && it<n; i--, it++)
            if(board[it][i] == 1)
                return false;
        for(int i=col; i<n && it<n; i++, it++)
            if(board[it][i] == 1)
                return false;
        return true;
    }
    static void find(int[][] board, int row, int n){
        if(row == n && visited==false){
            visited = true;
            for(int[] i : board){
                for(int j : i)
                    System.out.print(j+" ");
                System.out.println();
            }
        }
        if(row == n)
            return;
        for(int col = 0; col < n; col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 1;
                find(board, row+1, n);
                board[row][col] = 0;
            }
        }
    }
    static void solve_queens(int[][] board, int n) {
        // find the solution
        find(board, 0, n);
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows or columns : ");
        int row = sc.nextInt();

        int board[][] = new int[row][row];
        for(int i[] : board){
            for(int j : i)
                j = 0;
        }
        solve_queens(board, row);
    }    
}

