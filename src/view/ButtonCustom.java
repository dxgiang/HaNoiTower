package view;

import javax.swing.*;
import java.awt.*;

public class ButtonCustom extends JButton {
    public ButtonCustom(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
        setBackground(new Color(70, 130, 180));
        setForeground(Color.WHITE);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        setCursor(cursor);
    }
    public ButtonCustom(String titleButton, int width, int height, Color backgroundColor, Color foregroundColor) {
        super(titleButton);
        setPreferredSize(new java.awt.Dimension(width, height));
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}
