package g54889.humbug.model;

/**
 *
 * @author younes
 */
public class Grasshopper extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * jumps to the next free square and bounces back. on any other animals that
     * might get in his way.
     *
     * @param board
     * @param direction
     * @param animals
     * @return 
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position position = getPositionOnBoard().next(direction);
        if (Walls(board, position, direction)) {
            return super.getPositionOnBoard();
        }

        while (!Free(position, animals)) {
            position = position.next(direction);
        }
        if (board.isInside(position)) {
            super.caseIsOnStar(board, position);
            return position;
        } else {
            return null;
        }
    }

    public Grasshopper() {
        super();
    }
}
