import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int n=i.nextInt();
        int[] arr=new int[n];
        for(int j=0;j<n;j++){
          arr[j]=i.nextInt();
        }
        int m=i.nextInt();
        int count=find(arr,m);
        System.out.println(count);
    }
    public static int find(int[] arr,int a){
      int[][] dp=new int[arr.length][a+1];
      
      for(int i=0;i<arr.length;i++){
        for(int j=0;j<a+1;j++){
          if(j==0){
            dp[i][j]=0;
          }else if(i==0){
            dp[i][j]=j%arr[0]==0 ? j/arr[0] : Integer.MAX_VALUE-1;
          }else{
            if(arr[i]<=j){
              dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-arr[i]]);
            }else{
              dp[i][j]=dp[i-1][j];
            }
          }
        }
      }
      if(dp[arr.length-1][a]>=Integer.MAX_VALUE-1){
        return -1;
      }else{
        return dp[arr.length-1][a];
      }
    }
}