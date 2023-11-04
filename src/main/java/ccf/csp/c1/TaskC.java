package ccf.csp.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    Stack<Character> stack = new Stack<>();
    Set<String> set1 = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ':') {
        Character pop = stack.pop();
        set1.add("-" + (pop));
      } else {
        stack.push(s.charAt(i));
      }
    }
    Set<String> set2 = new HashSet<>();
    while (!stack.isEmpty()) {
      set2.add("-" + (stack.pop()));
    }

    int n = in.nextInt();

    for (int i = 1; i <= n; i++) {
      String com = in.readLine();
      String[] ss = com.split(" ");
      TreeMap<String, String> treeMap = new TreeMap<>();
      for (int j = 1; j < ss.length; j++) {
        boolean find = false;
        if (set1.contains(ss[j])) {
          if (j == ss.length - 1) {
            break;
          }
          treeMap.put(ss[j], ss[j + 1]);
          j++;
          find = true;
        } else if (set2.contains(ss[j])) {
          treeMap.put(ss[j], "$");
          find = true;
        }
        if (!find) {
          break;
        }
      }
      StringBuilder res = new StringBuilder();

      for (Map.Entry<String, String> kv : treeMap.entrySet()) {
        if (kv.getValue().equals("$")) {
          res.append(" ").append(kv.getKey());
        } else {
          res.append(" ").append(kv.getKey()).append(" ").append(kv.getValue());
        }
      }

      out.println("Case " + i + ":" + res.toString());
    }

  }
}
