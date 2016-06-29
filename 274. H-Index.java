public class Solution{
    public int hIndex(int[] citations){
        // Corner case
        if(citations == null || citations.length == 0){
            return 0;
        }

        int h = 0;
        int n = citations.length;
        Arrays.sort(citations);     // sort array

        for(int i = n - 1; i >= 0 && citations[i] >= (n - i); i--){
            h = n - i;
        }

        return h;
    }
}