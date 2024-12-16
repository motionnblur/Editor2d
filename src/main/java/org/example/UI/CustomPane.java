package org.example.UI;

import org.example.Data.Item;
import org.example.Event.MouseHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.example.Data.Global.Global.*;
import static org.example.Data.Global.Global.positionSetterDialog;

public class CustomPane extends JLayeredPane {
    public CustomPane() {
        DropTarget target = new DropTarget(this, new DropTargetListener() {
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
                if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    dtde.acceptDrag(DnDConstants.ACTION_COPY);
                } else {
                    dtde.rejectDrag();
                }
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                Transferable tr = dtde.getTransferable();
                try {
                    if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        List<File> files = (List<File>) tr.getTransferData(DataFlavor.javaFileListFlavor);
                        for (File file : files) {
                            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".bmp") || file.getName().endsWith(".gif")) {
                                BufferedImage img = ImageIO.read(file);

                                Point dropPoint = dtde.getLocation();
                                Item itemData = new Item();
                                itemData.itemName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                                itemData.SetPosition(dropPoint.x, dropPoint.y);
                                itemData.SetSize(img.getWidth(), img.getHeight());

                                Sprite sprite = new Sprite(new ImageIcon(img), dropPoint, new Dimension(img.getWidth(), img.getHeight()), itemData);
                                add(sprite);

                                items.add(itemData);

                                revalidate();
                                repaint();
                            }
                        }
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if(itemInspectorDialog != null)
                        itemInspectorDialog.Show(false);
                    positionAxis.Show(false);
                    
                    selectedItem = null;
                    selectedSprite = null;
                }
            }
        });
    }
}