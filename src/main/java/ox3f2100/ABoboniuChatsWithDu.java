package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ABoboniuChatsWithDu {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int d = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    List<Integer> small = new ArrayList<>();
    List<Integer> big = new ArrayList<>();
    long res = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] > m) {
        big.add(a[i]);
      } else {
        small.add(a[i]);
        res += a[i];
      }
    }
    small.sort((x, y) -> y - x);
    big.sort((x, y) -> y - x);

    long[] sum = new long[small.size() + 1];
    for (int i = 0; i < small.size(); i++) {
      sum[i + 1] = sum[i] + small.get(i);
    }

    long cur = 0;
    for (int i = 1; i <= big.size(); i++) {
      cur += big.get(i - 1);
      long days = (long) (i - 1) * (d + 1) + 1;
      if (days > n) {
        break;
      }
      int left = (int) Math.min(n - days, small.size());
      res = Math.max(res, cur + sum[left]);
    }
    out.println(res);
  }
}
