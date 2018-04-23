import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		
		 boolean istest = true;  
    		if (istest) System.out.println("Teszteset1 Halál, falhoz nyomás miatt \nTeszteset2 Kapcsoló deaktiválása \nTeszteset3 Láda mozgatása\nTeszteset4 Kapcsoló aktiválása" +
				"Teszteset5 Halál; lyukba érkezése következtében\nTeszteset6 Munkás mozog\nTeszteset7 Játékos pontot kap\nTeszteset8 " +
                        "Halál; kapcsoló aktiválódott\nTeszteset9 Láda lyukba esik\nTeszteset10 Játékost láda tolja\nTeszteset11 Munkás sikertelen mozgása\n" +
                       "Teszteset12 Olaj lerakása\nTeszteset13 Méz lerakása\n"); 
		
		
		Warehouse warehouse = new Warehouse();
		char inputchar;
		Color color;

		File f = new File("map.txt");
		FileReader input = new FileReader(f);

		Field actualField;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				inputchar = (char) input.read();
				inputchar = (char) input.read();
				switch (inputchar) {
				case 'H':
					warehouse.setField(i, j, new Hole());
					break;
				case 'F':
					warehouse.setField(i, j, new Field());
					break;
				case 'S':
					warehouse.setField(i, j, new Switch(input.read()));
					warehouse.addSwitch((Switch)warehouse.getField(i,j));
					break;
				case 'N':
					warehouse.setField(i, j, new NotSteppable());
					break;
				case 'K':
					warehouse.setField(i, j, new SwitchableHole(input.read()));
					warehouse.addSwitchableHole((SwitchableHole)warehouse.getField(i,j));
					break;
				case 'P':
					inputchar = (char) input.read();
					inputchar = (char) input.read();
					if (inputchar == 'B')
						warehouse.setField(i, j, new Pallet(Color.blue, warehouse));
					else
						warehouse.setField(i, j, new Pallet(Color.red, warehouse));
					break;

				default:
					break;
				}

				inputchar = (char) input.read();
				inputchar = (char) input.read();
				actualField = warehouse.getField(i, j);

				switch (inputchar) {
				case 'H':
					actualField.setSurface(new Honey(actualField));
					inputchar = (char) input.read();
					break;
				case 'O':
					actualField.setSurface(new Oil(actualField));
					break;
				case 'X':
					actualField.setSurface(new Surface(actualField));
					break;
				default:
					break;
				}

				inputchar = (char) input.read();
				inputchar = (char) input.read();
				switch (inputchar) {
				case 'W':
					inputchar = (char) input.read();
					inputchar = (char) input.read();
					if (inputchar == 'B')
						color = Color.blue;
					else
						color = Color.red;
					actualField.setMovable(new Worker(actualField, color, warehouse));
					break;
				case 'C':
					actualField.setMovable(new Crate(actualField, warehouse));
					break;
				default:
					break;
				}
				inputchar = (char) input.read();
			}
			inputchar = (char) input.read();
			inputchar = (char) input.read();
		}
		input.close();

		warehouse.connectSwitches();
		// System.out.println(warehouse.getWorker(Color.red));

		// neighbors beállítása
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				actualField = warehouse.getField(i, j);
				actualField.setNeighbors(Direction.up, warehouse.getField(i - 1, j));
				actualField.setNeighbors(Direction.right, warehouse.getField(i, j + 1));
				actualField.setNeighbors(Direction.down, warehouse.getField(i + 1, j));
				actualField.setNeighbors(Direction.left, warehouse.getField(i, j - 1));
			}
		}

		boolean exit = false;
		printToTxt(warehouse);
