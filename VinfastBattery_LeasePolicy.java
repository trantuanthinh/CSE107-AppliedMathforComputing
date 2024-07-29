import java.io.*;
import java.util.*;

//100 done
public class VinfastBattery_LeasePolicy {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		double cost = reader.nextDouble();
		double valueRecall = reader.nextDouble();
		int month = reader.nextInt();
		double interestRate = reader.nextDouble() / 100;
		double rent = 0;
		double step = 1_000_000_000;
		while (step >= 0.01) {
			for (;; rent += step) {
				var temp = check(cost, month, interestRate, rent);
				if (temp <= valueRecall) {
					break;
				}
			}
			rent -= step;
			step /= 10;
		}
		System.out.print(Math.round(rent));
	}

	static double check(double cost, double month, double interestRate, double rent) {
		double temp = cost;
		for (int i = 1; i <= month; i++) {
			temp = temp * (1 + interestRate) - rent;
		}
		return temp;
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