package view;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;
import logic.HanoiLogic;

public class HanoiPanel extends JPanel {
    private HanoiLogic logic;
    private int selectedTower = -1;

    public HanoiPanel(HanoiLogic logic) {
        this.logic = logic;
        setBackground(new Color(0x283C4F));
    }

    public void setSelectedTower(int index) {
        this.selectedTower = index;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int towerWidth = width / 3;

        g2.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            int x = i * towerWidth + towerWidth / 2 - 5;
            g2.fillRect(x, 100, 10, height - 150);
            g2.fillRect(i * towerWidth + 20, height - 50, towerWidth - 40, 10);

            if (i == selectedTower) {
                g2.setColor(new Color(255, 200, 0, 100));
                g2.fillRect(i * towerWidth + 20, 50, towerWidth - 40, height - 100);
                g2.setColor(Color.BLACK);
            }
        }

        Stack<Integer>[] towers = logic.getTowers();
        for (int i = 0; i < 3; i++) {
            Stack<Integer> tower = towers[i];
            for (int j = 0; j < tower.size(); j++) {
                int diskSize = tower.get(j);
                int diskWidth = 30 + diskSize * 25;
                int x = i * towerWidth + towerWidth / 2 - diskWidth / 2;
                int y = height - 70 - j * 25;

                g2.setColor(getDiskColor(diskSize));
                g2.fillRoundRect(x, y, diskWidth, 20, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(x, y, diskWidth, 20, 10, 10);
            }
        }
    }

    private Color getDiskColor(int size) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.ORANGE};
        return colors[(size - 1) % colors.length];
    }
}