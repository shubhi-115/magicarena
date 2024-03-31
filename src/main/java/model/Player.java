package model;

import exception.AttackAttributeNotSetException;
import exception.HealthAttributeNotSetException;
import exception.NameAttributeNotSetException;
import exception.StrengthAttributeNotSetException;

public class Player {
    private int health;
    private int strength;
    private int attack;
    private String name;
    public Player(){

    }
    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }
    public static class Builder{
        private int health;
        private int strength;
        private int attack;
        private String name;
        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setAttack(int attack) {
            this.attack = attack;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Player build() throws
                HealthAttributeNotSetException,
                StrengthAttributeNotSetException,
                AttackAttributeNotSetException,
                NameAttributeNotSetException {
            Player player = new Player();
            player.attack = this.attack;
            player.health = this.health;
            player.strength = this.strength;
            player.name = this.name;
            return player;
        }
    }
}
