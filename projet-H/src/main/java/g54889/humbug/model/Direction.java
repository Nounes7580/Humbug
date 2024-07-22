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
public enum Direction {

    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    private Direction(int row, int column) {
        this.deltaRow = row;
        this.deltaColumn = column;
    }

    private final int deltaRow;

    private final int deltaColumn;

    /**
     * Get the value of deltaColumn
     *
     * @return the value of deltaColumn
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Get the value of deltaRow
     *
     * @return the value of deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * method that gives the opposite direction to a direction
     *
     * @return opposite direction
     */
    public Direction opposite() {

        switch (this) {

            case NORTH:
                return SOUTH;

            case SOUTH:
                return NORTH;

            case WEST:
                return EAST;

            case EAST:
                return WEST;

        }

        throw new IllegalStateException("direction invalide");

    }

}
