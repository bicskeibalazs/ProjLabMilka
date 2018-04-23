import java.io.FileWriter;
import java.io.IOException;

//Egy raklapot reprezentál, amelyre a dolgozóknak ládát(Crate) kell tolnia,
//ezután nem kerülhet rá movable. (Örökölt felelősség: ld. Field.)
public class Pallet extends Field {
	
	//A raklapokhoz tartozó raktár.
	private Warehouse warehouse;
	//Raklap színe.
	private Color color;
	
  	private boolean steppable;
  
  
 	public Pallet(Color c, Warehouse w) {
        	color = c;
        	warehouse = w;
        	steppable = true;
      }
  
  	public Warehouse getWarehouse() {
        	return warehouse;
      }
  
  	public void setWarehouse(Warehouse w) {
        	warehouse = w;
      }
  
  	public Color getColor() {
        	return color;
      }
  
  	public void setColor(Color c) {
        	color = c;
      }
  
  	
  	
  	public boolean wantsToMoveHere(Direction d, Movable m) {
        	if(super.wantsToMoveHere(d, m)) {
              	warehouse.addPoint(color);
		steppable = false;
              	return true;
            }
        	else return false;
      }
	
	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		return false;
	}
	
	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Worker movableAlreadyHere) {
		if(super.someoneMovesHere(d, movableWhoWantsToMoveHere, movableAlreadyHere)) {
              	if(movable.isCrate()) {
                    warehouse.addPoint(color);
                    steppable = false;
                  }
              
              	return true;
            }
        	else return false;
	}
	
	public boolean someoneMovesHere(Direction d, Worker movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		return false;
	}
  	
  	public void printField(FileWriter output) throws IOException {
 	 	if (steppable){
             	 output.write('P');
       		 output.write('/');
       		 if (color == Color.red) output.write('R');
        	 else output.write('B');
              }
        	else output.write('N');
	}

}
