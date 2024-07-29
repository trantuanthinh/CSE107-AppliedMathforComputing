import java.io.*;
import java.util.*;

//100 done
public class saving1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static final double percent = 0.01;
	static double[] interestRateList = new double[] { 3.9 * percent, 3.92 * percent, 3.95 * percent, 3.99 * percent,
			4.04 * percent, 5.54 * percent, 5.72 * percent, 5.92 * percent, 6.14 * percent, 6.38 * percent,
			6.64 * percent, 6.92 * percent };

	public static void main(String[] args) {
		var initialSavingDeposit = reader.nextDouble();
		var months = reader.nextInt();
		var totalSaving = calculateSavingAmount(initialSavingDeposit, months);
		System.out.println((long) Math.round(totalSaving));
	}

	static double calculateSavingAmount(double initialSavingDeposit, int months) {
		var totalSaving = 0d;
		if (months <= 12) {
			totalSaving = calculateWithShortTerm(initialSavingDeposit, initialSavingDeposit, months);
		} else {
			var yearTerm = (int) Math.floor(months / 12);
			var monthTerm = months % 12;
			var tempSaving = calculateWithLongTerm(initialSavingDeposit, yearTerm);
			if (monthTerm != 0) {
				totalSaving = calculateWithShortTerm(tempSaving, tempSaving, monthTerm);
			}
		}
		return totalSaving;
	}

	static double calculateWithShortTerm(double totalSavingAmount, double initialSavingDeposit, int monthTerm) {
		var interestRate = interestRateList[monthTerm - 1] / 12;
		var total = totalSavingAmount + monthTerm * initialSavingDeposit * interestRate;
		return total;
	}

	static double calculateWithLongTerm(double initialSavingDeposit, int yearTerm) {
		var interestRate = interestRateList[11];
		var total = initialSavingDeposit * Math.pow((1 + interestRate), yearTerm);
		return total;
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
