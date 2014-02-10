package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author Daniel Paden Tomasello
 */
class Rotor {
    /** magic number IALPHA. */
    public static final int IALPHA = 26;
    /** Magic number for 16. */
    public static final int CHARATNUM = 65;
    /** Magic number for 12. */
    public static final int TWELV = 12;
    /** Rotorarray contructor which takes in int ID and builds
     * rotors. */
    public Rotor(int id) {
        permutation = rotorarray[id];
        if (id < 5) {
            notches = new int[] {toIndex(notcharray[id])};
        } else if (id < 8) {
            notches = new int[] {IALPHA, TWELV};
        }
    }
    /** Assuming that P is an integer in the range 0..IALPHA, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return Character.toChars(p + CHARATNUM)[0];
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..IALPHA. Inverse of toLetter. */
    static int toIndex(char c) {
        return Character.getNumericValue(c) - 10;
    }

    /** Return my current rotational position as an integer between 0
     *  and IALPHA (corresponding to letters 'A' to 'Z').  */
    int getPosition() {
        return position;
    }

    /** Set getPosition() to POSN.  */
    void setPosition(int posn) {
        position = posn;
    }

    /** Return the conversion of P (an integer in the range 0..IALPHA)
     *  according to my permutation. */
    int convertForward(int p) {
        while (p < 0) {
            p += Machine.ALPHA;
        }
        int a = Rotor.toIndex(permutation[(p + position) % Machine.ALPHA]);
        a = a - position;
        while (a < 0) {
            a += Machine.ALPHA;
        }
        return a;
    }

    /** Return the conversion of E (an integer in the range 0..IALPHA)
     *  according to the inverse of my permutation. */
    int convertBackward(int e) {
        int i = 0;
        for (; i < permutation.length; i += 1) {
            char a = Rotor.toLetter((e + position) % Machine.ALPHA);
            if (permutation[i] == a) {
                break;
            }
        }
        int result = i - position;
        if (result < 0) {
            result += Machine.ALPHA;
        }
        if (result > IALPHA) {
            result = result % Machine.ALPHA;
        }
        return result;
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        for (int i = 0; i < notches.length; i += 1) {
            if (notches[i] == position - 1) {
                return true;
            }
        }
        return false;
    }

    /** Advance me one position. */
    void advance() {
        position = position + 1;
        if (position > IALPHA) {
            position = position % Machine.ALPHA;
        }
    }


    /** My current position (index 0..IALPHA, with 0 indicating that 'A'
     *  is showing). */
    private int position;
    /** int arrary for notches. */
    private int[] notches;
    /** char arrary for notches. */
    private static char[] notcharray;
    /** Char array which maps out letter changes. */
    private char[] permutation;
    /** char array array which holds rotors. */
    private static char[][] rotorarray;
    /** Helper function that builds for the Rotors to untilize in the ROTORAR
     * RAY class variable. */
    static void rotorarraybuild() {
        char[][] rotorarray1 = new char[10][]; {
            rotorarray1[0] = new char[] {'E', 'K', 'M', 'F', 'L', 'G', 'D',
                'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P'
               , 'A', 'I', 'B', 'R', 'C', 'J'};
            rotorarray1[1] = new char[] {'A', 'J', 'D', 'K', 'S', 'I', 'R',
                'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z',
                'N', 'P', 'Y', 'F', 'V', 'O', 'E'};
            rotorarray1[2] = new char[] {'B', 'D', 'F', 'H', 'J', 'L', 'C',
                'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G',
                'A', 'K', 'M', 'U', 'S', 'Q', 'O'};
            rotorarray1[3] = new char[] {'E', 'S', 'O', 'V', 'P', 'Z', 'J',
                'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T',
                'G', 'K', 'D', 'C', 'M', 'W', 'B'};
            rotorarray1[4] = new char[] {'V', 'Z', 'B', 'R', 'G', 'I', 'T',
                'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M',
                'J', 'Q', 'O', 'F', 'E', 'C', 'K'};
            rotorarray1[5] = new char[] {'J', 'P', 'G', 'V', 'O', 'U', 'M',
                'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D', 'K', 'A',
                'S', 'X', 'L', 'I', 'C', 'T', 'W'};
            rotorarray1[6] = new char[] {'N', 'Z', 'J', 'H', 'G', 'R', 'C',
                'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I', 'V',
                'L', 'P', 'E', 'K', 'Q', 'D', 'T'};
            rotorarray1[7] = new char[] {'F', 'K', 'Q', 'H', 'T', 'L', 'X',
                'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z', 'R', 'A', 'M', 'E',
                'W', 'N', 'I', 'U', 'Y', 'G', 'V'};
            rotorarray1[8] = new char[] {'Y', 'R', 'U', 'H', 'Q', 'S', 'L',
                'D', 'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F',
                'Z', 'C', 'W', 'V', 'J', 'A', 'T'};
            rotorarray1[9] = new char[] {'F', 'V', 'P', 'J', 'I', 'A', 'O',
                'Y', 'E', 'D', 'R', 'Z', 'X', 'W', 'G', 'C', 'T', 'K', 'U',
                'Q', 'S', 'B', 'N', 'M', 'H', 'L'};
        }
        notcharray = new char[] {'Q', 'E', 'V', 'J', 'Z'};
        rotorarray = rotorarray1;
    }
}
