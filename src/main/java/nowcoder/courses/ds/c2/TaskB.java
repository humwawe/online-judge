package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskB {
  int n, m;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt(n);
    mapping(a);
    m = in.nextInt();
    int[] left = new int[m];
    int[] right = new int[m];
    int[] id = new int[m];
    for (int i = 0; i < m; i++) {
      left[i] = in.nextInt() - 1;
      right[i] = in.nextInt() - 1;
      id[i] = i;
    }
    Mo mo = new Mo(m, left, right, id);
    int[] res = mo.mo();
    for (int r : res) {
      out.println(r);
    }

  }

  Map<Integer, Integer> mapping(int[] x) {
    Map<Integer, Integer> map = new HashMap<>(x.length);
    int cnt = 0;
    int[] a = Arrays.copyOf(x, x.length);
    Arrays.sort(a);
    for (int value : a) {
      if (!map.containsKey(value)) {
        map.put(value, cnt++);
      }
    }
    for (int i = 0; i < x.length; i++) {
      x[i] = map.get(x[i]);
    }
    return map;
  }

  class Mo {
    // 分块大小，一般为 sqrt(n)
    int B = 500;
    int m;
    int tmpAns;
    int[] left;
    int[] right;
    int[] id;

    int[] cnt = new int[(int) (5e4 + 5)];

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

    int[] mo() {
      Integer[] idx = new Integer[m];
      for (int i = 0; i < m; i++) {
        idx[i] = i;
      }
      // 按块号（左端点决定）排序
      // 对奇偶的块按右大或小排序
      Arrays.sort(idx, (x, y) -> {
        int d = left[x] / B - left[y] / B;
        if (d == 0) {
          //          if (left[x] / B % 2 == 0) {
          return right[x] - right[y];
          //          }
          //          return right[y] - right[x];
        }
        return d;
      });


      int[] res = new int[m];
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
        res[id[j]] = tmpAns;
      }

      return res;

    }

    private void add(int i) {
      // update tmpAns
      cnt[a[i]]++;
      if (cnt[a[i]] == 1) {
        tmpAns++;
      }
    }

    private void del(int i) {
      // update tmpAns
      cnt[a[i]]--;
      if (cnt[a[i]] == 0) {
        tmpAns--;
      }
    }
  }
}
