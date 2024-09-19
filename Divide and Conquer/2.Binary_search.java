//Implement the Binary Search algorithm using the Divde and Conquer approach. Write a function binary_search(arr,target) that takes a sorted
// array of integers and a target value, and returns the index of the target if found, or -1 if not found.

// Sample Input 
// 1 2 3 4 5 6 7 8 9 10
// Sample Output
// 7


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
