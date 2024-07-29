import java.io.*;
import java.util.*;

//100 done
public class numberOfTriangle {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantity = reader.nextInt();
		int[] numberList = new int[quantity];
		for (int i = 0; i < quantity; i++) {
			numberList[i] = reader.nextInt();
		}
		var count = 0;
		for (int i = 0; i < quantity - 2; i++) {
			for (int j = i + 1; j < quantity - 1; j++) {
				for (int k = j + 1; k < quantity; k++) {
					var edge1 = numberList[i];
					var edge2 = numberList[j];
					var edge3 = numberList[k];
					if ((edge1 + edge2) > edge3 && (edge1 + edge3) > edge2 && (edge2 + edge3) > edge1) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
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
