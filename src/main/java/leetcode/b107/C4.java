package leetcode.b107;

import java.util.*;

/**
 * @author hum
 */
public class C4 {
  public int[] countServers(int n, int[][] logs, int x, int[] queries) {
    int[] res = new int[queries.length];

    List<int[]> list = new ArrayList<>();
    for (int[] log : logs) {
      list.add(new int[]{log[1], log[0], 0});
    }

    for (int i = 0; i < queries.length; i++) {
      list.add(new int[]{queries[i], i, 1});
    }

    list.sort((a, b) -> {
      int d = a[0] - b[0];
      if (d == 0) {
        return a[2] - b[2];
      }
      return d;
    });


    Deque<int[]> deque = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++) {
      int type = list.get(i)[2];
      int time = list.get(i)[0];
      int idx = list.get(i)[1];
      if (type == 0) {
        deque.addLast(list.get(i));
        map.put(idx, map.getOrDefault(idx, 0) + 1);
      } else {
        while (!deque.isEmpty() && deque.peekFirst()[0] < time - x) {
          int[] first = deque.pollFirst();
          int j = first[1];
          map.put(j, map.get(j) - 1);
          if (map.get(j) == 0) {
            map.remove(j);
          }
        }
        res[idx] = n - map.size();
      }
    }
    return res;

  }
}
