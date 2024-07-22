package g54889.humbug.model;

/**
 *
 * @author youne
 */
public class Ladybird extends Animal {
/**
 * 
 * @param positionOnBoard 
 */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);
    }
/**
 * moves two squares and stops before if there is an obstacle.
 * @param board
 * @param direction
 * @param animals
 * @return 
 */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position position = super.getPositionOnBoard();
        for (int i = 0; i < 2; i++) {
            if (board.isInside(position) && (super.Walls(board, position, direction) || !super.Free(position.next(direction), animals))) {
                super.caseIsOnStar(board, position);
                return position;
            }
            position = position.next(direction);
        }
        if (board.isInside(position)) {
            super.caseIsOnStar(board, position);
            return position;
        } else {
            return null;
        }
    }

    public Ladybird() {
        super();
    }
}
