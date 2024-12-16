package org.example.Event;

import org.example.Data.Item;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static org.example.Data.Global.Global.*;

public class MouseHandler extends MouseAdapter {
    private Point offset;
    private Item item;
    private boolean isDragging = false;

    public MouseHandler(Item item) {
        this.item = item;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            offset = e.getPoint();
            isDragging = true;

            selectedSprite = (org.example.UI.Sprite) e.getComponent();
            selectedItem = item;

            int positionX = selectedSprite.getLocation().x + selectedSprite.getWidth() / 2 - 50;
            int positionY = selectedSprite.getLocation().y + selectedSprite.getHeight() / 2 - 50;

            positionAxis.SetPosition(positionX, positionY);
            positionAxis.Show(true);

            itemInspectorDialog.SetText1(selectedItem.itemName);
            itemInspectorDialog.Show(true);
        }else{
            isDragging = false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            isDragging = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!isDragging) return;

        int x = e.getPoint().x - offset.x;
        int y = e.getPoint().y - offset.y;
        Component component = e.getComponent();
        Point location = component.getLocation();
        location.x += x;
        location.y += y;
        component.setLocation(location);
        item.position.x = location.x;
        item.position.y = location.y;

        positionAxis.SetPosition(item.position.x + item.size.x / 2 - 50, item.position.y + item.size.y / 2 - 50);
    }
}