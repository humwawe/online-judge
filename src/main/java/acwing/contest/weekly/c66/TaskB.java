package acwing.contest.weekly.c66;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char[] ss = s.toCharArray();
    int len = s.length();
    int t = 0;
    int cnt = 0;
    int[] sum = new int[26];
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '?') {
        cnt++;
      } else {
        char c = s.charAt(i);
        if (sum[c - 'A'] == 0) {
          t++;
        }
        sum[c - 'A']++;
      }

      if (i >= 26) {
        int j = i - 26;
        if (s.charAt(j) == '?') {
          cnt--;
        } else {
          char c = s.charAt(j);
          sum[c - 'A']--;
          if (sum[c - 'A'] == 0) {
            t--;
          }
        }
      }

      if (t + cnt >= 26) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
          if (sum[j] == 0) {
            list.add(j);
          }
        }
        int idx = 0;
        for (int j = i - 25; j <= i; j++) {
          if (s.charAt(j) == '?') {
            ss[j] = (char) ('A' + list.get(idx++));
          }
        }
        for (int j = 0; j < len; j++) {
          if (ss[j] == '?') {
            out.print('A');
          } else {
            out.print(ss[j]);
          }
        }
        out.println();
        return;
      }
    }
    out.println(-1);
  }
}
