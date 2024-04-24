# Java Practice

Some Java practice involving the encoding, decoding, and manipulation
of Hamming codewords, plus some other exercises.

- **Name:** E.J. Yu
- **Date:** April 5, 2019

## Why It's Important to Style Your Code

1. It is important to write comments for your code because
   it will allow others who look at your code to understand
   what is going on without having to spend an extensive amount
   of time understanding your logic first. But you shouldn't
   want to be too descriptive either because long comments (and
   also having TOO MANY comments) will reduce readability too.

2. In that code block, the in-line comment is okay, but is arguably
   not the most ideal comment because single-line comments are better
   particularly for the readability aspects of providing in-line
   comments.

   I guess it's alright too because the in-line comment provided
   is not redundant whatsoever. But the programmer could've just
   written something like:

   `// Initialize i to 0, and increment until the array length.`

   I think that would've been an ideal single-line in-line comment.

## Testing hammingDecode

op1: Method returns original String and doesn't actually decode 
     anything.

op2: Method returns bits 3, 4, 6, and 7,
     and not bits 3, 5, 6, and 7.

op3: Method does not check if the length of the string is 7.

op4: Method does not return null if letters are passed in.
     In fact, it doesn't even seem  to check for
     1 and 0 characters only...

## StringBuilder vs. Strings

1. *Running the script. Real runtimes are below.*

         Trial 1
         randomLowercaseString: 0m0.478s
         randomLowercaseStringII: 0m0.262s

         Trial 2
         randomLowercaseString: 0m0.413s
         randomLowercaseStringII:0m0.297s

         Trial 3
         randomLowercaseString: 0m0.480s
         randomLowercaseStringII:0m0.173s

2. StringBuilder is an efficient way of building string because
   when you build strings by concatenating strings together,
   the string has to be copied every single time you want to
   add something to it. StringBuilder doesn't do that, so it
   doesn't take as long to make strings.

3. I think it takes about the same amount of time and effort
   to make a string with StringBuilder compared to making
   a String by simply building them with the + operator.
   So with that in mind, I think it's better to use StringBuilder
   for tasks like these because it makes your code run
   much more efficiently.

## Summary

1. Writing the `hammingDecode()` testers helped me ensure that
   my implementations are correct. I'd think of edge cases,
   write some code, and then test it in `HammingTester.java`,
   and doing that helped me debug (for ALL cases, not just
   edge cases) as well!

2. Hamming Code is a concept describing numeric codewords
   consisting of ONLY 1's and 0's.
   They have a specific make up too: the
   first, second, and fourth characters in the codeword
   are essentially failsafes, and the other characters
   (in places three, five, six, and seven) are actually
   the characters that make up the message itself; however,
   the nice thing about Hamming Code is that if there is
   a one-bit error, the corrupted codeword may be fixed, 
   and this is done with a special yet simple algorithm.