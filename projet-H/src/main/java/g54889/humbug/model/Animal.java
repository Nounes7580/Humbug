package g54889.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 *
 * specifies that a typical value will appear in the JSON file. and that this
 * value is the name of the class
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
/**
 * specifies which class corresponds to which name. We chose to use the name of
 * the class as a value for type
 */
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})

/**
 *
 * @author younes
 */
public abstract class Animal {

    private boolean onStar;

    private Position positionOnBoard;

    public Animal() {

    }

    /**
     *
     * @param positionOnBoard
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        onStar = false;
    }

    /**
     * return onStar
     *
     * @return one instance of isOnStar
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * update boolean onstar
     *
     * @param onStar
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * return positionOnBoard
     *
     * @return one instance of position
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * update positionOnBoard
     *
     * @param positionOnBoard
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     *
     * allows the movement
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     *
     */
    public abstract Position move(Board board,
            Direction direction, Animal... animals);

    protected boolean Free(Position position, Animal... animals) {
        for (int i = 0; i < animals.length; i++) {
            if (position.equals(animals[i].getPositionOnBoard()) && !animals[i].isOnStar()) {
                return false;
            }
        }
        return true;
    }

    protected boolean Walls(Board board, Position position, Direction direction) {
        if (board.isInside(position.next(direction))) {
            return board.getSquares()[position.getRow()][position.getColumn()].hasWall(direction)
                    || board.getSquares()[position.next(direction).getRow()][position.next(direction).getColumn()].hasWall(direction.opposite());
        } else {
            return board.getSquares()[position.getRow()][position.getColumn()].hasWall(direction);
        }
    }

    protected void caseIsOnStar(Board board, Position position) {
        if (board.getSquareType(position) == SquareType.STAR) {
            board.getSquares()[position.getRow()][position.getColumn()] = new Square(SquareType.GRASS);
            this.setOnStar(true);
        }
    }

}
