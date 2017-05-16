package util;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        // 互換性のない型変換
        // TODO: 基本型からリストへの変換方法
        // int[] i1 = {1,2,3,4,5,6};
        // List<Integer> li1 = Arrays.asList(i1);

        List<Integer> li2 = Arrays.asList(2,3,4,5,6);
        System.out.println(li2);                 // -> [2, 3, 4, 5, 6]

        String[] s1 = {"hoge", "fuga"};
        List<String> ls1 = Arrays.asList(s1);
        System.out.println(ls1);                 // -> [hoge, fuga]

        System.out.println(Arrays.toString(Arrays.copyOf(s1, 1))); // -> [hoge]
        System.out.println(Arrays.toString(Arrays.copyOf(s1, 3))); // -> [hoge, fuga, null]

    }
}