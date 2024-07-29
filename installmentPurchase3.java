import java.io.*;
import java.util.*;

//100 done
public class installmentPurchase3 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var price = reader.nextLong();
		var firstPayment = reader.nextLong();
		var installmentPeriod = reader.nextInt();
		var interestRate = reader.nextDouble();
		var debt = price - firstPayment;
		var monthlyPayment = calculateInterestRate(installmentPeriod, interestRate, debt);
		System.out.println(monthlyPayment);
	}

	static long calculateInterestRate(int installmentPeriod, double interestRate, long debt) {
		var monthlyPayment = (debt * interestRate * Math.pow(1 + interestRate, installmentPeriod))
				/ (Math.pow(1 + interestRate, installmentPeriod) - 1);
		return (long) Math.floor(monthlyPayment);
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
