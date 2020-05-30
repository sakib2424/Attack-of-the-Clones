# Attack of the Clones
Supreme Chancellor Palpatine wants to create more clones for his army to fight the Jedi Order. He has a proposed DNA sequence, but his clone production machinery has been scrambled and he has been left with a sequence of DNA strands where some subsequence of these strands can (hopefully) be stitched together (i.e., concatenated) to form the proposed DNA sequence.

Supreme Chancellor Palpatine has tasked his underlings to find the most efficient way to stitch together a subsequence of the scrambled DNA strands in order to recover the proposed DNA sequence.

## Input Format
Supreme Chancellor Palpatine has provided you with the proposed DNA sequence as well as a sequence of DNA strands.

The first line contains a target string (i.e., proposed DNA sequence) .

The next line specifices a number of tiles (i.e., DNA strands) .

The final  lines contain the tiles .

NOTE: The tiles are 1-indexed, meaning that (as above) we denote the first tile as  (with the subscript indicating index 1).

## Constraints

You may assume that , , 

To avoid time-outs, your algorithm should run in time . In addition, in Java, you should use the built-in method , and in Python, you should use the built-in method .

To avoid running out of space, in addition to the string  and an array of strings storing the tiles , the main data structure you should use is a 2-dimensional array of size , where each entry is an .

## Output Format
If there is no subsequence of tiles that covers , output "0" and nothing else.

Otherwise, output the size  of a shortest subsequence of tiles, , where , that covers , i.e. , followed by the indices of the  tiles:


Here, a shortest subsequence means one with the least number of tiles. There may be more than one shortest subsequence of tiles that covers . Your program should just output one such subsequence.

NOTE: Again, the tiles are 1-indexed, so, for example if  is the index of the first of the  tiles, .
