import java.io.*;
import java.util.*;

//100 done
public class discount {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static int[] amountList = new int[] { 1000000, 2000000, 10000000, 50000000, 100000000, 200000000, 500000000 };
	static double[] discountRate = new double[] { 0, .03, .05, .07, .1, .12, .15 };

	public static void main(String[] args) {
		var amount = reader.nextLong();
		var payment = calculate(amount);
		System.out.println(payment);
	}

	static long calculate(long amount) {
		var payment = 0l;
		for (int i = amountList.length - 1; i >= 0; i--) {
			if (amount > amountList[i]) {
				payment = calculateDiscount(amount, i);
				break;
			}
		}
		return payment;
	}

	static long calculateDiscount(long amount, long level) {
		var discount = 0d;
		if (level == 0) {
			return amount;
		}
		for (int i = 1; i <= level; i++) {
			if (i == level) {
				discount += (amount - amountList[i]) * discountRate[i];
				break;
			}
			discount += (amountList[i + 1] - amountList[i]) * discountRate[i];
		}
		return (long) Math.round(amount - discount);
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
