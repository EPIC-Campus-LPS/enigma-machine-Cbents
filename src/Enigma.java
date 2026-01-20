import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Enigma {
    private String message;
    private Map<Character, Character> plugs;
    private Map<Character, Character> rotor1 = new HashMap<>();
    private Map<Character, Character> rotor2 = new HashMap<>();
    private Map<Character, Character> rotor3 = new HashMap<>();



    private void setupRotors(){
        //Key is the CURRENT LETTER value is the CHANGE LETTER
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

    }

    public Enigma(Map<Character, Character> pluh){
        setupRotors();
        plugs = pluh;
    }
    public String Encrypt(String m){

        message = m;
        String encryptedM;
        char[] charList = message.toCharArray();




        for (char i = 0; i < charList.length; i++){

            charList[i] = rotor3.get(charList[i]); // Rotor 3
            charList[i] = rotor2.get(charList[i]); // Rotor 2
            charList[i] = rotor1.get(charList[i]); //Rotor 1


            //Reflect
            charList[i] = Reflect(charList[i]);


                        //Go back through the rotors backwards
            charList[i] = getKeyByValue(rotor1, charList[i]);
            charList[i] = getKeyByValue(rotor2, charList[i]);
            charList[i] = getKeyByValue(rotor3, charList[i]);


        }
        // 1. Create a StringBuilder
        StringBuilder sb = new StringBuilder(charList.length);

        // 2. Append each character in the list
        for (Character c : charList) {
            sb.append(c);
        }

        // 3. Convert the StringBuilder to a String
        encryptedM = sb.toString();
        return encryptedM;

    }

    public String Decrypt(String m){
        message = m;
        String decryptedM;
        char[] charList = message.toCharArray();




        for (char i = 0; i < charList.length; i++){

            //Go through rotors backwards
            charList[i] = rotor3.get(charList[i]); // Rotor 3
            charList[i] = rotor2.get(charList[i]); // Rotor 2
            charList[i] = rotor1.get(charList[i]); //Rotor 1


            //Reflect
            charList[i] = Reflect(charList[i]);


            //Go back through the rotors backwards
            charList[i] = getKeyByValue(rotor1, charList[i]);
            charList[i] = getKeyByValue(rotor2, charList[i]);
            charList[i] = getKeyByValue(rotor3, charList[i]);


        }
        // 1. Create a StringBuilder
        StringBuilder sb = new StringBuilder(charList.length);

        // 2. Append each character in the list
        for (Character c : charList) {
            sb.append(c);
        }

        // 3. Convert the StringBuilder to a String
        decryptedM = sb.toString();
        return decryptedM;
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




}
