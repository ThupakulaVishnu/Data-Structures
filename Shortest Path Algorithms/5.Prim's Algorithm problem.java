//Write a program to find the minimum cost spanning tree using Prim's Algorithm.

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

// Give input in run time like..
// 6
// 0 3 1 6 0 0
// 3 0 5 0 7 0
// 1 5 0 4 8 2
// 6 0 4 0 2 3
// 0 7 8 2 0 4
// 0 0 2 3 4 0

// You will get output like...
// Edge: 0 - 1, Weight: 3
// Edge: 0 - 2, Weight: 1
// Edge: 5 - 3, Weight: 3
// Edge: 3 - 4, Weight: 2
// Edge: 2 - 5, Weight: 2
