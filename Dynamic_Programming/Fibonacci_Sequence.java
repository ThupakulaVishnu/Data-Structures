import java.util.*;
class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int n=i.nextInt();
        arr=new int[n+1];
        System.out.print(fib(n));
    }
    public static int fib(int n){
      if(n>=0){
        arr[0]=0;
      }
      if(n>=1){
        arr[1]=1;
      }
      for(int j=2;j<n+1;j++){
        arr[j]=arr[j-1]+arr[j-2];
      }
      return arr[n];
    }
}