package acwing.contest.weekly.c24;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.TreeSet;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = in.nextInt();
    }
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    Book[] books = new Book[n];
    TreeSet<Integer>[] map = new TreeSet[4];
    for (int i = 0; i < 4; i++) {
      map[i] = new TreeSet<>(Comparator.comparingInt(x -> books[x].p));
    }
    for (int i = 0; i < n; i++) {
      books[i] = new Book(i, p[i], b[i], b[i]);
      map[b[i]].add(i);
      map[b[i]].add(i);
    }
    int m = in.nextInt();
    int[] c = new int[m];
    for (int i = 0; i < m; i++) {
      c[i] = in.nextInt();
    }

    for (int i = 0; i < m; i++) {
      int t = c[i];
      TreeSet<Integer> set = map[t];
      if (set.size() > 0) {
        Integer first = set.pollFirst();
        out.print(books[first].p);
        out.print(" ");
        Integer id = books[first].id;
        map[books[first].a].remove(id);
        map[books[first].b].remove(id);
      } else {
        out.print(-1);
        out.print(" ");
      }
    }
    out.println();
  }

  class Book {
    int id;
    int p, a, b;

    public Book(int id, int p, int a, int b) {
      this.id = id;
      this.p = p;
      this.a = a;
      this.b = b;
    }
  }
}

