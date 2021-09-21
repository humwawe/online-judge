package codeforces.e114;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DTheStrongestBuild {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            int c = in.nextInt();
            lists[i] = new ArrayList<>(c);
            for (int j = 0; j < c; j++) {
                lists[i].add(in.nextInt());
            }
        }
        int m = in.nextInt();
        Set<St> ban = new HashSet<>();
        Set<St> vis = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int[] idx = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                idx[j] = in.nextInt() - 1;
                sum += lists[j].get(idx[j]);
            }
            ban.add(new St(idx, sum));
        }

        PriorityQueue<St> priorityQueue = new PriorityQueue<>();
        int[] idx = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            idx[i] = lists[i].size() - 1;
            sum += lists[i].get(idx[i]);
        }
        priorityQueue.add(new St(idx, sum));
        while (!priorityQueue.isEmpty()) {
            St cur = priorityQueue.poll();
            if (ban.contains(cur)) {
                for (int i = 0; i < n; i++) {
                    int[] tmpIdx = cur.idxs.clone();
//                    System.arraycopy(cur.idxs, 0, tmpIdx, 0, n);
                    int tmpSum = cur.value;
                    int j = tmpIdx[i];
                    if (j > 0) {
                        tmpSum -= lists[i].get(j) - lists[i].get(j - 1);
                        tmpIdx[i]--;
                        St st = new St(tmpIdx, tmpSum);
                        if (vis.contains(st)) {
                            continue;
                        }
                        priorityQueue.add(st);
                        vis.add(st);
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    out.print(cur.idxs[i] + 1 + " ");
                }
                out.println();
                return;
            }
        }

    }

    class St implements Comparable<St> {
        int[] idxs;
        int value;

        public St(int[] idxs, int value) {
            this.idxs = idxs;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof St)) return false;
            St st = (St) o;
            return value == st.value &&
                    Arrays.equals(idxs, st.idxs);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(value);
            result = 31 * result + Arrays.hashCode(idxs);
            return result;
        }

        @Override
        public int compareTo(St o) {
            return o.value - value;
        }

    }
}
