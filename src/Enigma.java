import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Enigma {
    private String message;

    public void Encrypt(String m){

        message = m;
        String encryptedM;
        char[] charList = message.toCharArray();
        //Key is the CURRENT LETTER value is the CHANGE LETTER
        Map<Character, Character> rotor1 = new HashMap<>();

        rotor1.put('a', 'e');
        rotor1.put('b', 'k');
        rotor1.put('c', 'm');
        rotor1.put('d', 'f');
        rotor1.put('e', 'l');
        rotor1.put('f', 'g');
        rotor1.put('g', 'd');
        rotor1.put('h', 'q');
        rotor1.put('i', 'v');
        rotor1.put('j', 'z');
        rotor1.put('k', 'n');
        rotor1.put('l', 't');
        rotor1.put('m', 'o');
        rotor1.put('n', 'w');
        rotor1.put('o', 'y');
        rotor1.put('p', 'h');
        rotor1.put('q', 'x');
        rotor1.put('r', 'u');
        rotor1.put('s', 's');
        rotor1.put('t', 'p');
        rotor1.put('u', 'a');
        rotor1.put('v', 'i');
        rotor1.put('w', 'b');
        rotor1.put('x', 'r');
        rotor1.put('y', 'c');
        rotor1.put('z', 'j');

        Map<Character, Character> rotor2 = new HashMap<>();
        rotor2.put('a', 'a');
        rotor2.put('b', 'j');
        rotor2.put('c', 'd');
        rotor2.put('d', 'k');
        rotor2.put('e', 's');
        rotor2.put('f', 'i');
        rotor2.put('g', 'r');
        rotor2.put('h', 'u');
        rotor2.put('i', 'x');
        rotor2.put('j', 'b');
        rotor2.put('k', 'l');
        rotor2.put('l', 'h');
        rotor2.put('m', 'w');
        rotor2.put('n', 't');
        rotor2.put('o', 'm');
        rotor2.put('p', 'c');
        rotor2.put('q', 'q');
        rotor2.put('r', 'g');
        rotor2.put('s', 'z');
        rotor2.put('t', 'n');
        rotor2.put('u', 'p');
        rotor2.put('v', 'y');
        rotor2.put('w', 'f');
        rotor2.put('x', 'v');
        rotor2.put('y', 'o');
        rotor2.put('z', 'e');


        Map<Character, Character> rotor3 = new HashMap<>();

        rotor3.put('a', 'b');
        rotor3.put('b', 'd');
        rotor3.put('c', 'f');
        rotor3.put('d', 'h');
        rotor3.put('e', 'j');
        rotor3.put('f', 'l');
        rotor3.put('g', 'c');
        rotor3.put('h', 'p');
        rotor3.put('i', 'r');
        rotor3.put('j', 't');
        rotor3.put('k', 'x');
        rotor3.put('l', 'v');
        rotor3.put('m', 'z');
        rotor3.put('n', 'n');
        rotor3.put('o', 'y');
        rotor3.put('p', 'e');
        rotor3.put('q', 'i');
        rotor3.put('r', 'w');
        rotor3.put('s', 'g');
        rotor3.put('t', 'a');
        rotor3.put('u', 'k');
        rotor3.put('v', 'm');
        rotor3.put('w', 'u');
        rotor3.put('x', 's');
        rotor3.put('y', 'q');
        rotor3.put('z', 'o');



        for (char c : charList){
            char startC = c;
            c = rotor1.get(c); //Rotor 1
            c = rotor2.get(c); // Rotor 2
            c = rotor3.get(c); // Rotor 3
            //Reflect
            c = Reflect(c);
            char finalC = c;
            char other = c;
            other = ReflectBack(other);
            other = getKeyByValue(rotor3, other);
            other = getKeyByValue(rotor2, other);
            other = getKeyByValue(rotor1, other);

            System.out.printf("Start Encrypt: %c Finish Encrypt: %c | Start Decrypt: %c Finish Decrypt: %c", startC, finalC, finalC, other);
            //Go back through the rotors

        }


    }
    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            // Use Objects.equals() to safely handle potential null values
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey(); // Returns the first matching key
            }
        }
        return null; // Return null if the value is not found
    }

    public static char Reflect(char cToReflect){
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        final String reverseA = "zyxwvutsrqponmlkjihgfedcba";

        int alphaIndex = ALPHABET.indexOf(cToReflect);
        cToReflect = reverseA.charAt(alphaIndex);
        return cToReflect;

    }

    public static char ReflectBack(char cToReflect){
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        final String reverseA = "zyxwvutsrqponmlkjihgfedcba";

        int rIndex = reverseA.indexOf(cToReflect);
        cToReflect = ALPHABET.charAt(rIndex);
        return cToReflect;

    }


}
