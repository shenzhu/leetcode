public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Corner case
        if(k <= 0 || n <= 0) return result;
        
        combination(result, new ArrayList<Integer>(), 1, k, n);
        return result;
    }
    
    private void combination(List<List<Integer>> result, List<Integer> list, int start, int k, int n){
        if(list.size() == k && n == 0) result.add(new ArrayList<Integer>(list));
        if(list.size() > k) return;
        for(int i = start; i <= 9; i++){
            list.add(i);
            combination(result, list, i + 1, k, n - i);
            list.remove(list.size() - 1);
        }
    }
}