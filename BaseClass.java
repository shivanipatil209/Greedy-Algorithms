import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseClass {
    int n;
    int m;
    int [][] houses;
    void takeInput(String childClass){

        //FUNCTION TAKES THE INPUT AND INITIALIZES THE ARRAY FOR HOUSES

        System.out.println("Give ALREADY SORTED input for "+ childClass+ " :");
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        int n = Integer.valueOf(nm.split(" ")[0]);
        int m = Integer.valueOf(nm.split(" ")[1]);
        this.n = n;
        this.m = m;
        this.houses = new int[m][2];
        for(int i=0; i<m; i++){
            String duration = sc.nextLine();
            int start = Integer.valueOf(duration.split(" ")[0]);
            int end = Integer.valueOf(duration.split(" ")[1]);
            this.houses[i][0] = start;
            this.houses[i][1] = end;
        }
        //this.printhouses();
    }
    void printhouses(){
        for (int i=0; i<this.m; i++){
            System.out.println(Arrays.toString(this.houses[i]));
        }
    }

    static void printOutput(List<Integer> output){
        String outputString = "";
        for(int i=0; i<output.size();i++){
            outputString += output.get(i)+" ";
        }
         System.out.println(outputString);

    }
}
