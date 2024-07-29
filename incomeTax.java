import java.io.*;
import java.util.*;

//100 done
public class incomeTax {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var income = reader.nextLong();
		var personalRelief = 9000000;
		System.out.println(calculateTax(income, personalRelief));
	}

	static long calculateTax(long income, int personalRelief) {
		var taxableIncome = income - personalRelief;
		int[] incometList = new int[] { 0, 5000000, 10000000, 18000000, 32000000, 52000000, 80000000 };
		double[] taxRate = new double[] { .05, .1, .15, .2, .25, .3, .35 };
		for (int i = incometList.length - 1; i >= 0; i--) {
			if (taxableIncome > incometList[i]) {
				return (long) calculate(taxableIncome, i, incometList, taxRate);
			}
		}
		return 0;
	}

	static long calculate(long taxableIncome, long level, int[] incometList, double[] taxRate) {
		var tax = 0d;
		for (int i = 0; i <= level; i++) {
			if (i == level) {
				tax += (taxableIncome - incometList[i]) * taxRate[i];
				break;
			}
			tax += (incometList[i + 1] - incometList[i]) * taxRate[i];
		}
		return (long) Math.round(tax);
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
