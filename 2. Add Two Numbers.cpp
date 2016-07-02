/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        
        //extract numbers from l1 and store them in vector
        vector<int> l1Nums;
        while(l1 != NULL){
            l1Nums.push_back(l1->val);
            l1 = l1->next;
        }
        
        //extract numbers from l2 and store them in vector
        vector<int> l2Nums;
        while(l2 != NULL){
            l2Nums.push_back(l2->val);
            l2 = l2->next;
        }
        
        //construct numbers
        for(vector<int>::size_type i = 0; i != l1Nums.size(); ++i){
            firstNumber += l1Nums[i] * pow(10, l1Nums.size() - 1 - i);
        }
        for(vector<int>::size_type j = 0; j != l2Nums.size(); ++j){
            secondNumber += l2Nums[j] * pow(10, l2Nums.size() - 1 - j);
        }
        
        //add numbers
        result = firstNumber + secondNumber;
        
        //extract numbers from result and store them in vector
        vector<int> resultNums;
        while(result != 0){
            resultNums.push_back(result % 10);
            result / 10;
        }
        
        //make vector<ListNode>
        vector<ListNode> resultNodes;
        for(vector<int>::iterator iter = resultNums.begin(); iter != resultNums.end(); ++iter){
            ListNode newNode = ListNode(*iter);
            resultNodes.push_back(newNode);
        }
        
        //make linked list
        for(vector<ListNode>::size_type i = 0; i < resultNodes.size() - 1; ++i){
            resultNodes[i].next = &resultNodes[i + 1];
        }
        
        return &resultNodes[0];
    }
};