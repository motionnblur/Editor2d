package org.example.UI;

import org.example.Data.Item;
import org.example.Event.MouseHandler;
import org.example.Interface.IDrawable;

import javax.swing.*;
import java.awt.*;

import static org.example.Data.Global.Global.frame;

public class Sprite extends JLabel implements IDrawable {
    public Sprite(ImageIcon imageIcon, Point dropPoint, Dimension d, Item itemData) {
        super(imageIcon);

        setSize(d);
        setLocation(dropPoint);
        MouseHandler mh = new MouseHandler(itemData);
        addMouseListener(mh);
        addMouseMotionListener(mh);
    }

    @Override
    public void Show(boolean isShow) {
        setVisible(isShow);
    }

    @Override
    public void SetPosition(int x, int y) {
        setLocation(x, y);
    }

    public void RemoveFromCanvas() {
        getParent().remove(this);
        frame.repaint();
    }
}
