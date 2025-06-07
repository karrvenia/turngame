package shootingspaceship;

import javax.management.timer.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;

public class GamePanel extends JPanel implements ActionListener {
    private GameManager gameManager;
    private KeyInputManager keyInputManager;

    private Timer timer;
    
    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();

        gameManager = new GameManager();

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0,0, getWidth(), getHeight());

        for (Player p : gameManager.getPlayers()) {
            p.drawPlayer(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameManager.update();
        repaint(); //화면 갱신
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 키 처리
    }

    @Override 
    public void keyReleased(KeyEvent e) {}
    @Override 
    public void keyTyped(KeyEvent e) {}
}


