/**
 * Author: E.J. Yu
 * Date: April 9, 2019
 * Sources of Help: Assignment documentation,
 *                  Oracle's Java documentation (for
 *                  String, StringBuilder, Random),
 *                  Piazza posts (primarily my own
 *                  questions: tutor answers to
 *                  my questions).
 *
 * HammingEC.java involves the encoding, decoding, and manipulation
 * of Hamming codewords. This file contains one class named HammingEC,
 * which consists of six methods and various instance variables that
 * are used to help identify, calculate, and generate bits. Aside from
 * Hamming codeword manipulations, two of the six methods in this file's
 * single class are String generators. These generators were made to
 * see the efficiency differences between Strings and StringBuilders.
 * 
 * @author E.J. Yu
 */

import java.util.*;

/**
 * The purpose of HammingEC is to take an arbitrary String of letters,
 * like "Hello", and be able to encode / decode it in 4-bit increments.
 * Instance variables exist for finding Hamming bit positions,
 * finding indicies that are explicitly parity indicies only OR
 * non-parity indicies only, finding values that make up these
 * Hamming codewords, and related uses.
 */
public class HammingEC {

    // Hamming bit position constants.
    private static final int BIT_1P = 1;
    private static final int BIT_2P = 2;
    private static final int BIT_3 = 3;
    private static final int BIT_4P = 4;
    private static final int BIT_5 = 5;
    private static final int BIT_6 = 6;
    private static final int BIT_7 = 7;

    // Organized makeup of Hamming codeword parts stored in arrays.
    private static final int[] parityIndices = {1, 2, 4};
    private static final int[] nonParityIndices = {3, 5, 6, 7};

    // Range of usable char values stored in instance variables.
    private static final int UPPERCASE_A_INTEGER = 65;
    private static final int UPPERCASE_Z_INTEGER = 90;
    private static final int LOWERCASE_A_INTEGER = 97;
    private static final int LOWERCASE_Z_INTEGER = 122;

    // Possible bit values stored in character variables.
    private static final char ZERO_CHARACTER = '0';
    private static final char ONE_CHARACTER = '1';

    // Commonly used integers used to help with calculations.
    private static final int TWO = 2;
    private static final int FOURTEEN = 14;

    /**
     * Creates a string of random lowercase letters of a
     * specified length. 
     * 
     * @param length Length of the random lowercase string.
     * @return       String of random lowercase letters.
     */
    public static String randomLowercaseString(int length) {
        // Initialize Random object to help generate random letters.
        Random rand = new Random();
        // Initialize String that will be returned.
        String randomLowercaseString = "";

        // Determine the range of numbers.
        int characterRange = LOWERCASE_Z_INTEGER - LOWERCASE_A_INTEGER;
        // Generate a random new letter "length" times...
        for(int i = 0; i < length; i++) {
            int randomCharacterGenerator = rand.nextInt(characterRange);
            char randomCharacter = (char)(randomCharacterGenerator
                                            + LOWERCASE_A_INTEGER);
            // ...and add that to the String.
            randomLowercaseString = randomLowercaseString + randomCharacter;
        }
        // Return the String of random lowercase letters.
        return randomLowercaseString;
    }

    /**
     * Creates a line of random lowercase letters of a
     * specified length in a more efficient way.
     * 
     * @param length Length of the random lowercase string.
     * @return       String of random lowercase letters.
     */
    public static String randomLowercaseStringII(int length) {
        // Initialize Random object to help generate random letters.
        Random rand = new Random();
        // Initialize StringBuilder object.
        StringBuilder randomLowercaseString = new StringBuilder("");

        // Determine the range of numbers.
        int characterRange = LOWERCASE_Z_INTEGER - LOWERCASE_A_INTEGER;
        // Generate a random new letter "length" times...
        for(int i = 0; i < length; i++) {
            int randomCharacterGenerator = rand.nextInt(characterRange);
            char randomCharacter = (char)(randomCharacterGenerator
                                            + LOWERCASE_A_INTEGER);
            // ...and add that to the String.
            randomLowercaseString.append(randomCharacter);
        }
        // Return the String of random lowercase letters.
        return randomLowercaseString.toString();
    }

