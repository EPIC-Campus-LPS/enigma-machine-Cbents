import java.util.HashMap;
import java.util.Map;

public class Enigma {
    private String message;

    public String Encrypt(String m){

        message = m;
        String encryptedM;
        char[] charList = message.toCharArray();
        //Key is the CURRENT LETTER value is the CHANGE LETTER
        Map<String, String> rotor1 = Map.of(
           "a", "e",
                "b", "k",
                "c", "m",
                "d", "f",
                "e", "l",
                "f", "g",
                "g", "d",
                "h", "q",
                "i", "v",
                "j", "z"

        );
        for (char c : charList){
            for ()
        }

        return encryptedM;
    }


}
