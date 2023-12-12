import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class STRAT4_optimal extends BaseClass{


    STRAT4_optimal(){
        new BaseClass();
        takeInput("Strat4_Optimal");
    }

    public List<Integer> optimizeTime(){
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int a[], int b[]) {
                return a[1] - b[1];
            }
        });
        List<Integer> optimalSet = new ArrayList<>();

        // start with the first house and take the start date of that house as the first eligible day for painting any house
        int curr_house = 0;
        int curr_startDay = houses[curr_house][0];

        while(curr_house<=m && curr_startDay <= n){
            //Add all the houses with similar start date to PQ so that once we have all the eligible houses for
            //that day we can poll the one with earliest deadline
            if(curr_house<m && houses[curr_house][0] == curr_startDay){
               int [] interval = new int[3];
                interval[0] = houses[curr_house][0];
                interval[1] = houses[curr_house][1];
                interval[2] = ++curr_house;
                pq.add(interval);
            }else{
                //Here we fill the days between house start days of houses i and i+1
                //If the house i the last house we fill all the remaining days which are open to be taken
                //Otherwise we just take the difference between the start times and fill those many days in between

                int difference = curr_house>=m ? n-curr_startDay+1 : houses[curr_house][0]-curr_startDay;
                int endDayOfEligibleHouses = curr_startDay;
                // no task with endDate>endDayOfEligibleHouses is eligible to be scheduled for painting
                while(!pq.isEmpty() && difference>0){
                    int []house_polled = pq.poll();
                    if(house_polled[1] >= endDayOfEligibleHouses ){
                        optimalSet.add(house_polled[2]);
                        endDayOfEligibleHouses++;
                        difference--;
                    }
                }
                curr_startDay = curr_house>=m ? n+1: houses[curr_house][0];
            }
        }
        return  optimalSet;
    }
    public static void main(String args[]){
        STRAT4_optimal strat4_optimal = new STRAT4_optimal();
        List<Integer> optimal = strat4_optimal.optimizeTime();
        printOutput(optimal);
    }
}
