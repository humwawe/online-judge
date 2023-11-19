package leetcode.c372;

/**
 * @author hum
 */
public class C3 {
  public int maximumXorProduct(long a, long b, int n) {
    int mod = (int) (1e9 + 7);
    long x = a >> n << n;
    long y = b >> n << n;

    for (int i = n - 1; i >= 0; i--) {
      if ((a >> i & 1) == (b >> i & 1)) {
        x |= 1L << i;
        y |= 1L << i;
      } else {
        boolean f = x > y;
        if (!f) {
          x |= 1L << i;
        } else {
          y |= 1L << i;
        }
      }
    }
    return (int) (x % mod * (y % mod) % mod);
  }


}
