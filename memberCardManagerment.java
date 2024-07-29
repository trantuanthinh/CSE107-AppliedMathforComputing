import java.io.*;
import java.util.*;

//100 done
public class memberCardManagerment {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static int million = 1_000_000;
	static int[] thresholdList = new int[] { million, 20 * million, 50 * million, 200 * million };
	static double[] discountList = new double[] { 0.02, 0.03, 0.05, 0.07 };

	public static void main(String[] args) {
		var numberOfTransaction = reader.nextInt();
		Hashtable<String, Long> transactionMap = new Hashtable<>();
		var totalDiscount = 0d;
		var discountRate = 0d;
		for (int i = 0; i < numberOfTransaction; i++) {
			String id = reader.next();
			var amount = reader.nextLong();
			if (!transactionMap.containsKey(id)) {
				transactionMap.put(id, amount);
			} else {
				discountRate = checkRank(transactionMap.get(id));
				totalDiscount += discountRate * amount;
				transactionMap.put(id, transactionMap.get(id) + amount);
			}
		}
		totalDiscount = Math.round(totalDiscount * 100) / 100d;
		System.out.println(totalDiscount);
	}

	static double checkRank(long totalPayment) {
		for (int i = thresholdList.length - 1; i >= 0; i--) {
			if (totalPayment >= thresholdList[i]) {
				return discountList[i];
			}
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
