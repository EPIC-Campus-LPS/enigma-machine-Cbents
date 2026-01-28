import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<Character, Character> pluhs = new HashMap<>();
        pluhs.put('b', 'a');
        pluhs.put('a', 'b');

        pluhs.put('q', 'u');
        pluhs.put('u', 'q');

        pluhs.put('c', 'g');
        pluhs.put('g', 'c');

        pluhs.put('x', 't');
        pluhs.put('t', 'x');

        pluhs.put('d', 'i');
        pluhs.put('i', 'd');

        pluhs.put('e', 'r');
        pluhs.put('r', 'e');

        pluhs.put('j', 'w');
        pluhs.put('w', 'j');

        pluhs.put('l', 's');
        pluhs.put('s', 'l');

        pluhs.put('v', 'k');
        pluhs.put('k', 'v');

        pluhs.put('n', 'm');
        pluhs.put('m', 'n');

        Enigma enigma = new Enigma(pluhs);
        Scanner scanner = new Scanner(System.in);


        System.out.println("(1) Encrypt (2) Decrypt: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1){
            System.out.println("Enter the message to encrypt: ");
            String message = scanner.nextLine();
            message = message.toLowerCase();
            String result = enigma.Process(message);
            System.out.printf("Result: %s", result);
        }
        else{
            System.out.println("Enter the message to decrypt: ");
            String message = scanner.nextLine();
            message = message.toLowerCase();
            String result = enigma.Process(message);
            System.out.printf("Result: %s", result);
        }


    }
}