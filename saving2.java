import java.io.*;
import java.util.*;

//100 done
public class saving2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static final double percent = 0.01;
	static double[] interestRateList = new double[] { 3.9 * percent, 3.92 * percent, 3.95 * percent, 3.99 * percent,
			4.04 * percent, 5.54 * percent, 5.72 * percent, 5.92 * percent, 6.14 * percent, 6.38 * percent,
			6.64 * percent, 6.92 * percent };

	public static void main(String[] args) {
		var months = reader.nextInt();
		var totalSavingAmount = 0d;
		for (int i = months; i > 0; i--) {
			var deposit = reader.nextDouble();
			totalSavingAmount += calculateSavingAmount(deposit, i);
		}
		System.out.println((long) Math.round(totalSavingAmount));
	}

	static double calculateSavingAmount(double initialSavingDeposit, int months) {
		var totalSaving = 0d;
		if (months <= 12) {
			var interestRate = interestRateList[months - 1] / 12;
			totalSaving = initialSavingDeposit * interestRate * months + initialSavingDeposit;
		} else {
			var yearTerm = months / 12;
			var monthTerm = months % 12;
			var interestRate = interestRateList[11];
			var tempSaving = initialSavingDeposit * Math.pow((1 + interestRate), yearTerm);
			if (monthTerm != 0) {
				interestRate = interestRateList[monthTerm - 1] / 12;
				totalSaving = tempSaving * interestRate * monthTerm + tempSaving;
			} else {
				totalSaving = tempSaving;
			}
		}
		return totalSaving;
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
