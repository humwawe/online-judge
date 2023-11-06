package ccf.csp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Map<Integer, Long> buy = new HashMap<>();
    Map<Integer, Long> sell = new HashMap<>();
    String s = in.readLine();
    List<String> list = new ArrayList<>();
    try {
      while (s != null || s.isEmpty()) {
        list.add(s);
        s = in.readLine();
      }
    } catch (Exception e) {

    } catch (Error e) {

    }


    for (String s1 : list) {
      String[] s2 = s1.split(" ");
      if (s1.charAt(0) == 'b') {
        int x = helper(s2[1]);
        buy.put(x, buy.getOrDefault(x, 0L) + Long.parseLong(s2[2]));
      } else if (s1.charAt(0) == 's') {
        int x = helper(s2[1]);
        sell.put(x, sell.getOrDefault(x, 0L) + Long.parseLong(s2[2]));
      } else {
        int x = Integer.parseInt(s2[1]);
        String tmp = list.get(x - 1);
        String[] s3 = tmp.split(" ");
        if (tmp.charAt(0) == 'b') {
          int xx = helper(s3[1]);
          buy.put(xx, buy.get(xx) - Long.parseLong(s3[2]));
        } else {
          int xx = helper(s3[1]);
          sell.put(xx, sell.get(xx) - Long.parseLong(s3[2]));
        }
      }
    }
    long res = 0;
    int last = 0;
    for (Integer cur : buy.keySet()) {
      long b = 0;
      for (Map.Entry<Integer, Long> kv : buy.entrySet()) {
        if (kv.getKey() >= cur) {
          b += kv.getValue();
        }
      }

      long sum = 0;
      for (Map.Entry<Integer, Long> kv : sell.entrySet()) {
        if (kv.getKey() <= cur) {
          sum += kv.getValue();
        }
      }
      sum = Math.min(b, sum);

      if (sum > res || sum == res && cur > last) {
        res = sum;
        last = cur;
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(last / 100).append(".");
    int m = last % 100;
    if (m < 10) {
      sb.append("0").append(m);
    } else {
      sb.append(m);
    }

    out.println(sb.toString(), res);

  }

  private int helper(String s) {
    String[] split = s.split("\\.");
    return Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1]);
  }
}
