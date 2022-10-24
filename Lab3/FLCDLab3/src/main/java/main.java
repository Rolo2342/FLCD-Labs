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
        testAll();
//        BST b = new BST();
//        b.addElement("c");
//        b.addElement("b");
//        System.out.println(b.getRoot().getValue());
//        b.addElement("e");
//        b.addElement("d");
//        b.addElement("f");
//        System.out.println(b.getRoot().getLeft().getValue());
//        System.out.println(b.getRoot().getRight().getValue());
//        b.inorder();
//        System.out.println(" ");
//        b.deleteKey("e");
//        b.inorder();
//        System.out.println(b.search("e"));
    }
}
