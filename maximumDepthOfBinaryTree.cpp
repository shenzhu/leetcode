#include<iostream>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int maxDepth(TreeNode *root)
{
	if (root == NULL){
		return 0;
	}

	int leftDepth = maxDepth(root->left);
	int rightDepth = maxDepth(root->right);

	if (leftDepth > rightDepth)
	{
		return leftDepth + 1;
	}
	else
	{
		return rightDepth + 1;
	}
}