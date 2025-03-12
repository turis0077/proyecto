package com.univalle.pokemon;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String ability;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int generation;
    private boolean legendary;

    public Pokemon(String name, String type1, String type2, String ability, int total, int hp,
                   int attack, int defense, int spAttack, int spDefense, int speed, int generation, boolean legendary) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getAbility() {
        return ability;
    }

    public int getTotal() {
        return total;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", ability='" + ability + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", spAttack=" + spAttack +
                ", spDefense=" + spDefense +
                ", speed=" + speed +
                ", generation=" + generation +
                ", legendary=" + legendary +
                '}';
    }
}
