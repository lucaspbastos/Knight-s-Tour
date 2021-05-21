/*
    Lucas Bastos
    CS 114-H01
*/
public class KnightsTour {
    // Initialize board
    private static int m = 8;
    private static int n = 8;
    private static int[][] board = new int[m][n];

	public static void main(String[] args) {
		move(0,0,0);
		steps();
	}

    // Print steps
	public static void steps(){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if (board[i][j] >= 10 || board[i][j] == -1){
					System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(board[i][j] + "  ");
                }
			}
			System.out.println();
		}
    }

    // Check move validity
    public static boolean isValid(int row, int col) {
		return (row <= m-1 && col <= n-1 && row >= 0 && col >= 0 && (board[row][col] == 0));
    }

    // Recursively discover moves
	public static boolean move(int row, int col, int step){
		board[row][col] = step;
        if (step>=(m*n)-1
        ||(isValid(row+2,col+1) && move(row+2, col+1, step+1))
        ||(isValid(row+1,col+2) && move(row+1, col+2, step+1))
        ||(isValid(row-1,col+2) && move(row-1, col+2, step+1))
        ||(isValid(row-2,col+1) && move(row-2, col+1, step+1))
        ||(isValid(row-2,col-1) && move(row-2, col-1, step+1))
        ||(isValid(row-1,col-2) && move(row-1, col-2, step+1))
        ||(isValid(row+1,col-2) && move(row+1, col-2, step+1))
        ||(isValid(row+2,col-1) && move(row+2, col-1, step+1))) {
            return true;
        } else{
            board[row][col] = 0;
            return false;
        }
	}
}
