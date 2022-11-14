import java.io.IOException;
import java.util.Objects;

public class main {

    public static void testCreate(){
        SymbolTable symbolTable = new SymbolTable();
        assert Objects.equals(symbolTable.getConstants(), new BST());
        assert Objects.equals(symbolTable.getIdentifiers(), new BST());
    }

    public static void testAdd(){
        SymbolTable symbolTable = new SymbolTable();
        try {
            symbolTable.getConstants().addElement("g");
            symbolTable.getConstants().addElement("a");
            symbolTable.getConstants().addElement("l");
        } catch (Exception e) {
            assert false;
        }

        assert Objects.equals(symbolTable.getConstants().search("a").getValue(), "a");
        assert Objects.equals(symbolTable.getConstants().search("a").getValue(), "g");
        assert Objects.equals(symbolTable.getConstants().search("a").getValue(), "l");

        try {
            symbolTable.getConstants().addElement("g");
            assert false;
        }
        catch (Exception e){
            assert true;
        }

    }

    public static void testRemove(){
        SymbolTable symbolTable = new SymbolTable();
        try {
            symbolTable.getConstants().addElement("g");
            symbolTable.getConstants().addElement("a");
            symbolTable.getConstants().addElement("l");
        } catch (Exception e) {
            assert false;
        }

        symbolTable.getConstants().deleteKey("a");

        assert Objects.equals(symbolTable.getConstants().search("a"), null);
    }

    public static void testSearch(){
        SymbolTable symbolTable = new SymbolTable();
        try {
            symbolTable.getConstants().addElement("g");
            symbolTable.getConstants().addElement("a");
            symbolTable.getConstants().addElement("l");
        } catch (Exception e) {
            assert false;
        }

    }

    public static void testAll(){
        testCreate();
        testAdd();
        testRemove();
        testSearch();
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner();
        try {
            scanner.scan();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
