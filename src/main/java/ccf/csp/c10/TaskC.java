package ccf.csp.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    StringBuilder res = new StringBuilder();
    boolean f1 = false;
    boolean f2 = false;
    try {

      while (true) {
        String s = in.readLine(false);
        if (s.isEmpty()) {
          if (f1) {
            res.append("</ul>").append("\n");
            f1 = false;
          }
          if (f2) {
            res.deleteCharAt(res.length() - 1);
            res.append("</p>").append("\n");
            f2 = false;
          }
          continue;
        }

        if (s.charAt(0) == '#') {
          int j = 0;
          for (; j < s.length(); j++) {
            if (s.charAt(j) != '#') {
              break;
            }
          }
          res.append(String.format("<h%d>", j));

          s = s.substring(j);
          s = s.strip();
          res.append(draw(s));
          res.append(String.format("</h%d>\n", j));

        } else if (s.charAt(0) == '*') {
          if (!f1) {
            res.append("<ul>").append("\n");
          }

          res.append("<li>");
          s = s.substring(1);
          s = s.strip();
          res.append(draw(s));
          res.append("</li>\n");
          f1 = true;

        } else {
          if (!f2) {
            res.append("<p>");
          }
          f2 = true;
          res.append(draw(s)).append("\n");
        }
      }

    } catch (Error e) {
      if (f1) {
        res.append("</ul>");
      }
      if (f2) {
        res.deleteCharAt(res.length() - 1);
        res.append("</p>");
      }
      out.print(res);
    }

  }

  private String draw(String s) {
    StringBuilder sb = new StringBuilder();
    s = helper(s);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        int i1 = s.indexOf(']', i);
        int i2 = s.indexOf(')', i);
        String x = s.substring(i + 1, i1);
        String y = s.substring(i1 + 2, i2);
        sb.append(String.format("<a href=\"%s\">%s</a>", y, x));
        i = i2;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  private String helper(String s) {
    StringBuilder sb = new StringBuilder();
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '_') {
        if (cnt % 2 == 0) {
          sb.append("<em>");
        } else {
          sb.append("</em>");
        }
        cnt++;
      } else {
        sb.append(s.charAt(i));
      }

    }
    return sb.toString();
  }
}
