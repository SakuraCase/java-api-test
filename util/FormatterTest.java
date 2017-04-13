package util;

import java.util.Formatter;

public class FormatterTest {
	public static void main(String[] args) {
		test3();
	}

	public static void test1() {
		System.out.printf("|%10s|", "hoge"); // -> |      hoge|
	}

	public static void test2() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);

		/*
		 * formatメソッド.
		 * 上書きされないで追加される
		 */
		formatter.format("%1$3s %2$3s", "a", "b");
		System.out.println(formatter); // -> "  a   b"

		formatter.format("%2$3s %1$3s", "a", "b");
		System.out.println(formatter); // -> "  a   b  b   a"

		sb.append("hoge");
		System.out.println(formatter); // -> "  a   b  b   ahoge"
	}

	public static void test3() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);

		formatter.format("%05d", 123);
		System.out.println(formatter); // -> "00123"

		sb.delete(0, sb.length());
		System.out.println(formatter); // -> ""

		int n = 5;
		formatter.format("%0"+ n + "d", 123);
		System.out.println(formatter); // -> "00123"
		sb.delete(0, sb.length());
	}
}
