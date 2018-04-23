import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

//Ismeri a szomszédos mezőket. Tudja, hogy van-e rajta Movable.
//Figyeli, hogy az adott irányban milyen szomszéd mezői vannak,
//és ha valaki éppen oda akarna lépni vagy mozogni,
//akkor megvizsgálja, hogy lehetséges-e ez az interakció. 

public class Field {

	protected Movable movable;
	protected HashMap<Direction, Field> neighbors;
	protected Surface surface;

	public Field() {
		neighbors = new HashMap<Direction, Field>();
	}

	public void setSurface(Surface s) {
		surface = s;
	}

	public Surface getSurface() {
		return surface;
	}

	public Movable getMovable() {
		return movable;
	}

	public void setMovable(Movable m) {
		movable = m;
	}

	public void setNeighbors(Direction d, Field f) {
		neighbors.put(d, f);
	}

	public Field getNeighbors(Direction d) {
		return neighbors.get(d);
	}
	
	//Az adott mezőről egy irányba történő mozgás megkezdésére irányuló metódus.
	public void wantsToMoveFrom(Direction d) {
		Field neighborInDirection = getNeighbors(d);
		if (neighborInDirection.wantsToMoveHere(d, movable)) {
			setMovable(null);
		}
	}
	
	// Egy Movable-t egy adott irányba lévő mezőre akarja mozgatni.
	//Ha sikeres a mozgás true-val tér vissza, ha sikertelen akkor false-al.

	public boolean wantsToMoveHere(Direction d, Movable m) {
		if (!isOccupied()) {
			setMovable(m);
			m.setField(this);
			return true;
		} else {
			if (m.isCrate()) {
				if (movable.isCrate()) {
					if (someoneMovesHere(d, (Crate) m, (Crate) movable)) {
						m.setField(this);
						setMovable(m);
						return true;
					} else
						return false;
				} else {
					if (someoneMovesHere(d, (Crate) m, (Worker) movable)) {
						m.setField(this);
						setMovable(m);
						return true;
					} else
						return false;
				}
			} else {
				if (movable.isCrate()) {
					if (someoneMovesHere(d, (Worker) m, (Crate) movable)) {
						m.setField(this);
						setMovable(m);
						return true;
					} else
						return false;
				} else {
					if (someoneMovesHere(d, (Worker) m, (Worker) movable)) {
						m.setField(this);
						setMovable(m);
						return true;
					} else
						return false;
				}
			}
		}
	}
	// Megnézi, hogy vannak-e éppen az adott mezőn.
	public boolean isOccupied() {
		if (movable == null)
			return false;
		else
			return true;
	}
	//Egy Crate típusú objektum egy megadott irányba szeretne mozogni,
	//ahol éppen egy másik Crate áll. Ha a mozgás még így is sikeres (pl több ládát tolunk egyszerre),
	//akkor true-val térünk vissza, ha sikertelen, akkor false-sal.
	//Megvizsgálja a movableWantsToMoveHereforceRemainingjét,
	//és ha az nulla, akkor false-al tér vissza, 
	//egyébként pedig a movableWantsToMoveHere forceRemainingjéből kiszámolja
	//a movableAlreadyHereforceRemainingjét a surface extraForceNeeded attribútuma segítségével,
	//és ha a movableAlreadyHere.setForceRemaining()-je false-al tér vissza, someoneMovesHere() is.

	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		if (movableWhoWantsToMoveHere.getForceRemaining() == 0)
			return false;
		else {
			if (!movableAlreadyHere.setForceRemaining(
					movableWhoWantsToMoveHere.getForceRemaining() - surface.getExtraForceNeeded() - 1))
				return false;
			else {
				Field neighborInDirection = getNeighbors(d);
				if (neighborInDirection.wantsToMoveHere(d, movable)) {
					movableWhoWantsToMoveHere.setField(this);
					setMovable(movableWhoWantsToMoveHere);
					return true;
				} else
					return false;
			}
		}
	}
	
	//Egy Crate típusú objektum egy megadott irányba szeretne mozogni, 
	//ahol éppen egy munkás áll. Ha a mozgás még így is sikeres 
	//(pl a munkás éppen el tud mozdulni a mezőjéről, ahová a Crate mozdulna),
	//akkor true-val térünk vissza, ha sikertelen, akkor false-sal.

	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Worker movableAlreadyHere) {
		if (movableWhoWantsToMoveHere.getForceRemaining() == 0)
			return false;
		else {
			if (!movableAlreadyHere.setForceRemaining(
					movableWhoWantsToMoveHere.getForceRemaining() - surface.getExtraForceNeeded() - 1))
				return false;
			else {
				movableAlreadyHere.setbeingPushed(true);
				Field neighborInDirection = getNeighbors(d);
				if (neighborInDirection.wantsToMoveHere(d, movable)) {
					movableWhoWantsToMoveHere.setField(this);
					setMovable(movableWhoWantsToMoveHere);
					return true;
				} else {
					movable.die();
					movableWhoWantsToMoveHere.setField(this);
					setMovable(movableWhoWantsToMoveHere);
					return true;
				}
			}
		}
	}
	
	//Egy Worker típusú objektum egy megadott irányba szeretne mozogni,
	//ahol éppen egy Crate áll. Ha a mozgás még így is sikeres (legegyszerűbb eset: sima tolás),
	//akkor true-val térünk vissza, ha sikertelen, akkor false-sal.
	//Megvizsgálja a movableWantsToMoveHere setforceRemainingjét, és ha az nulla,
	//akkor false-al tér vissza,egyébként pedig a movableWantsToMoveHere strenghtjéből
	//kiszámolja amovableAlreadyHere forceRemainingjét a surface extraForceNeeded
	//attribútumasegítségével, és ha a movableAlreadyHere.setForceRemaining()-je
	//false-al tér vissza,someoneMovesHere()
	public boolean someoneMovesHere(Direction d, Worker movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		if (movableWhoWantsToMoveHere.isBeingPushed())
			return false;
		else {
			if (!movableAlreadyHere
					.setForceRemaining(movableWhoWantsToMoveHere.getStrength() - surface.getExtraForceNeeded() - 1))
				return false;
			else {
				Field neighborInDirection = getNeighbors(d);
				if (neighborInDirection.wantsToMoveHere(d, movable)) {
					movableWhoWantsToMoveHere.setField(this);
					setMovable(movableWhoWantsToMoveHere);
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	//Egy Worker típusú objektum egy megadott irányba szeretne mozogni,
	//ahol éppen egy másik munkás áll. Ha a mozgás még így is sikeres
	//(a másik munkás pontosan akkor mozog el, amikor jön a mozgást kezdeményező munkás),
	//akkor true-val térünk vissza, ha sikertelen, akkor false-sal (egymást nem tolhatják).
	public boolean someoneMovesHere(Direction d, Worker movableWhoWantsToMoveHere, Worker movableAlreadyHere) {
		return false;
	}
	
	//Kiíró függvények Field/Surface/Movable
	public void printField(FileWriter output) throws IOException {
		output.write('F');
	}

	public void printSurface(FileWriter output) throws IOException {
		surface.printSurface(output);
	}

	public void printMovable(FileWriter output) throws IOException {
		if (movable == null)
			output.write('X');
		else
			movable.printMovable(output);
	}

}
