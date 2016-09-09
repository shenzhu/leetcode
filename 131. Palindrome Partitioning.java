public class Solution {
    private List<List<String>> resultList;
    private List<String> currList;
    
    public List<List<String>> partition(String s) {
        resultList = new ArrayList<List<String>>();
        currList = new ArrayList<String>();
        
        // Corner case
        if(s == null) return resultList;
        if(s.length() == 0){
            resultList.add(currList);
            return resultList;
        }
        
        backTrack(s, 0);
        
        return resultList;
    }
    
    private void backTrack(String s, int l){
        if(currList.size() > 0 && l == s.length()){
            resultList.add(new ArrayList<>(currList));
        }
        
        for(int i = l; i < s.length(); i++){
            if(isPalindrome(s, l, i)){
                currList.add(s.substring(l, i + 1));
                backTrack(s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int l, int r){
        if(l == r) return true;
        
        while(l < r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}