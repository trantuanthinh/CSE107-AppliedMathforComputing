import java.io.*;
import java.util.*;

public class creditCard {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static int million = 1_000_000;
	static int[] thresholdList = new int[] { million, 20 * million, 50 * million, 200 * million };
	static double[] discountList = new double[] { 0.02, 0.03, 0.05, 0.07 };

	public static void main(String[] args) {
		var numberOfTransaction = reader.nextInt();
		var interestRate = reader.nextDouble();
		var checkingDate = reader.nextInt();
		var balance = 0d;
		Hashtable<Integer, Long> transactionMap = new Hashtable<>();
		for (int i = 0; i < numberOfTransaction; i++) {
			var date = reader.nextInt();
			var amount = reader.nextLong();
			transactionMap.put(date, amount);
		}
		List<Integer> dateList = new ArrayList<>(transactionMap.keySet());
		for (int i = 0; i < numberOfTransaction; i++) {
			var amount = transactionMap.get(dateList.get(i));
			balance += amount;
			if (balance < 0) {

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
