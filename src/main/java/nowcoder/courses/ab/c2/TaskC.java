package nowcoder.courses.ab.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    for (int i = 0; i < n; i++) {
      int s = in.nextInt();
      int c = in.nextInt();
      res ^= dfs(s, c);
    }
    if (res == 0) {
      out.println("No");
    } else {
      out.println("Yes");
    }
  }

  private int dfs(int s, int c) {
    int t = (int) Math.sqrt(s);
    while (t + t * t >= s) {
      t--;
    }

    if (c > t) {
      return s - c;
    }
    if (c == t) {
      return 0;
    }
    return dfs(t, c);
  }
}
