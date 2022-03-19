package acwing.contest.weekly.c43;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Random;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long t = in.nextLong();
    int[] a = new int[n];
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] + a[i];
    }
    init();
    long res = 0;

    insert(root, 0, 0);
    for (int i = 1; i <= n; i++) {
      long tmp = sum[i] - t;
      int rankByKey = getRankByKey(root, tmp + 1) - 1;
      res += i + 1 - rankByKey;
      insert(root, sum[i], 0);
    }
    out.println(res);

  }

  int N = (int) (2e5 + 5);
  long inf = (long) 1e15;
  Node[] tr = new Node[N];
  int idx;
  int root;

  void init() {
    idx = 0;
    tr[0] = new Node();
    createNode(-inf);
    createNode(inf);
    // 根节点1号点, 右儿子2号点
    root = 1;
    tr[1].r = 2;
    tr[1].parent = 0;
    tr[2].parent = 1;
    pushUp(root);
    if (tr[1].val < tr[2].val) {
      zag(root);
    }
  }

  int createNode(long key) {
    tr[++idx] = new Node();
    tr[idx].key = key;
    tr[idx].val = new Random().nextLong();
    tr[idx].cnt = 1;
    tr[idx].size = 1;
    return idx;
  }

  void insert(int p, long key, int pre) {
    if (p == 0) {
      int cur = createNode(key);
      tr[cur].parent = pre;
      if (tr[pre].key > key) {
        tr[pre].l = cur;
      } else {
        tr[pre].r = cur;
      }
      return;
    }
    if (tr[p].key == key) {
      tr[p].cnt++;
      pushUp(p);
      return;
    }
    if (tr[p].key > key) {
      insert(tr[p].l, key, p);
      if (tr[tr[p].l].val > tr[p].val) {
        zig(p);
      }
    } else {
      insert(tr[p].r, key, p);
      if (tr[tr[p].r].val > tr[p].val) {
        zag(p);
      }
    }
    pushUp(p);
  }


  int getRankByKey(int p, long key) {
    if (p == 0) {
      return 1;
    }
    if (tr[p].key == key) {
      return tr[tr[p].l].size + 1;
    }
    if (tr[p].key > key) {
      return getRankByKey(tr[p].l, key);
    }
    return tr[tr[p].l].size + tr[p].cnt + getRankByKey(tr[p].r, key);
  }


  // 右旋
  private void zig(int p) {
    if (p == root) {
      root = tr[p].l;
    }
    int q = tr[p].l;
    tr[p].l = tr[q].r;
    tr[tr[q].r].parent = p;
    tr[q].parent = tr[p].parent;
    if (tr[tr[p].parent].l == p) {
      tr[tr[p].parent].l = q;
    } else {
      tr[tr[p].parent].r = q;
    }
    tr[p].parent = q;
    tr[q].r = p;
    pushUp(p);
    pushUp(q);

  }

  // 左旋
  private void zag(int p) {
    if (p == root) {
      root = tr[p].r;
    }
    int q = tr[p].r;
    tr[p].r = tr[q].l;
    tr[tr[q].l].parent = p;
    tr[q].parent = tr[p].parent;
    if (tr[tr[p].parent].l == p) {
      tr[tr[p].parent].l = q;
    } else {
      tr[tr[p].parent].r = q;
    }
    tr[p].parent = q;
    tr[q].l = p;
    pushUp(p);
    pushUp(q);
  }


  void pushUp(int p) {
    if (p == 0) {
      return;
    }
    tr[p].size = tr[tr[p].l].size + tr[tr[p].r].size + tr[p].cnt;
  }

  class Node {
    int l;
    int r;
    // 节点键值
    long key;
    // 堆中权值
    long val;
    // 这个数出现次数
    int cnt;
    // 每个(节点)子树个数
    int size;
    // 父节点
    int parent;

    public Node() {
      l = 0;
      r = 0;
      size = 0;
      cnt = 0;
    }
  }
}
