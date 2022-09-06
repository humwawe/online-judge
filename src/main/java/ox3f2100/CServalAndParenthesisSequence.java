package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CServalAndParenthesisSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    char[] cs = s.toCharArray();
    List<Integer> list = new ArrayList<>();
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        cnt1++;
      } else if (s.charAt(i) == ')') {
        cnt2++;
      } else {
        list.add(i);
      }
    }
    int cnt = n - cnt1 - cnt2;
    if (n % 2 != 0 || cnt1 > cnt + cnt2 || cnt2 > cnt1 + cnt) {
      out.println(":(");
      return;
    }
    int l = n / 2 - cnt1;

    for (int i = 0; i < l; i++) {
      cs[list.get(i)] = '(';
    }
    for (int i = l; i < list.size(); i++) {
      cs[list.get(i)] = ')';
    }
    int t = 0;
    for (int i = 0; i < n - 1; i++) {
      if (cs[i] == '(') {
        t++;
      } else {
        t--;
      }
      if (t <= 0) {
        out.println(":(");
        return;
      }
    }

    out.println(cs);
  }
}
