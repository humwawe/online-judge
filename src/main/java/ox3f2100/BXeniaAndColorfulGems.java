package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class BXeniaAndColorfulGems {
  long res = (long) 5e18;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    res = (long) 5e18;

    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    int[] a = new int[n1];
    TreeSet<Integer> seta = new TreeSet<>();
    for (int i = 0; i < n1; i++) {
      a[i] = in.nextInt();
      seta.add(a[i]);
    }

    int[] b = new int[n2];

    TreeSet<Integer> setb = new TreeSet<>();
    for (int i = 0; i < n2; i++) {
      b[i] = in.nextInt();
      setb.add(b[i]);
    }

    int[] c = new int[n3];
    TreeSet<Integer> setc = new TreeSet<>();
    for (int i = 0; i < n3; i++) {
      c[i] = in.nextInt();
      setc.add(c[i]);
    }

    helper2(a, setb, setc);
    helper2(a, setc, setb);
    helper2(b, seta, setc);
    helper2(b, setc, seta);
    helper2(c, seta, setb);
    helper2(c, setb, seta);

    out.println(res);
  }

  void helper2(int[] a, TreeSet<Integer> setb, TreeSet<Integer> setc) {
    for (int x : a) {
      Integer f1 = setb.floor(x);
      Integer c2 = setc.ceiling(x);
      if (f1 != null && c2 != null) {
        res = Math.min(res, helper(x, f1, c2));
      }
    }
  }

  private long helper(long x, long y, long z) {
    return (x - y) * (x - y) + (y - z) * (y - z) + (z - x) * (z - x);
  }
}
