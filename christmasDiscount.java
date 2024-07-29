import java.io.*;
import java.util.*;

//100 done
public class christmasDiscount {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static int million = 1_000_000;
	static long[] thresholdList = new long[] { 2 * million, 5 * million, 10 * million, 20 * million, 50 * million,
			100 * million, 200 * million };
	static double[] discountList = new double[] { .03, .04, .05, .06, .07, .08, .09, .1 };

	public static void main(String[] args) {
		var testcase = reader.nextInt();
		var total = 0d;
		for (int i = 0; i < testcase; i++) {
			var value = reader.nextLong();
			total += (double) calculateConvertGrade(value);
		}
		System.out.println(Math.round(total));
	}

	static double calculateConvertGrade(long value) {
		for (int i = 0; i < thresholdList.length - 1; i++) {
			if (value <= thresholdList[i]) {
				return value - value * discountList[i];
			}
		}
		return value - value * discountList[discountList.length - 1];
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
