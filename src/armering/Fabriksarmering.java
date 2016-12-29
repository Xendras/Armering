package armering;

import java.util.ArrayList;

public class Fabriksarmering {

    private int id;
    private final int length = 6000;
    private String diameter;
    private ArrayList<Armeringsjarn> partition;

    public Fabriksarmering(int id, String diameter) {
        this.diameter = diameter;
        this.id = id;
        this.partition = new ArrayList<>();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getDiameter(){
        return this.diameter;
    }

    public ArrayList<Armeringsjarn> getPartition() {
        return this.partition;
    }

    public boolean addToPartition(Armeringsjarn jarn) {
        if (sizeOfPartition() + jarn.getLength() <= 6000) {
            this.partition.add(jarn);
            return true;
        }
        return false;
    }

    public int sizeOfPartition() {
        int sum = 0;
        for (Armeringsjarn jarn : this.partition) {
            sum += jarn.getLength();
        }
        return sum;
    }
}
