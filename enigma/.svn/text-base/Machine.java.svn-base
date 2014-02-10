
package enigma;

/** Class that represents a complete enigma machine.
 *  @author cs61b-bz Daniel Paden Tomasello
 */
class Machine {
    /** Magic Number variable. */
    public static final int ALPHA = 26;
    /** reference variable for Rotors. */
    private Rotor leftRotor, middleRotor, rightRotor;
    /** Reference variable for Reflector. */
    private static Reflector reflector;
    /** Set my rotors to (from left to right), REFL, LEFT,
     *  MIDDLE, and RIGHT.  Initially, their positions are all 'A'. */
    void setRotors(Reflector refl, Rotor left, Rotor middle, Rotor right) {
        leftRotor = left;
        middleRotor = middle;
        rightRotor = right;
        reflector = refl;
    }
    /** Set the positions of my rotors according to SETTING, which
     *  must be a string of 4 upper-case letters. The first letter
     *  refers to the reflector position, and the rest to the rotor
     *  positions, left to right. */
    void setPositions(String setting) {
        reflector.setPosition(Rotor.toIndex(setting.charAt(0)));
        leftRotor.setPosition(Rotor.toIndex(setting.charAt(1)));
        middleRotor.setPosition(Rotor.toIndex(setting.charAt(2)));
        rightRotor.setPosition(Rotor.toIndex(setting.charAt(3)));
    }
    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        int index;
        String result;
        result = "";
        for (int i = 0; i < msg.length(); i += 1) {
            rightRotor.advance();
            if (rightRotor.atNotch()) {
                middleRotor.advance();
            }
            if (middleRotor.atNotch()) {
                middleRotor.advance();
                leftRotor.advance();
            }
            index = Rotor.toIndex(msg.charAt(i));
            index = rightRotor.convertForward(index);
            index = middleRotor.convertForward(index);
            index = leftRotor.convertForward(index);
            index = reflector.convertForward(index);
            index = leftRotor.convertBackward(index);
            index = middleRotor.convertBackward(index);
            index = rightRotor.convertBackward(index);
            if (index < 0) {
                index += ALPHA;
            }
            String a = Character.toString(Rotor.toLetter(index % ALPHA));
            result = result.concat(a);
        }
        return result;
    }
}
