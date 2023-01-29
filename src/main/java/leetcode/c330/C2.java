package leetcode.c330;

/**
 * @author PF-2CRL0N
 */
public class C2 {
  public int monkeyMove(int n) {
    int mod = (int) (1e9 + 7);
    long x = modPow0(2, n, mod);
    return (int) ((x - 2 + mod) % mod);
  }

  public long modPow0(long m, long k, long p) {
    m %= p;
    long res = 1;
    int x = 63 - Long.numberOfLeadingZeros(k);
    for (; x >= 0; x--) {
      res = res * res % p;
      if (k << 63 - x < 0) {
        res = res * m % p;
      }
    }
    return res;
  }
}
