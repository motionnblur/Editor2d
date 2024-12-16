package org.example.Data;

public class Item {
    public String itemName;
    public Position position;
    public Size size;

    public Item() {
        position = new Position();
        size = new Size();
    }

    public void SetPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }
    public void SetSize(int x, int y) {
        size.x = x;
        size.y = y;
    }
}
