package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class EReplaceTheNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.nextInt();
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      if (t == 1) {
        list.add(new int[]{t, in.nextInt()});
      } else {
        list.add(new int[]{t, in.nextInt(), in.nextInt()});
      }
    }
    List<Integer> res = new ArrayList<>();
    int[] map = new int[(int) (5e5 + 5)];
    for (int i = list.size() - 1; i >= 0; i--) {
      int t = list.get(i)[0];
      if (t == 1) {
        int x = list.get(i)[1];
        if (map[x] == 0) {
          res.add(x);
        } else {
          res.add(map[x]);
        }
      } else {
        int x = list.get(i)[1];
        int y = list.get(i)[2];
        if (map[y] != 0) {
          map[x] = map[y];
        } else {
          map[x] = y;
        }
      }
    }
    for (int i = res.size() - 1; i >= 0; i--) {
      out.print(res.get(i), "");
    }
    out.println();
  }
}
