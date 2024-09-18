import java.util.*;
class Finding_minimum_and_maximum {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        String n=i.nextLine();
        String[] ar=n.split(" ");
        int[] arr=new int[ar.length];
        for(int j=0;j<ar.length;j++){
          arr[j]=Integer.parseInt(ar[j]);
        }
        int[] result=find(arr,0,arr.length-1);
        System.out.println("Max - "+result[1]);
        System.out.println("Min - "+result[0]);
    }
    public static int[] find(int[] arr,int start,int end){
      if(arr[start]==arr[end]){
        return new int[]{arr[start],arr[end]};
      }else if(end==start+1){
        if(arr[start]<arr[end]){
          return new int[]{arr[start],arr[end]};
        }else{
          return new int[]{arr[end],arr[start]};
        }
      }else{
        int mid=(start+end)/2;
        int[] left=find(arr,start,mid);
        int[] right=find(arr,mid+1,end);
        int min=Math.min(left[0],right[0]);
        int max=Math.max(left[1],right[1]);
        return new int[]{min,max};
      }
    }
}