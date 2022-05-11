package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class BMinimumAndMaximum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    if (n == 1) {
      out.println("!", 1, 1);
      out.flush();
      return;
    }
    for (int i = 1; i <= n - 1; i += 2) {
      out.println("?", i, i + 1);
      out.flush();
      char c = in.nextCharacter();
      if (c == '>') {
        queue1.add(i);
        queue2.add(i + 1);
      } else {
        queue1.add(i + 1);
        queue2.add(i);
      }
    }
    while (queue1.size() > 1) {
      int a = queue1.poll();
      int b = queue1.poll();
      out.println("?", a, b);
      out.flush();
      char c = in.nextCharacter();
      if (c == '>') {
        queue1.add(a);
      } else {
        queue1.add(b);
      }
    }
    while (queue2.size() > 1) {
      int a = queue2.poll();
      int b = queue2.poll();
      out.println("?", a, b);
      out.flush();
      char c = in.nextCharacter();
      if (c == '>') {
        queue2.add(b);
      } else {
        queue2.add(a);
      }
    }
    if (n % 2 == 1) {
      out.println("?", n, queue1.peek());
      out.flush();
      char c = in.nextCharacter();
      if (c == '>' || c == '=') {
        out.println("!", queue2.peek(), n);
        out.flush();
        return;
      }
      out.println("?", n, queue2.peek());
      out.flush();
      c = in.nextCharacter();
      if (c == '>') {
        out.println("!", queue2.peek(), queue1.peek());
      } else {
        out.println("!", n, queue1.peek());
      }

    } else {
      out.println("!", queue2.peek(), queue1.peek());
    }
    out.flush();
  }

}
