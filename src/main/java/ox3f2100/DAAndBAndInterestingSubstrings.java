package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DAAndBAndInterestingSubstrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] s = new int[26];
    for (int i = 0; i < 26; i++) {
      s[i] = in.nextInt();
    }
    String str = in.nextString();
    Map<Long, Integer>[] map = new Map[26];
    Arrays.setAll(map, e -> new HashMap<>());
    long sum = 0;
    long res = 0;
    for (int i = 0; i < str.length(); i++) {
      int c = str.charAt(i) - 'a';
      res += map[c].getOrDefault(sum, 0);
      sum += s[c];
      map[c].put(sum, map[c].getOrDefault(sum, 0) + 1);
    }
    out.println(res);
  }
}
