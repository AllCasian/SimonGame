import javax.swing.*;
import java.awt.event.ActionListener;

public class TheBond{

    private final FrontEnd f;
    private final BackEnd b;
    private int [] sequence = new int[40];
    private int i = 1;
    private int counter = 0;

    TheBond(FrontEnd frontEnd, BackEnd backEnd) throws InterruptedException {
        f = frontEnd;
        b = backEnd;

        //maparea culorilor cu numere
        //  0 -- rosu
        //  1 -- albastru
        //  2 -- verde
        //  3 -- galben

        JButton redButton = f.getRed();
        JButton blueButton = f.getBlue();
        JButton greenButton = f.getGreen();
        JButton yellowButton = f.getYellow();

        ActionListener listener = e -> {

                if (e.getSource() == redButton && sequence[counter + 1] != 0) {
                    f.showError("Game Over! Your score was: " + (i - 1));
                    System.exit(0);
                    f.dispose();
                    f.setVisible(false);
                } else if (e.getSource() == blueButton && sequence[counter + 1] != 1) {
                    f.showError("Game Over! Your score was: " + (i - 1));
                    System.exit(0);
                    f.dispose();
                    f.setVisible(false);
                } else if (e.getSource() == greenButton && sequence[counter + 1] != 2) {
                    f.showError("Game Over! Your score was: " + (i - 1));
                    System.exit(0);
                    f.dispose();
                    f.setVisible(false);
                } else if (e.getSource() == yellowButton && sequence[counter + 1] != 3) {
                    f.showError("Game Over! Your score was: " + (i - 1));
                    System.exit(0);
                    f.dispose();
                    f.setVisible(false);
                } else {
                    counter++;
                }

        };

        redButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        greenButton.addActionListener(listener);
        yellowButton.addActionListener(listener);

        counter = 0;
        while(true) {

            int color = b.generateColor();
            b.addColorToSequence(sequence, color, i);

            for (int j = 1; j < i; j++) {
                if (sequence[j] == 0) {
                    f.shineRed();
                } else if (sequence[j] == 1) {
                    f.shineBlue();
                } else if (sequence[j] == 2) {
                    f.shineGreen();
                } else if (sequence[j] == 3) {
                    f.shineYellow();
                }
            }

            if (color == 0) {
                f.shineRed();
            } else if (color == 1) {
                f.shineBlue();
            } else if (color == 2) {
                f.shineGreen();
            } else if (color == 3) {
                f.shineYellow();
            }

            f.setTextGoLabel("GO!");

            while(counter != i){
                synchronized (this) {
                    wait(100);
                }
            }

            counter = 0;
            f.setTextGoLabel(" ");
            f.setScore(i);
            i ++;

            if(i == 31){
                f.showError("Congratulations! You Win the Simon Game!");
                System.exit(0);
                f.dispose();
                f.setVisible(false);
                break;
            }

            synchronized (this){
                wait(600);
            }
        }

    }

}
