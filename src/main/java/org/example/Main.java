package org.example;

import org.example.Event.KeyboardHandler;
import org.example.UI.CustomFrame;
import org.example.UI.CustomPane;
import org.example.UI.Axis.PositionAxis;
import org.example.UI.Dialogs.ItemInspectorDialog;
import org.example.UI.Dialogs.PositionSetterDialog;
import javax.swing.*;
import static org.example.Data.Global.Global.*;

public class Main {
    public static void main(String[] args) {
        CustomPane cPane = new CustomPane();
        frame = new CustomFrame();
        frame.addKeyListener(new KeyboardHandler());

        positionAxis = new PositionAxis();
        positionAxis.setSize(100, 100);

        positionSetterDialog = new PositionSetterDialog(frame);
        itemInspectorDialog = new ItemInspectorDialog();

        cPane.add(itemInspectorDialog);
        cPane.add(positionAxis);

        frame.setContentPane(cPane);
        frame.setSize(1280, 760);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}