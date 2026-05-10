Step 1: Initialize variables.
    • Let r = number of rows, c = number of columns
    • Create Queue<int[]> q to store rotten oranges positions
    • Initialize fresh = 0 → count of fresh oranges
Step 2: Traverse the grid.
    • For each cell (i, j):
      ○ If grid[i][j] == 2 → add position to queue
      ○ If grid[i][j] == 1 → increment fresh count
Step 3: Handle edge case.
    • If fresh == 0:
      ○ Return 0 (no fresh oranges to rot)
Step 4: Initialize BFS variables.
    • Set minutes = 0
    • Define 4 directions → up, down, left, right
Step 5: Start BFS (level-order traversal).
    • While queue is not empty:
      ○ Get current level size → size = q.size()
      ○ Initialize flag rotten = false
Step 6: Process current level.
    • For i = 0 to size − 1:
      ○ Remove element from queue → (x, y)
      ○ Check all 4 directions
Step 7: Rot adjacent fresh oranges.
    • For each direction (dx, dy):
      ○ Compute new position → (n, m)
      ○ If valid AND grid[n][m] == 1:
        • Mark as rotten → grid[n][m] = 2
        • Add to queue → q.offer(new int[]{n, m})
        • Decrease fresh count → fresh--
        • Set rotten = true
Step 8: Update time.
    • If any orange rotted in this level (rotten == true):
      ○ Increment minutes → minutes++
Step 9: Repeat BFS.
    • Continue until queue becomes empty
Step 10: Return result.
    • If fresh == 0 → return minutes
    • Else → return -1 (some oranges never rot)
Time Complexity Analysis:
    • Each cell is visited at most once → O(r × c)
    • BFS traversal processes all cells → O(r × c)
    • Total Time Complexity → O(r × c)
Space Complexity Analysis:
    • Queue can store up to all cells in worst case → O(r × c)
    • No extra data structures apart from queue
    • Total Space Complexity → O(r × c)
















  ================> code <============

  
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue & count fresh
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if(fresh == 0) return 0;

        int minutes = 0;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for(int[] d : dir){
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;   // make it rotten
                        q.offer(new int[]{nx, ny});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if(rotted) minutes++; // increase only if something changed
        }

        // If fresh oranges still left
        return (fresh == 0) ? minutes : -1;
    }
}
