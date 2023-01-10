package codeforces.c843;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CInterestingSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long x = in.nextLong();
    if (n < x) {
      out.println(-1);
      return;
    }
    if (n == x) {
      out.println(n);
      return;
    }

    String a = Long.toBinaryString(n);
    a = "0" + a;
    char[] chars = a.toCharArray();

    long res = -1;

    char[] ns = new char[chars.length];
    Arrays.fill(ns, '0');
    for (int i = 1; i < chars.length; i++) {
      ns[i] = chars[i];
      if (chars[i - 1] == '0' && chars[i] == '1') {
        ns[i - 1] = '1';
        ns[i] = '0';
        long tmp = Long.parseLong(new String(ns), 2);
        if ((tmp & n) == x) {
          res = tmp;
        }
        ns[i - 1] = '0';
        ns[i] = '1';
      }
    }
    out.println(res);
  }
}
