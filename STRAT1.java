import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class STRAT1 extends BaseClass{
    // O(n) implementation to assign jobs on n days out of the m available ones

    STRAT1(){
        //CONSTRUCTOR PROMPTS FOR INPUT
        new BaseClass();
        takeInput("Strat1");
    }

    public List<Integer> optimizeTime(){
        List<Integer> optimalSet = new ArrayList<>(); // INITIALIZES A LIST TO ADD HOUSES TO BE PAINTED
        int day = 1;
        int house_num = 0;

        // ITERATE TILL ALL DAYS ARE OCCUPIED OR ALL HOUSES ARE ASSIGNED
        while(day<=n && house_num<m){
            //if house eligible on the day then schedule
            if(day>=houses[house_num][0] && day<=houses[house_num][1]){ // IF HOUSE CAN BE PAINTED IN THE INTERVAL
                //ADD TO THE SOLUTION AND INCREASE HOUSE NUMBER AND DAY NUMBER
                optimalSet.add(++house_num);
                day++;
            }else{
                if(day<houses[house_num][0]){
                    // NO ELIGIBLE HOUSE ON THIS DAY SO WE SKIP THIS DAY. NO HOUSE WILL BE PAINTED ON THIS DAY
                    day++;
                }
                else{
                    // BACKLOG OF HOUSES WITH DEADLINE BEFORE THE CURRENT DAY
                    // WE SKIP THESE HOUSES AS THESE CANNOT BE PAINTED ON ANY DAY
                    house_num++;
                }
            }
        }
        return  optimalSet;
    }
    public static void main(String args[]){
        STRAT1 strat1 = new STRAT1();
        List<Integer> optimalStrat1 = strat1.optimizeTime();
        printOutput(optimalStrat1);
    }
}
