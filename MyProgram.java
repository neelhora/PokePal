import java.util.*;
import java.io.*;

public class MyProgram
{
    public static void main(String[] args) throws IOException {
        
        //creating PokemonArray object and asking user which pokemon they would like to input.
        
        PokemonArray gen1 = new PokemonArray();
        Scanner sc = new Scanner(System.in);
        String cont = "yes";
        while(cont.equalsIgnoreCase("yes")){
            
            System.out.print("Which Pokemon would you like to find out about?: ");
            String pkmn = sc.nextLine();
            System.out.println();
            
        //calling methods from PokemonArray Class
            System.out.println(gen1.findBestMatchup(pkmn));
            System.out.println();
            gen1.printEffectivenessChart(pkmn);
            System.out.println();
            System.out.println(gen1.weightComparison(pkmn));
            System.out.println();
            System.out.println(gen1.heightComparison(pkmn));
            System.out.println();
            
            System.out.print("Continue?: ");
            cont = sc.nextLine();
            System.out.println();
            System.out.println();
            
        }
    }
}
