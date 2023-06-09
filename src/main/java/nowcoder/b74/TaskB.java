package nowcoder.b74;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    if (n == 0) {
      out.println(0);
      return;
    }
    int i = 1;
    for (; i <= n; i++) {
      int cur = (i + 1) * i / 2;
      if (cur <= n) {
        continue;
      }
      break;
    }
    i--;

    int last = n - (i + 1) * i / 2;
    int[] res = new int[i];
    for (int j = 0; j < i; j++) {
      res[j] = j + 1;
    }

    res[i - 1] += last;
    out.println(res);
  }
}
