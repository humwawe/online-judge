package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DProductiveMeeting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>((x, y) -> y.v - x.v);
    for (int i = 1; i <= n; i++) {
      int a = in.nextInt();
      if (a == 0) {
        continue;
      }
      priorityQueue.add(new Person(i, a));
    }
    List<String> res = new ArrayList<>();
    while (!priorityQueue.isEmpty()) {
      Person p1 = priorityQueue.poll();
      Person p2 = priorityQueue.poll();
      if (p2 == null) {
        break;
      }
      p1.v--;
      p2.v--;
      res.add(p1.id + " " + p2.id);
      if (p1.v != 0) {
        priorityQueue.add(p1);
      }
      if (p2.v != 0) {
        priorityQueue.add(p2);
      }
    }
    out.println(res.size());
    for (String r : res) {
      out.println(r);
    }


  }

  class Person {
    int id;
    int v;

    public Person(int id, int v) {
      this.id = id;
      this.v = v;
    }
  }
}
