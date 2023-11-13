package ccf.csp.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    String s = in.nextString();
    String[] split = s.split("/");

    for (int i = 0; i < n; i++) {
      String q = in.readLine(false);
      if (q.isEmpty()) {
        out.println(s);
        continue;
      }
      Stack<String> stack = new Stack<>();
      if (q.charAt(0) != '/') {
        for (String s1 : split) {
          if (s1.isEmpty()) {
            continue;
          }
          stack.push(s1);
        }
      }
      String[] split1 = q.split("/");
      for (String s1 : split1) {
        if (s1.isEmpty() || s1.equals(".")) {
          continue;
        }
        if (s1.equals("..")) {
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else {
          stack.push(s1);
        }
      }
      if (stack.isEmpty()) {
        out.println("/");

      } else {
        for (int j = 0; j < stack.size(); j++) {
          out.print("/" + stack.get(j));
        }
        out.println();
      }

    }
  }
}
