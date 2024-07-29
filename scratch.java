import java.io.*;
import java.util.*;

 class bankLoan2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var loan = reader.nextDouble();
		var monthlyPayment = reader.nextDouble();
		var month = reader.nextInt();
		var interestRate = reader.nextDouble() / 12 / 100;
		var prepayPenaltyFee = reader.nextDouble() / 100;

		var interest = loan * interestRate;
		var averagePayment = loan / (double) month;
		var amountToPay = averagePayment;
		var left = monthlyPayment - amountToPay - interest;
		var prepayAmount = left / (1 + prepayPenaltyFee);
		var total = 0;
		for (int i = 1; i <= month; i++) {
			loan = loan - amountToPay - prepayAmount;
			total += amountToPay + prepayAmount;
			interest = loan * interestRate;
			amountToPay = Math.max(averagePayment * (i+1) - total, 0);
			left = monthlyPayment - amountToPay - interest;
			prepayAmount = left / (1 + prepayPenaltyFee);
			if (loan > 0) {
				stringBuilder.append(i).append(" ").append(Math.round(loan)).append("\n");
			} else {
				stringBuilder.append(i).append(" ").append(0).append("\n");
				break;
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
