package src;

/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * October 2, 2022
 * mac OS
 */
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel {

    private ImageIcon deck;
    private Deck gameDeck;

    private HitButton hitButton;
    private StayButton stayButton;
    private Game game;
    private PlayerFeild playerFeild;
    private DealerFeild dealerFeild;
    private CenterFeild centerFeild = new CenterFeild(this);

    public GamePanel(Game game) {
        this.game = game;
        this.playerFeild = new PlayerFeild(game);
        this.dealerFeild = new DealerFeild(game);
        this.playerFeild.setBounds(500, 275, 300, 100);
        this.gameDeck = game.getGameDeck();
        this.hitButton = new HitButton(this, game);
        this.stayButton = new StayButton(game, this);
        this.setLayout(null);
        this.setBackground(new ColorUIResource(0, 102, 20));
        this.setPreferredSize(new DimensionUIResource(1280, 720));
        deck = gameDeck.getBackImage();
        this.hitButton.setBounds(1075, 325, 150, 50);
        this.stayButton.setBounds(1075, 385, 150, 50);
        this.add(this.hitButton);
        this.add(this.stayButton);
        this.add(this.dealerFeild);
        this.add(this.playerFeild);
        game.updateDealerScore();
        game.updatePlayerScore();
        this.add(centerFeild);
        playerFeild.update();
        dealerFeild.update();
        centerFeild.update();
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        this.hitButton.paintComponents(g);
        this.playerFeild.paintComponents(g);
        deck.paintIcon(this, g, 1070, 10);
        this.game.getDealerHand().get(0).getCardFace().paintIcon(this, g, 10, 10);
        this.game.getDealerHand().get(1).getCardFace().paintIcon(this, g, 50, 50);
        this.game.getDealerHand().get(2).getCardFace().paintIcon(this, g, 100, 10);
        this.game.getDealerHand().get(3).getCardFace().paintIcon(this, g, 150, 50);
        this.game.getDealerHand().get(4).getCardFace().paintIcon(this, g, 200, 10);
        this.game.getPlayerHand().get(0).getCardFace().paintIcon(this, g, 500, 370);
        this.game.getPlayerHand().get(1).getCardFace().paintIcon(this, g, 540, 400);
        this.game.getPlayerHand().get(2).getCardFace().paintIcon(this, g, 590, 370);
        this.game.getPlayerHand().get(3).getCardFace().paintIcon(this, g, 640, 400);
        this.game.getPlayerHand().get(4).getCardFace().paintIcon(this, g, 690, 370);
    }

    public PlayerFeild getPlayerFeild() {
        return this.playerFeild;
    }

    public DealerFeild getDealerFeild() {
        return this.dealerFeild;
    }

    public HitButton getHitButton() {
        return this.hitButton;
    }

    public Game getGame() {
        return this.game;
    }

    public CenterFeild getCenterFeild() {
        return this.centerFeild;
    }

    public StayButton getStayButton() {
        return this.stayButton;
    }
}