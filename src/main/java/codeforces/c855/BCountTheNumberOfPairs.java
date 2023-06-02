package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class BCountTheNumberOfPairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int res = 0;
    for (char i = 'a'; i <= 'z'; i++) {
      int a = map.getOrDefault(i, 0);
      int b = map.getOrDefault((char) ('A' + i - 'a'), 0);
      res += Math.min(a, b);
      int c = Math.abs(a - b);
      if (k > 0) {
        res += Math.min(k, c / 2);
        k -= Math.min(k, c / 2);
      }
    }
    out.println(res);
  }
}
