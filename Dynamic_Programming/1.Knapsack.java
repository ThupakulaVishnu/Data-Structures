// Write a program to implement 0/1 Knapsack problem using Dynamic Programming method.

// sample Input
// 4
// 2 3
// 3 4
// 4 5
// 5 6
// 5
// sample output : 10


import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int N=i.nextInt();
        int[] w=new int[N+1];
        w[0]=0;
        int[] p=new int[N+1];
        p[0]=0;
        for(int j=1;j<=N;j++){
          w[j]=i.nextInt();
          p[j]=i.nextInt();
        }
        int cap=i.nextInt();
        int maxProfit=solve(w,p,cap);
        System.out.println(maxProfit);
    }
    public static int solve(int[] w,int[] p,int cap){
      int size=w.length;
      int[][] dp=new int[size][cap+1];
      for(int i=0;i<size;i++){
        for(int j=0;j<=cap;j++){
          if(i==0 || j==0){
            dp[i][j]=0;
          }else if(j<w[i]){
            dp[i][j]=dp[i-1][j];
          }else{
            dp[i][j]=Math.max(p[i]+dp[i-1][j-w[i]],dp[i-1][j]);
          }
        }
      }
      return dp[size-1][cap];
    }
}
