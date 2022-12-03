package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;
import util.MathMeth;

public class TaskF {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String b = in.nextString();
    String n = in.nextString();
    int c = in.nextInt();
    if (c == 1) {
      out.println(1);
      return;
    }


    String b1 = helper(b);
    String n1 = helper(n);
    int phi = (int) MathMeth.phi(c);
    long br = helper2(b, c);
    long b1r = helper2(b1, c);
    long res = 0;
    CombinationMath.initMod(c);
    if (comp(n1, phi) <= 0) {
      long n1r = Long.parseLong(n1);
      res = MathMeth.modPow0(br, n1r, c) * b1r % c;
      //      res = CombinationMath.pow(br, n1r) * b1r % c;
    } else {
      //      long n1r = helper2(n1, phi);
      res = MathMeth.modPow2(br, n1, c, MathMeth.phi(c)) * b1r % c;
      //      res = CombinationMath.pow(br, n1r + phi) * b1r % c;

    }

    out.println(res == 0 ? c : res);
  }

  private int comp(String n1, int phi) {
    String n2 = String.valueOf(phi);
    if (n1.length() > n2.length()) {
      return 1;
    }
    if (n1.length() < n2.length()) {
      return -1;
    }
    return n1.compareTo(n2);
  }

  private long helper2(String s, int mod) {
    int n = s.length();
    long res = 0;
    long base = 1;
    for (int i = 0; i < n; i++) {
      res = (res * 10 + (s.charAt(i) - '0')) % mod;
    }
    //    for (int i = n - 1; i >= 0; i--) {
    //      res = (res + base * (s.charAt(i) - '0')) % mod;
    //      base = base * 10 % mod;
    //    }
    return res;
  }

  private String helper(String s) {
    int n = s.length();
    StringBuilder sb = new StringBuilder(s);
    int x = 1;
    for (int i = n - 1; i >= 0; i--) {
      int cur = s.charAt(i) - '0';
      if (cur >= x) {
        sb.setCharAt(i, (char) ('0' + cur - x));
        break;
      }
      sb.setCharAt(i, (char) ('0' + 10 + cur - x));
      x = 1;
    }
    return sb.toString();
  }
}
