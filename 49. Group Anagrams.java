public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<>();
        // Arrays.sort(strs);       this line is not necessary unless lexicographical order required

        for(String s: strs){
            // Get the value of current s
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);

            // Check if already exists in map
            if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}