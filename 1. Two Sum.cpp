class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for(vector<int>::size_type i = 0; i != nums.size(); ++i){
            for(vector<int>::size_type j = i + 1; j != nums.size(); ++j){
                if(nums[i] + nums[j] == target){
                    //construct result
                    vector<int> result;
                    result.push_back(i);
                    result.push_back(j);
                    return result;
                }
            }
        }
    }
};