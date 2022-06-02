### Simple Lexical Analyzer Features

The task in this project is to write a simplified lexical analyzer that extracts lexemes from an input source code written in Java and determines their tokens as specified below. The first column of the following table shows the set of lexemes you need to recognize while the right shows their tokens.

Program also check for errors. Error types that could exist:
- Unknown operator: This occurs when an operator other than the ones given in
the table is scanned. For example, !, @, #, $, % are all unknown operators.
- Unknown identifier: This occurs when an identifier consisting of more than a
single char exists in the input. For example, ab, ab1, xyz, while, do are
unknown identifiers.

------------

### Table
                    
Lexeme | Token
------------- | -------------
`for` | FOR_STATEMENT
`(` | LPARANT
`)` | RPARANT
`int` | INT_TYPE
`char` | CHAR_TYPE
`=` | ASSIGNM
`;` | SEMICOLON
`>` | GREATER
`<` | LESS
`>=` | GRE_EQ
`<=` | LESS_EQ
`{` | LCURLYB
`}` | RCURLYB
`return` | RETURN_STMT
`-` | SUBT
`/` | DIV
`*` | MULT
`+` | ADD
`identifier` | An identifier consists of a single letter
`integer` | constant INT_LIT

------------


### Sample Run:

The code will take input and output files from the console as given in the following example where the source code, input and output files are named simpleLexicalAnalyzer.java, input.txt, and output.txt, respectively:

	java SimpleLexicalAnalyzer.java   input.txt   output.txt



### Example:
Sample `input`  file and the `output` of the lexical analyzer :

`INPUT`

    for (int i = 0; i < 10; i=i+1)
	{
		a = f;
		char c;
	}
	return 0;

`OUTPUT`

	Next token is FOR_STATEMENT Next lexeme is for
	Next token is LPARANT Next lexeme is (
	Next token is INT_TYPE Next lexeme is int
	Next token is identifier Next lexeme is i
	Next token is ASSIGNM Next lexeme is =
	Next token is INT_LIT Next lexeme is 0
	Next token is SEMICOLON Next lexeme is ;
	Next token is identifier Next lexeme is i
	Next token is LESS Next lexeme is <
	Next token is INT_LIT Next lexeme is 10
	Next token is SEMICOLON Next lexeme is ;
	Next token is identifier Next lexeme is i
	Next token is ASSIGNM Next lexeme is =
	Next token is identifier Next lexeme is i
	Next token is ADD Next lexeme is +
	Next token is INT_LIT Next lexeme is 1
	Next token is RPARANT Next lexeme is )
	Next token is LCURLYB Next lexeme is {
	Next token is identifier Next lexeme is a
	Next token is ASSIGNM Next lexeme is =
	Next token is identifier Next lexeme is f
	Next token is SEMICOLON Next lexeme is ;
	Next token is CHAR_TYPE Next lexeme is char
	Next token is identifier Next lexeme is c
	Next token is SEMICOLON Next lexeme is ;
	Next token is RCURLYB Next lexeme is }
	Next token is RETURN_STMT Next lexeme is return
	Next token is INT_LIT Next lexeme is 0
	Next token is SEMICOLON Next lexeme is ;
