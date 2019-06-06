import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Output {

    private ArrayList<Input.Test> listInput;
    private String EMPTY = "***";


    public Output(ArrayList<Input.Test> listInput) {
        this.listInput = listInput;
        printOutPut();
    }


    private void printOutPut() {


        for (int i = 0; i < listInput.size(); i++) {

            int rank = 0;
            int score = 1;

            System.out.println(i + 1);
            ArrayList<Input.Player> listScoreDesc = listInput.get(i).getListPlayer();
            listScoreDesc.sort((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()));
            int numberScores = listInput.get(i).getNumberScores();

            for (int x = 0; x < numberScores; x++) {

                StringBuilder stringBuilder = new StringBuilder();

                int scoreFor;
                if (x <= listScoreDesc.size() - 1) {
                    scoreFor = listScoreDesc.get(x).score;
                } else {
                    scoreFor = -1;
                }

                String nameFor;

                if (x <= listScoreDesc.size() - 1) {
                    nameFor = listScoreDesc.get(x).name;
                } else {
                    nameFor = EMPTY;
                }

                if (rank != scoreFor) {
                    stringBuilder.append(score);
                    stringBuilder.append(" ");
                    rank = scoreFor;
                    score++;
                } else {
                    score--;
                    stringBuilder.append(score);
                    stringBuilder.append(" ");
                    rank = scoreFor;
                    score++;
                }


                stringBuilder.append(nameFor);
                stringBuilder.append(" ");

                if (scoreFor != -1) {
                    stringBuilder.append(scoreFor);
                } else {
                    stringBuilder.append(EMPTY);
                }
                System.out.println(stringBuilder.toString());
            }
        }




    }


}
