package game;

import static game.Game.level;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Demonstrates how high-score data can be read from a text
 * file and printed to the terminal.
 */
public class HighScoreReader extends JPanel{

    private String fileName;
    private ArrayList<String>list;
    private JTextArea jta;

    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public HighScoreReader(String fileName) {
        this.fileName = fileName;
        list = new ArrayList<>();
        jta = new JTextArea(5,20);
        
    }

    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public void readScores() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if(!line.equals("")){
                    
                // file is assumed to contain one name, score pair per line
                list.add(line);
                }
                line = reader.readLine();
            }
            Collections.sort(list, Collections.reverseOrder());
            System.out.println("...done.");
            
            if (list.size() >=5){
                for(int i =0; i<5; i++){
                String[] tokens = list.get(i).split(",");
                int score = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int level = Integer.parseInt(tokens[2]);
                jta.append((i+1) + " Name: " + name + ", Score: " + score + " Level: " + level +"\n");
                }
            }else{
                for(int i =0; i<list.size(); i++){
                String[] tokens = list.get(i).split(",");
                int score = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int level = Integer.parseInt(tokens[2]);
                jta.append((i+1) + " Name: " + name + ", Score: " + score + " Level: " + level+ "\n");
                
                }
            }
            jta.setEditable(false);
            add(jta);
            
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        HighScoreReader demo = new HighScoreReader(args[0]);
        demo.readScores();
    }
}
