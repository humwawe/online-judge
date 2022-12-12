package nowcoder.courses.ds.c4.b;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

import java.util.Arrays;

public class TaskC {
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    a = in.nextInt(n);
    int[] l = new int[m];
    int[] r = new int[m];
    int[] id = new int[m];
    for (int i = 0; i < m; i++) {
      l[i] = in.nextInt() - 1;
      r[i] = in.nextInt() - 1;
      id[i] = i;
    }
    Mo mo = new Mo(m, l, r, id);
    long[][] res = mo.mo();
    for (long[] ret : res) {
      long a = ret[0];
      long b = ret[1] * (ret[1] - 1) / 2;
      long g = MathMeth.gcd(a, b);
      out.println(a / g + "/" + b / g);
    }

  }

  class Mo {
    // 分块大小，一般为 sqrt(n)
    int B = 500;
    int m;
    long tmpAns;
    int[] cnt = new int[50005];
    int[] left;
    int[] right;
    int[] id;

    public Mo(int m) {
      this.m = m;
      left = new int[m];
      right = new int[m];
      id = new int[m];
    }

    public Mo(int m, int[] left, int[] right, int[] id) {
      this.m = m;
      this.left = left;
      this.right = right;
      this.id = id;
    }

    long[][] mo() {
      Integer[] idx = new Integer[m];
      for (int i = 0; i < m; i++) {
        idx[i] = i;
      }
      Arrays.sort(idx, (x, y) -> {
        int d = left[x] / B - left[y] / B;
        if (d == 0) {
          if (left[x] / B % 2 == 0) {
            return right[x] - right[y];
          }
          return right[y] - right[x];
        }
        return d;
      });


      long[][] res = new long[m][2];
      int l = 0;
      int r = -1;
      // 对所有询问
      for (int i = 0; i < m; i++) {
        // 扩展
        int j = idx[i];
        while (r < right[j]) {
          add(++r);
        }
        while (l > left[j]) {
          add(--l);
        }
        // 缩小
        while (r > right[j]) {
          del(r--);
        }
        while (l < left[j]) {
          del(l++);
        }
        res[id[j]][0] = tmpAns;
        res[id[j]][1] = right[id[j]] - left[id[j]] + 1;
      }

      return res;

    }

    private void add(int i) {
      tmpAns += cnt[a[i]];
      cnt[a[i]]++;
      // update tmpAns
    }

    private void del(int i) {
      cnt[a[i]]--;
      tmpAns -= cnt[a[i]];
      // update tmpAns
    }
  }
}
