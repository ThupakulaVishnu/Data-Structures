//Given a set of intervals with start and end times, the goal is to find the maximum number of non-overlapping intervals.

import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        System.out.print("Enter no.of intervals :");
        int size=i.nextInt();
        interval[] intervals=new interval[size];

        //Give your input in runtime...
        for(int j=0;j<size;j++){
            System.out.print("Enter starting time : ");
            int a=i.nextInt();
            System.out.print("Enter ending time : ");
            int b=i.nextInt();
            intervals[j]=new interval(a,b);
        }

        Arrays.sort(intervals,Comparator.comparingInt((interval a)->a.end));

        int total=0,last=0;
        for(int j=0;j<size;j++){
            if(intervals[j].start>=last){
                total++;
                last=intervals[j].end;
            }
        }
        System.out.println("Maximum no.of non-overlapping intervals : "+total);
    }
}

class interval{
    public int start=0,end=0;
    interval(int a,int b){
        start=a;
        end=b;
    }
}
