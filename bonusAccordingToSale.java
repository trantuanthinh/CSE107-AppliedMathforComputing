import java.io.*;
import java.util.*;

//100 done
public class bonusAccordingToSale {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static double percent = 0.01;
	static int[] amountList = new int[] { 0, 20, 50, 200, 500, 2000 };
	static double[] discountRate = new double[] { 2 * percent, 3 * percent, 4 * percent, 5 * percent, 6 * percent,
			7 * percent };

	public static void main(String[] args) {
		var amount = reader.nextInt();
		var total = calculate(amount);
		System.out.println(total);
	}

	static double calculate(long amount) {
		var payment = 0d;
		for (int i = 1; i < amountList.length; i++) {
			if (amount <= amountList[i]) {
				payment = calculateBonus(amount, i);
				payment = Math.round(payment * 1000) / 1000d;
				return payment;
			}
		}
		if (amount > 2000) {
			payment = calculateBonus(amount, 6);
			payment = Math.round(payment * 1000) / 1000d;
		}
		return payment;
	}

	static double calculateBonus(long amount, long level) {
		var bonus = 0d;
		for (int i = 1; i <= level; i++) {
			if (i == level) {
				bonus += (amount - amountList[i - 1]) * discountRate[i - 1];
				break;
			}
			bonus += (amountList[i] - amountList[i - 1]) * discountRate[i - 1];
		}
		return bonus;
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
