import java.io.*;
import java.util.*;

//100 done
public class depositInterestRate {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var numberOfTestCase = reader.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			var depositMoney = reader.nextDouble();
			var interestRate = reader.nextDouble();
			interestRate /= 100;
			var moneyAfterDeposit = reader.nextDouble();
			stringBuilder.append(calculateYears(depositMoney, interestRate, moneyAfterDeposit)).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static int calculateYears(double depositMoney, double interestRate, double moneyAfterDeposit) {
		var year = Math.log(moneyAfterDeposit / depositMoney) / Math.log(1 + interestRate);
		return (int) Math.ceil(year);
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
