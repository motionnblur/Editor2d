package org.example.UI.Dialogs;

import javax.swing.*;
import java.awt.*;

public class ItemInspectorDialog extends JPanel {
    private JLabel field1;
    private JLabel field2;
    private JLabel field3;

    public ItemInspectorDialog() {
        field1 = new JLabel();
        field2 = new JLabel();
        field3 = new JLabel();

        Font currentFont = field2.getFont();
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), 15);
        field1.setFont(newFont);
        field2.setFont(newFont);
        field3.setFont(newFont);

        field1.setForeground(Color.WHITE);
        field2.setForeground(Color.WHITE);
        field3.setForeground(Color.WHITE);

        setLayout(new GridLayout(3, 1));
        add(field1);
        add(field2);
        add(field3);
        setOpaque(false);
        setPreferredSize(new Dimension(200, 200));

        setBounds(5, 5, 150, 60);

        setVisible(false);
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    public void Show(boolean isShow) {
        setVisible(isShow);
    }
    public void SetText1(String text) {
        field1.setText(text);
    }
    public void SetText2(String text) {
        field2.setText("X: " + text);
    }
    public void SetText3(String text) {
        field3.setText("Y: " + text);
    }
}