    /**
     * Helper function for hammingEncode() and hammingDecode(). Finds 
     * which indices of a String of length 7 that the caller should 
     * check for error detection.
     * 
     * @param  parityIndex the value whose associated bits we want to check 
     *                     in either hammingEncode() or hammingDecode()
     * @return             [1, 3, 5, 7] if input is 1
     *					   [2, 3, 6, 7] if input is 2
     *					   [4, 5, 6, 7] if input is 4
     *					   [0, 0, 0, 0] in all other cases
     */
    public static int[] parityHelper(int parityIndex) {
        // If parity index 1 is passed in...
        if(parityIndex == BIT_1P) {
            // ...return [1, 3, 5, 7].
            int[] indiciesForOne = {BIT_1P, BIT_3, BIT_5, BIT_7};
            return indiciesForOne;
        }
        // If parity index 2 is passed in...
        else if(parityIndex == BIT_2P) {
            // ...return [2, 3, 6, 7].
            int[] indiciesForTwo = {BIT_2P, BIT_3, BIT_6, BIT_7};
            return indiciesForTwo;
        }
        // If parity index 4 is passed in...
        else if(parityIndex == BIT_4P) {
            // ...return [4, 5, 6, 7].
            int[] indiciesForFour = {BIT_4P, BIT_5, BIT_6, BIT_7};
            return indiciesForFour;
        }
        // If any other number is passed in...
        else {
            // ...return [0, 0, 0, 0].
            int[] indiciesForAllElse = {0, 0, 0, 0};
            return indiciesForAllElse;
        }
    }

