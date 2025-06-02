package shootingspaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AttackerTest extends JPanel implements ActionListener, KeyListener {

    private Attacker attacker;
    private Timer timer;
    private List<Shot> shots;
    private Image skillImage;

    public AttackerTest() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        // 스킬 이미지 로딩
        skillImage = new ImageIcon(getClass().getResource("/image/laser.png")).getImage();

        attacker = new Attacker(400, 500, 0, 780, 10, 50);
        attacker.skillImage = skillImage; // 외부에서 설정

        shots = new ArrayList<>();
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        attacker.drawPlayer(g);

        for (Shot shot : shots) {
            shot.drawShot(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 샷 이동 처리
        for (Shot shot : shots) {
            shot.moveShot(-5);  // 위로 이동
        }

        // 화면 갱신
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            attacker.moveX(-10);
        } else if (key == KeyEvent.VK_RIGHT) {
            attacker.moveX(10);
        } else if (key == KeyEvent.VK_SPACE) {
            shots.add(attacker.generateShot());
        } else if (key == KeyEvent.VK_S) {
            Shot skill = attacker.useSkillShot();
            if (skill != null) {
                shots.add(skill);
            }
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Attacker Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AttackerTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}      
