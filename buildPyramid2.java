import java.io.*;
import java.util.*;

//100 done
public class buildPyramid2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int typesOfBricks = reader.nextInt();
		for (int i = 0; i < typesOfBricks; i++) {
			var quantityOfBricks = reader.nextLong();
			stringBuilder.append(bricksAtExactlyLayers(quantityOfBricks)).append(" ");
		}
		System.out.println(stringBuilder);
	}

	static long bricksAtExactlyLayers(long quantityOfBricks) {
		long layers = (long) Math.floor(Math.cbrt(quantityOfBricks * 6));
		if ((layers * (layers + 1) * (layers + 2)) <= quantityOfBricks * 6) {
			return layers;
		} else {
			return layers - 1;
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