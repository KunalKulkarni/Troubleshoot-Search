## To clean:
ant -buildfile troubleShootSearch/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile troubleShootSearch/src/build.xml all

-----------------------------------------------------------------------
## To run (for results) by specifying arguments from command line 

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=1

-----------------------------------------------------------------------

## To generate javadocs 

ant -buildfile troubleShootSearch/src/build.xml doc 

-----------------------------------------------------------------------

Implementation of Visitor Pattern:

The Visitor interface consists of a visit method called from the accept method in all Products(1-4).The product descriptions are taken from 4 separate files (One.txt-Four.txt).
The visitor algorithms work on these files and the userInput file taken from the command line. 
After the result/search is computed it is written to the output file. The Logger class works with following levels:

Level 0: No Output
Level 1: To print all results to StdOut
Level 2: Print all Constructors of the products.
Level 3: Print after file read for a product is successful.
Level 4: To print all visitor constructors after successful file read from a product.

Description Files for Products:
1. One.txt 2. Two.txt 3 Three.txt 4.Four.txt 5.synonyms.txt for Semantic Match

User Input File:
1. input.txt

Output File:
1. output.txt 
