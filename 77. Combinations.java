public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if(k > n) return list;
        addToList(list, new ArrayList<Integer>(), n, k, 1);
        return list;
    }
    
    public void addToList(List<List<Integer>> list, List<Integer> temp, int n, int k, int m){
        // We have added all k numbers in one combination
        if(k == 0){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        
        // Add every possible number 
        for(int i = m; i <= n - k + 1; i++){
            temp.add(i);
            addToList(list, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}