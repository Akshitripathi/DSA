package HashMAp;
import java.util.*;
public class firstUniqueCharacter {

    static int indexOfUniqueChar(String str){
        HashMap<Character,Integer> hm= new HashMap<>();
        for(char ch: str.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++){
            if(hm.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String str= input.nextLine();
        int n= indexOfUniqueChar(str);
        System.out.println(n);
    }
}
