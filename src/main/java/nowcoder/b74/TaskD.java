package nowcoder.b74;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    List<Long> list = new ArrayList<>();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] > 0) {
        list.add((long) a[i] * (n - i));
      }
      sum += a[i];
    }

    list.sort((x, y) -> Long.compare(y, x));

    for (int i = 0; i < Math.min(list.size(), m); i++) {
      sum -= list.get(i);
    }
    out.println(sum);
  }
}
