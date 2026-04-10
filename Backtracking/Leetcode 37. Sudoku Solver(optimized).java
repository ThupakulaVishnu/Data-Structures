👉 Optimization does NOT change Big-O here, but it reduces constant time.
⚡ What actually improves?
Without optimization:
•	Each issafe() → scans row + col + box → ~27 operations 
With optimization:
•	Direct lookup using arrays → ~1 operation
🎯 So what changes?
•	Before → O(9^n × 27) 
•	After → O(9^n × 1) 
👉 Big-O same, but runtime is much faster in practice

Step-by-step algorithm to solve a Sudoku puzzle using boolean arrays:
Step 1: Initialize tracking arrays.
• row[9][10] → tracks numbers used in each row
• col[9][10] → tracks numbers used in each column
• box[9][10] → tracks numbers used in each 3×3 subgrid
Step 2: Pre-fill tracking arrays with existing board numbers.
• For i = 0 to 8:
 o For j = 0 to 8:
  • If board[i][j] != '.' →
   • num = board[i][j] - '0'
   • Mark row, column, and box as used:
    • row[i][num] = true
    • col[j][num] = true
    • box[(i/3)*3 + j/3][num] = true
Step 3: Begin recursion with find(board, 0, 0)
Step 4: Define recursive function find(board, r, c)
• Base Case 1: If r == 9 → all rows filled → return true
• Base Case 2: If c == 9 → end of row reached → move to next row → find(board, r+1, 0)
• Step 4a: If current cell is already filled (board[r][c] != '.')
 o Move to next column → find(board, r, c+1)
• Step 4b: If current cell is empty (board[r][c] == '.')
 o Compute box index → b = (r/3)*3 + c/3
 o Try all numbers from 1 to 9:
  • If number i is not used in row, column, or box →
   • Place number → board[r][c] = (char)(i + '0')
   • Mark as used → row[r][i] = col[c][i] = box[b][i] = true
   • Recurse for next cell → find(board, r, c+1)
   • If recursion returns true → Sudoku solved → return true
   • Else → backtrack →
    • board[r][c] = '.'
    • row[r][i] = col[c][i] = box[b][i] = false
• Step 4c: If no number fits → return false
Step 5: Sudoku is solved when recursion returns true for all cells
________________________________________
Time Complexity:
For each empty cell, we try numbers 1 to 9 → O(9) per cell
Let n = number of empty cells
Worst-case time complexity = O(9^n)
Time Complexity = O(9^n)


  
Space Complexity:
Recursion stack can go as deep as number of empty cells → O(n)
Boolean arrays row, col, box use O(9×10 × 3) → O(1) constant space
Total space complexity = O(n) + O(1)
Space Complexity = O(n)
























  

class Solution {
    boolean[][] row=new boolean[9][10];
    boolean[][] col=new boolean[9][10];
    boolean[][] box=new boolean[9][10];

    public void solveSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0';
                    row[i][num]=true;
                    col[j][num]=true;
                    box[(i/3)*3+j/3][num]=true;
                }
            }
        }

        find(board,0,0);
    }
    public boolean find(char[][] board,int r,int c){
        if(r==9) return true;

        if(c==9)return find(board,r+1,0);

        if(board[r][c]!='.'){
            return find(board,r,c+1);
        }else{
            for(int i=1;i<=9;i++){
                int b=(r/3)*3+c/3;
                if(!row[r][i] && !col[c][i] && !box[b][i]){
                    board[r][c]=(char)(i+'0');
                    row[r][i]=col[c][i]=box[b][i]=true;

                    if(find(board,r,c+1))return true;

                    board[r][c]='.';
                    row[r][i]=col[c][i]=box[b][i]=false;
                }
            }
        }
        return false;
    }
}




  =============> Code <===========

  
