package armering;

import java.util.ArrayList;
import java.util.Scanner;

public class Optimiser {

    private ArrayList<Armeringsjarn> armeringsList;
    private ArrayList<Fabriksarmering> fabriksArmeringsList;
    private Scanner reader;

    public Optimiser(Scanner reader) {
        this.fabriksArmeringsList = new ArrayList<>();
        this.reader = reader;
        this.armeringsList = processList();
    }
    
    public ArrayList<Fabriksarmering> getFabriksArmering(){
        return this.fabriksArmeringsList;
    }
    
    public ArrayList<Armeringsjarn> getArmering(){
        return this.armeringsList;
    }
    

    public ArrayList<Armeringsjarn> processList() {
        ArrayList<Armeringsjarn> list = new ArrayList<>();
        while (reader.hasNextLine()) {
            String jarn = reader.nextLine();
            String[] jarnProperties = jarn.split(";");
            for (int i = 0; i < Integer.parseInt(jarnProperties[1]); i++) {
                Armeringsjarn newJarn = new Armeringsjarn(Integer.parseInt(jarnProperties[0]), jarnProperties[2], Integer.parseInt(jarnProperties[3]));
                list.add(newJarn);
            }
        }
        return list;
    }

    public void cutOptimise() {
        int id = 1;
        int listPosition = 0;
        Fabriksarmering armering = new Fabriksarmering(id, armeringsList.get(listPosition).getDiameter());
        fabriksArmeringsList.add(armering);
        armering.addToPartition(armeringsList.get(listPosition));
        listPosition++;
        while (listPosition < armeringsList.size()) {
            if (armering.addToPartition(armeringsList.get(listPosition))) {
                listPosition++;
                continue;
            }
            id++;
            armering = new Fabriksarmering(id, armeringsList.get(listPosition).getDiameter());
            fabriksArmeringsList.add(armering);
            armering.addToPartition(armeringsList.get(listPosition));
            listPosition++;

        }
    }
}
