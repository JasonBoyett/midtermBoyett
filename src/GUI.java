/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 2, 2022
* mac OS
*/
package src;

import javax.swing.JFrame;

public class GUI extends JFrame {

    static GamePanel gamePanel;

    public GUI(Game theGame) {
        GUI.gamePanel = new GamePanel(theGame);
        this.setResizable(false);
        this.setVisible(true);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}