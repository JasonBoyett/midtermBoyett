import java.awt.Font;

import javax.swing.JTextField;

public class DealerFeild extends JTextField{
    Game game;
    Font font = new Font(Font.SERIF, CENTER, 35);
    public DealerFeild(Game game){
        this.game = game;
        this.setFont(font);
        this.setText(String.format("Dealer's score: %d", game.getDealerScore()));
        this.setBounds(60,350,300,100);
        this.setOpaque(false);
        this.setBorder(null);
    }

    public void update(){
        if(!(this.game.playerWon()) && this.game.isGameOver()){
            this.setText("Dealer wins.");
        }
        else{
            this.setText(String.format("Dealer's score: %d", game.getDealerScore()));
        }
    }
}
