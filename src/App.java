import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        Enemy enemy = new Enemy();

        player.setStatus("Kurumi", 100, 5);
        player.setActionList("こうげき");
        enemy.setStatus("Slime", 100, 5);
        enemy.setActionList("こうげき");

        msgGameTitle();
        msgEncounter(enemy.getName());

        int select;
        while(true) {
            msgChoseAction();

            //Player turn
            select = player.selectAction();

            //End the game
            if(select == 0) {
                msgEndTheGame();
                sc.close();
                return;

            } else if(select == 1) {
                enemy.setHp(enemy.getHp() - player.attack());
                msgResponseEnemyHP(enemy.getName(), enemy.getHp());
            }

            //is Enemy die
            if(isDie(enemy.getName(), enemy.getHp(), player.getName())) {
                sc.close();
                return;
            }

            //Enemy turn
            select = enemy.selectAction();

            if(select == 0) {
                player.setHp(player.getHp() - enemy.attack());
                msgResponseEnemyHP(player.getName(), player.getHp());
            }

            //is Player die
            if(isDie(player.getName(), player.getHp(), enemy.getName())) {
                sc.close();
                return;
            }
        }
    }

    static boolean isDie(String loser, int hp, String winner) {
        if(hp == 0) {
            msgGameOver(loser, winner);
            return true;
        } else {
            return false;
        }
    }

    static void msgGameTitle() {
        System.out.println("------------------------------");
        System.out.println("ターン制バトルゲーム");
        System.out.println("------------------------------");
    }

    static void msgEncounter(String name) {
        System.out.println(name + "が現れた!!");
        System.out.println("------------------------------");
    }

    static void msgChoseAction() {
        System.out.println("コマンド入力中...");
        System.out.println("------------------------------");
        System.out.println("ゲームを閉じる:0 | こうげき:1");
        System.out.println("------------------------------");
    }

    static void msgEndTheGame() {
        System.out.println("------------------------------");
        System.out.println("ゲームを終了しました");
        System.out.println("------------------------------");
    }
    static void msgResponseEnemyHP(String name, int hp) {
        System.out.println(name + "の体力は" + hp);
        System.out.println("------------------------------");
    }
    static void msgGameOver(String loser, String winner) {
        System.out.println(loser + "は" + winner + "に負けてしまった!!");
        System.out.println("------------------------------");
    }
}
