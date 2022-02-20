package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ERockPaperScissors {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[3];
    int[] b = new int[3];
    for (int i = 0; i < 3; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < 3; i++) {
      b[i] = in.nextInt();
    }
    List<Node> list = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if ((i + 1) % 3 != j) {
          list.add(new Node(i, j));
        }
      }
    }
    Collections.sort(list);
    int res1 = Integer.MAX_VALUE;
    do {
      int[] na = a.clone();
      int[] nb = b.clone();
      for (Node node : list) {
        int cnt = Math.min(na[node.x], nb[node.y]);
        na[node.x] -= cnt;
        nb[node.y] -= cnt;
      }
      int t = Math.min(na[0], nb[1]) + Math.min(na[1], nb[2]) + Math.min(na[2], nb[0]);
      res1 = Math.min(res1, t);
    } while (nextPermutationList(list));
    int res2 = Math.min(a[0], b[1]) + Math.min(a[1], b[2]) + Math.min(a[2], b[0]);
    out.println(res1, res2);
  }

  public boolean nextPermutationList(List<Node> list) {
    int n = list.size();
    for (int i = n - 2; i >= 0; i--) {
      if (list.get(i).compareTo(list.get(i + 1)) < 0) {
        reverseList(list, i + 1, n - 1);
        for (int j = i + 1; ; j++) {
          if (list.get(j).compareTo(list.get(i)) > 0) {
            Node tmp = list.get(j);
            list.set(j, list.get(i));
            list.set(i, tmp);
            return true;
          }
        }
      }
    }
    return false;
  }

  public void reverseList(List<Node> data, int l, int r) {
    while (l < r) {
      Node tmp = data.get(l);
      data.set(l, data.get(r));
      data.set(r, tmp);
      l++;
      r--;
    }
  }

  class Node implements Comparable<Node> {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Node o) {
      if (x == o.x) {
        return y - o.y;
      } else {
        return x - o.x;
      }
    }
  }
}
