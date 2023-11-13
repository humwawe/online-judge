package ccf.csp.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  Person[][] p = new Person[2][10];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 10; j++) {
        p[i][j] = new Person(0, 0);
      }
    }
    p[0][0].h = 30;
    p[1][0].h = 30;

    int n = in.nextInt();
    int k = 0;
    while (n-- != 0) {
      String op = in.nextString();
      if (op.equals("end")) {
        k ^= 1;
      } else if (op.equals("summon")) {
        int pos, a, h;
        pos = in.nextInt();
        a = in.nextInt();
        h = in.nextInt();
        for (int i = 7; i > pos; i--) {
          p[k][i].a = p[k][i - 1].a;
          p[k][i].h = p[k][i - 1].h;
        }
        p[k][pos].a = a;
        p[k][pos].h = h;
      } else {
        int a, d;
        a = in.nextInt();
        d = in.nextInt();
        p[k][a].h -= p[k ^ 1][d].a;
        p[k ^ 1][d].h -= p[k][a].a;

        if (p[k][a].h <= 0 && a != 0) {
          remove(k, a);
        }

        if (p[k ^ 1][d].h <= 0 && d != 0) {
          remove(k ^ 1, d);
        }
      }
    }

    if (p[0][0].h <= 0) {
      out.println("-1");
    } else if (p[1][0].h <= 0) {
      out.println("1");
    } else {
      out.println("0");
    }

    for (int kk = 0; kk <= 1; kk++) {
      out.println(p[kk][0].h);
      int s = 0;
      for (int i = 1; i <= 7; i++) {
        if (p[kk][i].h > 0) {
          s++;
        }
      }

      out.printf("%d ", s);
      for (int i = 1; i <= s; i++) {
        out.printf("%d ", p[kk][i].h);
      }
      out.println();
    }
  }

  void remove(int k, int a) {
    for (int i = a; i < 7; i++) {
      p[k][i].a = p[k][i + 1].a;
      p[k][i].h = p[k][i + 1].h;
    }
    p[k][7].a = 0;
    p[k][7].h = 0;
  }

  class Person {
    int a;
    int h;

    public Person(int a, int h) {
      this.a = a;
      this.h = h;
    }
  }
}
