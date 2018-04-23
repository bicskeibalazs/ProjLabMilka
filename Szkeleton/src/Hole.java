import java.io.FileWriter;
import java.io.IOException;

//Ha Movable kerül rá akkor azt megöli(die). (Örökölt felelőssége: ld. Field.)
public class Hole extends Field {

	//Megöli az erre a mezőre mozgó Movable-t.
	public boolean wantsToMoveHere(Direction d, Movable m) {
		m.die();
		return true;
	}
	
	//Kiíró függvény
	public void printField(FileWriter output) throws IOException {
		output.write('H');
	}

}
