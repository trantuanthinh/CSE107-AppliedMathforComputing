import java.io.*;
import java.util.*;

//100 done
public class financialFreedom {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var interestRate = reader.nextDouble();
		interestRate /= 100;
		var inflation = reader.nextDouble();
		inflation /= 100;
		var withdraw = reader.nextDouble();
		var period = reader.nextDouble();
		var initialAmout = 0d;
		var step = 1000;
//		formula:
//		initialAmout = withdraw * (1 - Math.pow((1 + inflation) / (1 + interestRate), period - 1))
//				/ (interestRate - inflation);
		while (step > 0.00001) {
			for (;; initialAmout += step) {
				if (calculatRemain(initialAmout, interestRate, inflation, withdraw, period) > 0) {
					break;
				}
			}
			initialAmout -= step;
			step /= 10;
		}
		initialAmout = Math.round(initialAmout * 100_000) / 100_000d;
		System.out.println(initialAmout);
	}

	static double calculatRemain(double remain, double interestRate, double inflation, double withdraw, double period) {
		for (int i = 1; i < period; i++) {
			remain += remain * interestRate;
			remain -= withdraw;
			withdraw += withdraw * inflation;
		}
		return remain;
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
