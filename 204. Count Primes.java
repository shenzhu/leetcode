public class Solution{
	public int countPrimes(int n){
		boolean[] EratosthenesSieve = new boolean[n];

		// start from index 2, correspoding to prime numbers
		for(int i = 2; i * i < n; i++){
			if(!EratosthenesSieve[i]){
				for(int j = i; j * i < n; j++){
					EratosthenesSieve[i * j] = true;
				}
			}
		}

		int count = 0;
		for(int i = 2; i < n; i++){
			if(EratosthenesSieve[i] == false){
				count++;
			}
		}

		return count;
	}
}