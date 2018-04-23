import java.io.FileWriter;
import java.io.IOException;

//Reprentálja a Fieldekre letehető dolgokat (olaj, méz).
public class Surface {
	
	//Egy láda tolásának nehezítésére vagy könnyítésére szolgáló változó.
	protected int extraForceNeeded;
	// Egy mező, amelyen a Surface van.
	protected Field field;

	public Surface() {
		;
	}

	public Surface(Field f) {
		extraForceNeeded = 0;
		field = f;
		f.setSurface(this);
	}

	public Field getField() {
		return field;
	}

	public void setField(Field f) {
		field = f;
	}

	public int getExtraForceNeeded() {
		return extraForceNeeded;
	}

	public void setExtreaForceNeeded(int fr) {
		extraForceNeeded = fr;
	}
	
	//Kiíró függvény
	public void printSurface(FileWriter output) throws IOException {
		output.write('X');
	}
}
