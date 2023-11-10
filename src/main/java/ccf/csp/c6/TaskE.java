package ccf.csp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  int n;
  int[][] a;
  int[] b;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n][n];
    b = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextCharacter() - '0';
    }

    init(a);

    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int k = in.nextInt();
      int[] pow = pow(b, k);
      for (int ii : pow) {
        out.print(ii);
      }
      out.println();

    }

  }

  private void init(int[][] a) {
    MUL[0] = a;
    for (int i = 1; i < 31; i++) {
      MUL[i] = p2(MUL[i - 1]);
    }
  }

  int[][][] MUL = new int[31][n][n];

  public int[] pow(int[] v, long e) {
    int idx = 0;
    for (; e > 0; e >>>= 1) {
      if ((e & 1) == 1) {
        v = mul(MUL[idx], v);
      }
      idx++;
    }
    return v;
  }

  // int matrix*int vector
  public int[] mul(int[][] A, int[] v) {
    int m = A.length;
    int n = v.length;
    int[] w = new int[m];
    for (int i = 0; i < m; i++) {
      int sum = 0;
      for (int k = 0; k < n; k++) {
        sum ^= A[i][k] & v[k];
      }
      w[i] = sum;
    }
    return w;
  }

  public int[][] p2(int[][] A) {
    int n = A.length;
    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      int[] sum = new int[n];
      for (int k = 0; k < n; k++) {
        for (int j = 0; j < n; j++) {
          sum[j] ^= A[i][k] & A[k][j];
        }
      }
      System.arraycopy(sum, 0, res[i], 0, n);
    }
    return res;
  }
}
