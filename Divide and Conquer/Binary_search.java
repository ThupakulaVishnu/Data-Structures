import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        String n=i.nextLine();
        String[] m=n.split(" ");
        int[] arr=new int[m.length];
        for(int j=0;j<m.length;j++){
          arr[j]=Integer.parseInt(m[j]);
        }
        int a=i.nextInt();
        int index=binary_search(arr,a);
        System.out.println(index);
    }
    public static int binary_search(int[] arr,int a){
      int start=0,end=arr.length-1;
      while(start<=end){
        int mid=start+((end-start)/2);
        if(arr[mid]==a){
          return mid;
        }else if(arr[mid]>a){
          end=mid-1;
        }else{
          start=mid+1;
        }
      }
      return -1;
    }
}