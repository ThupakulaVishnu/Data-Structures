Step 1: Initialize direction arrays.
    • Define row = {1, 0, 0, -1} → movement for rows (Down, Left, Right, Up)
    • Define col = {0, -1, 1, 0} → movement for columns
    • Define pos = {"D", "L", "R", "U"} → corresponding direction characters
Step 2: Initialize result list.
    • Create ArrayList ans to store all valid paths
Step 3: Handle edge case.
    • If maze[0][0] == 0:
      ○ Return empty ans (starting point is blocked)
Step 4: Start backtracking.
    • Create temporary list temp to store current path
    • Call recursive function → find(0, 0, r, c, maze, temp)
Step 5: Base case (destination reached).
    • If i == r−1 AND j == c−1:
      ○ Convert temp list into string
      ○ Add string to ans
      ○ Return
Step 6: Mark current cell as visited.
    • Set maze[i][j] = 0 (to avoid revisiting same cell)
Step 7: Explore all 4 directions.
    • For k = 0 to 3:
      ○ Compute next cell:
        • uu = i + row[k]
        • vv = j + col[k]
Step 8: Check if next move is valid.
    • Call issafe(uu, vv, maze, r, c):
      ○ Ensure within bounds and cell value is 1
Step 9: Make recursive call (choose path).
    • Add direction → temp.add(pos[k])
    • Call find(uu, vv, r, c, maze, temp)
Step 10: Backtrack.
    • Remove last direction → temp.remove(temp.size() − 1)
Step 11: Unmark current cell.
    • Restore maze[i][j] = 1 (allow reuse in other paths)
Step 12: Repeat until all paths are explored.
    • Continue recursion for all valid directions
Step 13: Return final result.
    • Return ans → list of all possible paths
Time Complexity Analysis:
    • In worst case, each cell can explore 4 directions → O(4^(n×m))
    • More precisely exponential due to backtracking
    • Total Time Complexity → O(4^(n×m))
Space Complexity Analysis:
    • Recursion stack depth → O(n×m)
    • Path storage (temp) → O(n×m)
    • Result list depends on number of paths
    • Total Space Complexity → O(n×m) (excluding output)







  ===========> Code <===========

  
class Solution {
    int[] row = {1, 0, 0, -1};
    int[] col = {0, -1, 1, 0};
    String[] pos = {"D", "L", "R", "U"};
    ArrayList<String> ans=new ArrayList<>();
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int r=maze.length;
        int c=maze[0].length;
        if(maze[0][0]==0)return ans;
        List<String> temp=new ArrayList<>();
        find(0,0,r,c,maze,temp);
        return ans;
    }
    public void find(int i,int j,int r,int c,int[][] maze,List<String> temp){
        if(i==r-1 && j==c-1){
            String sr="";
            for(String jh:temp){
                sr+=jh;
            }
            ans.add(sr);
            return;
        }
        maze[i][j]=0;
        for(int k=0;k<4;k++){
            int uu=i+row[k],vv=j+col[k];
            if(issafe(uu,vv,maze,r,c)){
                temp.add(pos[k]);
                find(uu,vv,r,c,maze,temp);
                temp.remove(temp.size()-1);
            }
        }
        maze[i][j]=1;
    }
    public boolean issafe(int i,int j,int[][] maze,int r,int c){
        if(i>=0 && j>=0 && i<r && j<c && maze[i][j]==1){
            return true;
        }
        return false;
    }
}
