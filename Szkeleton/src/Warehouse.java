import java.util.ArrayList;
import java.util.HashMap;

//A raktárat reprezentálja.
public class Warehouse {
	
	//A dolgozókat reprezentálja a raktárban.
	private HashMap<Color, Worker> workers;
	//A ládák a raktárban
	private ArrayList<Crate> crates;
	//Kapcsolók a raktárban
	private ArrayList<Switch> switches;
	//Kapcsolható lyukak a raktárban
	private ArrayList<SwitchableHole> switchableHoles;
	//Egy dolgozó pontjainak száma. (Piros, kék)
	private HashMap<Color, Integer> points;
	//A raktár mezői a megfelelő sorrendben
	private Field fields[][];
	
	//Felvesz egy munkást, színnel együtt
	public void addWorker(Color c, Worker w) {
		workers.put(c, w);
	}
	
	//Hozzáad egy új ládát
	public void addCrate(Crate c) {
		crates.add(c);
	}
	
	//Hozzáad egy kapcsolót
	public void addSwitch(Switch s){
        	switches.add(s);
      }
  
  	public void addSwitchableHole(SwitchableHole sw){
        	switchableHoles.add(sw);
      }

	public Field getField(int i, int j) {
		return fields[i][j];
	}

	public void setField(int i, int j, Field f) {
		fields[i][j] = f;
	}

	public void setSwitches(int i, Switch s) {
		switches.set(i, s);
	}

	public void setSwitchableHoles(int i, SwitchableHole sh) {
		switchableHoles.set(i, sh);
	}

	public Switch getSwitch(int i) {
		return switches.get(i);
	}

	public SwitchableHole getSwtichableHoles(int i) {
		return switchableHoles.get(i);
	}

	public Worker getWorker(Color c) {
		return workers.get(c);
	}

	public Warehouse() {
		fields = new Field[12][12];
		crates = new ArrayList<Crate>();
		switches = new ArrayList<Switch>();
		switchableHoles = new ArrayList<SwitchableHole>();
		workers = new HashMap<Color, Worker>();
		points = new HashMap<Color, Integer>();
		points.put(Color.blue, 0);
		points.put(Color.red, 0);
	}
	
	//Összekapcsolása a kapcsolható lyukak és a kapcsolóknak
	public void connectSwitches() {
		Switch s;
		SwitchableHole sh;
		for (int i = 0; i < switches.size(); i++) {
			for (int j = 0; j < switchableHoles.size(); j++) {
				s = switches.get(i);
				sh = switchableHoles.get(j);
				if (s.getNumber() == sh.getNumber()) {
					s.setSwitchableHole(sh);
					sh.setSwitch(s);
				}
			}
		}
	}
	
	//A dolgozó pontjának számát növeli eggyel.
	public void addPoint(Color c) {
		int i = points.get(c);
		points.remove(c);
		points.put(c, i + 1);
	}

	public int getPoints(Color c) {
		return points.get(c);
	}
	
	//Töröl egy ládát.
	public void deleteCrate(Crate c) {
		crates.remove(c);
	}
}
