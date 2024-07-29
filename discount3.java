import java.io.*;
import java.util.*;

//100 done
public class discount3 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static int[] amountList = new int[] { 0, 5000000, 20000000, 100000000, 300000000, 600000000, 900000000 };
	static double[] discountRate = new double[] { 0, .03, .05, .07, .1, .12, .15 };
	static double promotion = 0.02;

	public static void main(String[] args) {
		var amount = reader.nextDouble();
		var payment = calculate(amount);
		System.out.println(payment);
	}

	static long calculate(double amount) {
		var payment = 0d;
		for (int i = amountList.length - 1; i >= 0; i--) {
			if (amount > amountList[i]) {
				payment = calculateDiscount(amount, i);
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			var promotion = reader.nextInt();
			if (promotion == 1) {
				payment = calculatePromotion(payment);
			}
		}
		return (long) Math.floor(payment);
	}

	static double calculateDiscount(double amount, long level) {
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
		return (long) Math.floor(amount - discount);
	}

	static double calculatePromotion(double amount) {
		var payment = 0d;
		payment = amount - amount * promotion;
		return (long) Math.floor(payment);
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
