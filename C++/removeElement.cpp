#include<iostream>

using namespace std;

int removeElement(int A[], int n, int elem){
	for (int i = 0; i < n; i++){
		if (elem == A[i]){
			//move last elements forward 
			for (int j = i; j < n; j++){
				A[j] = A[j + 1];
			}
			
			//the element new A[i] has not been checked, so we reduce i by 1
			i--;
			n--;
		}
	}

	return n;
}

int main()
{
	int A[] = { 3, 3, 3, 3, 3 };

	int n = removeElement(A, 5, 3);	
	cout << n << endl;

	system("pause");
	return 0;
}