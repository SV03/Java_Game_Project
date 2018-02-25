package game;

import static game.Game.level;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Demonstrates how high-score data can be written to a text file.
 */
public class HighScoreWriter {

    private String fileName;
    private Game game;

    public HighScoreWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeHighScore(String name, int score , int level) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(new DecimalFormat("00").format(score) + "," + name + "," + level);
            writer.write(System.getProperty( "line.separator" ));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HighScoreWriter hsWriter = new HighScoreWriter("sample.hs");
        for (int i = 0; i < args.length; i += 2) {
            String name = args[i];
            int score = Integer.parseInt(args[i + 1]);
            hsWriter.writeHighScore(name, score, level);
        }
    }
}
