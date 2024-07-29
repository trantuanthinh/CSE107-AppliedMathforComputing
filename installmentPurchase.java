import java.io.*;
import java.util.*;

//100 done
public class installmentPurchase {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var price = reader.nextLong();
		var installmentPeriod = reader.nextInt();
		var firstPayment = reader.nextLong();
		var paymentPerMonth = reader.nextLong();
		var debt = price - firstPayment;
		calculateInterestRate(installmentPeriod, firstPayment, paymentPerMonth, debt);
	}

	static void calculateInterestRate(int installmentPeriod, long firstPayment, long paymentPerMonth, long debt) {
		var rate = 0d;
		for (double i = 0.000001; i <= 1; i += 0.000001) {
			double tempDebt = (debt * i * Math.pow(1 + i, installmentPeriod))
					/ (Math.pow(1 + i, installmentPeriod) - 1);
			if (tempDebt >= paymentPerMonth) {
				rate = i - 0.000001;
				rate = Math.round(rate * 10000000) / 10000000d;
				System.out.println(String.format("%.7f", rate));
				break;
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
