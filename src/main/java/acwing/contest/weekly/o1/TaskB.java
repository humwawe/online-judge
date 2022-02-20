package acwing.contest.weekly.o1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
  int q;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    q = in.nextInt();
    // 存下标
    Map<Integer, Integer> map = new HashMap<>();
    int l = 0;
    int r = -1;
    for (int i = 0; i < q; i++) {
      char c = in.nextCharacter();
      int x = in.nextInt();
      if (c == 'R') {
        map.put(x, ++r);
      } else if (c == 'L') {
        map.put(x, --l);
      } else {
        out.println(Math.min(r - map.get(x), map.get(x) - l));
      }
    }
  }
}
