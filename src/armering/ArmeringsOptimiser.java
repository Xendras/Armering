
package armering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArmeringsOptimiser {

    public static void main(String[] args) throws FileNotFoundException {
        String armeringsList = "armeringtest.txt";
        File list = new File(armeringsList);
        Scanner reader = new Scanner(list);
        Optimiser optimiser = new Optimiser(reader);
        optimiser.cutOptimise();
        System.out.println(optimiser.getFabriksArmering().size()*6000);
        int sum = 0;
        for(Armeringsjarn jarn : optimiser.getArmering()){
            sum += jarn.getLength();
        }
        System.out.println(sum);
    }
    
}
