package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CRecoverAnRBS {
  String s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    int len = s.length();
    int l = 0;
    int r = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') {
        l++;
      } else if (s.charAt(i) == ')') {
        r++;
      }
    }

    int nl = len / 2 - l;
    int nr = len / 2 - r;

    if (nl == 0 || nr == 0) {
      out.println("YES");
      return;
    }

    char[] re = new char[nl + nr];
    for (int i = 0; i < nl; i++) {
      re[i] = '(';
    }
    for (int i = nl; i < nl + nr; i++) {
      re[i] = ')';
    }
    re[nl - 1] = ')';
    re[nl] = '(';


    char[] cs = s.toCharArray();
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (cs[i] == '?') {
        cs[i] = re[j++];
      }
    }
    int cnt = 0;
    for (int i = 0; i < len; i++) {
      if (cs[i] == ')') {
        if (cnt == 0) {
          out.println("YES");
          return;
        }
        cnt--;
      } else {
        cnt++;
      }
    }
    if (cnt != 0) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }
}
