//Write a program to implement knapsack problem using greedy method.

import java.util.*;
class sample {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        System.out.print("Enter capacity of knapsack :");
        int k=i.nextInt();
        System.out.print("Enter no.of items : ");
        int size=i.nextInt();
        item[] items=new item[size];

        //Give your input in runtime...
        for(int j=0;j<size;j++){
            System.out.print("Enter weight : ");
            int weight=i.nextInt();
            System.out.print("Enter value : ");
            int val=i.nextInt();
            items[j]=new item(weight,val);
        }

        Arrays.sort(items,Comparator.comparingDouble((item a)->a.ratio).reversed());

        int we=0;
        float va=0;
        for(int j=0;j<size;j++){
            if(we+items[j].weight<=k){
                we+=items[j].weight;
                va+=items[j].value;
            }else{
                float jk=(float)k-we;
                jk=jk/items[j].weight;
                jk=jk*items[j].value;
                va+=jk;
                break;
            }
        }
        System.out.println("Maximum value that can be obtained: "+va);
    }
}

class item{
    public int weight=0,value=0;
    public float ratio=0;
    item(int w,int v){
        weight=w;
        value=v;
        ratio=v/w;
    }
}