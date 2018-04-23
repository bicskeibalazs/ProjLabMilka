import java.io.FileWriter;
import java.io.IOException;

//Egy olyan speciális mezőt reprezentál, amelyre nem kerülhet movable. (Örökölt felelősség: ld. Field.)
public class NotSteppable extends Field {
	
	//Nem engedi, hogy egy Movable erre a speciális mezőre lépjen.
	public boolean wantsToMoveHere(Direction d, Movable m) {
		return false;
	}
	
	//Kiíró függvény
	public void printField(FileWriter output) throws IOException {
		output.write('N');
	}

}
