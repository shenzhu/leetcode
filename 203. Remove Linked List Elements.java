/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; } 
 * } 
 */  
// 重点题目：dummy node的使用情况，当头部节点可能出现变化的时候
// 当链表中出现next.next之类的情况的时候，可以思考使用双指针来处理问题
public class Solution{
	public ListNode removeElements(ListNode head, int val){
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy;
		ListNode q = head;

		while(q != null){
			if(q.val == val){
				p.next = q.next;
			}else{
				p = p.next;
			}
			q = q.next;
		}

		return dummy.next;
	}
}