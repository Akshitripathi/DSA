package ADI.DP;

public class EditDistance {
    public static void main(String[] args) {
        String s1= "hello";
        String s2= "seldom";
        int l1= s1.length();
        int l2= s2.length();
        int count= editDistance(s1,s2,l1,l2);
        System.out.println(count);
    }
    static int editDistance(String s1, String s2, int l1, int l2){
        if(l1==0){
            return l2;
        }
        if(l2==0){
            return l1;
        }
        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            return editDistance(s1,s2,l1-1,l2-1);
        }
        return 1+Math.min(editDistance(s1,s2,l1,l2-1),Math.min(editDistance(s1,s2,l1-1,l2),editDistance(s1,s2,l1-1,l2-1)));
    }
}
