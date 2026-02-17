import java.util.*;

public class Pokemon {
    
    //the reason these varibales do not follow camelCase 
    //is because i just copy pasted them from the csv file 
    //to save time. That is also the same reason why they are public
    //in the grand scheme of things... you don't need setter methods
    //because you cannot go back in time to 1996 and change the gen1 data
    //and getter methods would have taken a lot of time to indivually implement. Instead, to focus on
    //creating my methods I've elected saving time here.
    public int Num;
    public String Name;
    public String Type1;
    public String Type2;
    
    public double Height;
    public double Weight;
    
    public int Base_Total;
    public int HP; 
    public int Attack; 
    public int Defense; 
    public int Special; 
    public int Speed; 
    
    //originally i had seperate variables for each type and the damage that
    //they did to the pokemon, but I looked for a better solution and found
    //this Map class within java.util
    public Map<String, Double> effectiveness;
 
    public int Evolutions; 
    public boolean Legendary;
    
    //this variable is used to determine if the selected pokemon
    //(the one which is the best matchup) should be a primarily
    //physcial or special attacker to maximize damage
    public boolean DefGreaterThanSpecial;
    
    public Pokemon(int Num,	String Name, String Type1, String Type2, double Height, double Weight, int Base_Total, int	HP, int Attack, int	Defense, int Special, int Speed, double Normal_Dmg, double Fire_Dmg, double Water_Dmg, double Eletric_Dmg, double Grass_Dmg, double Ice_Dmg, double Fight_Dmg, double Poison_Dmg, double Ground_Dmg, double Flying_Dmg, double Psychic_Dmg, double Bug_Dmg, double Rock_Dmg, double Ghost_Dmg, double Dragon_Dmg, int Evolutions, int Legendary, boolean DefGreaterThanSpecial){
        
        this.Num = Num;
        this.Name = Name;
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.Height = Height;
        this.Weight = Weight;
        
        this.Base_Total = Base_Total;
        this.HP = HP;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Special = Special;
        this.Speed = Speed;
        
        //creating the hashmap for each pokemon's type
        //I was actually stuck here for a while, when I had 15 different
        //type variables for each pokemon, and that system would have worked 
        //until I realized there can be more than 1 super effective type
        //on a singular pokemon, and hence choosing only one of the super 
        //effective types to compare base stats is not very useful.
        String[] types = {"normal", "fire", "water", "electric", "grass", "ice", "fighting", "poison", "ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "None"};
        double[] typeDamage = {Normal_Dmg, Fire_Dmg, Water_Dmg, Eletric_Dmg, Grass_Dmg, Ice_Dmg, Fight_Dmg, Poison_Dmg, Ground_Dmg, Flying_Dmg, Psychic_Dmg, Bug_Dmg, Rock_Dmg, Ghost_Dmg, Dragon_Dmg, 0};
        effectiveness = new HashMap<>();
        for(int i =0; i<types.length; i++){
            effectiveness.put(types[i],typeDamage[i]);
        }
        
        this.Evolutions = Evolutions;
        //making legendary boolean
        if(Legendary == 1){
            this.Legendary = true;
        } else{
            this.Legendary = false;
        }
        
        this.DefGreaterThanSpecial = DefGreaterThanSpecial;
        
    }
    
    
}
