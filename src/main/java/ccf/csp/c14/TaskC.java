package ccf.csp.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TaskC {
  String[] strs;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    strs = new String[n];
    for (int i = 0; i < n; i++) {
      strs[i] = in.readLine();
    }
    for (int i = 0; i < m; i++) {
      String s = in.readLine();
      String[] qs = s.split(" ");
      for (int j = 0; j < qs.length; j++) {
        if (qs[j].charAt(0) != '#') {
          qs[j] = qs[j].toLowerCase();
        }
      }
      List<Integer> res = work(qs);
      out.print(res.size(), "");
      out.println(res);
    }
  }

  private List<Integer> work(String[] qs) {
    List<Integer> res = new ArrayList<>();
    Stack<Css> stack = new Stack<>();
    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      Css cur = new Css(str);
      while (!stack.isEmpty() && stack.peek().tab >= cur.tab) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        cur.k = stack.peek().k;
      }
      if (cur.k == qs.length) {
        cur.k--;
      }
      if (cur.check(qs[cur.k])) {
        cur.k++;
        if (cur.k == qs.length) {
          res.add(i + 1);
        }
      }
      stack.push(cur);
    }
    return res;
  }

  class Css {
    String label;
    String id;
    int tab;
    int k;

    public Css(String str) {
      int i = 0;
      while (i < str.length() && str.charAt(i) == '.') {
        i++;
      }
      tab = i;
      String[] s = str.substring(i).split(" ");
      label = s[0].toLowerCase();
      if (s.length > 1) {
        id = s[1];
      }
      k = 0;
    }

    boolean check(String word) {
      if (word.charAt(0) == '#') {
        return word.equals(id);
      }
      return word.equals(label);
    }
  }
}
