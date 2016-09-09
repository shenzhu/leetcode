public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet();
        Set repeated = new HashSet();
        
        String ten;
        for(int i = 0; i + 9 < s.length(); i++){
            ten = s.substring(i, i + 10);
            if(!seen.add(ten)){
                repeated.add(ten);
            }
        }
        
        return new ArrayList<String>(repeated);
    }
}