import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        String n=i.nextLine();
        String[] m=n.split(" ");
        int[] arr=new int[m.length];
        for(int y=0;y<m.length;y++){
          arr[y]=Integer.parseInt(m[y]);
        }
        int[] finall=merge_sort(arr);
        for(int u:finall){
          System.out.print(u+" ");
        }
    }
    public static int[] merge_sort(int[] arr){
      if(arr.length==1){
        return arr;
      }
      int mid=arr.length/2;
      int[] left=merge_sort(Arrays.copyOfRange(arr,0,mid));
      int[] right=merge_sort(Arrays.copyOfRange(arr,mid,arr.length));
      return combain(left,right);
    }
    public static int[] combain(int[] a,int[] b){
      int size=a.length+b.length;
      int[] result=new int[size];
      int n=0,m=0,k=0;
      while(n<a.length && m<b.length){
        if(a[n]<b[m]){
          result[k++]=a[n++];
        }else{
          result[k++]=b[m++];
        }
      }
      while(n<a.length){
        result[k++]=a[n++];
      }
      while(m<b.length){
        result[k++]=b[m++];
      }
      return result;
    }
}