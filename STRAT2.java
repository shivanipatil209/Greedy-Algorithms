import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class STRAT2 extends BaseClass{
    //O(N + MLOGM IMPLEMENTATION OF THE LATEST START TIME FIRST ALGORITHM )

    STRAT2(){
        new BaseClass();
        takeInput("Strat2");
    }

    public List<Integer> optimizeTime(){

        // INITIALIZE A PQ AND DEFINE A COMPARATOR WHICH WHEN RECEIVES TWO ARRAYS, IT COMPARES THEIR
        // START TIME AND RETURNS THE HIGHER ONE, MEANING PQ WITH PRIORITY TO HIGHEST START TIME
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int a[], int b[]) {
                if(b[0] == a[0]){
                    return b[1]-a[1];
                }
                return (b[0]-a[0]);
            }
        });

        List<Integer> optimalSet = new ArrayList<>();
        int day = 1;
        int house_num = 0;
        // ITERATE TILL ALL DAYS ARE OCCUPIED OR ALL HOUSES ARE ASSIGNED
        while(day<=n && house_num<=m){
           //add all compatible job to the PQ for the ongoing day
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
                    optimalSet.add(house_TBS[2]);
                }
            }
            day++;
        }
        return  optimalSet;
    }

    public static void main(String args[]){
        STRAT2 strat2 = new STRAT2();
        List<Integer> optimalStrat2 = strat2.optimizeTime();
        printOutput(optimalStrat2);
    }
}

