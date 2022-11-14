import java.util.ArrayList;

public class PIF {
    public ArrayList<Pair> data;

    public PIF(){
        this.data = new ArrayList<>();
    }

    public void add(String key, Integer pos){
        data.add(new Pair(key,pos));
    }

    public String toString(){
        StringBuilder value = new StringBuilder();
        for(Pair val : data){
            value.append(val.getValue()+ " " + val.getIndex()+"\n");
        }
        return value.toString();
    }
}
