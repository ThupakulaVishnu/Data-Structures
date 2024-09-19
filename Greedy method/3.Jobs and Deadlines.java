//Given a set of jobs with associated deadlines and profits, the goal is to find the sequence of jobs to maximize the 
//total profit. Each job takes one unit of time to complete, and a job cannot be scheduled if its deadline has passed.

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        System.out.print("Enter no.of jobs :");
        int size=i.nextInt();
        details[] dt=new details[size];
        int max=Integer.MIN_VALUE;

        //Give your input in runtime...
        for(int j=0;j<size;j++){
            System.out.print("Enter job name : ");
            char a=i.next().charAt(0);
            System.out.print("Enter deadline time : ");
            int b=i.nextInt();
            System.out.print("Enter profit : ");
            int c=i.nextInt();
            if(max<b){
                max=b;
            }
            dt[j]=new details(a,b,c);
        }

        boolean[] biggest=new boolean[max];
        Arrays.sort(dt,Comparator.comparingInt((details a)->a.profit).reversed());

        System.out.println("Job Sequence with Maximum Profits: ");
        int total=0;
        for(int j=0;j<size;j++){
            int q=dt[j].deadline-1;
            while(q>=0){
                if(biggest[q]==false){
                    biggest[q]=true;
                    System.out.print(dt[j].job+" ");
                    total+=dt[j].profit;
                    break;
                }else{
                    q--;
                }
            }
        }
        System.out.println();
        System.out.println("Total Profit: "+total);
    }
}

class details{
    public char job=0;
    public int deadline=0,profit=0;
    details(char a,int b,int c){
        job=a;
        deadline=b;
        profit=c;
    }
}
