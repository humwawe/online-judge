package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CSumOfNestings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextLong();
    if ((long) n * (n - 1) / 2 < k) {
      out.println("Impossible");
      return;
    }
    dfs(out, n, k);
  }

  private void dfs(OutputWriter out, int n, long k) {
    if (n == 0) {
      return;
    }
    if (n - 1 <= k) {
      out.print("(");
      dfs(out, n - 1, k - (n - 1));
      out.print(")");
    } else {
      out.print("()");
      dfs(out, n - 1, k);
    }
  }
}
