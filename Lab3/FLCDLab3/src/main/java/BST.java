public class BST {

    public Element root;


    public Element getRoot() {
        return root;
    }

    public void setRoot(Element root) {
        this.root = root;
    }


    /**
     * Adds an element to the search tree by comparing it to all the nodes
     *
     * @param value The string value of the new element
     */
    public void addElement(String value) throws Exception {
        if (this.root == null)
            this.root = new Element(value);
        else{
            Element currentElement = this.root;
            while(currentElement != null){
                if(currentElement.value.compareTo(value)>0){
                    if(currentElement.getLeft() == null) {
                        currentElement.setLeft(new Element(value));
                        break;
                    }
                    else
                        currentElement = currentElement.left;
                }
                else if(currentElement.value.compareTo(value)<0){
                    if(currentElement.getRight() == null) {
                        currentElement.setRight(new Element(value));
                        break;
                    }
                    else
                        currentElement = currentElement.right;
                }
                else{
                    throw new Exception("Element already exists!");
                }
            }
        }
    }


    /**
     * Searches for a given element by comparing it to every node and moving acordingly
     *
     * @param value The string value of the searched element
     * @return The element
     */
    public Element search(String value){
        Element currentElement = this.root;
        while(currentElement != null){
            if(currentElement.getValue().equals(value)){
                return currentElement;
            }
            else if(currentElement.getValue().compareTo(value)>0){
                if(currentElement.getLeft() == null) {

                    break;
                }
                else
                    currentElement = currentElement.left;
            }
            else if(currentElement.value.compareTo(value)<0){
                if(currentElement.getRight() == null) {
                    break;
                }
                else
                    currentElement = currentElement.right;
            }
        }
        return null;
    }

    /**
     * Starts the recursive method for deleting an element
     *
     * @param value The string value of the element that needs to be deleted
     */
    public void deleteKey(String value) {
        root = deleteRecursive(root, value);
    }

    /**
     *  Traverses the tree recursivelt until it finds the element that needs to be deleted
     *
     * @param currentElement
     * @param value The String value of the element to be deleted
     * @return
     */
    private Element deleteRecursive(Element currentElement, String value)  {
        if (currentElement == null)  return currentElement;
        if (currentElement.getValue().compareTo(value) > 0)
            currentElement.left = deleteRecursive(currentElement.left, value);
        else if (currentElement.getValue().compareTo(value) < 0)
            currentElement.right = deleteRecursive(currentElement.right, value);
        else  {
            if (currentElement.left == null)
                return currentElement.right;
            else if (currentElement.right == null)
                return currentElement.left;
            currentElement.setValue(minValue(currentElement.getRight()));
            currentElement.setRight(deleteRecursive(currentElement.right, currentElement.getValue()));
        }
        return currentElement;
    }


    /**
     * Finds the maximum value of the elements that are smaller then the element to be deleted
     *
     * @param root
     * @return
     */
    private String minValue(Element root)  {
        String minval = root.getValue();
        while (root.getLeft() != null)  {
            minval = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minval;
    }


    /**
     * Recursive traversal of the tree
     */
    void inorder() {
        inorder_Recursive(this.root);
    }

    /**
     *
     * @param root
     */
    void inorder_Recursive(Element root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.getValue() + " ");
            inorder_Recursive(root.right);
        }
    }


}
