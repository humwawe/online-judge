package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskK {
  int mod = (int) (1e9 + 7);

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String s = in.nextString();
    Matrix[] a = new Matrix[n];
    a[0] = new Matrix(2, 2);
    a[0].asStandard();

    int[][] x = new int[][]{{1, 1}, {0, 1}};
    int[][] y = new int[][]{{1, 0}, {1, 1}};
    for (int i = 1; i < n; i++) {
      char c = s.charAt(i - 1);
      if (c == '/') {
        a[i] = new Matrix(x);
      } else {
        a[i] = new Matrix(y);
      }
    }
    SegmentTree1 segmentTree1 = new SegmentTree1(a);

    for (int i = 0; i < m; i++) {
      int op = in.nextInt();
      if (op == 0) {
        int idx = in.nextInt();
        char c = in.nextCharacter();
        if (c == '/') {
          segmentTree1.modify(1, idx, new Matrix(x));
        } else {
          segmentTree1.modify(1, idx, new Matrix(y));
        }
      } else {
        int hs = in.nextInt();
        int ht = in.nextInt();
        int ps = in.nextInt();
        int pt = in.nextInt();
        out.println(segmentTree1.query(1, hs, ht - 1).mat[ps * 2 + pt]);
      }


    }
  }

  class SegmentTree1 {
    int N;
    Matrix[] w;
    int[] left;
    int[] right;
    Matrix[] val;

    public SegmentTree1(int n) {
      this.N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      val = new Matrix[N * 4];
      w = new Matrix[n];
      build(1, 0, n - 1);
    }

    public SegmentTree1(Matrix[] w) {
      this.w = w;
      this.N = w.length + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      val = new Matrix[N * 4];
      build(1, 0, w.length - 1);
    }

    void pushUp(int u) {
      val[u] = val[u << 1].mul(val[u << 1 | 1], mod);
    }

    private void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        val[u] = w[r];
        return;
      }
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    // 从u开始查找，需满足l<=r
    Matrix query(int u, int l, int r) {
      // 已经完全在[l,r]中了
      if (left[u] >= l && right[u] <= r) {
        return val[u];
      }
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return query(u << 1, l, r).mul(query(u << 1 | 1, l, r), mod);
      }
    }


    // 从u开始，修改x位置的值为v
    void modify(int u, int x, Matrix v) {
      if (left[u] == x && right[u] == x) {
        val[u] = v;
        return;
      }
      int mid = left[u] + right[u] >> 1;
      if (x <= mid) {
        modify(u << 1, x, v);
      } else {
        modify(u << 1 | 1, x, v);
      }
      pushUp(u);
    }
  }

  class Matrix {
    int n, m;
    long[] mat;

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
