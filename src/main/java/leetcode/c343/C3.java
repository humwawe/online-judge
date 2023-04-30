package leetcode.c343;

import java.util.*;

/**
 * @author hum
 */
public class C3 {
  public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
    Set<Long> set = new HashSet<>();
    long base = (long) 1e6;
    set.add(start[0] * base + start[1]);
    set.add(target[0] * base + target[1]);

    for (int[] specialRoad : specialRoads) {
      set.add(specialRoad[0] * base + specialRoad[1]);
      set.add(specialRoad[2] * base + specialRoad[3]);
    }
    int n = set.size();
    List<Long> list = new ArrayList<>(set);
    int[][] dis = new int[n][n];
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(list.get(i), i);
      for (int j = 0; j < n; j++) {
        int x1 = (int) (list.get(i) / base);
        int y1 = (int) (list.get(i) % base);

        int x2 = (int) (list.get(j) / base);
        int y2 = (int) (list.get(j) % base);

        dis[i][j] = dis[j][i] = Math.abs(x1 - x2) + Math.abs(y1 - y2);
      }
    }

    for (int[] specialRoad : specialRoads) {
      int i = map.get(specialRoad[0] * base + specialRoad[1]);
      int j = map.get(specialRoad[2] * base + specialRoad[3]);
      dis[i][j] = Math.min(dis[i][j], specialRoad[4]);
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        }
      }
    }

    int s = map.get(start[0] * base + start[1]);
    int t = map.get(target[0] * base + target[1]);

    return dis[s][t];
  }
}
