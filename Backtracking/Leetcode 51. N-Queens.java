Step-by-step algorithm for solving the N-Queens problem using Backtracking:

    Step 1: Create a 2D board of size n × n to represent the chessboard.
        • Sub-step 1a: Fill every position in the board with . to represent empty cells.

    Step 2: Create a result list to store all valid board configurations.

    Step 3: Start a recursive backtracking function beginning from row = 0.

    Step 4: In the backtracking function, check if the current row equals n.
        • Sub-step 4a: If true, it means queens are successfully placed in all rows.
        • Sub-step 4b: Convert the board into a list of strings.
        • Sub-step 4c: Add this configuration to the result list.
        • Sub-step 4d: Return to explore other possible configurations.

    Step 5: For the current row, try placing a queen in every column from 0 to n−1.

    Step 6: For each column position, check if placing a queen there is safe.

    Step 7: To check safety, verify three directions above the current cell:
        • Sub-step 7a: Check the upper-left diagonal.
            o Move diagonally upward-left and ensure no queen exists.

        • Sub-step 7b: Check the same column above.
            o Move upward in the same column and ensure no queen exists.

        • Sub-step 7c: Check the upper-right diagonal.
            o Move diagonally upward-right and ensure no queen exists.

    Step 8: If the position is safe:
        • Sub-step 8a: Place a queen at that position on the board.

    Step 9: Move to the next row and repeat the process using recursion.

    Step 10: After returning from recursion, remove the queen from the current position.
        • Sub-step 10a: Replace the queen with .
        (This is called backtracking, allowing exploration of other possibilities.)

    Step 11: Continue checking all columns for the current row.

    Step 12: Repeat this process until all rows and column possibilities are explored.

    Step 13: After exploring all configurations, return the result list containing all valid N-Queens boards.

Time Complexity:

    You are thinking in the right direction, but the exact count is not strictly n-2, n-4. Let me explain clearly.

    1. In the first row, we have n possible positions to place the queen.

    2. In the second row, the queen from row 1 blocks:
        o 1 column
        o 2 diagonals

        So up to 3 positions may become unsafe, but depending on the column where the first queen was placed, the number of blocked cells can vary.

    3. Because the blocked positions change based on where queens are placed, we cannot exactly say n-2 or n-4 for every row.

    4. In worst case analysis, we approximate that each row has about n, n-1, n-2, n-3 ... choices, which leads to

        n × (n−1) × (n−2) × ... ≈ n!

    So we say:

    Time Complexity = O(n!)

    ✔ Key idea:
    Backtracking tries many permutations of column placements, and in worst case it behaves like n! possibilities, not strictly n, n-2, n-4.

Space Complexity:

    Board storage + recursion stack.

    Space Complexity = O(N²) for board and O(N) recursion stack.











                  ================> Code <=================

  class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] qun=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(qun[i],'.');
        }
        backtrack(n,0,qun);
        return result;
    }
    public void backtrack(int n,int row,char[][] qun){
        if(row==n){
            result.add(create(qun));
            return;
        }
        for(int col=0;col<n;col++){
            if(issafe(n,row,col,qun)){
                qun[row][col]='Q';
                backtrack(n,row+1,qun);
                qun[row][col]='.';
            }
        }
    }
    public boolean issafe(int n,int row,int col,char[][] qun){

        for(int i=row,j=col ; i>=0 && j>=0 ; i-- ,j--){
            if(qun[i][j]=='Q')return false;
        }

        for(int i=row ; i>=0 ; i--){
            if(qun[i][col]=='Q')return false;
        }

        for(int i=row, j=col; i>=0 && j<n ; i--, j++){
            if(qun[i][j]=='Q')return false;
        }

        return true;
    }
    public List<String> create(char[][] qun){
        List<String> al=new ArrayList<>();
        for(char[] rows:qun){
            al.add(new String(rows));
        }
        return al;
    }
}
