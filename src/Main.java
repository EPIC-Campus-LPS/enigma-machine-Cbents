import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<Character, Character> pluhs = new HashMap<>();
        Enigma enigma = new Enigma(pluhs);
        Scanner scanner = new Scanner(System.in);


        System.out.println("(1) Encrypt (2) Decrypt: ");
        int choice = scanner.nextInt();
        if (choice == 1){
            System.out.println("Enter the message to encrypt: ");
            String message = scanner.nextLine();

            String result = enigma.Encrypt(message);
            System.out.printf("Result: %s", result);
        }
        else{
            System.out.println("Enter the message to decrypt: ");
            String message = scanner.nextLine();
            String result = enigma.Decrypt(message);
            System.out.printf("Result: %s", result);
        }


    }
}