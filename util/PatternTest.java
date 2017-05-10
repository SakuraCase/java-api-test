package util;

import java.util.regex.Pattern;

public class PatternTest{
    public static void main(String[] argas) {
        // コンパイルによってString.matchesやPattern.matchesより処理が効率化？
        Pattern p1 = Pattern.compile("a*[b-d]");
        System.out.println(p1);             // -> a*[b-d]
        System.out.println(p1.pattern());   // -> a*[b-d]

        System.out.println(Pattern.matches(".*", "abcde"));     // -> true
        System.out.println(Pattern.matches("abc", "abcde"));    // -> false


        // compile(regex, flags)
        // split
    }
}