package lang;

public class StringTest {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		String s = "abcde";

		print(s.charAt(1));           // -> b
		print(s.codePointAt(1));      // -> 98
		print(s.codePointBefore(1));  // -> 97

		// 辞書順比較
		print(s.compareTo("abcd"));       // -> 1
		print(s.compareTo("b"));          // -> -1
		print(s.compareTo("c"));          // -> -2
		print(s.compareTo("C"));          // -> 30
		print(s.compareToIgnoreCase("C"));// -> -2

		// + で結合するより2倍ほど早い。
		// けどStringBufferやBuilderのほうが圧倒的に早い
		print(s.concat("f"));

		
		// charは与えられない
		// print(s.contains('c'));  // -> error: incompatible types
		print(s.contains("c"));     // -> true
		print(s.contains("z"));     // -> false
		print(s.contains("az"));    // -> false
		print(s.contains("ab"));    // -> true
		print(s.contains("ba"));    // -> false
		print("あいうえお".contains("あ"));  // -> true

		
		// StringBufferと比較するときなどに使うらしい。
		// 「StringBufferとの同期をとる」がよくわからない
		print(s.contentEquals("ab"));     // -> false
		print(s.contentEquals("abcde"));  // -> true
		StringBuffer sb = new StringBuffer("abcde");
		print(s==sb.toString()? true: false); // -> false
		print(s.contentEquals(sb));           // -> true
		print(s==sb.toString()? true: false); // -> false
	}

	public static void print(Object o) {
		System.out.println(o);
	}
}
