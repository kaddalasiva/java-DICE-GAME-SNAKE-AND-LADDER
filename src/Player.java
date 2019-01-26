import java.util.HashMap;
import java.util.Map;

public class Player {
    public String name;
    public int score,previousScore;

    final static int WINPOINT = 100;

    static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
    static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();

    {
        snake.put(97,66);
        snake.put(94,70);
        snake.put(77,41);
        snake.put(68,25);
        snake.put(44,13);
        snake.put(33,9);
        snake.put(23,7);


        ladder.put(5,26);
        ladder.put(13,46);
        ladder.put(18,39);
        ladder.put(37,62);
        ladder.put(48,72);
        ladder.put(60,82);
        ladder.put(65,95);
    }

    public Player(String name){
        this.name = name;
    }

    /*public int getScore(){
        return score;
    }*/

    public int getPreviousScore(){
        return previousScore;
    }

    public int calculatePlayerValue(int diceValue) {
        previousScore = score;
        score = score + diceValue;
        System.out.println("SCORE:  "+score+"   PSCORE:   "+previousScore+"   Dice:   "+diceValue);

        if(score > WINPOINT) {
            score = score - diceValue;
            return score;
        }
        if(null!= snake.get(score)) {
            System.out.println("swallowed by snake");
            score = snake.get(score);
        }
        if(null != ladder.get(score)) {
            System.out.println("climb up the ladder");
            score = ladder.get(score);
        }
        return score;
    }

    public boolean isWin()
    {
        return WINPOINT == score;
    }
}
