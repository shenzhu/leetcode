public class Solution{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Corner case
        if(numRows < 1) return triangle;

        for(int i = 0; i < numRows; i++){
            List<Integer> level = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(i == 0 || j == 0 || i == j){
                    level.add(1);
                }else{
                    level.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(level);
        }

        return triangle;
    }
}
