package code.jam.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.math.BigInteger;

public class AppendSort {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
//        long[] a = in.nextLongArray(n);
        String[] a = new String[n];
        BigInteger one = new BigInteger("1");
        int res = 0;
        a[0] = in.nextString();
        for (int i = 1; i < n; i++) {
            a[i] = in.nextString();
            if (new BigInteger(a[i]).compareTo(new BigInteger(a[i - 1])) > 0) {
                continue;
            }
            if (a[i].equals(a[i - 1])) {
                a[i] += "0";
                res += 1;
                continue;
            }
            String s1 = a[i - 1];
            String s2 = a[i];
            int tmp = 0;
            if (s1.startsWith(s2)) {
                BigInteger bigInteger = new BigInteger(s1);
                String s = bigInteger.add(one).toString();
                if (s.startsWith(s2)) {
                    tmp = s.length() - s2.length();
                    res += tmp;
                    a[i] = s;
                } else {
                    tmp = s1.length() - s2.length() + 1;
                    res += tmp;
                    for (int j = 0; j < tmp; j++) {
                        s2 += "0";
                    }
                    a[i] = s2;
                }
                continue;
            }
            int compare = s1.compareTo(s2);
            if (compare > 0) {
                tmp = s1.length() - s2.length() + 1;
            } else if (compare < 0) {
                tmp = s1.length() - s2.length();
            }
            res += tmp;
            for (int j = 0; j < tmp; j++) {
                s2 += "0";
            }
            a[i] = s2;
        }
//        for (int i = 0; i < n; i++) {
//            out.print(a[i]+" ");
//        }
        out.printf("Case #%d: ", testNumber);
        out.println(res);
    }

}
