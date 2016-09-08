public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        List<String> result = new ArrayList<String>();
            
        for(int i = 0; i < 4 && i < length - 2; i++){
            for(int j = i + 1; j < i + 4 && j < length - 1; j++){
                for(int k = j + 1; k < j + 4 && k < length; k++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, length);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s){
        if(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255){
            return false;
        }
        return true;
    }
}