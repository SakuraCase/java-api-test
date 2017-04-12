package lang;

public class StringBufferTest {
	public static void main(String[] args) {
		test3();
	}

	public static void test3() {
		StringBuffer st = new StringBuffer();
		st.append("abcd abcd abcd abcd");

		/*
		 * 最後の文字以外を****で置き換える
		 */
		for (int i = 0; i < 4; i++) {
			int delimiter = 5 * i;
			int start = delimiter;
			int end = st.indexOf(" ", delimiter);

			System.out.println(delimiter);
			if (i != 3) {
				st.replace(start, end, "****");
			}
		}
		System.out.println(st); // => "**** **** **** abcd"
	}

	public static void test2() {
		StringBuffer st = new StringBuffer();
		st.append("abcd ea");
		
		System.out.println(st.charAt(1));        // => "b"
		System.out.println(st.indexOf("a"));     // => 0
		System.out.println(st.lastIndexOf("a")); // => 6
	}

	public static void test1() {
		StringBuffer st = new StringBuffer();
		System.out.println(st); // => ""

		/* 
		 * append, insertは型が何でも利用できる
		 */
		st.append("abcd");
		System.out.println(st); // => "abcd"

		st.insert(1, "x");
		System.out.println(st); // => "axbcd"

		st.insert(0, true);
		System.out.println(st); // => "trueaxbcd"
		// st.insert(50, "z");  // => StringIndexOutOfBoundsException


		/*
		 * insertのreturn StringBufferは等値
		 */
		StringBuffer st2 = st.insert(0, 2);
		System.out.println(st);  // => "2trueaxbcd"
		System.out.println(st2); // => "2trueaxbcd"

		st2.insert(0, 2);
		System.out.println(st);      // => "22trueaxbcd"
		System.out.println(st2);     // =>  "22trueaxbcd"
		System.out.println(st==st2); // => true


		/* 
		 * capacityとlength
		 * 容量超えたら割当てが発生
		 */ 
		System.out.println(st.capacity()); // => 16
		System.out.println(st.length());   // => 11
		st.append("aa");
		System.out.println(st.capacity()); // => 16
		System.out.println(st.length());   // => 13
		st.append("aaaa");
		System.out.println(st.capacity()); // => 34
		System.out.println(st.length());   // => 17

		st.delete(0, st.length());
		System.out.println(st);            // => ""
	}
}

