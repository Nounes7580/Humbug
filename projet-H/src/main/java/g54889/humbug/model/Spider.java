/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

/**
 *
 * @author younes
 */
public class Spider extends Animal {

    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * 
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {

        Position position = super.getPositionOnBoard();

        if (Walls(board, position, direction)) {
            return super.getPositionOnBoard();
        }

        if (super.Walls(board, position, direction)) {
            super.caseIsOnStar(board, position);
            return position;
        }
        while (board.isInside(position.next(direction))) {
            if (super.Walls(board, position, direction)) {
                super.caseIsOnStar(board, position);
                return position;
            }
            if (board.isInside(position)) {
                if (!Free(position.next(direction), animals)) {
                    super.caseIsOnStar(board, position);
                    return position;
                }
            }
            position = position.next(direction);
            
        }
        if(super.Walls(board, position, direction)){
           super.caseIsOnStar(board, position);
           
           return position;
            
        }
        return null;
    }

    public Spider() {
        super();
    }

}
