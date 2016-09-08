public class Solution{
	public int numDecodings(String s){
		int length = s.length();
		if(length == 0) return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.chatAt(n - 1) == '0' ? 0 : 1;

		for(int i = n - 2; i >= 0; i--){
			if(s.charAt(i) == '0'){
				memo[i] = 0;
			} else if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
				memo[i] = memo[i + 1] + memo[i + 2];
			} else {
				memo[i] = memo[i + 1];
			}
		}
		return memo[0];
	}
}