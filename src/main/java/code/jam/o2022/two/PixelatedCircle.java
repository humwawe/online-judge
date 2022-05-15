package code.jam.o2022.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PixelatedCircle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    //    out.printf("Case #%d: ", testNumber);
    //    int n = in.nextInt();
    for (int i = 1; i <= 100; i++) {
      Set<P> set = drawCircleFilled(i);
      Set<P> set1 = drawCircleFilledWrong(i);
      out.println(i + ":", (set.size() - set1.size()) / 4, set.size(), set1.size(), (set.size() - set1.size()));
    }

  }


  Set<P> drawCircleFilled(int r) {
    Set<P> list = new HashSet<>();
    for (int x = -r; x <= r; x++) {
      for (int y = -r; y <= r; y++) {
        if (Math.round(Math.sqrt(x * x + y * y)) <= r) {
          list.add(new P(x, y));
        }
      }
    }
    return list;
  }

  Set<P> drawCircleFilledWrong(int r) {
    Set<P> list = new HashSet<>();
    for (int i = 0; i <= r; i++) {
      list.addAll(drawCirclePerimeter(i));
    }
    return list;
  }

  Set<P> drawCirclePerimeter(int r) {
    Set<P> list = new HashSet<>();
    for (int x = -r; x <= r; x++) {
      int y = (int) Math.round(Math.sqrt(r * r - x * x));
      list.add(new P(x, y));
      list.add(new P(x, -y));
      list.add(new P(y, x));
      list.add(new P(-y, x));
    }
    return list;
  }

  class P {
    int x;
    int y;

    public P(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "P{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof P)) {
        return false;
      }
      P p = (P) o;
      return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
