package org.example.Data.Global;

import org.example.Data.Item;
import org.example.UI.Axis.PositionAxis;
import org.example.UI.Dialogs.ItemInspectorDialog;
import org.example.UI.Dialogs.PositionSetterDialog;
import org.example.UI.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Global {
    public static JFrame frame;
    public static List<Item> items = new ArrayList<>();
    public static Item selectedItem;
    public static PositionAxis positionAxis;
    public static Sprite selectedSprite;
    public static PositionSetterDialog positionSetterDialog;
    public static ItemInspectorDialog itemInspectorDialog;
}