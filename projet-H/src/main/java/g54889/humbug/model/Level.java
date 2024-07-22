package g54889.humbug.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author youne
 */
public class Level {

    /**
     * representing the tray for this level
     */
    private Board board;
    /**
     * representing animals for this level
     */
    private Animal[] animal;
    /**
     * representing the number of trips allowed for this level
     */
    private int nMoves;

    /**
     *
     * @param board
     * @param animals
     * @param nMoves
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animal = animals;
        this.nMoves = nMoves;
    }

    
    public Level() {

    }
/**
 * 
 * @return board
 */
    public Board getBoard() {
        return board;
    }

    @JsonProperty("animals")
   
    /**
     * @return animal
     */
    public Animal[] getAnimal() {
        return animal;
    }
/**
 * 
 * @return nMoves
 */
    public int getnMoves() {
        return nMoves;
    }

    /**
     * allows you to read a file to return a game level
     *
     * @param n
     * @return
     */
    private static Level readLevel(int n) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + n + ".json");

            Level level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * returning a level
     *
     * @param level
     * @return
     */
    public static Level getLevel(int level) {
        return readLevel(level);
    }
}
