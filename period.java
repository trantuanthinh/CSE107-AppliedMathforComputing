import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class period {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		System.out.println("Input Day(dd): ");
		var day = reader.nextInt();
		System.out.println("Input Month(mm): ");
		var month = reader.nextInt();
		stringBuilder = calculatePeriod(day, month);
		System.out.println(stringBuilder);
	}

	static StringBuilder calculatePeriod(int day, int month) {
		LocalDate date = LocalDate.of(LocalDate.now().getYear(), month, day);
		LocalDate ovulationDay = date.minusDays(14);
		String tempDayString = null;
		stringBuilder.append("Menstrual Period: ");
		for (int i = 0; i <= 2; i++) {
			stringBuilder.append(plusDays(date, tempDayString, i)).append(" ");
		}
		stringBuilder.append("\n").append("Unsafe Days: ");
		for (int i = 3; i >= 1; i--) {
			stringBuilder.append(plusDays(ovulationDay, tempDayString, i)).append(" ");
		}
		tempDayString = ovulationDay.format(DateTimeFormatter.ofPattern("dd/MM"));
		stringBuilder.append(tempDayString).append(", ");
		for (int i = 1; i <= 8; i++) {
			stringBuilder.append(minusDays(ovulationDay, tempDayString, i)).append(" ");
		}
		stringBuilder.append("\n").append("Safe Days: ");
		for (int i = 1; i <= 10; i++) {
			stringBuilder.append(minusDays(date, tempDayString, i)).append(" ");
		}
		stringBuilder.append("\n").append("Relatively Safe Days: ");
		for (int i = 3; i <= 8; i++) {
			stringBuilder.append(plusDays(date, tempDayString, i)).append(" ");
		}
		return stringBuilder;
	}

	static String plusDays(LocalDate date, String tempDayString, int range) {
		var tempSoonDay = date.plusDays(range);
		tempDayString = tempSoonDay.format(DateTimeFormatter.ofPattern("dd/MM"));
		return tempDayString;
	}

	static String minusDays(LocalDate date, String tempDayString, int range) {
		var tempSoonDay = date.minusDays(range);
		tempDayString = tempSoonDay.format(DateTimeFormatter.ofPattern("dd/MM"));
		return tempDayString;
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
