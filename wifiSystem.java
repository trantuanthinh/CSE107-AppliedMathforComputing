import java.io.*;
import java.util.*;

//100 done
public class wifiSystem {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var testCase = reader.nextInt();
		for (int i = 0; i < testCase; i++) {
			var row = reader.nextLong();
			var column = reader.nextLong();
			var min = findMin(row, column);
			stringBuilder.append(min).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static long findMin(long row, long column) {
		if (row <= 2 || column <= 2) {
			return 0;
		}
		row -= 2;
		column -= 2;
		var tempRow = (long) Math.ceil((double) row / 3);
		var tempColumn = (long) Math.ceil((double) column / 3);
		return tempRow * tempColumn;
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
