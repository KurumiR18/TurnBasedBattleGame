import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private Random rand = new Random();
    private ArrayList<String> actionList = new ArrayList<String>();

    private String name;
    private int hp;
    private int power;

    public void setStatus(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void setActionList(String action) {
        this.actionList.add(action);
    }

    public int selectAction() {
        return rand.nextInt(1);
    }

    public int attack() {
        int damage = power + rand.nextInt(3);
        return damage;
    }

    public void setHp(int hp) {
        if(hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getPower() {
        return this.power;
    }
}
