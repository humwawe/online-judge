package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskG {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    long cnt = 0;
    long res = 0;
    int mod = (int) (1e9 + 7);
    long sum = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        res += cnt * i - sum;
        res = (res + mod) % mod;
        sum += i;
        cnt++;
      }
    }
    out.println(res);
  }
}
