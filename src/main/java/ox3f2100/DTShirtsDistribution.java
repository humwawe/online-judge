package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTShirtsDistribution {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String[] cmp = {"S,M", "M,L", "L,XL", "XL,XXL", "XXL,XXXL"};
    String[] as = {"S", "M", "L", "XL", "XXL", "XXXL"};
    int[] a = new int[6];
    for (int i = 0; i < 6; i++) {
      a[i] = in.nextInt();
    }
    int n = in.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = in.nextString();
      for (int j = 0; j < 6; j++) {
        if (s[i].equals(as[j])) {
          a[j]--;
        }
      }
    }

    for (int i = 0; i < 6; i++) {
      if (a[i] < 0) {
        out.println("NO");
        return;
      }
    }

    for (int t = 0; t < 5; t++) {
      for (int i = 0; i < n; i++) {
        if (s[i].equals(cmp[t])) {
          if (a[t] > 0) {
            a[t]--;
            s[i] = as[t];
          } else if (a[t + 1] > 0) {
            a[t + 1]--;
            s[i] = as[t + 1];
          } else {
            out.println("NO");
            return;
          }
        }
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.println(s[i]);
    }
  }
}
