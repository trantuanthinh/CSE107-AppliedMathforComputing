import java.io.*;
import java.util.*;

//100 done
public class bankFee2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfAccount = reader.nextInt();
		var totalCheque = 0d;
		var totalChequeFee = 0d;
		for (int i = 0; i < quantityOfAccount; i++) {
			var money = reader.nextDouble();
			var cheque = reader.nextDouble();
			totalCheque += cheque;
			var chequeFee = calculateChequeFee(money, cheque);
			totalChequeFee += chequeFee;
		}
		var averageFee = totalChequeFee / totalCheque;
		System.out.println(averageFee);
	}

	static double calculateChequeFee(double money, double cheque) {
		if (money < 500) {
			return 12 + cheque * 0.2;
		}
		if (money <= 1999) {
			return 7.5 + cheque * 0.2;
		}
		if (money <= 4999) {
			return 5 + cheque * 0.1;
		}
		return 0;
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
