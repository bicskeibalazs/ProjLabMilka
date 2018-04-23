import java.io.FileWriter;
import java.io.IOException;

//Képes arra, hogy egy adott irányba mozogjon, és meghaljon. Munkásokat reprezentálja a raktárban.
public class Worker extends Movable {

	private int strength;
	//A dolgozó életben van-e.
	private boolean alive;
	//Azt vizsgálja egy mozgás során, hogy őt tolták-e (egy ládával)
	//vagy ő az, aki az egész mozgás iterakciót kezdeményezte.
	private boolean beingPushed;
	// A dolgozó felhasználta-e már a nála lévő mézet.
	private boolean honeyDeployed;
	// A dolgozó felhasználta-e már a nála lévő olajat.
	private boolean oilDeployed;
	//A raktárat testesíti meg, ahol a munkások a ládákat tolják.
	private Warehouse warehouse;
	//A munkás színe
	private Color color;

	public Worker(Field f, Color c, Warehouse w) {
		color = c;
		field = f;
		f.setMovable(this);
		warehouse = w;
		warehouse.addWorker(c, this);
		strength = 5;
		alive = true;
		beingPushed = false;
		honeyDeployed = false;
		oilDeployed = false;
	}

	public boolean isCrate() {
		return false;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int s) {
		strength = s;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		color = c;
	}

	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean b) {
		alive = b;
	}

	public boolean getbeingPushed() {
		return beingPushed;
	}

	public void setbeingPushed(boolean b) {
		beingPushed = b;
	}

	public boolean getHoneyDeployed() {
		return honeyDeployed;
	}

	public void setHoneyDeployed(boolean b) {
		honeyDeployed = b;
	}

	public boolean getOilDeployed() {
		return oilDeployed;
	}
	//Létrehoz egy új Oil objektumot,
	//és beállítja a field-jének a surface attribútumára.
	public void DeployOil() {
		if (alive) {
			field.setSurface(new Oil(field));
			oilDeployed = true;
		}

	}
	
	// Létrehoz egy új Honey objektumot,
	//és beállítja a field-jének a surface attribútumára.
	public void DeployHoney() {
		if (alive) {
			field.setSurface(new Honey(field));
			honeyDeployed = true;
		}
	}

	public boolean isBeingPushed() {
		return beingPushed;
	}
	
	// A dolgozót az adott irányban szomszédos mezőre lépteti
	public void move(Direction d) {
		if (alive)
			this.getField().wantsToMoveFrom(d);
	}
	
	//Törli a dolgozót a saját mezőjéről (és a teljes raktárból).
	public void die() {
		alive = false;
	}

	public void setField(Field f) {
		field = f;
	}

	public Field getField() {
		return field;
	}

	public void printMovable(FileWriter output) throws IOException {
		output.write('W');
		output.write('/');
		if (color == Color.red)
			output.write('R');
		else
			output.write('B');
	}
}
