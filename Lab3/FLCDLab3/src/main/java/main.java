public class main {
    public static void main(String args[]){
        BST b = new BST();
        b.addElement("c");
        b.addElement("b");
        System.out.println(b.getRoot().getValue());
        b.addElement("e");
        b.addElement("d");
        b.addElement("f");
        System.out.println(b.getRoot().getLeft().getValue());
        System.out.println(b.getRoot().getRight().getValue());
        b.inorder();
        System.out.println(" ");
        b.deleteKey("e");
        b.inorder();
//        System.out.println(b.search("e"));
    }
}
