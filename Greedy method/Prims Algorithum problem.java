import java.util.*;
class sample{
    public static int ver;
    public static void main(String[] args){
        Scanner i=new Scanner(System.in);
        System.out.print("Enter no.of Vertices : ");
        ver=i.nextInt();
        int[][] graph=new int[ver][ver];
        System.out.println("Enter N X N metrics correctly for weights ");
        for(int a=0;a<ver;a++){
            for(int b=0;b<ver;b++){
                graph[a][b]=i.nextInt();
            }
        }

        int[] parent=new int[ver];
        int[] key=new int[ver];
        boolean[] check=new boolean[ver];

        for(int a=0;a<ver;a++){
            key[a]=Integer.MAX_VALUE;
        }

        key[0]=0;
        parent[0]=-1;

        for(int a=0;a<ver-1;a++){
            int u=findmin(key,check);
            check[u]=true;

            for(int b=0;b<ver;b++){
                if(graph[u][b]!=0 && check[b]==false && graph[u][b]<key[b]){
                    parent[b]=u;
                    key[b]=graph[u][b];
                }
            }
        }

        for(int a=1;a<ver;a++){
            System.out.println("Edge: "+parent[a]+" - "+a+", Weight: "+graph[a][parent[a]]);
        }
    }
    public static int findmin(int[] key,boolean[] check){
        int min=Integer.MAX_VALUE;
        int min_index=-1;

        for(int a=0;a<ver;a++){
            if(check[a]==false && key[a]<min){
                min=key[a];
                min_index=a;
            }
        }

        return min_index;
    }
}