#include<iostream>
#include<map>

using namespace std;

int singleNumber(int A[], int n){
	map<int, int> numberFreq;

	for (int i = 0; i < n; i++){
		map<int, int>::iterator temp = numberFreq.find(A[i]);
		if (temp == numberFreq.end(){
			numberFreq.insert(make_pair(A[i], 0))
		}

		numberFreq[A[i]]++;
	}

	for (map<int, int>::iterator iter = numberFreq.begin(); iter != numberFreq.end(); iter++){
		if (iter->second == 1){
			return iter->first;
		}
	}
}

