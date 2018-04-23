import java.io.FileWriter;
import java.io.IOException;

//Egy raklapot reprezentál, amelyre a dolgozóknak ládát(Crate) kell tolnia,
//ezután nem kerülhet rá movable. (Örökölt felelősség: ld. Field.)
public class Pallet extends Field {

	private Warehouse warehouse;
	private Color color;

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

	public Pallet(Color c, Warehouse w) {
		color = c;
		warehouse = w;
	}
	//Az adott Movable a megadott irányba szeretne mozogni.
	//Ha a mozgás sikeres, akkor true-val, ha sikertelen nyilvánvalóan false-sal tér vissza.
	public boolean wantsToMoveHere(Direction d, Movable m) {
		if (super.wantsToMoveHere(d, m)) {
			warehouse.addPoint(color);
			return true;
		} else
			return false;
	}
	
	//Nem engedi, hogy az adott láda erre a mezőre mozogjon.
	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		return false;
	}
	
	//Megöli a mezőn álló dolgozót, majd az adott ládát erre a mezőre mozgatja.
	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Worker movableAlreadyHere) {
		if (super.someoneMovesHere(d, movableWhoWantsToMoveHere, movableAlreadyHere)) {
			if (movable.isCrate())
				warehouse.addPoint(color);
			return true;
		} else
			return false;
	}
	
	//Nem engedi, hogy az adott dolgozó erre a mezőre mozogjon.
	public boolean someoneMovesHere(Direction d, Worker movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		return false;
	}
	
	//Kiíró függvény különböző esetekben
	public void printField(FileWriter output) throws IOException {
		output.write('P');
		output.write('/');
		if (color == Color.red)
			output.write('R');
		else
			output.write('B');
	}

}
