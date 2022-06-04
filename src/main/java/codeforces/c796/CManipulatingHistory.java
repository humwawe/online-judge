package codeforces.c796;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CManipulatingHistory {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[26];
    for (int i = 0; i < 2 * n; i++) {
      String t = in.nextString();
      for (char c : t.toCharArray()) {
        cnt[c - 'a'] ^= 1;
      }
    }
    String t = in.nextString();
    for (char c : t.toCharArray()) {
      cnt[c - 'a'] ^= 1;
    }
    for (int i = 0; i < 26; i++) {
      if (cnt[i] == 1) {
        out.println((char) ('a' + i));
        return;
      }
    }
  }
}
