package leetcode.c362;

/**
 * @author hum
 */
public class C4 {

  public int numberOfWays(String s, String t, long k) {
    String tmp = t + "#" + s + s;
    int[] zs = zFunction(tmp);
    int c = 0;
    for (int i = t.length() + 1; i < tmp.length() - s.length(); i++) {
      if (zs[i] == s.length()) {
        c++;
      }
    }

    int[][] a = {{c - 1, c}, {s.length() - c, s.length() - 1 - c}};

    if (t.equals(s)) {
      int[] b = {1, 0};
      int[] pow = pow(a, b, k);
      return pow[0];
    } else {
      int[] b = {0, 1};
      int[] pow = pow(a, b, k);
      return pow[0];
    }


  }

  public final int mod = 1000000007;
  public final long m2 = (long) mod * mod;
  public final long BIG = 8L * m2;

  // A^e*v
  public int[] pow(int[][] A, int[] v, long e) {
    for (int i = 0; i < v.length; i++) {
      if (v[i] >= mod) {
        v[i] %= mod;
      }
    }
    int[][] MUL = A;
    for (; e > 0; e >>>= 1) {
      if ((e & 1) == 1) {
        v = mul(MUL, v);
      }
      MUL = p2(MUL);
    }
    return v;
  }

  // int matrix*int vector
  public int[] mul(int[][] A, int[] v) {
    int m = A.length;
    int n = v.length;
    int[] w = new int[m];
    for (int i = 0; i < m; i++) {
      long sum = 0;
      for (int k = 0; k < n; k++) {
        sum += (long) A[i][k] * v[k];
        if (sum >= BIG) {
          sum -= BIG;
        }
      }
      w[i] = (int) (sum % mod);
    }
    return w;
  }

  // int matrix^2 (be careful about negative value)
  public int[][] p2(int[][] A) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
      long[] sum = new long[n];
      for (int k = 0; k < n; k++) {
        for (int j = 0; j < n; j++) {
          sum[j] += (long) A[i][k] * A[k][j];
          if (sum[j] >= BIG) {
            sum[j] -= BIG;
          }
        }
      }
      for (int j = 0; j < n; j++) {
        C[i][j] = (int) (sum[j] % mod);
      }
    }
    return C;
  }

  int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
      if (i <= r && z[i - l] < r - i + 1) {
        z[i] = z[i - l];
      } else {
        z[i] = Math.max(0, r - i + 1);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
          ++z[i];
        }
      }
      if (i + z[i] - 1 > r) {
        l = i;
        r = i + z[i] - 1;
      }
    }
    return z;
  }
}
