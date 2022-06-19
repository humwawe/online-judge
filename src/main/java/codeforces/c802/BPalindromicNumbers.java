package codeforces.c802;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.math.BigInteger;

public class BPalindromicNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    if (s.charAt(0) != '9') {
      for (int i = 0; i < n; i++) {
        out.print(9 - (s.charAt(i) - '0'));
      }
      out.println();
    } else {
      BigInteger bigInteger = new BigInteger("1".repeat(n + 1));
      BigInteger res = bigInteger.subtract(new BigInteger(s));
      out.println(res);
    }
  }
}
