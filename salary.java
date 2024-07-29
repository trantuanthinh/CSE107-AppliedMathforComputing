import java.io.*;
import java.util.*;

//100 done
public class salary {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var numberOfEmployee = reader.nextInt();
		var extraWage = 1.5d;
		var totalOfficeHour = 0d;
		var totalOverTimeHour = 0d;
		var totalOfficePayment = 0d;
		var totalOverTimePayment = 0d;
		for (int i = 0; i < numberOfEmployee; i++) {
			double[] workingTime = new double[5];
			for (int j = 0; j < workingTime.length; j++) {
				workingTime[j] = reader.nextDouble();
			}
			double wage = reader.nextDouble();
			double payment = 0d;
			for (int j = 0; j < workingTime.length; j++) {
				if (workingTime[j] > 8) {
					workingTime[j] -= 8;
					totalOfficeHour += 8;
					totalOverTimeHour += workingTime[j];
					totalOfficePayment += 8 * wage;
					totalOverTimePayment += workingTime[j] * wage * extraWage;
					payment += 8 * wage;
					payment += workingTime[j] * wage * extraWage;
				} else {
					totalOfficeHour += workingTime[j];
					totalOfficePayment += workingTime[j] * wage;
					payment += workingTime[j] * wage;
				}
			}
			stringBuilder.append(payment).append("\n");
		}

		var averageOfficePayment = totalOfficePayment / totalOfficeHour;
		averageOfficePayment = Math.round(averageOfficePayment * 100d) / 100d;
		var averageOverTimePayment = 0d;
		if (totalOverTimeHour > 0) {
			averageOverTimePayment = totalOverTimePayment / totalOverTimeHour;
			averageOverTimePayment = Math.round(averageOverTimePayment * 100d) / 100d;
		}
		stringBuilder.append(averageOfficePayment).append("\n").append(averageOverTimePayment);
		System.out.println(stringBuilder);
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
