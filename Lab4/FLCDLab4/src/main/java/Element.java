public class Element {

    public String value;

    public Element right;

    public Element left;

    public Element(String value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Element getRight() {
        return right;
    }

    public void setRight(Element right) {
        this.right = right;
    }

    public Element getLeft() {
        return left;
    }

    public void setLeft(Element left) {
        this.left = left;
    }
}
