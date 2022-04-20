package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class DStrangeDevice {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 1; i <= k + 1; i++) {
      out.print("? ");
      for (int j = 1; j <= k + 1; j++) {
        if (i == j) {
          continue;
        }
        out.print(j, "");
      }
      out.println();
      out.flush();
      int x = in.nextInt();
      int y = in.nextInt();
      map.put(y, map.getOrDefault(y, 0) + 1);
      max = Math.max(max, y);
    }
    out.println("!", map.get(max));
    out.flush();
  }
}
