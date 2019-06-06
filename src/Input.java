import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

    private BufferedReader bufferedReader;
    private int numberTest;

    public Input(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        try {
            readText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readText() throws IOException {

        ArrayList<Test> listInput = new ArrayList<>();
        String line = bufferedReader.readLine();

        if (line != null && Integer.valueOf(line) > 0) {
            numberTest = Integer.valueOf(line.trim());
        } else {
            System.out.println("Casos de prueba igual a Cero (0)");
            return;
        }



        for (int i = 0; i < numberTest; i++) {
            Test test = new Test();
            line = bufferedReader.readLine();
            if (line != null) {
                String[] splitA = line.trim().split(" ");

                if (splitA.length != 2) {
                    System.out.println("Verifique los parámetros de entrada");
                    return;
                }
                int numberPlayer = Integer.parseInt(splitA[0]);
                int numberScores = Integer.parseInt(splitA[1]);

                if (numberPlayer > 100000) {
                    System.out.println("Máximo 100.000 jugadores para el registro");
                    return;
                }

                if (numberScores == 0 || numberScores >= 1000) {
                    System.out.println("El número de puntuaciones para la lista de puntuaciones más altas, debe estar en este rango ( 0 < t < 1000 )");
                    return;
                }

                test.setNumberPlayer(numberPlayer);
                test.setNumberScores(numberScores);

                for (int x = 0; x < numberPlayer; x++) {
                    line = bufferedReader.readLine();

                    if (line != null) {
                        String [] splitB = line.trim().split(" ");
                        String name = splitB[0];
                        int score = Integer.parseInt(splitB[1]);
                        test.getListPlayer().add(new Player(name, score));
                    }
                }
                listInput.add(test);
            }

        }

        if (numberTest == listInput.size()) {
            System.out.println("Creación de listInput exitosa");
            new Output(listInput);
        } else {
            System.out.println("Error al crear listInput");
        }

    }




    public class Test {

        private int numberPlayer;
        private int numberScores;
        private ArrayList<Player> listPlayer = new ArrayList<>();


        Test() {
        }

        public Test(int numberPlayer, int numberScores, ArrayList<Player> listPlayer) {
            this.numberPlayer = numberPlayer;
            this.numberScores = numberScores;
            this.listPlayer = listPlayer;
        }


        public int getNumberPlayer() {
            return numberPlayer;
        }

        public void setNumberPlayer(int numberPlayer) {
            this.numberPlayer = numberPlayer;
        }

        public int getNumberScores() {
            return numberScores;
        }

        public void setNumberScores(int numberScores) {
            this.numberScores = numberScores;
        }

        public ArrayList<Player> getListPlayer() {
            return listPlayer;
        }

        public void setListPlayer(ArrayList<Player> listPlayer) {
            this.listPlayer = listPlayer;
        }

    }





    public class Player {

        String name;
        int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }


}
