import java.util.*;
import java.io.*;

public class PokemonArray {
    
    //intializing the array
    Pokemon[] pokemonArray = new Pokemon[151];
    
    public PokemonArray() throws IOException{
        
        //creating the file and a scanner to run through it
        File f = new File("pokemon.csv");
        Scanner scan = new Scanner(f);
        scan.nextLine();
        
        //loading all of the pokemon.csv file into the array using i
        int i = 0;
        while(scan.hasNextLine()){
            boolean defLarger = true;
            
            String line = scan.nextLine();
            String[] data = line.split(",");
            
            //deciding if the defense is larger than the special defense 
            //(in retrospect this should be done in the pokemon class
            //as the defense and SpDef are already defined there)
            if(Integer.parseInt(data[15])<Integer.parseInt(data[16])){
                
                defLarger = false;
                
            }
            
            Pokemon p = new Pokemon(Integer.parseInt(data[0].trim()), data[1].trim(), data[3].trim(), data[4].trim(),Double.parseDouble(data[5].trim()), Double.parseDouble(data[6].trim()), Integer.parseInt(data[12].trim()), Integer.parseInt(data[13].trim()), Integer.parseInt(data[14].trim()), Integer.parseInt(data[15].trim()), Integer.parseInt(data[16].trim()), Integer.parseInt(data[17].trim()), Double.parseDouble(data[18].trim()), Double.parseDouble(data[19].trim()), Double.parseDouble(data[20].trim()), Double.parseDouble(data[21].trim()), Double.parseDouble(data[22].trim()), Double.parseDouble(data[23].trim()), Double.parseDouble(data[24].trim()), Double.parseDouble(data[25].trim()),  Double.parseDouble(data[26].trim()), Double.parseDouble(data[27].trim()), Double.parseDouble(data[28].trim()), Double.parseDouble(data[29].trim()), Double.parseDouble(data[30].trim()), Double.parseDouble(data[31].trim()), Double.parseDouble(data[32].trim()), Integer.parseInt(data[33].trim()), Integer.parseInt(data[34].trim()), defLarger);
            pokemonArray[i] = p;
            i++;
        }
        
        
    }
    
    
    /*This method is "the complex" method of my project
    It's goal is to, after being given the name of a Pokemon,
    find that pokemon in the array, use it's typing to find 
    its greatest weakness. (Some pokemon are 4x weak if they are dual type)
    Then, find out if the pokemon has a weaker Defense stat or Special Defense
    stat. If it has a weaker Defense stat, find the strongest physical attacker,
    if it has a weaker Special Defense stat, find the strongest Special attacker.
    This gets difficult because often times pokemon are weak to more than just
    one type. So, I would have to compare pokemon across typings. Finally it
    needs to return the name of the pokemon that is most effective (typing + stats)*/
    public String findBestMatchup(String pokemonName){
        
        int index = -1;
        int targetIndex = -1;
        int targetAttackStatMax = 0;
        double targetEffectivenessMax = 4;
        
        //find the pokemon from the input string
        for (int i =0; i <151; i++){
            if (pokemonArray[i] != null && pokemonArray[i].Name.equalsIgnoreCase(pokemonName)){
                index = i;
            }
        }
        if (index == -1){
            return ("Sorry, could not find pokemon");
        }
        
        //if the pokemon has a 4x weakness find it here
        for (int i =0; i <151; i++){
            
            //looks to match up pokemon's dual typings versus the weaknesses of the input pokemon
            double targetEffectivess = pokemonArray[index].effectiveness.get(pokemonArray[i].Type1);
            double targetEffectivess2 = pokemonArray[index].effectiveness.get(pokemonArray[i].Type2);
            
            if(targetEffectivess == targetEffectivenessMax || targetEffectivess2 == targetEffectivenessMax){
                
                //checks to search for physical or special attackers
                if(pokemonArray[index].DefGreaterThanSpecial && pokemonArray[i].Special > targetAttackStatMax){
                    
                    targetIndex = i;
                    targetAttackStatMax = pokemonArray[i].Special;
                    
                } else if (!pokemonArray[index].DefGreaterThanSpecial && pokemonArray[i].Defense > targetAttackStatMax){
                    targetIndex = i;
                    targetAttackStatMax = pokemonArray[i].Defense;
                }
                
                
            }
        }
        
        if (targetIndex>-1){
             return pokemonArray[targetIndex].Name +" is the most favorable matchup against " + pokemonName+"! It is 4x effective...";
        } else {
            targetEffectivenessMax-=2;
        }
        
        //if there is no 4x weakness, makes targetEffectivenessMax 2 so find 2x weakness
        for (int i =0; i <151; i++){
            
            //looks to match up pokemon's dual typings versus the weaknesses of the input pokemon
            double targetEffectivess = pokemonArray[index].effectiveness.get(pokemonArray[i].Type1);
            double targetEffectivess2 = pokemonArray[index].effectiveness.get(pokemonArray[i].Type2);
            
            if(targetEffectivess == targetEffectivenessMax || targetEffectivess2 == targetEffectivenessMax){
                
                //checks to search for physical or special attackers
                if(pokemonArray[index].DefGreaterThanSpecial && pokemonArray[i].Special > targetAttackStatMax){
                    
                    targetIndex = i;
                    targetAttackStatMax = pokemonArray[i].Special;
                    
                } else if (!pokemonArray[index].DefGreaterThanSpecial && pokemonArray[i].Defense > targetAttackStatMax){
                    targetIndex = i;
                    targetAttackStatMax = pokemonArray[i].Defense;
                }
                
                
            }
        }
        
        return pokemonArray[targetIndex].Name +" is the most favorable matchup against " + pokemonName+"! It is 2x effective...";
        
       
    }
    
    public void printEffectivenessChart(String pokemonName){
        
        int index = -1;
        
        for (int i =0; i <151; i++){
            if (pokemonArray[i] != null && pokemonArray[i].Name.equalsIgnoreCase(pokemonName)){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("Sorry, could not find pokemon");
        } else {
            System.out.println(pokemonArray[index].effectiveness);
        }
    }
    
    public String weightComparison(String pokemonName){
        
        int index = -1;
        int comp = 1;
        
        for (int i =0; i <151; i++){
            if (pokemonArray[i] != null && pokemonArray[i].Name.equalsIgnoreCase(pokemonName)){
                index = i;
            }
        }
        if (index == -1){
            return ("Sorry, could not find pokemon");
        }
        
        for (int i = 0; i <151; i++){
            if (pokemonArray[index].Weight < pokemonArray[i].Weight){
                comp++;
            }
        }
        
        return pokemonName + " is ranked #" + comp + " in weight out of all 151 Generation 1 Pokemon";
        
        
    }
    
    public String heightComparison(String pokemonName){
        
        int index = -1;
        int comp = 1;
        
        for (int i =0; i <151; i++){
            if (pokemonArray[i] != null && pokemonArray[i].Name.equalsIgnoreCase(pokemonName)){
                index = i;
            }
        }
        if (index == -1){
            return ("Sorry, could not find pokemon");
        }
        
        for (int i = 0; i <151; i++){
            if (pokemonArray[index].Height < pokemonArray[i].Height){
                comp++;
            }
        }
        
        return pokemonName + " is ranked #" + comp + " in height out of all 151 Generation 1 Pokemon";
        
        
    }
    
}
