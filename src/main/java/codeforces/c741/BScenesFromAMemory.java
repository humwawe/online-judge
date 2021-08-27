package codeforces.c741;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BScenesFromAMemory {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.nextString();

        if (n == 1) {
            out.println(1);
            out.println(s);
            return;
        }

        String s1 = s.substring(1);
        if (s.indexOf('1') != -1) {
            out.println(1);
            out.println(1);
            return;
        }

        if (s.indexOf('4') != -1) {
            out.println(1);
            out.println(4);
            return;
        }
        if (s.indexOf('6') != -1) {
            out.println(1);
            out.println(6);
            return;
        }
        if (s.indexOf('8') != -1) {
            out.println(1);
            out.println(8);
            return;
        }
        if (s.indexOf('9') != -1) {
            out.println(1);
            out.println(9);
            return;
        }

        if (s1.indexOf('2') != -1) {
            out.println(2);
            out.print(s.charAt(0));
            out.print(2);
            out.println();
            return;
        }

        if (s1.indexOf('5') != -1) {
            out.println(2);
            out.print(s.charAt(0));
            out.print(5);
            out.println();
            return;
        }

        int i = s.lastIndexOf('3');
        int j = s.indexOf('3');
        if (j != -1 && j < i) {
            out.println(2);
            out.println(33);
            return;
        }

        i = s.lastIndexOf('7');
        j = s.indexOf('2');
        if (j != -1 && j < i) {
            out.println(2);
            out.println(27);
            return;
        }
        j = s.indexOf('5');
        if (j != -1 && j < i) {
            out.println(2);
            out.println(57);
            return;
        }
        j = s.indexOf('7');
        if (j != -1 && j < i) {
            out.println(2);
            out.println(77);
            return;
        }

    }
}
