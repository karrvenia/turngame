package shootingspaceship;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Defenser extends Player {
    private int atkDmg;
    public static final float sharedDmg = 0.7f;
    private boolean isSkilled;

    protected Image defenserImage; 
    protected Image skillImage;

    public Defenser(int x, int y, int min_x, int max_x, int atkDmg) {
        super(x, y, min_x, max_x,5000);
        this.atkDmg = atkDmg;
        defenserImage = new ImageIcon(getClass().getResource("/image/defenser.png")).getImage();
        skillImage = new ImageIcon(getClass().getResource("/image/tankerskill.png")).getImage();
    }

    public int getAtkDmg() {
        return atkDmg;
    }

    public void activeSkill() {
        isSkilled = true;
    }

    public boolean isSkilled() {
        return isSkilled;
    }

    public float getSharedDmg() {
        return sharedDmg;
    }

    @Override
    public PlayerShot generateShot() {
        return new PlayerShot(x_pos, y_pos, atkDmg);
    }

    public void sacrificialGuard (Player someone, int incomDmg) {
        if(!isSkilled) return;
        isSkilled = false;

        int dmgToDefenser = Math.round(incomDmg*sharedDmg); //탱커가 대신맞는 dmg
        int dmgToSomeone = incomDmg - dmgToDefenser;

        this.setHp(this.getHp() - dmgToDefenser); //탱커가 맞는 데미지
        someone.setHp(someone.getHp() - dmgToSomeone); //딜러가 맞는 데미지지

    }
}
