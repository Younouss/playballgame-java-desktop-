import javax.swing.JFrame;
public class Main {
    public static void main(String[] args){
        BaseballGame game = new BaseballGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }       
}
