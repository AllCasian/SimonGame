import java.util.Arrays;
import java.util.Random;

public class BackEnd {
    Random rand = new Random();

    int randomColor = rand.nextInt(4);

    private int [] sequence = new int[40];


    BackEnd(){
        reset();
    }

    public void reset(){
        randomColor = rand.nextInt(4);
        Arrays.fill(sequence, 0);
        sequence[0] = randomColor;
    }

    public int generateColor(){
        int x = rand.nextInt(4);
        //System.out.println(x);
        return x;
    }

    public void addColorToSequence(int[] array, int value, int position){
        array[position] = value;
    }

}
