package shootingspaceship;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BattleScreenEx extends JPanel {
    private List<String> selectedUnits;

    public BattleScreenEx(List<String> selectedUnites) {
        this.selectedUnits = selectedUnites;

        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        //적
        String[] enemyUnits = {"Enemy Fighter", "Enemy Destroyer"};
        int enemyX = 200;
        for (String enemy : enemyUnits) {
            JLabel enemyLabel = new JLabel(enemy, SwingConstants.CENTER);
            enemyLabel.setFont(new Font("Arial", Font.BOLD, 16));
            enemyLabel.setForeground(Color.RED);
            enemyLabel.setBounds(enemyX, 100, 150, 30);
            add(enemyLabel);
            enemyX += 250;
        }

        //플레이어어
        int playerX = 200;
        for (String unit : selectedUnits) {
            JLabel unitLabel = new JLabel(unit, SwingConstants.CENTER);
            unitLabel.setFont(new Font("Arial", Font.BOLD, 16));
            unitLabel.setForeground(Color.CYAN);
            unitLabel.setBounds(playerX, 400, 150, 30);
            add(unitLabel);
            playerX += 250;
        }

        JButton nextTurButton = new JButton("다음 턴");
        nextTurButton.setBounds(600,500,150,40);
        add(nextTurButton);

        nextTurButton.addActionListener(e-> {

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Battle Screen Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        List<String> mockUnits = List.of("Assault Cruiser", "Medical Frigate");
        frame.setContentPane(new BattleScreenEx(mockUnits));
        frame.setVisible(true);
    }
}
