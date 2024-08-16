/*
Given an integer n, return the number of prime numbers that are strictly less than n.
 */
package problem.basic;


import java.util.Arrays;

public class CountPrimes {
    private static int sieveMethod(int n, boolean[] isPrime) {
        Arrays.fill(isPrime,true);
        for (int i = 2; i * i <n; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count=0;
        for(int i=2;i<isPrime.length;++i) {
            if(isPrime[i]) count++;
        }

        return count;
    }

    public int countPrimes(int n) {
        boolean[] isPrime=new boolean[n];
        return sieveMethod(n,isPrime);
    }
}
