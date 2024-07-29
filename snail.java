import java.io.*;
import java.util.*;

//100 done
public class snail {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var climbUpMeter = reader.nextInt();
		var dropDownMeter = reader.nextInt();
		var height = reader.nextInt();
		var result = calculateTime(climbUpMeter, dropDownMeter, height);
		System.out.println(result);
	}

	static int calculateTime(int climbUpMeter, int dropDownMeter, int height) {
		var climbUpDailyResult = climbUpMeter - dropDownMeter;
		var climbUpFinalResult = height - climbUpMeter;
		int result = (int) Math.ceil((double) climbUpFinalResult / climbUpDailyResult);
		return result + 1;
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
