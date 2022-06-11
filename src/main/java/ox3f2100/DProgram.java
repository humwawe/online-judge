package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DProgram {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    String s = in.nextString();
    int[] preMin = new int[n + 5];
    int[] preMax = new int[n + 5];
    int[] sufMin = new int[n + 5];
    int[] sufMax = new int[n + 5];
    int cur = 0;
    int[] v = new int[n + 5];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '-') {
        cur--;
      } else {
        cur++;
      }
      v[i + 1] = cur;
      preMax[i + 1] = Math.max(preMax[i], cur);
      preMin[i + 1] = Math.min(preMin[i], cur);
    }
    for (int i = n; i >= 1; i--) {
      if (s.charAt(i - 1) == '-') {
        sufMin[i] = Math.min(sufMin[i + 1] - 1, -1);
        sufMax[i] = Math.max(sufMax[i + 1] - 1, -1);
      } else {
        sufMin[i] = Math.min(sufMin[i + 1] + 1, 1);
        sufMax[i] = Math.max(sufMax[i + 1] + 1, 1);
      }
    }
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      int max = Math.max(preMax[l - 1], v[l - 1] + sufMax[r + 1]);
      int min = Math.min(preMin[l - 1], v[l - 1] + sufMin[r + 1]);
      out.println(max - min + 1);
    }
  }
}
