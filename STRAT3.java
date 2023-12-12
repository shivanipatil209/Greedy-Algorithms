import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class STRAT3 extends BaseClass {
    STRAT3(){
        new BaseClass();
        takeInput("Strat3");
    }

    public List<Integer> optimizeTime(){
        // INITIALIZE A PQ AND DEFINE A COMPARATOR WHICH WHEN RECEIVES TWO ARRAYS, IT COMPARES THEIR SLACK
        // i.e (END_TIME-START_TIME) AND RETURNS THE ONE WITH SMALLER SLACK
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int a[], int b[]) {
                return ((a[1]-a[0]) - (b[1]-b[0]));
            }
        });
        List<Integer> optimalset = new ArrayList<>();
        int day = 1;
        int house_num = 0;
        // ITERATE TILL ALL DAYS ARE OCCUPIED OR ALL HOUSES ARE ASSIGNED

        while(day<=n && house_num<=m){
            //add all compatible job to the PQ for ongoing day
            // ALL THE JOBS THAT START ON/BEFORE THE CURRENT DAY ARE ELIGIBLE
            while(house_num<m && houses[house_num][0]<=day){
                int [] interval = new int[3];
                interval[0] = houses[house_num][0];
                interval[1] = houses[house_num][1];
                interval[2] = ++house_num;
                pq.add(interval);
            }
            //once added then try to get the first compatible interval among the ones available
            //possible no new houses are compatible with the day so we try to schedule any other house
            //so we poll the houses available untill a compatible one is found or we exaust all the available houses

            while(!pq.isEmpty() && pq.peek()[1]<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                //upon finding a compatible house, schedule it and note the day
                int [] house_TBS = pq.poll();
                if(house_TBS[1]>=day){
                    optimalset.add(house_TBS[2]);
                }
            }
            day++;

        }
        return  optimalset;
    }
    public static void main(String args[]){
        STRAT3 strat3 = new STRAT3();
        List<Integer> optimalStrat3 = strat3.optimizeTime();
        printOutput(optimalStrat3);
    }
}
