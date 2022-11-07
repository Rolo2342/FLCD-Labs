import java.util.HashMap;
import java.util.Map;

public class PIF {
    public Map<String, Integer> data;

    public PIF(){
        this.data = new HashMap<>();
    }

    public void add(String key, Integer pos){
        data.put(key,pos);
    }

    public String toString(){
        StringBuilder value = new StringBuilder();
        for(Map.Entry<String,Integer> val : data.entrySet()){
            value.append(val.getKey()+ " " + val.getValue()+"\n");
        }
        return value.toString();
    }
}
