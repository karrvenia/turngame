package shootingspaceship;

import javax.swing.*;
import java.awt.*;

public class EnemyAttack {
    Image image = new ImageIcon("/image/laser.png").getImage();
    int x,y;
    private int width = image.getWidth(null);
    private int height = image.getHeight(null);
    private int attack = 5;
    static int enemyType;

    public EnemyAttack(int x, int y) {
        this.x = x;
        this.y = y;

        // if (enemyType == 1) {
        //     image = new ImageIcon("이미지링크");
        // } 
        // else  {
        //     image = new ImageIcon("이미지링크");
        // }

        image = new ImageIcon(getClass().getResource("/image/enemyattack.png")).getImage();

    }

    public void fire() {
            this.y -= 12; //y축 나중에 꼭 확인
        }
}
