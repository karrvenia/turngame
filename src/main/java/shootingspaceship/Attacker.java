package shootingspaceship;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Attacker extends Player {
    private int atkDmg;
    private int skillDmg;
    private boolean skillAvailable;
    protected Image attakerImage;
    protected Image skillImage;

    public Attacker(int x, int y, int min_x, int max_x, int atkDmg, int skillDmg) {
        super(x, y, min_x, max_x,2700);
        this.atkDmg = atkDmg;
        this.skillDmg = skillDmg;
        this.skillAvailable = true;
        attakerImage = new ImageIcon(getClass().getResource("/image/attaker1.png")).getImage();
        skillImage = new ImageIcon(getClass().getResource("/image/laser3.png")).getImage();
    }

    public int getAtkDmg() {
        return atkDmg;
    }

    public int getSkillDmg() {
        return skillDmg;
    }

    public boolean isSkillAvailable() {
        return skillAvailable;
    }

    @Override
    public PlayerShot generateShot() {
        return new PlayerShot(x_pos, y_pos, atkDmg);
    }

    // public SkillShot useSkillShot() {
    //     if(!skillAvailable) return null;
    //     skillAvailable = false;
        
    //     return new SkillShot(x_pos, y_pos, skillDmg, skillImage, target.getY());
    // }

    public SkillShot useSkillShot(Enemy target) {
        if(!skillAvailable || target ==null){
            return null;
        } 
        skillAvailable = false;
        
        target.takeDamage(skillDmg); //스킬데미지 적용용

        return new SkillShot(x_pos, y_pos, skillDmg, skillImage, target.getY());
    }

    public void resetSkill() {
        skillAvailable = true;
    }

    @Override
    public void drawPlayer(Graphics g) {
        g.drawImage(attakerImage, x_pos - attakerImage.getWidth(null)/2
        , y_pos, null); 
    }

    @Override
    public void takeTurn() {
        Enemy target = GameManager.getInstance().selectEnemy();
    }
    
}