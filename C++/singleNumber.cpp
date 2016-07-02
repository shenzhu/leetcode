#include<iostream>
#include<map>

using namespace std;

int singleNumber(int array[], int n){
	map<int, int> numberFreq;
	//length of array
	//int length = sizeof(array) / sizeof(array[0]);

	//loop over array and get freq map
	for (int i = 0; i < n; i++)
	{
		//check if array[i] has been in the map
		map<int, int>::iterator result = numberFreq.find(array[i]);
		if (result != numberFreq.end())
		{
			numberFreq.insert(make_pair(array[i], 0));
		}

		numberFreq[array[i]] += 1;
	}

	for (map<int, int>::iterator iter = numberFreq.begin(); iter != numberFreq.end(); iter++)
	{
		if ((iter->second) == 1)
		{
			return iter->first;
		}
	}
}

int main()
{
	int array[] = { 1, 2, 3, 4, 5, 3, 2, 1, 4 };
	int result = singleNumber(array, 9);

	cout << result << endl;

	system("pause");
	return 0;
}