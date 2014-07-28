#include<iostream>
#include<vector>
#include<map>
#include<unordered_map>

using namespace std;

struct Point{
	int x;
	int y;
	Point() : x(0), y(0) {}
	Point(int a, int b) : x(a), y(b) {}
};

/*int maxPoints(vector<Point> &points){
	//stores the result of every line 
	vector<int> result;

	for (vector<Point>::iterator i = points.begin(); i != points.end(); i++){
		for (vector<Point>::iterator j = points.begin(); j != points.end(); j++){
			double k = (i->y - j->y) / (i->x - j->x);
			double b = i->y - i->x * k;
			int num = 0;

			for (vector<Point>::iterator iter = points.begin(); iter != points.end(); iter++){
				if (iter != i && iter != j){
					if (iter->y == k * iter->x + b){
						num++;
					}
				}
			}

			result.push_back(num);
		}
	}

	vector<int>::iterator iter = result.begin();
	int max = *iter;

	for (; iter != result.end(); iter++){
		if (*iter > max){
			max = *iter;
		}
	}

	return max;
*/

int max(int a, int b)
{
	if (a >= b)
	{
		return a;
	}
	else
	{
		return b;
	}
}

int maxPoints(vector<Point> &points){
	if (points.size() <= 1)
		return points.size();

	unordered_map<double, int> hash;
	double fSlope;
	int ret = 0;
	int iVertical, iSame, iMaxValue;

	for (int i = 0; i < points.size(); i++)
	{
		hash.clear();
		iVertical = iSame = iMaxValue = 0;
		for (int j = 0; j < points.size(); j++)
		{
			if (points[i].x == points[j].x)
			{
				//two points are the same
				if (points[i].y == points[j].y)
				{
					iSame++
				}
				else
				{
					//the line is vertical
					iVertical++;
				}
			}
			else
			{
				fSlope = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
				hash[fSlope]++;
				iMaxValue = max(iMaxValue, hash[fSlope]);
			}
		}

		ret = max(ret, max(iMaxValue, iVertical) + iSame);
	}

	return ret;
}

