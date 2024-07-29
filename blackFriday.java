import java.io.*;
import java.util.*;

//100 done
public class blackFriday {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var container = reader.nextInt();
		int[] outcomeList = new int[container];
		for (int i = 0; i < container; i++) {
			outcomeList[i] = reader.nextInt();
		}
		int resultIndex = findHighestUniqueOutcome(container, outcomeList);
		if (resultIndex == -1) {
			System.out.println("none");
		} else {
			System.out.println(resultIndex);
		}
	}

	static int findHighestUniqueOutcome(int container, int[] outcomeList) {
		Hashtable<Integer, Integer> outcomeCountMap = new Hashtable<>();
		for (int outcome : outcomeList) {
			outcomeCountMap.put(outcome, outcomeCountMap.getOrDefault(outcome, 0) + 1);
		}
		int highestUniqueOutcome = -1;
		int highestUniqueIndex = -1;
		for (int i = 0; i < container; i++) {
			var outcome = outcomeList[i];
			if (outcomeCountMap.get(outcome) == 1) {
				if (highestUniqueOutcome == -1 || outcome > highestUniqueOutcome) {
					highestUniqueOutcome = outcome;
					highestUniqueIndex = i;
				}
			}
		}
		if (highestUniqueIndex == -1) {
			return -1;
		}
		return ++highestUniqueIndex;
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
