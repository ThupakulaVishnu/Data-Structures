import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        String n=i.nextLine();
        String m=i.nextLine();
        String[] s=n.split("");
        String[] s1=m.split("");
        System.out.println(find(s,s1));
    }
    public static int find(String[] a,String[] b){
      int[][] com=new int[a.length+1][b.length+1];
      for(int i=0;i<a.length+1;i++){
        for(int j=0;j<b.length+1;j++){
          if(i==0 || j==0){
            com[i][j]=0;
          }else if(a[i-1].equals(b[j-1])){
            com[i][j]=com[i-1][j-1]+1;
          }else{
            com[i][j]=Math.max(com[i][j-1],com[i-1][j]);
          }
        }
      }
      return com[a.length][b.length];
    }
}