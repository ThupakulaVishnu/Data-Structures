Step-by-step algorithm to solve a Sudoku puzzle:
Step 1: Start solving.
           • Call solveSudoku(board)
           • Begin recursion with find(board, 0, 0)
Step 2: Define recursive function find(board, r, c)
           • Base Case 1: If r == 9 → all rows are filled → return true
           • Base Case 2: If c == 9 → end of row reached → move to next row → find(board, r+1, 0)
    • Step 2a: If current cell is already filled (board[r][c] != '.')
            o Move to next column → find(board, r, c+1)
    • Step 2b: If current cell is empty (board[r][c] == '.')
             o Try all numbers from 1 to 9:
          • Sub-step 2b-i: Check if number i is safe using issafe(board, r, c, i)
          • Sub-step 2b-ii: If safe
                 • Place the number → board[r][c] = (char)(i + '0')
                 • Recurse for next cell → find(board, r, c+1)
                 • If recursion returns true → Sudoku solved → return true
                 • Else → backtrack → board[r][c] = '.'
          • Step 2c: If no number fits → return false
Step 3: Define function issafe(board, r, c, num)
    • Step 3a: Check row r
          o For i = 0 to 8 → if board[r][i] == num → return false
    • Step 3b: Check column c
          o For i = 0 to 8 → if board[i][c] == num → return false
    • Step 3c: Check 3×3 subgrid
          o sr = (r/3)*3, sc = (c/3)*3
          o For i = sr to sr+2
                 • For j = sc to sc+2 → if board[i][j] == num → return false
    • Step 3d: If no conflicts → return true
Step 4: Sudoku is solved when recursion returns true for all cells
  
Time Complexity:
      For each empty cell, we try numbers 1 to 9 → O(9) per cell
      Let n = number of empty cells
      Worst-case time complexity = O(9^n)
      Time Complexity = O(9^n)

Space Complexity:
      Recursion stack can go as deep as number of empty cells → O(n)
      Board uses O(81) constant space for 9×9 Sudoku
      Total space complexity = O(n) + O(81)
      Space Complexity = O(n)








  ============> Code <=========

  

class Solution {
    public void solveSudoku(char[][] board) {
        find(board,0,0);
    }
    public boolean find(char[][] board,int r,int c){
        if(r==9) return true;

        if(c==9) return find(board,r+1,0);

        if(board[r][c]!='.'){
            return find(board,r,c+1);
        }else{
            for(int i=1;i<=9;i++){
                if(issafe(board,r,c,i)){

                    board[r][c]=(char)(i+'0');

                    if(find(board,r,c+1))return true;

                    board[r][c]='.';

                }
            }
        }
        return false;
    }
    public boolean issafe(char[][] board,int r,int c,int num){
        for(int i=0;i<9;i++){
            if(board[r][i]!='.' && board[r][i]-'0'==num){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(board[i][c]!='.' && board[i][c]-'0'==num){
                return false;
            }
        }

        int sr=(r/3)*3;
        int sc=(c/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]!='.' && board[i][j]-'0'==num){
                    return false;
                }
            }
        }

        return true;
    }
}
