/**
 * Name: E.J. Yu
 * Date: April 8, 2019
 * Resources: None used. File written from scratch.
 * 
 * HammingTester.java serves as a tester for the Hamming class.
 * 
 * In this file, I will primarily be writing my decode implementation.
 * 
 * Tests will be ran for the purpose of helping myself determine
 * whether or not my implementations of the various Hamming codeword
 * manipulation methods have even been implemented correctly at all.
 * 
 * @author E.J. Yu
 */

/**
 * The HammingTester class contains only one method, a main
 * method, which serves to test the method implementations
 * in Hamming. There may be multiple tests for the decode
 * implementation.
 */
public class HammingTester{
    /**
     * Regardless of the arguments passed in, this main
     * method will test out the method implementations
     * in Hamming. Does not return anything; should only
     * print statements to the console.
     * 
     * @param args User-defined arguments passed in.
     * @return     Nothing.
     */
    public static void main (String[] args){
        // Indicate that the tester is being run.
        System.out.println("HammingTester is now running.");
        // Spacer.
        System.out.println("");

        // Indicate that hammingDecode() is now being tested.
        System.out.println("Testing: hammingDecode()");
        // Spacer.
        System.out.println("");

        // Set tester variables.
        String input;
        String correctOutput;

        // Initialize encoded String.
        input = "0000000";
        // Initialize correct original message String.
        correctOutput = "0000";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "1111111";
        // Initialize correct original message String.
        correctOutput = "1111";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "1010101";
        // Initialize correct original message String.
        correctOutput = "1101";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }
        
        // Initialize encoded String.
        input = "0110011";
        // Initialize correct original message String.
        correctOutput = "1011";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "01100111";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == correctOutput)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == correctOutput)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "I0I0I0I";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == correctOutput)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "1010100";
        // Initialize correct original message String.
        correctOutput = "1101";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "0010101";
        // Initialize correct original message String.
        correctOutput = "1101";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "NG976NG76gn97g7n6g9&^79tyg(&Tfn97ng97ynfg(&TF(";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == null)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "i rly want 2 play Smash Ultimate rn *sad face*";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == null)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = "101010.1";
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == null)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Initialize encoded String.
        input = null;
        // Initialize correct original message String.
        correctOutput = null;
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input) == correctOutput)) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Spacer.
        System.out.println("");
        // Indicate that the more complex tests are now being run.
        System.out.println("Initiate intense and extreme test cases.");
        // Spacer.
        System.out.println("");

        // Initialize encoded String.
        input = "0011001";
        // Initialize correct original message String.
        correctOutput = "1001";
        // Check if implementation is working.
        if (!(Hamming.hammingDecode(input).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + input
                                + "!");
        }

        // Nested encoding and decoding implementations.
        input = Hamming.hammingEncode(
                    Hamming.hammingDecode(
                        Hamming.hammingEncode(
                            Hamming.hammingDecode(input)
                        )
                    )
                );

        // Even more nested encoding and decoding implementations.
        String inputTwo = Hamming.hammingEncode(
                               Hamming.hammingDecode(
                                   Hamming.hammingEncode(
                                       Hamming.hammingDecode(input)
                                   )
                               )
                          );

        // Check if implementation is working.
        if (!(Hamming.hammingDecode(inputTwo).equals(correctOutput))) {
            // Will print to indicate failure.
            System.out.println("> [DECODE] FAILED. Method returned "
                                + Hamming.hammingDecode(inputTwo)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("> [DECODE] SUCCEEDED for input "
                                + "INTENSE AND EXTREME CASE"
                                + "!!!!!!!!");
        }

        // Spacer.
        System.out.println("");
        // Indicate that the tests are over.
        System.out.println("Testing finished.");
    }
} 
