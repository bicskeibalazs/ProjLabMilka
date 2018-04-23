import java.io.FileWriter;
import java.io.IOException;

//Aktiválja, vagy deaktiválja a hozzá tartozó kapcsolható lyukat,
//miután rákerül vagy lekerül róla egy láda. (Örökölt felelősség: ld. Field.)
public class Switch extends Field {
	
	//A kapcsolóhoz tartozó kapcsolható lyuk.
	private SwitchableHole switchableHole;
	private int number;

	public int getNumber() {
		return number;
	}

	public Switch(int n) {
		number = n;
	}

	public SwitchableHole getSwitchable() {
		return switchableHole;
	}

	public void setSwitchableHole(SwitchableHole sw) {
		switchableHole = sw;
	}
	
	// Erről a mezőről egy Movable szeretne mozogni a d irány felé. 
	//Ha sikeres a mozgás: true a visszátérési értéke, ha sikertelen, akkor pedig false.
	public boolean wantsToMoveHere(Direction d, Movable m) {
		if (super.wantsToMoveHere(d, m)) {
			if (movable.isCrate())
				switchableHole.activate();
			else
				switchableHole.deactivate();
			return true;
		} else
			return false;
	}
	
	//Az adott dolgozót továbbmozgatja, majd az adott ládát erre a speciális mezőre mozgatja.
	//Aktiválja a kapcsolóhoz tartozó kapcsolható lyukat.
	public boolean someoneMovesHere(Direction d, Crate movableWhoWantsToMoveHere, Worker movableAlreadyHere) {
		if (super.someoneMovesHere(d, movableWhoWantsToMoveHere, movableAlreadyHere)) {
			switchableHole.activate();
			return true;
		} else
			return false;
	}
	
	//Az adott ládát továbbmozgatja, majd az adott dolgozót erre a speciális mezőre mozgatja.
	//Deaktiválja a kapcsolóhoz tartozó kapcsolható lyukat.
	public boolean someoneMovesHere(Direction d, Worker movableWhoWantsToMoveHere, Crate movableAlreadyHere) {
		if (super.someoneMovesHere(d, movableWhoWantsToMoveHere, movableAlreadyHere)) {
			switchableHole.deactivate();
			return true;
		} else
			return false;
	}
	
	//Kiíró függvény
	public void printField(FileWriter output) throws IOException {
		output.write('S');
		output.write(number);
	}

}
