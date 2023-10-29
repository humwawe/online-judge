package nowcoder.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int[] cnt = new int[m];
    for (int i : a) {
      cnt[i - 1]++;
    }
    int[] res = new int[m];
    Integer[] idx = new Integer[m];
    Arrays.setAll(idx, i -> i);
    Arrays.sort(idx, Comparator.comparingInt(x -> cnt[x]));
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = m - 1; i >= 0; i--) {
      int j = idx[i];
      treeMap.put(cnt[j], i);
    }

    int[] sum = new int[m + 1];
    for (int ii = 0; ii < m; ii++) {
      int i = idx[ii];
      sum[ii + 1] = sum[ii] + cnt[i];
    }
    for (int ii = 0; ii < m; ii++) {
      int i = idx[ii];
      if (n - cnt[i] < k) {
        res[i] = -1;
        continue;
      }

      int l = 0;
      int r = cnt[idx[m - 1]];
      while (l < r) {
        int mid = l + r >> 1;
        int p = treeMap.ceilingEntry(mid).getValue();
        int s = sum[m] - sum[p];
        int len = m - p;
        if (cnt[i] >= mid) {
          s -= cnt[i];
          len--;
        }
        if (s - len * mid <= k) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      res[i] = l;

    }
    out.println(res);

  }
}
