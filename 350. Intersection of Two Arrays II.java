// Method One: HashMap
public class Solution{
    public int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Add elements of nums1 to map
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i]) + 1);
            else map.put(nums1[i], 1);
        }

        // Find intersections to result
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] intersect = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            intersect[i] = result.get(i);
        }

        return intersect;
    }
}


// Method Two: Two pointers
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i< nums1.length && j<nums2.length;){
                if(nums1[i]<nums2[j]){
                    i++;
                }
                else if(nums1[i] == nums2[j]){
                    res.add(nums1[i]);
                    i++;
                    j++;
                }
                else{
                    j++;
                }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}