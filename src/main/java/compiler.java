import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class compiler {

    public List<String> readFile(String filename) {
        List<String> lines = new ArrayList<String>();
        String line = null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Unable to find " + filename + ".");
        } catch(IOException e) {
            System.out.println("Error reading file " + filename + ".");
        }
        return lines;
    }

    public List<String> lexer(String string) {
        List<String> lexicalSyntax = new ArrayList<String>();
        String symbol = "";
        for(int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if(symbol.equals("=")) {
                lexicalSyntax.add("BECOMES");
                symbol = "";
                continue;
            } else if(symbol.equals(">=")) {
                lexicalSyntax.add("GE");
                symbol = "";
                continue;
            } else if(symbol.equals("<=")) {
                lexicalSyntax.add("LE");
                symbol = "";
                continue;
            } else if(symbol.equals("!=")) {
                lexicalSyntax.add("NE");
                symbol = "";
                continue;
            } else if(symbol.equals("==")) {
                lexicalSyntax.add("EQ");
                symbol = "";
                continue;
            } else if(symbol.equals("wain")) {
                lexicalSyntax.add("WAIN");
                symbol = "";
                continue;
            } else if(symbol.equals("if")) {
                lexicalSyntax.add("IF");
                symbol = "";
                continue;
            } else if(symbol.equals("else")) {
                lexicalSyntax.add("ELSE");
                symbol = "";
                continue;
            } else if(symbol.equals("while")) {
                lexicalSyntax.add("WHILE");
                symbol = "";
                continue;
            } else if(symbol.equals("return")) {
                lexicalSyntax.add("RETURN");
                symbol = "";
                continue;
            } else if(symbol.equals("int")) {
                lexicalSyntax.add("INT");
                symbol = "";
                continue;
            } else {
                switch (character) {
                    case '(':
                        lexicalSyntax.add("LPAREN");
                        continue;
                    case ')':
                        lexicalSyntax.add("RPAREN");
                        continue;
                    case '{':
                        lexicalSyntax.add("LBRACE");
                        continue;
                    case '}':
                        lexicalSyntax.add("RBRACE");
                        continue;
                    case '+':
                        lexicalSyntax.add("PLUS");
                        continue;
                    case '-':
                        lexicalSyntax.add("MINUS");
                        continue;
                    case '*':
                        lexicalSyntax.add("STAR");
                        continue;
                    case '/':
                        lexicalSyntax.add("SLASH");
                        continue;
                    case '%':
                        lexicalSyntax.add("PCT");
                        continue;
                    case ',':
                        lexicalSyntax.add("COMMA");
                        continue;
                    case ';':
                        lexicalSyntax.add("SEMI");
                        continue;
                    case '[':
                        lexicalSyntax.add("LBRACK");
                        continue;
                    case ']':
                        lexicalSyntax.add("RBRACK");
                        continue;
                    case '&':
                        lexicalSyntax.add("AMP");
                        continue;
                    case '=':
                        symbol.concat(Character.toString(character));
                        continue;
                    case '<':
                        symbol.concat(Character.toString(character));
                        continue;
                    case '>':
                        symbol.concat(Character.toString(character));
                        continue;
                    case ' ':
                        lexicalSyntax.add("SPACE");
                        continue;
                    default:
                        symbol.concat(Character.toString(character));
                        continue;
                }

            }

        }
        return lexicalSyntax;
    }

    public int main() {
        String file = "practice.txt";
        List<String> code = this.readFile(file);

        for(int i = 0; i < code.size(); i++) {
            this.lexer(code.get(i));
        }
        return 0;
    }
}
