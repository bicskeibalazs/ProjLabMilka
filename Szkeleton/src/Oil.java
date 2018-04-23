import java.io.FileWriter;
import java.io.IOException;

//Játékban az olajat reprezentálja, amely könnyebbé teszi a ládák mozgatását.
public class Oil extends Surface {

	public Oil(Field f) {
		super.extraForceNeeded = -1;
		super.field = f;
		f.setSurface(this);
	}
	
	//Kiíró függvény
	public void printSurface(FileWriter output) throws IOException {
		output.write('O');
	}

}
