/*
Problem Description

You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.



Problem Constraints

1 <= A <= 109

2 <= B, C <= 40000
 */
package searching;

public class AthMagicalNumber {
    private static final long MOD = 1000000007;

    // Function to calculate GCD
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Function to count magical numbers less than or equal to x
    private long countMagicalNumbers(long x, long B, long C) {
        long countB = x / B;
        long countC = x / C;
        long countLCM = x / lcm(B,C);
        return countB + countC - countLCM;
    }

    // Binary search to find A-th magical number
    private long findAthMagicalNumber(long A, long B, long C) {
        long low = 1;
        long high = A * Math.min(B, C);

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = countMagicalNumbers(mid, B, C);

            if (count >= A) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high+1; // high is the A-th magical number, adjusted for 0-based indexing
    }

    public int solve(int A, int B, int C) {
        long result = findAthMagicalNumber(A, B, C);
        return (int) (result % MOD);
    }
}
