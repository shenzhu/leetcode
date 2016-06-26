// Version One: Call iUgly for every number; Time Limit Exceeded
public class Solution{
	public boolean isUgly(int n){
		if(n == 0){
			return false;
		}
		if(n == 1){
			return true;
		}

		while(n % 2 == 0) n /= 2;
		while(n % 3 == 0) n /= 3;
		while(n % 5 == 0) n /= 5;

		return n == 1;
	}

	public int nthUglyNumber(int n){
		int i = 1;
		int count = 0;

		while(count != n){
			if(isUgly(i)){
				count++;
			}
			i++;
		}

		return --i;
	}
}


// Version Two
public class Solution{
	public int nthUglyNUmber(int n){
		int u = 0;
		List<Integer> l2 = new LinkedList<Integer>();
		List<Integer> l3 = new LinkedList<Integer>();
		List<Integer> l5 = new LinkedList<Integer>();
		l2.add(1);
		l3.add(1);
		l5.add(1);

		for(int i = 0; i < n; i++){
			u = Math.min(Math.min(l2.get(0), l3.get(0)), l5.get(0));

			// remove element
			if(l2.get(0) == u) l2.remove(0);
			if(l3.get(0) == u) l3.remove(0);
			if(l5.get(0) == u) l5.remove(0);

			l2.add(u * 2);
			l3.add(u * 3);
			l5.add(u * 5);
		}	
		return u;
	}
}
