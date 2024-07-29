import java.io.*;
import java.util.*;

//100 done understand it moredz
public class bankLoan2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var loan = reader.nextDouble();
		var monthlyPayment = reader.nextDouble();
		var months = reader.nextInt();
		var interestRate = reader.nextDouble() / 12 / 100;
		var prepayPenaltyFee = reader.nextDouble() / 100;
		double defaultBalance = loan;
		double averagePayment = loan / months;
		int countMonth = 0;
		while (loan > 0) {
			defaultBalance -= averagePayment;
			double paymentPerMonth = monthlyPayment;
			paymentPerMonth -= loan * (interestRate);
			if (loan > defaultBalance) {
				paymentPerMonth -= (loan - defaultBalance);
				loan = defaultBalance - paymentPerMonth / (1 + prepayPenaltyFee);
				countMonth++;
			} else {
				loan -= (paymentPerMonth) / (1 + prepayPenaltyFee);
				countMonth++;
			}
			if (loan < 0) {
				loan = 0;
			}
			stringBuilder.append(countMonth + " " + Math.round(loan) + "\n");
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
