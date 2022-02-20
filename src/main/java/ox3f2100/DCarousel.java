package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DCarousel {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      set.add(a[i]);
    }
    if (set.size() == 1) {
      out.println(1);
      for (int i = 0; i < n; i++) {
        out.print(1 + " ");
      }
      out.println();
      return;
    }
    if (n % 2 == 0) {
      out.println(2);
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          out.print(1 + " ");
        } else {
          out.print(2 + " ");
        }
      }
      out.println();
      return;
    }
    boolean f = true;
    for (int i = 1; i <= n; i++) {
      if (a[i % n] == a[(i - 1) % n]) {
        f = false;
        break;
      }
    }
    if (f) {
      out.println(3);
      for (int i = 0; i < n - 3; i++) {
        if (i % 2 == 0) {
          out.print(1 + " ");
        } else {
          out.print(2 + " ");
        }
      }
      out.println("1 2 3");
      return;
    }

    out.println(2);
    f = false;
    int last = 1;
    out.print(last + " ");
    for (int i = 1; i < n; i++) {
      if (!f && a[i] == a[i - 1]) {
        out.print(last + " ");
        f = true;
      } else {
        last = 3 - last;
        out.print(last + " ");
      }
    }
    out.println();
  }
}
