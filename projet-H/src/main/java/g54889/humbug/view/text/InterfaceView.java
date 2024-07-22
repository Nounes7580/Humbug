/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.view.text;

import g54889.humbug.model.Animal;
import g54889.humbug.model.Board;
import g54889.humbug.model.Direction;
import g54889.humbug.model.Position;

/**
 *
 * @author younes
 */
public interface InterfaceView {
   
 public void displayRemainingMoves(int nMoves);
    
  public  void displayBoard(Board board,Animal... animals);
    
   public Position askPosition();
    
   public Direction askDirection();

   public void displayError(String message);
    
}
