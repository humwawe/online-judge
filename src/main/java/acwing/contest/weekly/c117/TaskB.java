package acwing.contest.weekly.c117;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[26];
    int res = 0;
    for (int i = 0; i < 2 * n - 2; i++) {
      int c = in.nextCharacter();
      if (Character.isUpperCase(c)) {
        if (cnt[c - 'A'] == 0) {
          res++;
        } else {
          cnt[c - 'A']--;
        }
      } else {
        cnt[c - 'a']++;
      }
    }
    out.println(res);
  }
}
