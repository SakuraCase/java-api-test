package lang;

public class StringTest {
	public static void main(String[] args) {
		String s = "abcde";
		test3(s);
	}

	public static void test1(String s) {
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

	public static void test2(String s) {
		// 数値をStringに変えたりするValueOfと同等らしい
		char[] c = {'x', 'y', 'z'};
		String hoge = String.copyValueOf(c, 1, 2);
		print(hoge);                           // -> yz
		for(char x: c){System.out.print(x);}   // -> xyz
		c[1] = 'a';
		for(char x: c){System.out.print(x);}   // -> xaz
		print(hoge);                           // -> yz


		print(s);                 // -> abcde
		print(s.endsWith("a"));   // -> false
		print(s.endsWith("e"));   // -> true
		print(s.endsWith("de"));  // -> true
	}

	public static void test3(String s) {
		// stringの好きな部分をchar[]の好きな部分に入れられる
		char[] c1 = {'x', 'y', 'z'};
		s.getChars(0, 2, c1, 0);
		printArrayChar(c1);            // -> abz
		char[] c2 = {'x', 'y', 'z'};
		s.getChars(1, 2, c2, 1);       // -> xbz
		printArrayChar(c2);


	}


	public static void print(Object o) {
		System.out.println(o);
	}

	public static void printArrayChar(char[] ac) {
		for(char c: ac) {
			print(c);
		}
	}
}
