public class SymbolTable {
    private BST identifiers;
    private BST constants;

    public BST getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(BST identifiers) {
        this.identifiers = identifiers;
    }

    public BST getConstants() {
        return constants;
    }

    public void setConstants(BST constants) {
        this.constants = constants;
    }
}
