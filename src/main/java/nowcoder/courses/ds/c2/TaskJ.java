package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskJ {
  long inf = (long) 1e17;
  char[] s;
  long[][] val;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    s = in.nextString().toCharArray();


    val = new long[n][3];
    for (int i = 1; i < n; i++) {
      val[i][0] = in.nextLong();
      val[i][1] = in.nextLong();
      val[i][2] = in.nextLong();
    }

    SegmentTree1 segmentTree1 = new SegmentTree1(n);

    for (int i = 0; i < m; i++) {
      int op = in.nextInt();
      if (op == 0) {
        int idx = in.nextInt();
        char c = in.nextCharacter();
        s[idx - 1] = c;
        segmentTree1.modify(1, idx, helper(idx));
      } else if (op == 2) {
        int hs = in.nextInt();
        int ht = in.nextInt();
        int ps = in.nextInt();
        int pt = in.nextInt();
        long l = segmentTree1.query(1, hs, ht - 1).mat[ps * 2 + pt];
        out.println(l == inf ? -1 : l);
      } else {
        int idx = in.nextInt();
        val[idx][0] = in.nextLong();
        val[idx][1] = in.nextLong();
        val[idx][2] = in.nextLong();
        segmentTree1.modify(1, idx, helper(idx));
      }


    }
  }

  Matrix helper(int x) {
    if (s[x - 1] == '/') {
      return new Matrix(new long[]{val[x][0], val[x][2], inf, val[x][1]}, 2);
    } else {
      return new Matrix(new long[]{val[x][0], inf, val[x][2], val[x][1]}, 2);
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
      build(1, 1, n - 1);
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
      val[u] = val[u << 1].mul(val[u << 1 | 1]);
    }

    private void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        val[u] = helper(l);
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
        return query(u << 1, l, r).mul(query(u << 1 | 1, l, r));
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

    public void fill(long v) {
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
    public Matrix mul(Matrix b) {
      assert m == b.n;
      int h = n;
      int mid = m;
      int w = b.m;
      Matrix c = new Matrix(h, w);
      c.fill(inf);
      for (int i = 0; i < h; i++) {
        for (int k = 0; k < mid; k++) {
          for (int j = 0; j < w; j++) {
            c.mat[i * w + j] = Math.min(c.mat[i * w + j], mat[i * mid + k] + b.mat[k * w + j]);
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
