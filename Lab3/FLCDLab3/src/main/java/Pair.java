public class Pair {
    String value;
    Integer index;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Pair(String value, Integer index) {
        this.value = value;
        this.index = index;
    }
}