// TESZTELŐ MÓD
    if (istest){
      while(!exit) {
        	System.out.print("Piros jatekos erre mozog: ");
        	inputchar = (char) System.in.read();
        	switch(Character.toUpperCase(inputchar)) {
                  case 'W' : warehouse.getWorker(Color.red).move(Direction.up);
                             break;
                  case 'A' : warehouse.getWorker(Color.red).move(Direction.left);
                             break;
                  case 'S' : warehouse.getWorker(Color.red).move(Direction.down);
                             break;
                  case 'D' : warehouse.getWorker(Color.red).move(Direction.right);
                             break;
             	case 'Q' : if(!warehouse.getWorker(Color.red).getOilDeployed()) warehouse.getWorker(Color.red).DeployOil();
                             break;
                  case 'E' : if(!warehouse.getWorker(Color.red).getHoneyDeployed()) warehouse.getWorker(Color.red).DeployHoney();
                             break;
                  case 'X' : exit = true;
                             break;
                  default :  break;
              
            }
      	inputchar = (char) System.in.read();
       	inputchar = (char) System.in.read();
        	System.out.print("Kek jatekos erre mozog: ");
        	inputchar = (char) System.in.read();
        	switch(Character.toUpperCase(inputchar)) {
                  case 'W' : warehouse.getWorker(Color.blue).move(Direction.up);
                             break;
                  case 'A' : warehouse.getWorker(Color.blue).move(Direction.left);
                             break;
                  case 'S' : warehouse.getWorker(Color.blue).move(Direction.down);
                             break;
                  case 'D' : warehouse.getWorker(Color.blue).move(Direction.right);
                             break;
              	case 'Q' : if(!warehouse.getWorker(Color.blue).getOilDeployed()) warehouse.getWorker(Color.blue).DeployOil();
                             break;
                  case 'E' : if(!warehouse.getWorker(Color.blue).getHoneyDeployed()) warehouse.getWorker(Color.blue).DeployHoney();
                             break;
                  case 'X' : exit = true;
                             break;
                  default :  break;
              
            }
       	inputchar = (char) System.in.read();
            inputchar = (char) System.in.read();
          	printToTxt(warehouse);
	}
    }
    //JÁTÉK MÓD     
else  {    
               while (!exit) {
			inputchar = (char) System.in.read();
			switch (Character.toUpperCase(inputchar)) {
			case 'W':
				warehouse.getWorker(Color.red).move(Direction.up);
				break;
			case 'A':
				warehouse.getWorker(Color.red).move(Direction.left);
				break;
			case 'S':
				warehouse.getWorker(Color.red).move(Direction.down);
				break;
			case 'D':
				warehouse.getWorker(Color.red).move(Direction.right);
				break;
                  case 'Q': 
                        if(!warehouse.getWorker(Color.red).getOilDeployed()) warehouse.getWorker(Color.red).DeployOil();
                        break;
                  case 'E' : 
                        if(!warehouse.getWorker(Color.red).getHoneyDeployed()) warehouse.getWorker(Color.red).DeployHoney();
                        break;
                  case 'I':
				warehouse.getWorker(Color.blue).move(Direction.up);
				break;
			case 'J':
				warehouse.getWorker(Color.blue).move(Direction.left);
				break;
			case 'K':
				warehouse.getWorker(Color.blue).move(Direction.down);
				break;
			case 'L':
				warehouse.getWorker(Color.blue).move(Direction.right);
				break;
                  case 'U': 
                        if(!warehouse.getWorker(Color.blue).getOilDeployed()) warehouse.getWorker(Color.blue).DeployOil();
                        break;
                  case 'O' : 
                        if(!warehouse.getWorker(Color.blue).getHoneyDeployed()) warehouse.getWorker(Color.blue).DeployHoney();
                        break;
			case 'X':
				exit = true;
				break;
			default:
				break;

			}
			inputchar = (char) System.in.read();
			inputchar = (char) System.in.read();
			printToTxt(warehouse);
		}
	}
}         
		
	// Kiírás fáljba

	public static void printToTxt(Warehouse warehouse) throws IOException {
		FileWriter output = new FileWriter("outputmap.txt");
		Field actualField;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				actualField = warehouse.getField(i, j);
				output.write('[');
				actualField.printField(output);
				output.write(',');
				actualField.printSurface(output);
				output.write(',');
				actualField.printMovable(output);
				output.write(']');
			}
			output.write('\r');
			output.write('\n');
		}
		output.close();
		BufferedReader r = new BufferedReader(new FileReader("outputmap.txt"));
		String s = "", line = null;
		for (int rowcount = 0; (line = r.readLine()) != null; rowcount++)
		/* while ((line = r.readLine()) != null) */ {
			s += rowcount + " ";
			s += line;
			s += '\n';
		}
		System.out.print(s);
		r.close();
	}
}
