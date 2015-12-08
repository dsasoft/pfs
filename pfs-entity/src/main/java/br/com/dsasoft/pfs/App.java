package br.com.dsasoft.pfs;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String[] s = { "ixhi", "0", "0.0", "0.001", "123.0ae", "123456.32165409" };

		for (String ss : s)
			if (ss.matches("(?:\\d*\\.)?\\d+"))
				System.out.println("Y");
			else
				System.out.println("N");
	}
}
