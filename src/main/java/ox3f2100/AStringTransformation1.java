package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AStringTransformation1 {
  int N = 25;
  int[] p = new int[N];
  int res = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int i = 0; i < N; i++) {
      p[i] = i;
    }
    int n = in.nextInt();
    res = 0;
    String s = in.nextString();
    String t = in.nextString();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) > t.charAt(i)) {
        out.println(-1);
        return;
      }
      merge(s.charAt(i) - 'a', t.charAt(i) - 'a');
    }

    out.println(res);
  }

  int find(int x) {
    if (p[x] == x) {
      return x;
    }
    return p[x] = find(p[x]);
  }

  void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      p[x] = y;
      res++;
    }
  }
}
