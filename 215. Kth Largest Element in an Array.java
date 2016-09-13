// Solution 1: Sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}

// Solution 2: Priority Queue
public class Solution {
    public int findKthLargest(int[] nums, int k) {
 		PriorityQueue<Integer> pq = new PriorityQueue<>();
 		for(int val : nums){
 			pq.offer(val);

 			if(pq.size() > k){
 				pq.poll();
 			}
 		}
 		return pq.peek();
    }
}

// Solution 3: Selection Sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];	
    }

    private int quickSelect(int[] nums, int lo, int hi, int k){
    	// return the index of the kth smallest number
    	// put nums <= pivot to the left
    	// put nums >= pivot to the right
    	int i = lo, j = hi, pivot = nums[hi];
    	while(i < j){
    		if(nums[i++] > pivot) swap(nums, --i, --j);
    	}
    	swap(nums, i, hi);

    	// count the nums that are <= pivot from lo
    	int m = i - lo + 1;

    	if(m == k) return i;
    	else if(m > k) return quickSelect(nums, 0, i - 1, k);
    	else return quickSelect(nums, i + 1, hi, k - m);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k){
    	// return the index of the kth smallest number
    	// put num <= pivot to the left 
    	// put nums > pivot to the right
    	int i = lo, j = hi, pivot = num[k];
    	while(i < j){
    		if(num[i++] > pivot) swap(nums, --i, --j);
    	}
    	swap(nums, i, hi);

    	// count the nums that are <= pivot from lo
    	int m = i - lo + 1;

    	if(m == k) return i;
    	else if(m > k) return quickSelect(nums, lo, i - 1, k);
    	else return quickSelect(num, i + 1, hi, k - m);
    }

    private void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}