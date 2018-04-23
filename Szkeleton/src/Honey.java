import java.io.FileWriter;
import java.io.IOException;

//Játékban a mézet reprezentálja, amely nehezebbé teszi a ládák mozgatását.
public class Honey extends Surface {

	public Honey(Field f) {
		super.field = f;
		super.extraForceNeeded = 1;
		f.setSurface(this);
	}

	public void printSurface(FileWriter output) throws IOException {
		output.write('H');
		output.write('o');
	}
}
