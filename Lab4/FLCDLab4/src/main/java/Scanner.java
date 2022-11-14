import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Scanner {

    private ArrayList<String> operators;
    private ArrayList<String> separators;
    private ArrayList<String> reservedWords;
    private ArrayList<String> reservedTokens;

    public Scanner(){
        operators = new ArrayList<>();
        operators.addAll(Arrays.asList("+", "-", "*", "/", ">", "<", ":=", "<=", ">=", "==", "!=", "%"));
        separators = new ArrayList<>();
        separators.addAll(Arrays.asList("[", "]", "{", "}", ";", ":", "(", ")", "'", "\""));
        reservedWords = new ArrayList<>();
        reservedWords.addAll(Arrays.asList("START", "VARIABLES", "key", "value", "signedint", "int", "boolean", "string", "char", "pair", "ARRAY", "OF", "BEGIN", "END", "READ", "WRITE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE"));
        reservedTokens = new ArrayList<>();
        reservedTokens = getTokens();
    }

    private ArrayList<String> getTokens() {
        BufferedReader reader;
        ArrayList<String> tokens = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\valiv\\IdeaProjects\\FLCDLab3\\src\\main\\data\\token.in"));
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                // read next line
                line = reader.readLine();
                tokens.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    private boolean needsLookAhead(String token){
        String[] elements = {">", "<", "=", "!"};
        for (String s : elements) {
            if (token.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isReservedToken(String token){
        return (reservedWords.contains(token) || operators.contains(token) || separators.contains(token));
    }

    private boolean isNrConst(String token){
        return Pattern.compile("[-+]?[1-9][0,9]+|0|[0-9]*")
                .matcher(token)
                .find();
    }

    private boolean isStringConst(String token){
        return Pattern.compile("\"[a-zA-Z0-9:;?!.]+\"")
                .matcher(token)
                .find();
    }

    private boolean isIdentifierConst(String token){
        return Pattern.compile("^[a-zA-Z][a-zA-Z\\d]*")
                .matcher(token)
                .find();
    }

    public void setVariablesPIF(BST symbolTable, ArrayList<String> pif){
        Integer position = 0;
        for (String value:symbolTable.getInorder()) {
            pif.add(value);
            position++;
        }
    }

    public void scan() throws IOException {
        BST symbolTable = new BST();
        PIF programInternalForm = new PIF();
        Integer position = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\valiv\\OneDrive\\Documents\\GitHub\\FLCD-Labs\\Lab4\\FLCDLab4\\src\\main\\data\\p3.txt"));
            String line;
            ArrayList<String> tokens = new ArrayList<>();
            while((line = br.readLine())!= null){
                tokens.addAll(List.of(line.split(" ")));
            }
            br.close();
            tokens.removeAll(Collections.singleton(""));

//            System.out.println(tokens);4
            for (String token: tokens) {
//                System.out.println(token);
                if(isReservedToken(token))
                    programInternalForm.add(token, 0);
                else if(isNrConst(token) || isIdentifierConst(token) || isStringConst(token)){
                    try {
                        if(symbolTable.search(token) == null)
                            symbolTable.addElement(token);
                        programInternalForm.add(token, -1);
                        position++;
                    }
                    catch (Exception e){
                        continue;
                    }
                }
                else
                    throw new Exception("Lexical error on token " + token);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> pif = new ArrayList<>();
        setVariablesPIF(symbolTable, pif); //inorder and number
        for(Pair pair : programInternalForm.data){
            if(!isReservedToken(pair.getValue()) && isIdentifierConst(pair.getValue())){
                pair.setIndex(pif.indexOf(pair.getValue()));
            }
        }
        BufferedWriter writePif = new BufferedWriter(new FileWriter("pif.out"));
        writePif.write(programInternalForm.toString());

        writePif.close();

        symbolTable.inorder();
    }
}
