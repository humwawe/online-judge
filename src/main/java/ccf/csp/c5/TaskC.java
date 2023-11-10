package ccf.csp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = in.readLine();
    }
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      String x = in.readLine();
      int y = x.indexOf(" ");
      String k = x.substring(0, y);
      String v = x.substring(y + 2, x.length() - 1);
      map.put(k, v);
    }


    for (int i = 0; i < s.length; i++) {
      int index = s[i].indexOf("{{ ");
      String pre = s[i];
      int last;
      while (index != -1) {
        String befor = pre.substring(0, index);
        out.print(befor);
        String after = pre.substring(index);
        last = after.indexOf(" }}");
        String swa = after.substring(3, last);
        if (map.containsKey(swa)) {
          out.print(map.get(swa));
        }
        pre = after.substring(last + 3);
        index = pre.indexOf("{{ ");
      }
      out.println(pre);

    }

  }
}
