package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class DPashmakAndParmidasProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Map<Integer, Integer> suf = new HashMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      suf.put(a[i], suf.getOrDefault(a[i], 0) + 1);
    }


    long res = 0;
    Map<Integer, Integer> pre = new HashMap<>();
    for (int i = 0; i < n; i++) {
      res += sum(N - 1) - sum(suf.get(a[i]));

      suf.put(a[i], suf.get(a[i]) - 1);
      if (suf.get(a[i]) == 0) {
        suf.remove(a[i]);
      }

      pre.put(a[i], pre.getOrDefault(a[i], 0) + 1);
      int x = pre.get(a[i]);
      add(x, 1);
    }
    out.println(res);
  }

  int N = (int) (1e6 + 5);
  int[] t = new int[N];

  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, int c) {
    for (int i = x; i < N; i += lowbit(i)) {
      t[i] += c;
    }
  }

  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t[i];
    }
    return res;
  }
}
