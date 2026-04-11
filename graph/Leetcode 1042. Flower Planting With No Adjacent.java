Step-by-step algorithm to assign flowers to gardens:
Step 1: Initialize adjacency list.
• Create al = new ArrayList<>() of size n → one list per garden
Step 2: Fill adjacency list using paths.
• For each path [u, v] in paths:
 o Add edge both ways →
  • al.get(u-1).add(v-1)
  • al.get(v-1).add(u-1)
Step 3: Initialize result array.
• flower = new int[n] → stores flower number (1 to 4) for each garden
Step 4: Assign flowers to each garden.
• For i = 0 to n-1:
 o Step 4a: Initialize boolean array → bol = new boolean[5] (flower 1 to 4)
 o Step 4b: Mark flowers used by neighbors →
  • For each curr in al.get(i) →
   • bol[flower[curr]] = true
 o Step 4c: Pick first unused flower →
  • For c = 1 to 4:
   • If !bol[c] → assign → flower[i] = c → break
Step 5: Return the assigned flowers array → flower
Time Complexity:
• Building adjacency list → O(n + paths.length)
• Assigning flowers → for each garden, check neighbors → O(n + sum of degrees) → O(n + paths.length)
Time Complexity = O(n + paths.length)
Space Complexity:
• Adjacency list → O(n + paths.length)
• Result array → O(n)
• Temporary boolean array → O(5) → O(1)
Space Complexity = O(n + paths.length)














  ===================> Code <===============
  
class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }

        for(int[] a:paths){
            al.get(a[0]-1).add(a[1]-1);
            al.get(a[1]-1).add(a[0]-1);
        }

        int[] arr=new int[n];

        find(0,n,arr);
        return arr;
    }
    public boolean find(int node,int n,int[] arr){
        if(node==n){
            return true;
        }
        for(int i=1;i<=4;i++){
            if(issafe(node,i,arr)){
                arr[node]=i;
                if(find(node+1,n,arr))return true;
                arr[node]=0;
            }
        }
        return false;
    }
    public boolean issafe(int node,int k,int[] arr){
        for(int h:al.get(node)){
            if(arr[h]==k)return false;
        }
        return true;
    }
}


