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
public class Position {

    private final int row;

    private final int column;

    /**
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {

        this.column = column;
        this.row = row;

    }
    /**
     * 
     */

    public Position() {
        this.row = 0;
        this.column = 0;
    }

    /**
     *
     * @param d
     * @return
     */
    public Position next(Direction d) {

        return new Position(this.row + d.getDeltaRow(), this.column + d.getDeltaColumn());

    }

    /**
     * Get the value of column
     *
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Get the value of row
     *
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.row;
        hash = 41 * hash + this.column;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

}
