package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCyclicRotation {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    int j = n - 1;
    for (int i = n - 1; i >= 0 && j >= 0; ) {
      while (j - 1 >= 0 && b[j] == b[j - 1]) {
        cnt[b[j]]++;
        j--;
      }

      if (a[i] == b[j]) {
        i--;
        j--;
      } else if (cnt[a[i]] > 0) {
        cnt[a[i]]--;
        i--;
      } else {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
