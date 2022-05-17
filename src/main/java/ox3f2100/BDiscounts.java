package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BDiscounts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    double res = 0;
    List<int[]> list = new ArrayList<>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int c = in.nextInt();
      int t = in.nextInt();
      if (t == 1) {
        cnt++;
      }
      res += c;
      list.add(new int[]{c, t, i});
    }

    list.sort((x, y) -> {
      int d = x[1] - y[1];
      if (d == 0) {
        return y[0] - x[0];
      }
      return d;
    });

    if (cnt >= k - 1) {
      for (int i = 0; i < k - 1; i++) {
        res -= list.get(i)[0] * 0.5;
      }
      if (cnt >= k) {
        res -= Math.min(list.get(cnt - 1)[0], list.get(n - 1)[0]) * 0.5;
      }
    } else {
      for (int i = 0; i < cnt; i++) {
        res -= list.get(i)[0] * 0.5;
      }
    }

    out.printf("%.1f\n", res);

    for (int i = 0; i < k - 1; i++) {
      out.println(1, list.get(i)[2] + 1);
    }

    out.print(n - k + 1);
    for (int i = k - 1; i < n; i++) {
      out.print("", list.get(i)[2] + 1);
    }

  }
}
