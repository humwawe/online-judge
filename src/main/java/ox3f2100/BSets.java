package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSets {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n * (n - 1) / 2; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int x = in.nextInt();
        map.computeIfAbsent(x, t -> new ArrayList<>()).add(i);
      }
    }

    List<Integer> list = new ArrayList<>(map.keySet());
    if (n == 2) {
      out.println(1, list.get(0));
      out.print(list.size() - 1);
      for (int i = 1; i < list.size(); i++) {
        out.print("", list.get(i));
      }
      return;
    }

    boolean[] vis = new boolean[list.size()];
    for (int i = 0; i < list.size(); i++) {
      if (vis[i]) {
        continue;
      }
      vis[i] = true;
      List<Integer> tmp = new ArrayList<>();
      tmp.add(list.get(i));
      f:
      for (int j = i + 1; j < list.size(); j++) {
        for (int k = 0; k < map.get(list.get(i)).size(); k++) {
          if (!map.get(list.get(i)).get(k).equals(map.get(list.get(j)).get(k))) {
            continue f;
          }
        }
        vis[j] = true;
        tmp.add(list.get(j));
      }
      out.print(tmp.size(), "");
      out.println(tmp);
    }
  }
}
