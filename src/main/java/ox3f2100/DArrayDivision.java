package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DArrayDivision {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    if (sum % 2 != 0) {
      out.println("NO");
      return;
    }
    sum = sum / 2;

    if (check(a, sum)) {
      out.println("YES");
      return;
    }
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
    }
    if (check(a, sum)) {
      out.println("YES");
      return;
    }
    out.println("No");
  }

  private boolean check(int[] a, long sum) {
    Set<Long> set = new HashSet<>();
    set.add(0L);
    long t = 0;
    boolean f = true;
    for (int i = 0; i < a.length; i++) {
      t += a[i];
      if (f && t < sum) {
        set.add(t);
      } else {
        f = false;
        long need = sum - a[i];
        if (set.contains(need)) {
          return true;
        }
      }
    }
    return false;
  }
}
