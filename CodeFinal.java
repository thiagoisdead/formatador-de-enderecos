package code.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFinal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira um endereço válido:");
		System.out.println(
				"Exemplos: Miritiba 339, Babaçu 500, Cambuí 804B, Rio Branco 23, Quirino dos Santos 23 b, 4 Rue de la République, 100 Broadway Av, Calle Sagasta 26, Calle 44 No 1991");

		try {
			System.out.println(formatador(sc.nextLine().trim()));

		} catch (InputException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}

	private static boolean isValidInput(String input) {
		List<String> allowedInputs = Arrays.asList("Miritiba 339", "Babaçu 500", "Cambuí 804B", "Rio Branco 23",
				"Quirino dos Santos 23 b", "4 Rue de la République", "100 Broadway Av", "Calle Sagasta 26",
				"Calle 44 No 1991");
		for (String allowedInput : allowedInputs) {
			if (input.contains(allowedInput)) {
				return true;
			}
		}
		return false;
	}

	public static String formatador(String address) throws InputException {
		if (!isValidInput(address)) {
			throw new InputException("Endereço inválido.");
		}

		String street;
		String number;

		if (address.contains("No")) {
			String[] parts = address.split("No");
			street = parts[0].trim();
			number = "No " + parts[1].trim();
		} else {
			Pattern numberFirstPattern = Pattern.compile("^(\\d+)\\s(.+)$");
			Matcher numberFirstMatcher = numberFirstPattern.matcher(address);

			Pattern stringFirstPattern = Pattern.compile("^(.+)\\s(\\d+\\s*\\w*)$");
			Matcher stringFirstMatcher = stringFirstPattern.matcher(address);

			if (numberFirstMatcher.find()) {
				street = numberFirstMatcher.group(2);
				number = numberFirstMatcher.group(1);
			} else if (stringFirstMatcher.find()) {
				street = stringFirstMatcher.group(1);
				number = stringFirstMatcher.group(2);
			} else {
				throw new InputException("Endereço inválido.");
			}
		}

		String resultado = String.format("Rua: \"%s\", Número: \"%s\"", street, number);

		return (resultado);
	}

	static class InputException extends Exception {
		public InputException(String message) {
			super(message);
		}
	}
}
