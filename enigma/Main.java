package enigma;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

/** Enigma simulator.
 *  @author cs61b-bz Daniel Paden Tomasello
 */

public final class Main {

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    private static boolean isConfigured = false;
    /** Runs the program. UNUSED is the string input */
    public static void main(String[] unused) {
        Rotor.rotorarraybuild();
        Machine M = new Machine();
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));
        buildRotors();
        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                if (isConfigurationLine(line)) {
                    configure(M, line);
                } else {
                    if (!isConfigured || !isValidMsg(standardize(line))) {
                        System.exit(1);
                    }
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }
    /** Return true if MSG is a valid msg. */
    static boolean isValidMsg(String msg) {
        for (int i = 0; i < msg.length(); i += 1) {
            if (Character.isDigit(msg.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /** Return true iff LINE is an Enigma configuration line. */
    static boolean isConfigurationLine(String line) {
        if (line.charAt(0) != '*') {
            return false;
        }
        return true;
    }
    /** Configure M according to the specification given on CONFIG,
     *  which must have the format specified in the assignment. */
    static void configure(Machine M, String config) {
        String [] parts;
        parts = config.split(" ");
        if (!Main.isConfiguration(parts)) {
            System.exit(1);
        }
        Reflector ref1;
        if (parts.length != 6) {
            System.exit(1);
        }
        if (parts[1].equals("B")) {
            ref1 = reflectorB;
        } else {
            ref1 = reflectorC;
        }
        Rotor leftrotor = rHash.get(parts[2]);
        Rotor middlerotor = rHash.get(parts[3]);
        Rotor rightrotor = rHash.get(parts[4]);
        M.setRotors(ref1, leftrotor, middlerotor, rightrotor);
        M.setPositions(parts[5]);
        isConfigured = true;
    }
    /** Takes config as String array PARTS and returns true if its a valid
     *line. */
    static boolean isConfiguration(String[] parts) {
        if (!parts[1].equals("B") && !parts[1].equals("C")) {
            return false;
        }
        if (!rHash.containsKey(parts[2])) {
            return false;
        }
        if (!rHash.containsKey(parts[3])) {
            return false;
        }
        if (!rHash.containsKey(parts[4])) {
            return false;
        }
        if (parts[1] == parts[2]) {
            return false;
        }
        if (parts[2] == parts[3]) {
            return false;
        }
        if (parts[3] == parts[1]) {
            return false;
        }
        for (int i = 0; i < parts[4].length() - 1; i += 1) {
            if (Character.isDigit(parts[4].charAt(i))) {
                return false;
            }
            if (i > 3 || parts[4].length() < 3) {
                return false;
            }
        }
        return true;
    }
    /** Return the result of converting LINE to all upper case,
     *  removing all blanks.  It is an error if LINE contains
     *  characters other than letters and blanks. */
    static String standardize(String line) {
        String newline = line.toUpperCase().replace(" ", "");
        return newline;
    }

    /** Print MSG in groups of five (except that the last group may
     *  have fewer letters). */
    static void printMessageLine(String msg) {
        String result = "";
        while (msg.length() > 5) {
            result = result.concat(msg.substring(0, 5) + " ");
            if (msg.length() > 4) {
                msg = msg.substring(5, msg.length());
            }
        }
        result = result.concat(msg);
        msg = result;
        System.out.println(result);
    }
    /** Create Hashmap. */
    private static HashMap<String, Rotor> rHash = new HashMap<String, Rotor>();
    /** declare Rotor variables. */
    private static Rotor rotor1, rotor2, rotor3, rotor4;
    /** declare more Rotor reference variables. */
    private static Rotor rotor5, rotor6, rotor7, rotor8;
    /** declare Reflector variables. */
    private static Reflector reflectorB, reflectorC;
    /** Assign reference variables to new Rotors. */
    static void buildRotors() {
        rotor1 = new Rotor(0);
        rotor2 = new Rotor(1);
        rotor3 = new Rotor(2);
        rotor4 = new Rotor(3);
        rotor5 = new Rotor(4);
        rotor6 = new Rotor(5);
        rotor7 = new Rotor(6);
        rotor8 = new Rotor(7);
        reflectorB = new Reflector(8);
        reflectorC = new Reflector(9);
        rHash.put("I", rotor1);
        rHash.put("II", rotor2);
        rHash.put("III", rotor3);
        rHash.put("IV", rotor4);
        rHash.put("V", rotor5);
        rHash.put("VI", rotor6);
        rHash.put("VII", rotor7);
        rHash.put("VIII", rotor8);
    }
}

