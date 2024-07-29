import java.io.*;
import java.util.*;

//100 done
public class everyNumber {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var numberOfTestcase = reader.nextInt();
		for (int i = 0; i < numberOfTestcase; i++) {
			var quantityOfNumber = reader.nextInt();
			var lastNumber = reader.nextInt();
			Hashtable<Integer, Boolean> numberMap = new Hashtable<>();
			for (int j = 0; j < lastNumber; j++) {
				numberMap.put(j + 1, false);
			}
			for (int j = 0; j < quantityOfNumber; j++) {
				var number = reader.nextInt();
				if (numberMap.containsKey(number) && !numberMap.get(number)) {
					numberMap.put(number, true);
				}
			}
			if (numberMap.containsValue(false)) {
				stringBuilder.append("No").append("\n");
			} else {
				stringBuilder.append("Yes").append("\n");
			}
		}
		System.out.println(stringBuilder);
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
