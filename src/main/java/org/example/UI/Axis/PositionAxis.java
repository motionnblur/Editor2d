package org.example.UI.Axis;

import org.example.Interface.IDrawable;

import javax.swing.*;
import java.awt.*;

import static org.example.Data.Global.Global.itemInspectorDialog;
import static org.example.Data.Global.Global.selectedItem;

public class PositionAxis extends JPanel implements IDrawable {
    AxisX axisX;
    AxisY axisY;

    public PositionAxis() {
        axisX = new AxisX(this, 47,50);
        axisY = new AxisY(this, 47,-25);

        setLayout(new GroupLayout(this));
        add(axisX, BorderLayout.CENTER);
        add(axisY, BorderLayout.CENTER);

        setOpaque(false);

        Show(false);
    }

    @Override
    public void Show(boolean isShow) {
        setVisible(isShow);
    }

    @Override
    public void SetPosition(int x, int y) {
        setLocation(x, y);
        itemInspectorDialog.SetText2(String.valueOf(selectedItem.position.x + selectedItem.size.x / 2));
        itemInspectorDialog.SetText3(String.valueOf(selectedItem.position.y + selectedItem.size.y / 2));
    }
}
