import java.util.*;
class Main {
    // Kadane's Algorithum.
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int n=i.nextInt();
        int[] arr=new int[n];
        for(int j=0;j<n;j++){
          arr[j]=i.nextInt();
        }
        int max=find(arr);
        System.out.println(max);
    }
    public static int find(int[] arr){
      int temp=arr[0];
      int max=arr[0];
      for(int i=1;i<arr.length;i++){
        temp=Math.max(arr[i],temp+arr[i]);
        max=Math.max(temp,max);
      }
      return max;
    }
}