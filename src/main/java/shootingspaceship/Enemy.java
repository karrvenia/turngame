/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingspaceship;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author wgpak
 */
public abstract class Enemy extends GameUnit {

    protected float x_pos;
    protected float y_pos;
    protected float delta_x;
    protected float delta_y;
    protected int max_x;
    protected int max_y;
    protected float delta_y_inc;
    protected final int collision_distance = 10;

    public Enemy(int x, int y, float delta_x, float delta_y, int max_x, int max_y, float delta_y_inc, Team team) {
        x_pos = x;
        y_pos = y;
        this.delta_x = delta_x;
        this.delta_y = delta_y;
        this.max_x = max_x;
        this.max_y = max_y;
        this.delta_y_inc = delta_y_inc;
        this.team = team;
    }

    public void move() {
        x_pos += delta_x;
        y_pos += delta_y;

        if (x_pos < 0) {
            x_pos = 0;
            delta_x = -delta_x;
        } else if (x_pos > max_x) {
            x_pos = max_x;
            delta_x = -delta_x;
        }
        if (y_pos > max_y) {
            y_pos = 0;
            delta_y += delta_y_inc;
        }
    }

    public boolean isCollidedWithShot(Shot[] shots) {
        for (Shot shot : shots) {
            if (shot == null) {
                continue;
            }
            if (-collision_distance <= (y_pos - shot.getY()) && (y_pos - shot.getY() <= collision_distance)) {
                if (-collision_distance <= (x_pos - shot.getX()) && (x_pos - shot.getX() <= collision_distance)) {
                    //collided.
                    shot.collided();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCollidedWithPlayer(Player player) {
        if (-collision_distance <= (y_pos - player.getY()) && (y_pos - player.getY() <= collision_distance)) {
            if (-collision_distance <= (x_pos - player.getX()) && (x_pos - player.getX() <= collision_distance)) {
                //collided.
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        int[] x_poly = {(int) x_pos, (int) x_pos - 10, (int) x_pos, (int) x_pos + 10};
        int[] y_poly = {(int) y_pos + 15, (int) y_pos, (int) y_pos + 10, (int) y_pos};
        g.fillPolygon(x_poly, y_poly, 4);
    }
}
