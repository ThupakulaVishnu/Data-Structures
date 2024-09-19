import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int ver=i.nextInt();
        int edg=i.nextInt();
        int[][] graph=new int[ver][ver];
        for(int j=0;j<ver;j++){
          Arrays.fill(graph[j],Integer.MAX_VALUE);
        }
        for(int j=0;j<edg;j++){
          int a=i.nextInt();
          int b=i.nextInt();
          int c=i.nextInt();
          graph[a][b]=c;
        }
        int sou=i.nextInt();
        find(graph,sou);
    }
    public static void find(int[][] graph,int sor){
      int val=graph.length;
      
      int[] dist=new int[val];
      Arrays.fill(dist,Integer.MAX_VALUE);
      dist[sor]=0;
      boolean[] bool=new boolean[val];
      
      for(int i=0;i<val-1;i++){
        int u=valid(dist,bool);
        bool[u]=true;
        for(int j=0;j<val;j++){
          if(!bool[j] && graph[u][j]!=Integer.MAX_VALUE && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][j]<dist[j]){
            dist[j]=dist[u]+graph[u][j];
          }
        }
      }
      System.out.println("Shortest distances from source node:");
      for(int u=0;u<val;u++){
        System.out.println("Node "+u+": "+dist[u]);
      }
    }
    public static int valid(int[] dist,boolean[] bool){
      int min=Integer.MAX_VALUE;
      int indx=-1;
      for(int i=0;i<dist.length;i++){
        if(!bool[i] && dist[i]<min){
          min=dist[i];
          indx=i;
        }
      }
      return indx;
    }
}
