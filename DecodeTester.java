/**
 * Name: E.J. Yu
 * Date: April 6, 2019
 * Resources: Assignment documentation only.
 * 
 * DecodeTester.java serves as a tester for the Decode class.
 * I'll be performing code testing practices on a component of
 * the Hamming Code: the "decode" part of it.
 * 
 * Tests will be ran on Decode.class, which will help to
 * determine what's going on with each of the faulty hammingDecode()
 * implementations in Decode.class.
 * 
 * Note: Decode.class was not written by me.
 * 
 * @author E.J. Yu
 */

/**
 * The DecodeTester class contains only one method, a main
 * method, which serves to test the various implementations
 * of hammingDecode(). There are multiple testers per
 * implementation test of hammingDecode().
 */
public class DecodeTester{
    /**
     * Regardless of the arguments passed in, this main
     * method will test out the method implementations
     * in the Decode.class file. Does not return anything;
     * should only print statements to the console.
     * 
     * @param args User-defined arguments passed in.
     * @return     Nothing.
     */
    public static void main (String[] args){
        // Indicate that the decode tester is being run.
        System.out.println ("This is the DecodeTester.");

        // Initialize encoded String.
        String input = "1010101";
        // Initialize correct original message String.
        String correctOutput = "1101";
        // Check if op1 implementation is working.
        if (!(Decode.op1(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op1] FAILED. Method returned "
                                + Decode.op1(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op1] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "1010101";
        // Update correct original message String.
        correctOutput = "1101";
        // Check if op2 implementation is working.
        if (!(Decode.op2(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op2] FAILED. Method returned "
                                + Decode.op2(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op2] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "0111100";
        // Update correct original message String.
        correctOutput = "1100";
        // Check if op2 implementation is working.
        if (!(Decode.op2(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op2] FAILED. Method returned "
                                + Decode.op2(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op2] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "0101010";
        // Update correct original message String.
        correctOutput = "0010";
        // Check if op2 implementation is working.
        if (!(Decode.op2(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op2] FAILED. Method returned "
                                + Decode.op2(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op2] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "1010101";
        // Update correct original message String.
        correctOutput = "1101";
        // Check if op3 implementation is working.
        if (!(Decode.op3(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op3] FAILED. Method returned "
                                + Decode.op3(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op3] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "0111100";
        // Update correct original message String.
        correctOutput = "1100";
        // Check if op3 implementation is working.
        if (!(Decode.op3(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op3] FAILED. Method returned "
                                + Decode.op3(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op3] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "01111000";
        // Update correct original message String.
        correctOutput = "1100";
        // Check if op3 implementation is working.
        if (!(Decode.op3(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op3] FAILED. Method returned "
                                + Decode.op3(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op3] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "1010101";
        // Update correct original message String.
        correctOutput = "1101";
        // Check if op4 implementation is working.
        if (!(Decode.op4(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op4] FAILED. Method returned "
                                + Decode.op4(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op4] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

        // Update to test new encoded String.
        input = "111110G";
        // Update correct original message String.
        correctOutput = "110G";
        // Check if op4 implementation is working.
        if (!(Decode.op4(input).equals(correctOutput))) {
            // Will print to indicate failure. (Record in README.)
            System.out.println("[op4] FAILED. Method returned "
                                + Decode.op4(input)
                                + " but it should have returned "
                                + correctOutput 
                                + "."); 
        }
        else {
            // Will print to signify working implementation. 
            System.out.println("[op4] SUCCEEDED on input "
                                + input
                                + ", keep trying " 
                                + "until it fails on the input!");
        }

    }
} 
