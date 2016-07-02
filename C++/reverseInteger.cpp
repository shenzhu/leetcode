#include<iostream>
#include<stack>

using namespace std;

int reverse(int x){
	int result = 0;

	while (x){
		result = result * 10 + (x % 10);
		x /= 10;
	}

	return result;
}

int main()
{
	int a = 81726381723681;
	int b = -12314513541;
	int c = 0;

	a = reverse(a);
	b = reverse(b);
	c = reverse(c);

	cout << a << endl;
	cout << b << endl;
	cout << c << endl;

	system("pause");
	return 0;
}
