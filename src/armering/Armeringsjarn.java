
package armering;

public class Armeringsjarn implements Comparable<Armeringsjarn>{
    
    private String diameter;
    private int length;
    private int id;
    
    public Armeringsjarn(int id, String diameter, int length){
        this.diameter = diameter;
        this.length = length;
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int newId){
        this.id = newId;
    }
    
    public String getDiameter(){
        return this.diameter;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void setDiameter(String newDiameter){
        this.diameter = newDiameter;
    }
    
    public void setLength(int newLength){
        this.length = newLength;
    }

    @Override
    public int compareTo(Armeringsjarn o) {
        return 1;
    }
}
