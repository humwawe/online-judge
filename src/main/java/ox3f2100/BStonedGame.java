package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class BStonedGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < n; i++) {
            priorityQueue.add(in.nextInt());
        }
        while (!priorityQueue.isEmpty()) {
            Integer a = priorityQueue.poll();
            Integer b = priorityQueue.poll();
            if (b == null) {
                out.println("T");
                return;
            }
            if (a > 1) {
                priorityQueue.add(a - 1);
            }
            if (b > 1) {
                priorityQueue.add(b - 1);
            }
        }
        out.println("HL");

    }
}
