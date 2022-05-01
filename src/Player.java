import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Player {
    Random rand = new Random();
    private ArrayList<String> actionList = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    private String name;
    private int hp;
    private int power;

    public void setStatus(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.actionList.add("ゲームを閉じる");
    }

    public void setActionList(String action) {
        this.actionList.add(action);
    }

    public int selectAction() {
        int res = sc.nextInt();
        return res;
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
