import java.io.*;
import java.util.*;

//100 done
public class birthDayPresent {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var testCase = reader.nextInt();
		for (int i = 0; i < testCase; i++) {
			var quantityOfBlue = reader.nextLong();
			var quantityOfRed = reader.nextLong();
			var bluePrice = reader.nextLong();
			var redPrice = reader.nextLong();
			var changePrice = reader.nextLong();

			if (bluePrice + changePrice < redPrice) {
				System.out.println((bluePrice * quantityOfBlue) + ((bluePrice + changePrice) * quantityOfRed));
			} else if (redPrice + changePrice < bluePrice) {
				System.out.println((redPrice * quantityOfRed) + ((redPrice + changePrice) * quantityOfBlue));
			} else {
				System.out.println((bluePrice * quantityOfBlue) + (redPrice * quantityOfRed));
			}
		}
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
