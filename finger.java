import java.io.*;
import java.util.*;

//100 done
public class finger {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var number = reader.nextInt();
//		String[] fingers = { "thumb", "index finger", "middle finger", "ring finger", "little finger", "little finger",
//				"ring finger", "middle finger", "index finger", "thumb" };
		String[] fingers = { "", "cai", "tro", "giua", "ap ut", "ut", "ut", "ap ut", "giua", "tro", "cai" };
//		String[] hands = { "left hand", "right hand" };
		String[] hands = { "trai", "phai" };
		System.out.println(calculate(number, fingers, hands));
	}

	static String calculate(int number, String[] fingers, String[] hands) {
		String finger = "";
		String hand = "";
		for (int i = 1; i <= 10; i++) {
			var count = ((double) number - i) / 18;
			if (isInteger(count)) {
				finger = fingers[i];
				if (i <= 5) {
					hand = hands[0];
				} else {
					hand = hands[1];
				}
//				return finger + " " + hand;
				return "Ngon " + finger + " cua ban tay " + hand;
			}
		}
		var temp = 16;
		for (int i = 2; i <= 9; i++) {
			var count = ((double) number - temp - i) / 18;
			if (isInteger(count)) {
				finger = fingers[i];
				if (i <= 5) {
					hand = hands[0];
				} else {
					hand = hands[1];
				}
//				return finger + " " + hand;
				return "Ngon " + finger + " cua ban tay " + hand;
			}
			temp -= 2;
		}
//		return finger + " " + hand;
		return "Ngon " + finger + " cua ban tay " + hand;
	}

	static boolean isInteger(double n) {
		if (n % 1 == 0) {
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
