import java.util.*;

public class printAbbrevations {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        if(pos == str.length()){
            //if count not zero add cnt two the asf and make it zero.
            if(count > 0){
                asf += count;
                count=0;
            }
            System.out.println(asf);
            return;
        }
        // one time including the char with previous count and calling next terms.
        if(count > 0){
            solution(str , asf + count + str.charAt(pos) , 0 , pos+1);
        }else{
            solution(str , asf + str.charAt(pos) , 0 , pos+1);
        }
        // one time withount adding the char rather including the count for later inclusions.
        solution(str , asf , count+1 , pos+1);
    }
	public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.nextLine();
            solution(str,"",0,0);
        }
    }
    
    
}