package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int mod = (int) (1e9 + 7);
    String s = in.nextString();
    Matrix[] a = new Matrix[n - 1];

    int[][] x = new int[][]{{1, 1}, {0, 1}};
    int[][] y = new int[][]{{1, 0}, {1, 1}};

    for (int i = 0; i < n - 1; i++) {
      char c = s.charAt(i);
      if (c == '/') {
        a[i] = new Matrix(x);
      } else {
        a[i] = new Matrix(y);
      }
    }
    Matrix[] sum = new Matrix[n + 1];
    sum[0] = new Matrix(2, 2);
    sum[0].asStandard();
    for (int i = 0; i < n - 1; i++) {
      sum[i + 1] = sum[i].mul(a[i], mod);
    }

    for (int i = 0; i < m; i++) {
      int hs = in.nextInt();
      int ht = in.nextInt();
      int ps = in.nextInt();
      int pt = in.nextInt();
      out.println(inv(sum[hs - 1], mod).mul(sum[ht - 1], mod).mat[ps * 2 + pt]);
    }
  }

  Matrix inv(Matrix a, int p) {
    return new Matrix(new long[]{a.mat[3], (p - a.mat[1]) % p, (p - a.mat[2]) % p, a.mat[0]}, 2);
  }

  class Matrix {
    int n, m;
    long[] mat;
    int mod = (int) (1e9 + 7);

    public Matrix(int n, int m) {
      this.n = n;
      this.m = m;
      mat = new long[n * m];
    }

    public Matrix(int[][] a) {
      this.n = a.length;
      this.m = a[0].length;
      mat = new long[n * m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          mat[i * m + j] = a[i][j];
        }
      }
    }

    public Matrix(long[][] a) {
      this.n = a.length;
      this.m = a[0].length;
      mat = new long[n * m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          mat[i * m + j] = a[i][j];
        }
      }
    }

    public Matrix(int[] a, int n) {
      assert a.length % n == 0;
      this.n = n;
      this.m = a.length / n;
      mat = new long[a.length];
      for (int i = 0; i < a.length; i++) {
        mat[i] = a[i];
      }
    }

    public Matrix(long[] a, int n) {
      assert a.length % n == 0;
      this.n = n;
      this.m = a.length / n;
      mat = new long[a.length];
      System.arraycopy(a, 0, mat, 0, a.length);
    }

    public long[][] toArray() {
      long[][] res = new long[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          res[i][j] = mat[i * m + j];
        }
      }
      return res;
    }

    public void fill(int v) {
      Arrays.fill(mat, v);
    }

    public void asStandard() {
      fill(0);
      for (int i = 0; i < mat.length; i += m + 1) {
        mat[i] = 1;
      }
    }

    public void set(int i, int j, long val) {
      mat[i * m + j] = val;
    }

    public long get(int i, int j) {
      return mat[i * m + j];
    }

    // 矩阵乘法，结果对p取模
    // (n m) * (b.n,b.m)
    public Matrix mul(Matrix b, int p) {
      assert m == b.n;
      int h = n;
      int mid = m;
      int w = b.m;
      Matrix c = new Matrix(h, w);

      for (int i = 0; i < h; i++) {
        for (int k = 0; k < mid; k++) {
          for (int j = 0; j < w; j++) {
            c.mat[i * w + j] = (c.mat[i * w + j] + mat[i * mid + k] * b.mat[k * w + j]) % p;
          }
        }
      }
      return c;
    }

    public Matrix plus(Matrix b, int p) {
      assert n == b.n;
      assert m == b.m;
      Matrix res = new Matrix(n, m);
      for (int i = 0; i < res.mat.length; i++) {
        res.mat[i] = (mat[i] + b.mat[i]) % p;
      }
      return res;
    }

    public Matrix subtract(Matrix b, int p) {
      assert n == b.n;
      assert m == b.m;
      Matrix res = new Matrix(n, m);
      for (int i = 0; i < res.mat.length; i++) {
        res.mat[i] = (mat[i] - b.mat[i] + p) % p;
      }
      return res;
    }

    public Matrix mul(Matrix a, long k, int p) {
      Matrix res = new Matrix(n, m);
      for (int i = 0; i < res.mat.length; i++) {
        res.mat[i] = a.mat[i] * k % p;
      }
      return res;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder("\n");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          builder.append(mat[i * m + j]).append(' ');
        }
        builder.append('\n');
      }
      return builder.toString();
    }

  }
}
