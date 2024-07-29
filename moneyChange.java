import java.io.*;
import java.util.*;

//100 done
public class moneyChange {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var money = reader.nextInt();
		System.out.println(moneyChange(money));
	}

	static StringBuilder moneyChange(int money) {
		// 20 10 5 1
		if (money != 0) {
			if (money > 20) {
				var temp = (int) Math.floor(money / 20);
				if (checkMoney(temp)) {
					stringBuilder.append("20").append(" ").append(temp).append("\n");
					money -= temp * 20;
				}
			}
			if (money > 10) {
				var temp = (int) Math.floor(money / 10);
				if (checkMoney(temp)) {
					stringBuilder.append("10").append(" ").append(temp).append("\n");
					money -= temp * 10;
				}
			}
			if (money > 5) {
				var temp = (int) Math.floor(money / 5);
				if (checkMoney(temp)) {
					stringBuilder.append("5").append(" ").append(temp).append("\n");
					money -= temp * 5;
				}
			}
			if (money > 1) {
				var temp = (int) Math.floor(money / 1);
				if (checkMoney(temp)) {
					stringBuilder.append("1").append(" ").append(temp).append("\n");
					money -= temp * 1;
				}
			}
		}
		return stringBuilder;
	}

	static boolean checkMoney(int temp) {
		if (temp > 0) {
			return true;
		}
		return false;
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
