package org.example.UI.Dialogs;

import javax.swing.*;
import java.awt.*;

import static org.example.Data.Global.Global.*;

public class PositionSetterDialog {
    private JFrame frame;
    private JPanel panel;
    private JTextField field1;
    private JTextField field2;

    public PositionSetterDialog(JFrame frame) {
        this.frame = frame;

        field1 = new JTextField(10);
        field2 = new JTextField(10);
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5); // add a small gap between label and input box
        panel.add(new JLabel("x:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0); // no gap between input box and edge
        panel.add(field1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 5); // add a small gap between rows
        panel.add(new JLabel("y:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 0); // no gap between input box and edge
        panel.add(field2, gbc);
    }
    public void showDialog() {
        field1.setText(String.valueOf(selectedItem.position.x + selectedItem.size.x / 2));
        field2.setText(String.valueOf(selectedItem.position.y + selectedItem.size.y / 2));

        int result = JOptionPane.showConfirmDialog(frame, panel, "Enter values", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String input1 = field1.getText();
            String input2 = field2.getText();

            if(selectedItem != null) {
                int x = (input1 == null || input1.isEmpty()) ? 0 : Integer.parseInt(input1);
                int y = (input2 == null || input2.isEmpty()) ? 0 : Integer.parseInt(input2);

                selectedItem.SetPosition(x - selectedItem.size.x / 2, y - selectedItem.size.y / 2);
                selectedSprite.setLocation(x - selectedItem.size.x / 2, y - selectedItem.size.y / 2);
                positionAxis.SetPosition(selectedItem.position.x + selectedItem.size.x / 2 - 50, selectedItem.position.y + selectedItem.size.y / 2 - 50);

                itemInspectorDialog.SetText2(String.valueOf(selectedItem.position.x + selectedItem.size.x / 2));
                itemInspectorDialog.SetText3(String.valueOf(selectedItem.position.y + selectedItem.size.y / 2));
            }
        }
    }
}
