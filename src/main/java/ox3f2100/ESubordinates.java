package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ESubordinates {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = in.nextInt();
    int[] cnt = new int[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (i == s - 1 && x != 0) {
        res++;
      }
      cnt[x]++;
    }
    int sum = 1;
    for (int i = 1; sum < n; i++) {
      if (cnt[i] > 0) {
        sum += cnt[i];
      } else {
        sum += 1;
      }
      if (cnt[i] == 0) {
        res++;
      }
    }
    out.println(res);

  }
}
