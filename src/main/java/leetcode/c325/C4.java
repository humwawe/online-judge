package leetcode.c325;

/**
 * @author hum
 */
public class C4 {
  public static void main(String[] args) {
    C4 c4 = new C4();
    System.out.println(c4.countPartitions(new int[]{1, 2}, 55));
  }

  public int countPartitions(int[] nums, int k) {
    int n = nums.length;
    int mod = (int) (1e9 + 7);
    long all = 0;
    for (int num : nums) {
      all += num;
    }

    long res = 0;
    if (all < 2 * k) {
      return 0;
    }
    int[][] dp = new int[n + 1][k];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < k; j++) {
        dp[i][j] += dp[i - 1][j];
        if (j - nums[i - 1] >= 0) {
          dp[i][j] += dp[i - 1][j - nums[i - 1]];
        }
        dp[i][j] %= mod;
      }
    }

    for (int i = 0; i < k; i++) {
      res += dp[n][i];
      res %= mod;
    }
    res = res * 2 % mod;

    long sum = pow(2, n, mod);

    return (int) ((sum - res + mod) % mod);
  }

  long pow(long m, long k, long p) {

    long ret = 1;
    int x = 63 - Long.numberOfLeadingZeros(k);
    for (; x >= 0; x--) {
      ret = ret * ret % p;
      if (k << 63 - x < 0) {
        ret = ret * m % p;
      }
    }
    return ret;
  }
}
