# CreateDiamondFromAlphabet
Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.

For example: print-diamond ‘C’ prints

```
  A
 B B
C   C
 B B
  A
```
My code returns the diamond as an arraylist of strings representing each row of the diamond shape. 

The way the code works is:
1. Take the letter of the alphabet and validate that it is an upper case letter between A and Z
2. Calculate the amount of rows the diamond needs to consist of as well as how wide each row should be.
3. A string builder then contructs the string which will be used as the base for each row.
4. Looping through each row and letter starting at A we track and subsitute where each letter should be placed in each row.
5. finally we return out diamond arrayList where we can print each item line by line which will form our diamond
