#include<iostream>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :val(x), left(NULL), right(NULL) {}
};

bool isSameTree(TreeNode *p, TreeNode *q){
	//both binary trees are empty
	if (p == NULL && q == NULL){
		return true;
	}

	//one is empty and the other is not 
	if ((p == NULL && q != NULL) || (p != NULL && q == NULL)){
		return false;
	}

	//both are not empty
	if ((p->val == q->val) && (isSameTree(p->left, q->left)) && (isSameTree(p->right, q->right))){
		return true;
	}
	else
	{
		return false;
	}
}