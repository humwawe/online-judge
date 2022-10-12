package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CPlatformsJumping {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int d = in.nextInt();
    int[] c = new int[m];
    int sum = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      c[i] = in.nextInt();
      sum += c[i];
      for (int j = 0; j < c[i]; j++) {
        list.add(i + 1);
      }
    }
    int[] a = new int[n];
    int idx = n - sum;
    int x = 0;
    for (int i = idx; i < n; i++) {
      a[i] = list.get(x++);
    }
    int j = 0;
    int cur = -1;
    while (cur + d < n && a[cur + d] == 0) {
      if (j == m) {
        out.println("NO");
        return;
      }

      for (int i = 0; i < c[j]; i++) {
        a[idx++] = 0;
      }
      for (int i = 0; i < c[j]; i++) {
        a[cur + d + i] = j + 1;
      }
      cur = cur + d + c[j] - 1;
      j++;
    }
    out.println("YES");
    out.println(a);
  }
}
