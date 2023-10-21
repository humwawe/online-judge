package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char[] ss = s.toCharArray();
    Arrays.sort(ss);

    if (ss[0] == ss[1] && ss[1] == ss[2] && ss[2] != ss[3]) {
      out.println("Yes");
      return;
    }
    if (ss[0] != ss[1] && ss[1] == ss[2] && ss[2] == ss[3]) {
      out.println("Yes");
      return;
    }
    out.println("No");
  }
}
