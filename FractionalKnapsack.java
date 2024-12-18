import java.util.*;
import java.util.Scanner;

public class FractionalKnapsack {
    static double FractionalKnapsackProblem(int[] profit, int[] weight, int sack){
        TreeMap<Double, List<Integer>> tm= new TreeMap<Double,List<Integer>>(Collections.reverseOrder());
        int n= profit.length;
        for(int i=0;i<n;i++){
            List<Integer> list= new ArrayList<Integer>();
            list.add(profit[i]);
            list.add(weight[i]);
            double r= (double) profit[i]/weight[i];
            tm.put(r,list);
        }
        double res=0;
        for(Map.Entry<Double, List<Integer>> x:tm.entrySet()){
            if(x.getValue().get(1)<=sack){
                res+=(x.getValue().get(0));
                sack-=(x.getValue().get(1));
            }else{
                res+=(sack*x.getValue().get(0)/x.getValue().get(1));
//                 res+= sack*x.getKey();
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] profit = {120, 100, 60};
        int[] weight = {17, 13, 8};
        int sack=20;
        double res= FractionalKnapsackProblem(profit,weight,sack);
        System.out.println(res);
    }

}