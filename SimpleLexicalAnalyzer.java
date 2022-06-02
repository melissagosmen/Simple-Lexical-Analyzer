import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleLexicalAnalyzer {

    public Queue lexemeList = new LinkedList<String>();

    public static void main(String [] args){

        SimpleLexicalAnalyzer sla = new SimpleLexicalAnalyzer();
        ArrayList<String> lines = sla.readFile(args[0]);
        for(int i = 0 ; i < lines.size() ; i++)
            sla.findLexemes(lines.get(i));

        try{
            FileWriter fw = new FileWriter(args[1]);

            for(Object s : sla.lexemeList) {
                String token = sla.token(s.toString());
                fw.write("Next token is " + token);
                for(int space = 0 ; space<= 20 - token.length() ; space++){
                    fw.write(" ");
                }
                fw.write("Next lexeme is " + s.toString() + "\n");
                if(token.equals("Unknown identifier") || token.equals("Unknown operator")){
                    break;
                }
            }

            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String token (String lexeme){
        switch (lexeme) {
            case "for":
                return "FOR_STATEMENT";
            case "(":
                return "LPARANT";
            case ")":
                return "RPARANT";
            case "int":
                return "INT_TYPE";
            case "char":
                return "CHAR_TYPE";
            case "=":
                return "ASSIGNM";
            case ";":
                return "SEMICOLON";
            case ">":
                return "GREATER";
            case "<":
                return "LESS";
            case ">=":
                return "GRE_EQ";
            case "<=":
                return "LESS_EQ";
            case "{":
                return "LCURLYB";
            case "}":
                return "RCURLYB";
            case "return":
                return "RETURN_STMT";
            case "-":
                return "SUBT";
            case "/":
                return "DIV";
            case "*":
                return "MULT";
            case "+":
                return "ADD";
            default:
                try {
                    Integer.parseInt(lexeme);
                    return "INT_LIT";
                } catch (NumberFormatException e) {
                    if(lexeme.length() == 1){
                        if((lexeme.charAt(0) >= 'a' && lexeme.charAt(0) <= 'z' ) || (lexeme.charAt(0) >= 'A' && lexeme.charAt(0) <= 'Z'))
                            return "identifier";
                        else{
                            return "Unknown operator";
                        }
                    }
                }
                return "Unknown identifier";
        }
    }

    public ArrayList<String> readFile(String fileName){
        ArrayList<String> lines = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }


    //ASCII code 48-57  65-90  97-122

    public void findLexemes(String line){
        String lexeme = "";
        if(line.length() != 0){
            for(int i = 0 ; i < line.length() ; i++){

                int charAtI = line.charAt(i);
                if(charAtI == '\t'){
                  findLexemes(line.substring(i+1));
                  break;
                }
                else if(charAtI == ' '){
                    if(lexeme.length() != 0){
                        lexemeList.add(lexeme);
                    }
                    findLexemes(line.substring(i+1));
                    break;
                }
                else if(charAtI == '(' || charAtI == ')' || charAtI == '=' || charAtI == ';'  || charAtI == '{' || charAtI == '}' || charAtI == '-' || charAtI == '/' || charAtI == '*' || charAtI == '+'){
                    if(lexeme != ""){
                        lexemeList.add(lexeme);
                    }
                    lexeme = "";
                    lexeme = lexeme + line.charAt(i);
                    lexemeList.add(lexeme);
                    findLexemes(line.substring(i+1));
                    break;
                }
                else if( charAtI == '<' || charAtI == '>'){ //???
                    if(line.charAt(i+1) == '='){
                        lexeme = lexeme + line.charAt(i) + line.charAt(i+1) ;
                        lexemeList.add(lexeme);
                        findLexemes(line.substring(i+2));
                        break;
                    }
                    else{
                        lexeme = lexeme + line.charAt(i);
                        lexemeList.add(lexeme);
                        findLexemes(line.substring(i+1));
                        break;
                    }

                }
                else if((charAtI >= 'a' && charAtI <= 'z' ) || (charAtI >= 'A' && charAtI <= 'Z') || (charAtI >= '0' && charAtI <= '9')){
                    lexeme = lexeme + line.charAt(i);
                }
                else{
                    lexeme = lexeme + line.charAt(i);
                    lexemeList.add(lexeme);
                    findLexemes(line.substring(i+1));
                    break;
                }
            }
        }
    }
}
