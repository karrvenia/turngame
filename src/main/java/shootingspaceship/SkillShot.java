package shootingspaceship;

import java.awt.Graphics;
import java.awt.Image;

public class SkillShot extends Shot {
    private int dmg;
    private Image skillImage;
    private int targetY;

    public SkillShot(int x, int y, int dmg, Image skillImage, int targetY) {
        super(x, y);
        this.dmg = dmg;

        this.skillImage = skillImage;
        this.targetY = targetY;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public void drawShot(Graphics g) {
        if (!alive) return;
                
        int width = skillImage.getWidth(null);
        int height = skillImage.getHeight(null);
        g.drawImage(skillImage, x_pos - width /2, y_pos - height, null); //x - w means it starts middle of image y-h means it semms like botom to top
    }

    @Override
    public void moveShot(int speed) {
        y_pos += speed * 2;
    }
}
