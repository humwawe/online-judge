package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BRootersSong {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int w = in.nextInt();
    int h = in.nextInt();
    Map<Integer, List<int[]>> map1 = new HashMap<>();
    Map<Integer, List<int[]>> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int type = in.nextInt();
      int p = in.nextInt();
      int t = in.nextInt();
      if (type == 1) {
        map1.computeIfAbsent(p - t, x -> new ArrayList<>()).add(new int[]{p, 0, i});
        map2.computeIfAbsent(p - t, x -> new ArrayList<>()).add(new int[]{p, h, i});
      } else {
        map1.computeIfAbsent(p - t, x -> new ArrayList<>()).add(new int[]{0, p, i});
        map2.computeIfAbsent(p - t, x -> new ArrayList<>()).add(new int[]{w, p, i});
      }
    }

    for (List<int[]> value : map1.values()) {
      value.sort((x, y) -> {
        int d = y[1] - x[1];
        if (d == 0) {
          return x[0] - y[0];
        }
        return d;
      });
    }

    for (List<int[]> value : map2.values()) {
      value.sort((x, y) -> {
        int d = y[1] - x[1];
        if (d == 0) {
          return x[0] - y[0];
        }
        return d;
      });
    }

    int[] l = new int[n];
    int[] r = new int[n];

    for (Integer key : map1.keySet()) {
      List<int[]> list1 = map1.get(key);
      List<int[]> list2 = map2.get(key);
      for (int i = 0; i < list1.size(); i++) {
        l[list1.get(i)[2]] = list2.get(i)[0];
        r[list1.get(i)[2]] = list2.get(i)[1];
      }
    }

    for (int i = 0; i < n; i++) {
      out.println(l[i], r[i]);
    }

  }
}
