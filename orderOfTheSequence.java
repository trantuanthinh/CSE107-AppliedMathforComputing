import java.io.*;
import java.util.*;

//100 done
public class orderOfTheSequence {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfNumber = reader.nextInt();
		int[] array = new int[quantityOfNumber];
		for (int i = 0; i < quantityOfNumber; i++) {
			array[i] = reader.nextInt();
		}
//		Arrays.sort(array);
		switch (checkOrder(array)) {
		// -1 decrease
		case -1:
			System.out.println("decreasing");
			break;
		// 0 none
		case 0:
			System.out.println("none");
			break;
		// 1 increase
		case 1:
			System.out.println("increasing");
			break;
		}
	}

	static int checkOrder(int[] array) {
		// increase check
		if (array[0] < array[array.length - 2]) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] >= array[i + 1]) {
					return 0;
				}
			}
			return 1;
		}
		// decrease check
		if (array[0] > array[array.length - 2]) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] <= array[i + 1]) {
					return 0;
				}
			}
			return -1;
		}
		return 0;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
