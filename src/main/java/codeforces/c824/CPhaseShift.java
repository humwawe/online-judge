package codeforces.c824;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CPhaseShift {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String t = in.nextString();
    int[] fa = new int[26];
    int[] son = new int[26];
    Arrays.fill(fa, -1);
    Arrays.fill(son, -1);
    for (int i = 0; i < n; i++) {
      int c = t.charAt(i) - 'a';
      if (fa[c] == -1) {
        for (int j = 0; j < 26; j++) {
          if (j == c) {
            continue;
          }
          if (son[j] == -1 && helper(son, c, j)) {
            son[j] = c;
            fa[c] = j;
            break;
          }
        }
      }
      out.print((char) (fa[c] + 'a'));
    }
    out.println();
  }

  private boolean helper(int[] son, int c, int j) {
    int cnt = 0;
    while (true) {
      cnt++;
      if (son[c] == -1) {
        return true;
      }
      if (son[c] == j) {
        break;
      }
      c = son[c];
    }
    return cnt >= 25;
  }
}
