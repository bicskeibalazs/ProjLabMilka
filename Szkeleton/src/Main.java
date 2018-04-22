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
					break;
				case 'N':
					warehouse.setField(i, j, new NotSteppable());
					break;
				case 'K':
					warehouse.setField(i, j, new SwitchableHole(input.read()));
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

		// neighbors be�ll�t�sa
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
		while (!exit) {
			System.out.print("Bemenet: ");
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
	// Ki�r�s f�ljba

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