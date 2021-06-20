package codeforces.c727;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DPriceFixed {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        List<Node> nodes = new ArrayList<>(n);
        List<Integer> idx = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            idx.add(i);
            long a = in.nextLong();
            long b = in.nextLong();
            nodes.add(new Node(i, a, b));
        }
        idx.sort(Comparator.comparingLong(x -> nodes.get(x).b));

        long res = 0;
        long sum = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            int index = idx.get(i);
            long discountNum = nodes.get(index).b;
            long needNum = nodes.get(index).a;
            if (needNum == 0) {
                continue;
            }
            if (sum >= discountNum) {
                res += needNum;
                sum += needNum;
                continue;
            }
            discountNum -= sum;
            long tmp = discountNum;
            long other = 0;
            while (j > i) {
                int index2 = idx.get(j);
                long cnt = nodes.get(index2).a;
                if (cnt >= tmp) {
                    cnt -= tmp;
                    res += tmp * 2;
                    other += tmp;
                    nodes.get(index2).a = cnt;
                    break;
                } else {
                    j--;
                    tmp -= cnt;
                    res += cnt * 2;
                    other += cnt;
                    cnt = 0;
                    nodes.get(index2).a = cnt;
                }
            }
            sum += other;
            if (other >= discountNum) {
                res += needNum;
                sum += needNum;
            } else {
                discountNum -= other;
                if (needNum >= discountNum) {
                    res += discountNum * 2;
                    res += needNum - discountNum;
                } else {
                    res += needNum * 2;
                }
            }
        }
        out.println(res);
    }
}

class Node {
    int id;
    long a, b;

    public Node(int id, long a, long b) {
        this.id = id;
        this.a = a;
        this.b = b;
    }
}
