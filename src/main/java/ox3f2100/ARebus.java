package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ARebus {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readLine();
    int pos = 1;
    int neg = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+') {
        pos++;
      } else if (s.charAt(i) == '-') {
        neg++;
      }
    }
    int n = 0;
    int base = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        n += base * (s.charAt(i) - '0');
        base *= 10;
      } else {
        break;
      }
    }

    if (pos - n * neg > n || n * pos - neg < n) {
      out.println("Impossible");
      return;
    }
    List<Integer> res = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i > 0 && s.charAt(i) != '+' && s.charAt(i) != '-') {
        continue;
      }
      int sign = 1;
      if (s.charAt(i) == '-') {
        sign = -1;
      }

      if (sign == 1) {
        pos--;
      } else {
        neg--;
      }

      for (int j = 1; j <= n; j++) {
        if (sum + j * sign + (pos - n * neg) <= n && sum + j * sign + (n * pos - neg) >= n) {
          sum += j * sign;
          res.add(j);
          break;
        }
      }
    }
    out.println("Possible");
    int idx = 0;
    for (char c : s.toCharArray()) {
      if (c == '?') {
        out.print(res.get(idx++));
      } else {
        out.print(c);
      }
    }
    out.println();

  }

}
