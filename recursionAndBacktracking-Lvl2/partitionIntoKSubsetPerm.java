import java.util.*;

public class partitionIntoKSubsetPerm {

	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(i > n){
			for (ArrayList<Integer> var : ans) {
				System.out.print(var+" ");
			}
			System.out.println();
			return;
		}
		for(int ii =0 ; ii <ans.size() ; ii++){
			ArrayList<Integer> l = ans.get(ii);
			boolean flag =true;
			for (int  var : l) {
				if(var == i){
					flag= false;
					break;
				}
			}
			if(flag){
				l.add(i);
			}
			solution(i+1 , n , k , rssf , ans);
			if(flag){
				l.remove(l.size()-1);
			}

		}
		if(ans.size() < k){
			ArrayList<Integer> own = new ArrayList<Integer>();
			own.add(i);
			ans.add(own);
			solution(i+1 , n , k , rssf , ans);
			ans.remove(ans.size()-1);
		

		}
		
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			for(int i  = 0; i < k; i++) {
				ans.add(new ArrayList<>());
			}
			solution(1, n, k, 0, ans);
		}

	}

}