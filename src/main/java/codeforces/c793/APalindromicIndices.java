package codeforces.c793;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APalindromicIndices {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();

    int mid = n / 2;
    int j = mid;
    while (j - 1 >= 0 && s.charAt(j - 1) == s.charAt(mid)) {
      j--;
    }
    if (n % 2 == 0) {
      out.println((mid - j) * 2);
    } else {
      out.println((mid - j) * 2 + 1);
    }

  }
}
