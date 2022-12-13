package nowcoder.courses.str.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String t = in.nextString();
    int[] match = kmpMatch(s.toCharArray(), t.toCharArray());
    for (int i : match) {
      out.println(i + 1);
    }
    int[] next = kmpNext(t.toCharArray());
    out.println(next);
  }

  public int[] kmpNext(char[] s) {
    int n = s.length;
    int[] next = new int[n];
    for (int i = 1; i < n; i++) {
      next[i] = next[i - 1];
      while (next[i] > 0 && s[i] != s[next[i]]) {
        next[i] = next[next[i] - 1];
      }
      next[i] += s[i] == s[next[i]] ? 1 : 0;
    }
    return next;
  }

  public int[] kmpMatch(char[] s, char[] t) {
    int n = s.length;
    int m = t.length;
    int[] res = new int[n];
    int cnt = 0;

    int[] next = kmpNext(t);
    int j = 0;
    for (int i = 0; i < n; ) {
      while (j > 0 && s[i] != t[j]) {
        j = next[j - 1];
      }
      if (s[i] == t[j]) {
        i++;
        j++;
      } else {
        i++;
      }


      if (j == m) {
        res[cnt++] = i - m;
        j = next[m - 1];
      }
    }
    return Arrays.copyOf(res, cnt);
  }
}
