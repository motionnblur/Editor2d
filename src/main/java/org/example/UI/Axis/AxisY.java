package org.example.UI.Axis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static org.example.Data.Global.Global.*;

public class AxisY extends JLabel {
    private PositionAxis parent;
    private Point offset;

    public AxisY(PositionAxis parent, int x, int y) {
        this.parent =  parent;
        
        setBackground(Color.GREEN);
        setOpaque(true);
        setSize(5, 80);
        setLocation(x, y);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.RED);
                setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.GREEN);
                setBorder(BorderFactory.createLineBorder(Color.GREEN));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Record the initial position of the mouse when pressed
                offset = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Optionally, handle the end of dragging here
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int diff = e.getY() - offset.y;

                Point location = parent.getLocation();
                location.y += diff;

                parent.setLocation(location);

                location = selectedSprite.getLocation();
                location.y += diff;
                selectedSprite.setLocation(location);

                itemInspectorDialog.SetText2(String.valueOf(selectedSprite.getLocation().x + selectedSprite.getWidth() / 2));
                itemInspectorDialog.SetText3(String.valueOf(selectedSprite.getLocation().y + selectedSprite.getHeight() / 2));
            }
        });
    }
}

