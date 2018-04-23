import java.io.FileWriter;
import java.io.IOException;

//Egy olyan speciális mezőt reprezentál, amelyre nem kerülhet movable. (Örökölt felelősség: ld. Field.)
public class NotSteppable extends Field {

	public boolean wantsToMoveHere(Direction d, Movable m) {
		return false;
	}

	public void printField(FileWriter output) throws IOException {
		output.write('N');
	}

}
