public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // Calculate area of both squares
        int areaOfSqrA = (C - A) * (D - B);
        int areaOfSqrB = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        
        // Check if overlaps
        int overlap = 0;
        if(right > left && top > bottom){
            overlap = (right - left) * (top - bottom);
        }
        
        return areaOfSqrA + areaOfSqrB - overlap;
    }
}