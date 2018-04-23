import java.io.FileWriter;
import java.io.IOException;

//Egy mozgatható dolgot reprezentál.
public abstract class Movable {

	protected Field field;
	protected int forceRemaining;
	
	//Egy sima setter függvényhez képest annyi plusz,
	//hogy bool a visszatérése. Ha fR < 0,
	//akkor false a visszatérés, egyébként beállítja, és true.
	public boolean setForceRemaining(int f) {
		forceRemaining = f;
		return true;
	}

	public int getForceRemaining() {
		return forceRemaining;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field f) {
		field = f;
	}

	public void printMovable(FileWriter output) throws IOException {
		;
	}
	//A mozgatható dolog képes arra, hogy meghaljon, 
	//egy láda beleeshet a lyukba, úgy ahogy, a munkás is.
	//Vagy az is előfordulhat, hogy a munkást összelapítják egy doboz segítségével.
	public abstract void die();

	public abstract boolean isCrate();
}
