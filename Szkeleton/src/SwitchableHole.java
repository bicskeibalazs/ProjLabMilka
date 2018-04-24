import java.io.FileWriter;
import java.io.IOException;

//Lyukként vagy sima mezőként viselkedik. (Örökölt felelősség: ld. Hole.)
public class SwitchableHole extends Hole {
	
	//A kapcsolható lyukhoz tartozó kapcsoló.
	private Switch _switch;
	//A kapcsolható lyuk állapota. Lehet aktív vagy inaktív.
	private boolean state;
	private int number;

	public int getNumber() {
		return number;
	}

	public SwitchableHole(int n) {
		number = n;
		state = false;
	}

	public void setSwitch(Switch s) {
		_switch = s;
	}

	public Switch getSwitch() {
		return _switch;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean b) {
		state = b;
	}
	
	//A kapcsolható lyukat aktív állapotba helyezi.
	public void activate() {
		state = true;
		if (isOccupied()) {
			movable.die();
			movable.setField(null);
			movable = null;
		}
	}
	
	//A kapcsolható lyukat inaktív állapotba helyezi.
	public void deactivate() {
		state = false;
	}
	
	//Ha aktív állapotban van a kapcsolható lyuk,
	//akkor az erre a mezőre mozgó Movable-t megöli.
	//Ha inaktív állapotban van, akkor erre a mezőre lépteti a movable-t.
	public boolean wantsToMoveHere(Direction d, Movable m) {
		if (state)
			return true;
		else
			return inactiveMoveHere(d, m);
	}

	//Segédfüggvény, hogy inaktív állapotban mezőként viselkedjen a lyuk.
	private boolean inactiveMoveHere(Direction d, Movable m) {
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
	
	//Kiíró függvény
	public void printField(FileWriter output) throws IOException {
		if (state) output.write('H');
 	 	else 
		{
          		output.write('K');
       			output.write(number);
           	}
	}
}
