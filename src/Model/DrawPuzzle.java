package Model;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class DrawPuzzle extends Frame {
    DrawPuzzle(int rows, int columns){
        JFrame window = new JFrame();
        window.setSize(520,550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Taquin");
        window.getContentPane().add(new GameController(rows,columns));
        window.setVisible(true);
    }
}