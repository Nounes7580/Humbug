/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

/*
 *Square on the board. A square has a type grass or star and it’s all.
 *A square doesn’t know where it is on the board.

 */
/**
 *
 * @author younes
 */
public class Square {

    private boolean northWall;
    private boolean southWall;
    private boolean westWall;
    private boolean eastWall;

    private SquareType type;

    /*
     * Constructor of Square on board.
     *@param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
        this.northWall = false;
        this.southWall = false;
        this.eastWall = false;
        this.westWall = false;
    }

    /**
     * Simple getter of type
     *
     * @return type of Square
     */
    public SquareType getType() {
        return type;
    }

    public Square() {

    }
/**
 * 
 * @param northWall 
 */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }
/**
 * 
 * @param southWall 
 */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }
/**
 * 
 * @param westWall 
 */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }
/**
 * 
 * @param eastWall 
 */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }
/**
 * method of specifying whether there is a wall in a given direction
 * @param direction
 * @return 
 */
    public boolean hasWall(Direction direction) {

        switch (direction) {

            case NORTH:
                return this.northWall;

            case SOUTH:
                return this.southWall;

            case WEST:
                return this.westWall;

            case EAST:
                return this.eastWall;
        }
        throw new IllegalStateException("direction inexistante");
    }
    
}
