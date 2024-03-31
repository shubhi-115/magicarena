package model;

import exception.HealthAttributeNotSetException;
import strategies.GetPointStrategy.AttackStrategy;
import strategies.GetPointStrategy.DefendStrategy;
import strategies.GetPointStrategy.PointStrategy;

public class Player {
    private int health;
    private int strength;
    private int attack;
    private Dice dice;
    private PointStrategy attackStrategy;
    private PointStrategy defendStrategy;
    private PlayerStatus playerStatus;
    private String name;

    private Player() {

    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackPoints() {
        return attackStrategy.getPoint(this, dice);
    }

    public int getDefendPoints() {
        return defendStrategy.getPoint(this, dice);
    }

    protected void setHealth(int health) {
        this.health = health;
    }
    protected void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public static Builder create() {
        return new Builder();
    }
    public static class Builder {
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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Player build() throws HealthAttributeNotSetException {
            if(this.health == 0) {
                throw new HealthAttributeNotSetException("Health attribute not set");
            }

            // 3 more excetpion

            Player player = new Player();
            player.attack = this.attack;
            player.health = this.health;
            player.strength = this.strength;
            player.name = this.name;
            player.dice = new Dice();
            player.attackStrategy = new AttackStrategy();
            player.defendStrategy = new DefendStrategy();
            return player;
        }
    }
}
