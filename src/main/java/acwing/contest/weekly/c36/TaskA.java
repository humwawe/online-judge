package acwing.contest.weekly.c36;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString().toLowerCase();
        StringBuilder sb = new StringBuilder();
        List<Character> characterList = new ArrayList<>();
        characterList.add('a');
        characterList.add('o');
        characterList.add('y');
        characterList.add('e');
        characterList.add('u');
        characterList.add('i');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterList.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        for (int i = 0; i < sb.length(); i++) {
            out.print("." + sb.charAt(i));
        }
        out.println();
    }
}
