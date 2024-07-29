import java.io.*;
import java.util.*;

//100 done
public class homeLoan {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var totalAmount = reader.nextDouble();
		var amount = reader.nextDouble();
		var monthLength = reader.nextInt();
		var interestRate = reader.nextDouble();
		var loan = totalAmount - amount;
		interestRate /= 100;
		var monthlyPayment = (double) loan / monthLength;
		for (int i = 0; i < monthLength; i++) {
			var paymentPerMonth = (double) Math.round(monthlyPayment + (loan * interestRate));
			loan -= monthlyPayment;
			stringBuilder.append(i + 1).append(" ").append((long) paymentPerMonth).append("\n");
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
