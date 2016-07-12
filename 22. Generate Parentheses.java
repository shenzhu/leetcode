public class Solution {
    private void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max * 2){
            list.add(str);
            return;
        }
        
        if(open < max){
            backtrack(list, str + "(", open + 1, close, max);
        }
        if(close < open){
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n <= 0) return list;
        
        backtrack(list, "", 0, 0, n);
        return list;
    }
}