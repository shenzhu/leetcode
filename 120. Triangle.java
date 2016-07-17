public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;      // corner case
        
        int[] minLength = new int[triangle.size() + 1];
        for(int layer = triangle.size() - 1; layer >= 0; layer--){
            for(int i = 0; i < triangle.get(layer).size(); i++){
                minLength[i] = triangle.get(layer).get(i) + Math.min(minLength[i], minLength[i + 1]);
            }
        }
        
        return minLength[0];
    }
}