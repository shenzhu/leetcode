// Version One: Two Pointers
// Time: O(n); Space: O(1)
public class Solution{
	public int removeElement(int[] nums, int val){
		// Corner case
		if(nums == null || nums.length < 1){
			return 0;
		}

		int i = 0;
		for(int j = 0; j < nums.length; j++){
			if(nums[j] != val){
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}
}


// Version Two: Two Pointers - when elements to remove are rare
public class Solution{
	public int removeElement(int[] nums, int val){
		int i = 0;
		int n = nums.length;

		while(i < n){
			if(nums[i] == val){
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			}else{
				i++;
			}
		}

		return n;
	}
}