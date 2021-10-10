package codeforces.e115;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTrainingSession {
    int n;
    P[] ps;


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int[] cnt1 = new int[n + 5];
        int[] cnt2 = new int[n + 5];
        ps = new P[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new P(in.nextInt(), in.nextInt());
            cnt1[ps[i].a]++;
            cnt2[ps[i].b]++;
        }
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            long c1 = cnt1[ps[i].a];
            long c2 = cnt2[ps[i].b] - 1;
            tmp += (c1 - 1) * c2;
        }
        long sum = 1;
        for (int i = 0; i < 3; i++) {
            sum *= (n - i);
        }
        sum /= 6;
        out.println(sum - tmp);
    }

    class P {
        int a;
        int b;

        public P(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
