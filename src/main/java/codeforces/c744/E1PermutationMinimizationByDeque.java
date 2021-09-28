package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Deque;

public class E1PermutationMinimizationByDeque {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (deque.isEmpty() || deque.getFirst() >= a) {
                deque.addFirst(a);
            } else {
                deque.addLast(a);
            }
        }
        for (Integer d : deque) {
            out.print(d + " ");
        }
        out.println();
    }
}
