import java.util.*;
class Edges{
    public int src,des,weight;
    Edges(int a,int b,int c){
        src=a;
        des=b;
        weight=c;
    }
}
public class sample {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        int vertices=i.nextInt();
        int edges=i.nextInt();
        Edges[] edg=new Edges[edges];

        //Give your input in runtime...
        for(int j=0;j<edges;j++){
            int x=i.nextInt();
            int y=i.nextInt();
            int z=i.nextInt();
            edg[j]=new Edges(x,y,z);
        }

        Arrays.sort(edg,Comparator.comparingInt((Edges a)->a.weight));

        valid vld=new valid(vertices);
        int count=0;

        for(Edges e:edg){
            if(count==vertices-1){
                break;
            }else{
                if(vld.find(e.src)!=vld.find(e.des)){
                    System.out.println("Edge: "+e.src+" - "+e.des+", weight: "+e.weight);
                    vld.union(e.src,e.des);
                    count++;
                }
            }
        }
    }
}

class valid{
    public int parent[];
    public valid(int n){
        parent=new int[n];
        for(int k=0;k<n;k++){
            parent[k]=k;
        }
    }

    public int find(int z){
        if(z!=parent[z]){
            parent[z]=find(parent[z]);
        }
        return parent[z];
    }

    public void union(int x,int y){
        int root=find(x);
        int child=find(y);
        parent[root]=child;
    }
}
