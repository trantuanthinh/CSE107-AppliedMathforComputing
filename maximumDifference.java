import java.io.*;
import java.util.*;

//100 done
public class maximumDifference {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var lengthOfArray = reader.nextInt();
		long[] array = new long[lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			array[i] = reader.nextLong();
		}
		var minVal = array[0];
		var maxDifference = 0L;
		for (int i = 1; i < lengthOfArray; i++) {
			maxDifference = Math.max(maxDifference, array[i] - minVal);
			minVal = Math.min(minVal, array[i]);
		}
		System.out.println(maxDifference);
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