    /**
     * Will encode a four-character numeric String into a 
     * seven-character String of Hamming bits.
     * 
     * @param  plaintext The four-character numeric String in question.
     * @return           The Hamming codeword for the String passed in.
     */
    public static String hammingEncode(String plaintext) {
        // String passed in will be converted to seven-character String.
        StringBuilder convertedArg = new StringBuilder("");
        // The final encoded message will be stored here.
        StringBuilder encodedMessage = new StringBuilder("");
        // Indicies of size four arrays. (Recycling Hamming bit constants.)
        int indexZero = BIT_1P - 1;
        int indexOne = BIT_2P - 1;
        int indexTwo = BIT_3 - 1;
        int indexThree = BIT_4P - 1;
        // Counter to be used for satisfying XOR operations.
        int occurrenceCounter = 0;
        // Indicies to use with seven-character numeric String.
        int[] parityBitOneIndicies = parityHelper(BIT_1P);
        int[] parityBitTwoIndicies = parityHelper(BIT_2P);
        int[] parityBitFourIndicies = parityHelper(BIT_4P);

        // Return null if null is passed in.
        if(plaintext == null) {
            return null;
        }

        // Check if the length of plaintext is 4.
        int requiredStringSize = nonParityIndices.length;
        if (plaintext.length() != requiredStringSize) {
            return null;
        }

        // Flag to help check for characters other than 0 or 1.
        boolean hasWeirdCharacter = false;
        // Check if String passed in ONLY consists of 0's and 1's.
        for(int i = 0; i < requiredStringSize; i++) {
            if(plaintext.charAt(i) != ZERO_CHARACTER
                && plaintext.charAt(i) != ONE_CHARACTER) {
                    // Set flag to true if non-0 AND non-1 character found.
                    hasWeirdCharacter = true;
            }
        }
        // Return null if unsupported characters were passed in.
        if(hasWeirdCharacter == true) {
            return null;
        }
        
        // Create the WIP encoded message as seven-character numeric String.
        convertedArg.append(0);
        convertedArg.append(0);
        convertedArg.append(plaintext.charAt(indexZero));
        convertedArg.append(0);
        convertedArg.append(plaintext.charAt(indexOne));
        convertedArg.append(plaintext.charAt(indexTwo));
        convertedArg.append(plaintext.charAt(indexThree));

        // Now begin encoding message's parity bits.
        // Begin with bit 1. (First parity bit.)
        // Check if index 3 of encoded message is a 1.
        if(convertedArg.charAt(parityBitOneIndicies[indexOne] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 5 of encoded message is a 1.
        if(convertedArg.charAt(parityBitOneIndicies[indexTwo] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 7 of encoded message is a 1.
        if(convertedArg.charAt(parityBitOneIndicies[indexThree] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // If counter is even, bit 1 in encoded message remains 0.
        if(occurrenceCounter % TWO == 0) {
            encodedMessage.append(0);
        }
        // But if counter is odd, swap first parity bit to a 1.
        else {
            encodedMessage.append(1);
        }
        // Reset bit occurrence counter.
        occurrenceCounter = 0;
        
        // Set bit 2. (Second parity bit.)
        // Check if index 3 of encoded message is a 1.
        if(convertedArg.charAt(parityBitTwoIndicies[indexOne] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 6 of encoded message is a 1.
        if(convertedArg.charAt(parityBitTwoIndicies[indexTwo] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 7 of encoded message is a 1.
        if(convertedArg.charAt(parityBitTwoIndicies[indexThree] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // If counter is even, bit 1 in encoded message remains 0.
        if(occurrenceCounter % TWO == 0) {
            encodedMessage.append(0);
        }
        // But if counter is odd, swap first parity bit to a 1.
        else {
            encodedMessage.append(1);
        }
        // Reset bit occurrence counter.
        occurrenceCounter = 0;

        // Set bit 3.
        encodedMessage.append(plaintext.charAt(indexZero));

        // Set bit 4. (Third parity bit.)
        // Check if index 5 of encoded message is a 1.
        if(convertedArg.charAt(parityBitFourIndicies[indexOne] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 6 of encoded message is a 1.
        if(convertedArg.charAt(parityBitFourIndicies[indexTwo] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // Check if index 7 of encoded message is a 1.
        if(convertedArg.charAt(parityBitFourIndicies[indexThree] - 1)
            == ONE_CHARACTER) {
                // Increment counter if value is 1.
                occurrenceCounter++;
        }
        // If counter is even, bit 1 in encoded message remains 0.
        if(occurrenceCounter % TWO == 0) {
            encodedMessage.append(0);
        }
        // But if counter is odd, swap first parity bit to a 1.
        else {
            encodedMessage.append(1);
        }
        // Reset bit occurrence counter.
        occurrenceCounter = 0;

        // Set bit 5.
        encodedMessage.append(plaintext.charAt(indexOne));

        // Set bit 6.
        encodedMessage.append(plaintext.charAt(indexTwo));

        // Set bit 7.
        encodedMessage.append(plaintext.charAt(indexThree));

        // Create final String and return it.
        return encodedMessage.toString(); 
    }

    /**
     * Decodes a numeric seven-character Hamming codeword.
     * 
     * @param ciphertext The Hamming codeword in question (as a String).
     * @return           A numeric four-character String.
     */
    public static String hammingDecode(String ciphertext) {
        // Flag to help detect errors.
        boolean argHasError = false;
        // Decoded message will be stored here.
        StringBuilder decodedMessage = new StringBuilder("");
        // Index of the corrupted bit (if there is one).
        int badBit = 0;

        // Return null if null is passed in.
        if(ciphertext == null) {
            return null;
        }

        // Length required of the String passed in.
        int requiredArgumentLength = parityIndices.length
                                   + nonParityIndices.length;
        // Check if String passed in has length of 7.
        if(ciphertext.length() != requiredArgumentLength) {
            return null;
        }

        // Flag to help check for characters other than 0 or 1.
        boolean hasWeirdCharacter = false;
        // Check if String passed in ONLY consists of 0's and 1's.
        for(int i = 0; i < requiredArgumentLength; i++) {
            if(ciphertext.charAt(i) != ZERO_CHARACTER &&
               ciphertext.charAt(i) != ONE_CHARACTER) {
                    // Set flag to true if non-0 AND non-1 character found.
                    hasWeirdCharacter = true;
            }
        }
        // Return null if unsupported characters were passed in.
        if(hasWeirdCharacter == true) {
            return null;
        }

        // Counter for occurrences of 1's in non-parity bit positions.
        int occurrenceCounter = 0;
        // Iterate through parity indices array and fetch associated bits.
        for(int i = 0; i < parityIndices.length; i++) {
            // Parity bit and its associations will be stored in an array.
            int[] parityCalcHelper = parityHelper(parityIndices[i]);
            // Iterate through argument passed in (ciphertext).
            for(int j = 1; j < parityCalcHelper.length; j++) {
                // For the specified non-parity indicies with value of 1...
                if(ciphertext.charAt(parityCalcHelper[j] - 1)
                    == ONE_CHARACTER) {
                        // ...increment counter recording these occurrences.
                        occurrenceCounter++;
                }
            }
            // Expected value of parity bit will be stored here.
            char expectedParityValue;
            // Determine EXPECTED values based on counter divisibility.
            if(occurrenceCounter % TWO == 0) {
                expectedParityValue = ZERO_CHARACTER;
            }
            else {
                expectedParityValue = ONE_CHARACTER;
            }
            // If a parity bit in argument is not what is expected...
            if(ciphertext.charAt(parityCalcHelper[0] - 1)
                != expectedParityValue) {
                    // ...indicate that an error exists.
                    argHasError = true;
                    badBit += parityCalcHelper[0];
            }
            // Reset occurrence counter
            occurrenceCounter = 0;
        }

        // If there are NO errors in the Hamming codeword passed in...
        if(argHasError == false) {
            // ...fetch indicies to fetch values from, and...
            for (int i = 0; i < nonParityIndices.length; i++) {
                int codewordIndex = nonParityIndices[i] - 1;
                char nonParityValue = ciphertext.charAt(codewordIndex);
                // ...decode the message since error-fixing isn't needed.
                decodedMessage.append(nonParityValue);
            }
        }
        // If some error EXISTS in the Hamming codeword passed in...
        if(argHasError == true) {
            for (int i = 0; i < nonParityIndices.length; i++) {
                // ...fetch non-parity index (one at a time), and...
                int nonParityIndex = nonParityIndices[i];
                // ...check for bad bit.
                if(nonParityIndex != badBit) {
                    int codewordIndex = nonParityIndex - 1;
                    char nonParityValue = ciphertext.charAt(codewordIndex);
                    // If not bad, add bit to decoded message workspace.
                    decodedMessage.append(nonParityValue);
                }
                // If bad bit is encountered, flip it.
                else {
                    int codewordIndex = nonParityIndex - 1;
                    char nonParityValue = ciphertext.charAt(codewordIndex);
                    // If bad bit is a 0...
                    if (nonParityValue == ZERO_CHARACTER) {
                        // ...append a 1 to the decoded message workspace.
                        decodedMessage.append(ONE_CHARACTER);
                    }
                    // If bad bit is a 1...
                    if (nonParityValue == ONE_CHARACTER) {
                        // ...append a 0 to the decoded message workspace.
                        decodedMessage.append(ZERO_CHARACTER);
                    }
                }
            }
        }

        // Create final String and return it.
        return decodedMessage.toString();
    }

    /**
     * Takes a numeric seven-character Hamming codeword and flips the
     * bit specified as an argument to corrupt the codeword.
     * 
     * @param ciphertext  The Hamming codeword in question (as a String).
     * @param bitPosition Bit in the codeword to corrupt.
     * @return            The Hamming codeword corrupted at argued bit.
     */
    public static String bitCorrupt(String ciphertext, int bitPosition) {
        // Return null if null is passed in as the codeword argument.
        if(ciphertext == null) {
            return null;
        }

        // Return null if bitPosition is not >= 1 or <= 7.
        if(bitPosition < 1 || bitPosition > 7) {
            return null;
        }

        // Length required of the String passed in.
        int requiredArgumentLength = parityIndices.length
                                   + nonParityIndices.length;
        // Check if String passed in has length of 7.
        if(ciphertext.length() != requiredArgumentLength) {
            return null;
        }

        // Flag to help check for characters other than 0 or 1.
        boolean hasWeirdCharacter = false;
        // Check if String passed in ONLY consists of 0's and 1's.
        for(int i = 0; i < requiredArgumentLength; i++) {
            if(ciphertext.charAt(i) != ZERO_CHARACTER &&
               ciphertext.charAt(i) != ONE_CHARACTER) {
                    // Set flag to true if non-0 AND non-1 character found.
                    hasWeirdCharacter = true;
            }
        }
        // Return null if unsupported characters were passed in.
        if(hasWeirdCharacter == true) {
            return null;
        }

        // Initialize workspace for the codeword corruptor.
        StringBuilder codewordCorruptor = new StringBuilder("");
        // Iterate through the Hamming codeword.
        for(int i = 0; i < requiredArgumentLength; i++) {
            // If this index is not the bit argued for corruption...
            if(i != bitPosition - 1) { 
                // ...don't corrupt bit and add to corruption workspace.
                codewordCorruptor.append(ciphertext.charAt(i));
            }
            // IF it is, flip the bit at i.
            else {
                int valueAtIndex = ciphertext.charAt(i);
                if(valueAtIndex == ZERO_CHARACTER) {
                    codewordCorruptor.append(ONE_CHARACTER);
                }
                if(valueAtIndex == ONE_CHARACTER) {
                    codewordCorruptor.append(ZERO_CHARACTER);
                }
            }
        }

        // Create final String and return it.
        return codewordCorruptor.toString();
    }

    /**
     * Takes in a String of letters and returns that String after
     * undergoing a conversion to binary, then a conversion to Hamming
     * codeword format.
     * 
     * @param originalMessage The String in question, containing letters.
     * @return                The original message in Hamming Code format.
     */
    public static String encodeWord(String originalMessage) {
        // Return null if null is passed in as the argument.
        if(originalMessage == null || originalMessage.length() < 1) {
            return null;
        }

        // Flag to help check for characters other than letters.
        boolean hasWeirdCharacter = false;
        // Check if String passed in ONLY consists of LETTERS.
        for(int i = 0; i < originalMessage.length(); i++) {
            if(originalMessage.charAt(i) < UPPERCASE_A_INTEGER ||
               originalMessage.charAt(i) > UPPERCASE_Z_INTEGER &&
               originalMessage.charAt(i) < LOWERCASE_A_INTEGER ||
               originalMessage.charAt(i) > LOWERCASE_Z_INTEGER) {
                    // Set flag to true if non-letter character found.
                    hasWeirdCharacter = true;
            }
        }
        // Return null if non-letter values are detected.
        if(hasWeirdCharacter == true) {
            return null;
        }

        // Initialize variable for storing the final encoded String.
        StringBuilder encodedWord = new StringBuilder("");

        // Looping through each character from the input String
        for(int i = 0; i < originalMessage.length(); i++) {
            // A character from the String passed in.
            int currentCharacter;
            // The current working character as a 7-bit binary String.
            String charAsCodeword;
            // Workspace for making 7-bit binary String an 8-bit String.
            StringBuilder binaryStringConverter = new StringBuilder ("");
            // Workspace for first half of the binary String.
            StringBuilder binaryHalfOne = new StringBuilder ("");
            // Workspace for second half of the binary String.
            StringBuilder binaryHalfTwo = new StringBuilder ("");

            // Convert String passed in to binary.
            currentCharacter = originalMessage.charAt(i);
            charAsCodeword = Integer.toBinaryString(currentCharacter);
            binaryStringConverter.append(0 + charAsCodeword);
            // Ensure that the binary message is still a String.
            String binaryString = binaryStringConverter.toString();
            // Grab half the length of the binary String. (For separation.)
            int halfBinaryLength = binaryString.length() / TWO;
            // Extract the first half of the binary String.
            for(int j = 0; j < halfBinaryLength; j++) {
                binaryHalfOne.append(binaryString.charAt(j));
            }
            // Extract the second half of the binary String.
            for(int l = halfBinaryLength; l < binaryString.length(); l++) {
                binaryHalfTwo.append(binaryString.charAt(l));
            }
            // Ensure that the halves of the binary message are type String.
            String binaryStringHalfOne = binaryHalfOne.toString();
            String binaryStringHalfTwo = binaryHalfTwo.toString();
            // Convert halves of binary String to Hamming, then combine.
            encodedWord.append(hammingEncode(binaryStringHalfOne) +
                               hammingEncode(binaryStringHalfTwo));
        }
        // Create final String and return it.
        return encodedWord.toString();
    }

    /**
     * Takes in an encoded String and returns the decoded
     * String of letters.
     * 
     * @param ciphertext The numeric String in question.
     * @return           A String consisting of letters ONLY.
     */
    public static String decodeWord(String ciphertext) {
        // Return null if null is passed in, or if String is empty.
        if(ciphertext == null || ciphertext.length() == 0) {
            return null;
        }

        // Return null if ciphertext is NOT a multiple of 14.
        if(ciphertext.length() % FOURTEEN != 0) {
            return null;
        }

        // Flag to help check for characters other than 0 or 1.
        boolean hasWeirdCharacter = false;
        // Check if String passed in ONLY consists of 0's and 1's.
        for(int i = 0; i < ciphertext.length(); i++) {
            if(ciphertext.charAt(i) != ZERO_CHARACTER
                && ciphertext.charAt(i) != ONE_CHARACTER) {
                    // Set flag to true if non-0 AND non-1 character found.
                    hasWeirdCharacter = true;
            }
        }
        // Return null if unsupported characters were passed in.
        if(hasWeirdCharacter == true) {
            return null;
        }

        // For storing String argument as StringBuilder.
         StringBuilder ciphertextWorkspace = new StringBuilder("");
        // Storage for current working Hamming codework to decode.
        StringBuilder hammingCodeword = new StringBuilder("");
        // A decoded 7-bit Hamming codeword from the argument.
        String hammingDecoded;
        // Decoded 1's and 0's String.
        StringBuilder nowBinary = new StringBuilder("");
        // Storage for current working binary codework to decode.
        StringBuilder decodedWord = new StringBuilder("");

        // Convert argument from String to StringBuilder.
        for(int i = 0; i < ciphertext.length(); i++) {
            ciphertextWorkspace.append(ciphertext.charAt(i));
        }

        // Length of a Hamming codeword. (Used for decoding calculations.)
        int hammingLength = FOURTEEN / TWO;
        // Occurrences of Hamming codewords.
        int hammingLengthCount = ciphertext.length() / hammingLength;
        // Iterate through argument in chunks of 7.
        for(int i = 0; i < hammingLengthCount; i++) {
            // Iterate through the Hamming codeword occurrence.
            if(ciphertextWorkspace.length() != 0) {
                for(int j = 0; j < hammingLength; j++) {
                    // Create the Hamming codeword.
                    hammingCodeword.append(ciphertextWorkspace.charAt(j));
                }
            }
            // Decode the Hamming codeword after preparing the 7-bit String.
            hammingDecoded = hammingDecode(hammingCodeword.toString());
            // Prepare binary codeword.
            nowBinary.append(hammingDecoded);
            // Clear occurrences for next iteration.
            hammingCodeword.delete(0,hammingCodeword.length());
            ciphertextWorkspace.delete(0, hammingLength);
        }

        // Length of a binary codeword. (Used for decoding calculations.)
        int binaryLength = hammingLength + 1;
        // Occurrences of binary codewords.
        int binaryLengthCount = nowBinary.length() / binaryLength;
        // Iterate through binary codeword in chunks of 8.
        for(int i = 0; i < binaryLengthCount; i++) {
            // Last Calculated total in binary to text conversion.
            int previousTotal = 0;
            for(int j = 0; j < binaryLength; j++) {
                // Fetch leftmost bit untouched by calculator.
                StringBuilder bit = new StringBuilder("" +
                                                      nowBinary.charAt(j));
                // Turn the value of that bit into an integer.
                int currentBitValue = Integer.parseInt(bit.toString());
                // Finalize binary conversion to text at current bit.
                previousTotal =  previousTotal * TWO + currentBitValue;
            }
            // Append converted binary codeword to string.
            decodedWord.append((char)previousTotal);
            // Clear occurrences for next iteration.
            nowBinary.delete(0, binaryLength);
        }
        // Create the final string and return it.
        return decodedWord.toString();
    }
}