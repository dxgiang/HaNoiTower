import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.HanoiController;
import logic.HanoiLogic;
import view.HanoiPanel;
import view.ButtonCustom;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hanoi Tower");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLayout(new BorderLayout());
            frame.setUndecorated(true);

            HanoiLogic logic = new HanoiLogic(5);
            HanoiPanel gamePanel = new HanoiPanel(logic);
            HanoiController controller = new HanoiController(logic, gamePanel);

            JPanel panelBar = new JPanel();
            panelBar.setBackground(new Color(0x283C4F));
            panelBar.setLayout(new BorderLayout());
            JPanel panelTitle = new JPanel();
            panelTitle.setBackground(new Color(0x283C4F));
            panelTitle.setOpaque(false);
            JLabel title = new JLabel("  Guess Pin Code");
            title.setBackground(new Color(0x283C4F));
            title.setForeground(Color.WHITE);
            title.setFont(title.getFont().deriveFont(12f));
            panelTitle.add(title);
            panelBar.add(panelTitle, BorderLayout.WEST);
            JPanel panelExitandMinimize = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            panelExitandMinimize.setOpaque(false);
            ButtonCustom buttonMinimize = new ButtonCustom("–", 45, 25, Color.GRAY, Color.WHITE);
            buttonMinimize.setOpaque(false);
            buttonMinimize.addActionListener(e -> frame.setState(Frame.ICONIFIED));
            panelExitandMinimize.add(buttonMinimize);
            ButtonCustom buttonExit = new ButtonCustom("X", 45, 24, Color.red, Color.black);
            buttonExit.addActionListener(e -> System.exit(0));
            panelExitandMinimize.add(buttonExit);
            panelBar.add(panelExitandMinimize, BorderLayout.EAST);
            {
                final Point[] mouseDownCompCoords = { null };
                panelBar.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        mouseDownCompCoords[0] = e.getPoint();
                    }

                    public void mouseReleased(MouseEvent e) {
                        mouseDownCompCoords[0] = null;
                    }
                });
                panelBar.addMouseMotionListener(new MouseAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        Point currCoords = e.getLocationOnScreen();
                        frame.setLocation(currCoords.x - mouseDownCompCoords[0].x,
                                currCoords.y - mouseDownCompCoords[0].y);
                    }
                });
            }
            // Panel chứa các nút bấm
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(0x283C4F));
            for (int i = 0; i < 3; i++) {
                final int index = i;
                ButtonCustom btn = new ButtonCustom("Column " + (i + 1));
                btn.addActionListener(e -> controller.handleTowerSelection(index));
                btn.setBackground(Color.GREEN);
                btn.setForeground(Color.BLACK);
                buttonPanel.add(btn);
            }

            ButtonCustom resetBtn = new ButtonCustom("Reset");
            resetBtn.setBackground(new Color(220, 20, 60));
            resetBtn.addActionListener(e -> controller.resetGame());

            JPanel controlPanel = new JPanel(new BorderLayout());
            controlPanel.setBackground(new Color(0x283C4F));
            controlPanel.add(buttonPanel, BorderLayout.CENTER);
            controlPanel.add(resetBtn, BorderLayout.EAST);

            frame.add(panelBar, BorderLayout.NORTH);
            frame.add(gamePanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}