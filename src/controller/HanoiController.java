package controller;

import javax.swing.*;
import view.HanoiPanel;
import logic.HanoiLogic;

public class HanoiController {
    private HanoiLogic logic;
    private HanoiPanel panel;
    private int fromTower = -1;
    private int moves = 0;

    public HanoiController(HanoiLogic logic, HanoiPanel panel) {
        this.logic = logic;
        this.panel = panel;
    }

    public void handleTowerSelection(int towerIndex) {
        if (fromTower == -1) {
            if (!logic.getTowers()[towerIndex].isEmpty()) {
                fromTower = towerIndex;
                panel.setSelectedTower(fromTower);
            }
        } else {
            if (logic.moveDisk(fromTower, towerIndex)) {
                moves++;
                if (logic.isWin()) {
                    panel.repaint();
                    JOptionPane.showMessageDialog(panel, "You win! After " + moves + " moves.");
                    resetGame();
                }
            } else {
                if (fromTower != towerIndex) {
                    JOptionPane.showMessageDialog(panel, "Invalid move!");
                }
            }
            fromTower = -1;
            panel.setSelectedTower(-1);
        }
        panel.repaint();
    }

    public void resetGame() {
        logic.reset();
        fromTower = -1;
        moves = 0;
        panel.setSelectedTower(-1);
        panel.repaint();
    }
}
