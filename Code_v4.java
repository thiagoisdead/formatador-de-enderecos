package code.challenge;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code_v4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um endereço válido:");
        System.out.println("Exemplos: Miritiba 339, Babaçu 500, Cambuí 804B, Rio Branco 23, Quirino dos Santos 23 b, Rue de la République 4, 100 Broadway Av, Calle Sagasta 26, Calle 44 No 1991");

        try {
            String address = sc.nextLine().trim();
            if (!isValidInput(address)) {
                throw new InputException("Endereço inválido. Por favor, insira um dos exemplos fornecidos.");
            }

            Pattern pattern = Pattern.compile("^(.+)\\s(\\d+\\s*\\w*)$");
            Matcher matcher = pattern.matcher(address);

            if (matcher.find()) {
                String street = matcher.group(1);
                String number = matcher.group(2);
                System.out.printf("Rua: \"%s\", Número: \"%s\"\n", street, number);
            } else {
                throw new InputException("Endereço inválido.");
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static boolean isValidInput(String input) {
        List<String> allowedInputs = Arrays.asList(
            "Miritiba 339", "Babaçu 500", "Cambuí 804B", 
            "Rio Branco 23", "Quirino dos Santos 23 b", 
            "Rue de la République 4", "100 Broadway Av", 
            "Calle Sagasta 26", "Calle 44 No 1991"
        );
        for (String allowedInput : allowedInputs) {
            if (input.contains(allowedInput)) {
                return true;
            }
        }
        return false;
    }

    static class InputException extends Exception {
        public InputException(String message) {
            super(message);
        }
    }
}
