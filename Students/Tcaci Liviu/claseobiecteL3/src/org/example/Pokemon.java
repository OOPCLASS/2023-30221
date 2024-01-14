package org.example;
//remember one file one class: untold rule
//classes are blueprints for objects
public class Pokemon {

    //attributes or instance variables
    String name;
    String type;
    int health;
    int level;
    //constructor
    public Pokemon(){

    }

    void attak(){
        System.out.println("Pokemon " + name + " was attacked");
    }
    public Pokemon(String name, String type, int health, int level){
        this.name = name;
        this.type = type;
        this.health = health;
        this.level = level;
    }
    //methods
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
        System.out.println("Pokemon " + pokemon.name + " was attacked by " + this.name);
    }
    public void pokemonInfo(){
        System.out.println("\n");
        System.out.println("Pokemon name: " + this.name);
        System.out.println("Pokemon type: " + this.type);
        System.out.println("Pokemon health: " + this.health);
        System.out.println("Pokemon level: " + this.level);
    }
}
