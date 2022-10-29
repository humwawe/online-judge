package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class F1PromisingStringEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      char c = in.nextCharacter();
      if (c == '+') {
        a[i] = -1;
      } else {
        a[i] = 1;
      }
      sum[i + 1] = sum[i] + a[i];
    }
    int res = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int cnt = sum[j + 1] - sum[i];
        if (cnt >= 0 && cnt * 2 % 3 == 0) {
          res++;
        }
      }
    }
    out.println(res);

  }
}
