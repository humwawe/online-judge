package nowcoder.courses.ds.c4.b;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskB {
  int[] a;
  List<int[]> list = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] left = new int[m];
    int[] right = new int[m];
    int[] time = new int[m];
    int[] id = new int[m];
    int q = 0;
    int t = 0;
    a = in.nextInt(n);
    for (int i = 0; i < m; i++) {
      char c = in.nextCharacter();
      int x = in.nextInt();
      int y = in.nextInt();
      if (c == 'Q') {
        left[q] = x - 1;
        right[q] = y - 1;
        time[q] = t;
        id[q] = q++;
      } else {
        list.add(new int[]{x - 1, y});
        t++;
      }
    }
    Mo mo = new Mo(q, Arrays.copyOf(left, q), Arrays.copyOf(right, q), Arrays.copyOf(id, q), Arrays.copyOf(time, q));
    long[] res = mo.mo();
    for (long re : res) {
      out.println(re);
    }
  }

  class Mo {
    // 分块大小，一般为 sqrt(n)
    int B = 500;
    int m;
    long tmpAns;
    int[] cnt = new int[1000005];
    int[] left;
    int[] right;
    int[] time;
    int[] id;

    public Mo(int m) {
      this.m = m;
      left = new int[m];
      right = new int[m];
      time = new int[m];
      id = new int[m];
    }

    public Mo(int m, int[] left, int[] right, int[] id, int[] time) {
      this.m = m;
      this.left = left;
      this.right = right;
      this.id = id;
      this.time = time;
    }

    long[] mo() {
      Integer[] idx = new Integer[m];
      for (int i = 0; i < m; i++) {
        idx[i] = i;
      }
      Arrays.sort(idx, (x, y) -> {
        int d = left[x] / B - left[y] / B;
        if (d == 0) {
          if (right[x] == right[y]) {
            return time[x] - time[y];
          }
          return right[x] - right[y];
        }
        return d;
      });


      long[] res = new long[m];
      int l = 0;
      int r = -1;
      int t = 0;
      // 对所有询问
      for (int i = 0; i < m; i++) {
        int j = idx[i];
        while (r < right[j]) {
          add(++r);
        }
        while (l > left[j]) {
          add(--l);
        }
        while (r > right[j]) {
          del(r--);
        }
        while (l < left[j]) {
          del(l++);
        }
        while (t < time[j]) {
          change(t++, j);
        }
        while (t > time[j]) {
          change(--t, j);
        }
        res[id[j]] = tmpAns;
      }

      return res;

    }

    private void change(int i, int j) {
      int pos = list.get(i)[0];
      int v = list.get(i)[1];
      if (pos >= left[j] && pos <= right[j]) {
        cnt[a[pos]]--;
        if (cnt[a[pos]] == 0) {
          tmpAns--;
        }
        cnt[v]++;
        if (cnt[v] == 1) {
          tmpAns++;
        }
      }
      list.get(i)[1] = a[pos];
      a[pos] = v;

    }

    private void add(int i) {
      cnt[a[i]]++;
      if (cnt[a[i]] == 1) {
        tmpAns++;
      }
    }

    private void del(int i) {
      cnt[a[i]]--;
      if (cnt[a[i]] == 0) {
        tmpAns--;
      }
    }
  }
}
