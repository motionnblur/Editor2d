package org.example.Event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.Data.Global.Global;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static org.example.Data.Global.Global.*;

public class KeyboardHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F1){
            if(selectedItem != null)
                positionSetterDialog.showDialog();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(itemInspectorDialog != null)
                itemInspectorDialog.Show(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()) {
            try {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(Global.items);
                System.out.println(json);
                try {
                    java.nio.file.Files.writeString(java.nio.file.Paths.get("./scene.json"), json);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(selectedItem != null) selectedItem = null;
            positionAxis.Show(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(selectedItem != null) {
                Global.items.remove(selectedItem);
                selectedItem = null;
                positionAxis.Show(false);
                itemInspectorDialog.Show(false);

                selectedSprite.RemoveFromCanvas();
                selectedSprite = null;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
