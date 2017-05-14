package util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class PatternTest{
    public static void main(String[] argas) {
        // コンパイルによってString.matchesやPattern.matchesより処理が効率化？
        Pattern p1 = Pattern.compile("a*[b-d]");
        System.out.println(p1);             // -> a*[b-d]
        System.out.println(p1.pattern());   // -> a*[b-d]


        System.out.println(Pattern.matches(".*", "abcde"));     // -> true
        System.out.println(Pattern.matches("abc", "abcde"));    // -> false


        // 大文字小文字を区別しないマッチ
        Pattern p2 = Pattern.compile("a*[b-d]", Pattern.CASE_INSENSITIVE);
        Matcher m = p2.matcher("AaaAD");
        System.out.println(m.matches());     // -> true


        Pattern p3 = Pattern.compile("x");
        System.out.println(Arrays.toString(p3.split("aaxaaxx")));    // -> [aa, aa]
        System.out.println(Arrays.toString(p3.split("aaxaaxx", 2))); // -> [aa, aaxx]
        System.out.println(Arrays.toString(p3.split("aaxaax  x")));  // -> [aa, aa,   ]
    }
}