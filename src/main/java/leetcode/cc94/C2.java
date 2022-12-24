package leetcode.cc94;

import java.util.*;

/**
 * @author hum
 */
public class C2 {
  public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
    Set<String> set1 = new HashSet<>();
    Collections.addAll(set1, positiveFeedback);
    Set<String> set2 = new HashSet<>();
    Collections.addAll(set2, negativeFeedback);
    int n = studentId.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      String[] ss = report[i].split(" ");
      for (String s : ss) {
        if (set1.contains(s)) {
          res[i] += 3;
        } else if (set2.contains(s)) {
          res[i] -= 1;
        }
      }
    }

    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }

    Arrays.sort(idx, (x, y) -> {
      int d = res[y] - res[x];
      if (d == 0) {
        return studentId[x] - studentId[y];
      }
      return d;
    });

    List<Integer> list = new ArrayList<>();
    for (
        int i = 0;
        i < k; i++) {
      list.add(studentId[idx[i]]);
    }
    return list;
  }
}
