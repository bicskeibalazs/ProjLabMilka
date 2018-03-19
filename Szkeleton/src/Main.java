import java.util.Scanner;

public class Main {

    public static int callNumber; //Sz�molja, hogy milyen 'm�lyen' j�runk a f�ggv�nyh�v�sokban.
    //Minden h�v�s el�tt n�velni kell, ha k�zvetlen ut�na pedig cs�kkenteni.

    public static void main(String[] args) {

        while(true) {

        //V�ltoz�k inicializ�l�sa.
       callNumber = 0;
      Field f1 = new Field();
      Field f2 = new Field();
      Field f3 = new Field();
      Field f4 = new Field();
      Crate c1 = new Crate();
      Crate c2 = new Crate();
      Worker w = new Worker();
      Worker w2 = new Worker();
      Pallet p = new Pallet();
      SwitchableHole sh = new SwitchableHole();
      Switch s = new Switch();
      Hole h = new Hole();
      NotSteppable ns = new NotSteppable();
      
        //Use-case v�laszt�s.
        //sz�veg
        System.out.println("1 - L�da lyukba esik\n2 - L�da l�d�t tol\n3 - L�da embert tol(nem hal meg)\n"
        		+ "4 - L�da embert tol(meghal)\n5 - L�da embert tol raklapra(meghal)\n6- Kapcsolhat� lyuk deaktiv�l�sa\n"
        		+ "7 - Kapcsol� aktiv�l�s\n8 - Kapcsolhat� lyukon �ll�s k�zbeni hal�l(Worker)\n"
        		+ "9 - Kapcsol� lyukon �ll�s k�zbeni hal�l(Crate)\n10 - L�datol�s(mehet)\n11 - Dolgoz� lyukba mozog(meghal)\n"
        		+ "12 - Dolgozo mozog(sikeres)\n13 - Dolgoz� mozog(fal,nem siker�l)\n14 - Dolgoz� mozog(dolgoz�->dolgoz�,sikertelen)\n"
        		+ "15 - Dolgoz� l�d�t mozgat(Sikeres)\n16 - Dolgoz� l�d�t mozgat(Sikertelen)\n"
        		+ "Adja meg a v�laszott Use-case sz�m�t");
        //beolvas�s
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        //{Ki�rod, hogy mik a lehet�s�gek, a sz�muk, �s beolvasod a v�laszt�st. Minden use-case egy case a switchben.
        // Kell m�g egy eset, hogy ha nem megfelel� a bemenet.}
        //SWITCH-CASE-el megval�s�tott use-case v�laszt�s.
        //KIEG�SZ�TVE A LEGUTOLS� BEADOTT DOKSINKBAN, HOGY AZ ADOTT SZEKVENCI�K HOL VANNAK
        switch(input) {
        //11. oldal
        case 1:
        	//L�da lyukba esik
        	
        	
        	callNumber++;
            h.wantsToMoveHere(Direction.left, c1);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            c1.die();
            callNumber--;
            callNumber--;
        	break;
        
        case 2:
        	//L�da l�d�t tol
        	callNumber++;
            f4.wantsToMoveHere(Direction.right, c1);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.someoneMovesHere(Direction.right, c1, c2);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.getNeighbor(Direction.right);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f4.wantsToMoveHere(Direction.right, c2);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f4.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            c2.setField(f4);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f4.setMovable(c2);
            callNumber--;
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.setMovable(c1);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            c1.setField(f3);
            callNumber--;
            callNumber--;
            callNumber--;
            break;
            
        	
        case 3:
        	// L�da embert tol(nem hal meg)
        	callNumber++;
        	f1.wantsToMoveHere(Direction.left, c2);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.wantsToMoveHere(Direction.left, c1);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getNeighbor(Direction.left);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.wantsToMoveHere(Direction.left, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.setField(f3);
            callNumber--;
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.setMovable(c1);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            c1.setField(f2);
            callNumber--;
            callNumber--;
            callNumber--;
            break;
        	
        	
        	
        case 4:
        	// L�da embert tol(meghal)
        	callNumber++;
        	f1.wantsToMoveHere(Direction.left, c2);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.wantsToMoveHere(Direction.left, c1);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.someoneMovesHere(Direction.left, c1, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.setBeingPushed(true);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getNeighbor(Direction.left);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.wantsToMoveHere(Direction.left, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.someoneMovesHere(Direction.left, w, c2);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.isBeingPushed();
            callNumber--;
            callNumber--;
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.die();
            callNumber--;
            callNumber--;
            callNumber--;
            callNumber--;
            
        	break;
        case 5:
        	//L�da embert tol raklapra(meghal)
        	callNumber++;
        	f1.wantsToMoveHere(Direction.left, c2);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.wantsToMoveHere(Direction.left, c1);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.someoneMovesHere(Direction.left, c1, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.setBeingPushed(true);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f2.getNeighbor(Direction.left);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            p.wantsToMoveHere(Direction.left, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            p.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            p.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            p.someoneMovesHere(Direction.left, w, c2);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.isBeingPushed();
            callNumber--;
            callNumber--;
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.die();
            callNumber--;
            callNumber--;
            callNumber--;
            callNumber--;
        	break;
        	
        case 6:
        
        	//Kapcsolhat� lyuk deaktiv�l�sa
            callNumber++;
            w.move(Direction.right);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.getField();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f1.wantsToMoveFrom(Direction.right);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f1.getNeighbor(Direction.right);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.wantsToMoveHere(Direction.right, w);
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.getMovable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
        	s.someoneMovesHere(Direction.right, w, c1);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.getNeighbor(Direction.right);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            f3.wantsToMoveHere(Direction.right, c1);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            sh.deactivate();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.setMovable(w);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            w.setField(s);
            callNumber--;
            callNumber--;
            callNumber--;
            callNumber--;
            break;
            
            
        case 7:
        	//Kapcsol� aktiv�l�s
            callNumber++;
            s.wantsToMoveHere(Direction.left, c1); 
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.isOccupied();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.setMovable(c1);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            c1.setField(s);
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            s.getSwitchable();
            callNumber--;
            for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
            callNumber++;
            sh.activate();
            callNumber--;
            callNumber--;	
        	
            break;
        case 8:
        	//Kapcsolhat� lyukon �ll�s k�zbeni hal�l(Worker)
        	callNumber++;
        	sh.activate();
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	sh.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.die();
        	callNumber--;
            callNumber--;
        	
            break;
        case 9:
        	//Kapcsolhat� lyukon �ll�s k�zbeni hal�l(Crate)
        	callNumber++;
        	sh.activate();
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	sh.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	c1.die();
        	callNumber--;
            callNumber--;
            break;
        case 10:
        	//l�datol�s(mehet)
        	callNumber++;
        	f3.wantsToMoveHere(Direction.right, c1);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f3.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f3.setMovable(c1);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	c1.setField(f3);
        	callNumber--;
        	callNumber--;
        	break;
        	
        	
        case 11:
        	//Dolgoz� lyukba mozog(meghal)
        	
        	callNumber++;
        	w.move(Direction.down);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.down);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.down);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	h.wantsToMoveHere(Direction.down, w);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.die();
        	callNumber--;
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.setMovable(null);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	break;
        	
        	
        case 12:
        	//Dolgozo mozog(sikeres)
        	
        	callNumber++;
        	w.move(Direction.right);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.right);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.right);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.wantsToMoveHere(Direction.right, w);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.setMovable(w);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.setField(f2);
        	callNumber--;
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.setMovable(null);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	break;
        	
        case 13:
        	//Dolgoz� mozog(fal,nem siker�l)
        	callNumber++;
        	w.move(Direction.right);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.right);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.right);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	ns.wantsToMoveHere(Direction.right, w);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	break;
        
        case 14:
        	//Dolgoz� mozog(dolgoz�->dolgoz�,sikertelen)
        	callNumber++;
        	w.move(Direction.up);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.up);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.up);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.wantsToMoveHere(Direction.up, w);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.getMovable();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.someoneMovesHere(Direction.up, w, w2);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	break;
        	
        case 15:
        	//Dolgoz� l�d�t mozgat(Sikertelen)
        	callNumber++;
        	w.move(Direction.down);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.down);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.down);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.wantsToMoveHere(Direction.down, w);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.getMovable();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.someoneMovesHere(Direction.down, w, c1);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.isBeingPushed();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.getNeighbor(Direction.down);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f3.wantsToMoveHere(Direction.down, c1);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	break;
        	
        case 16:
        	//Dolgoz� l�d�t mozgat(Sikeres)
        	callNumber++;
        	w.move(Direction.up);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.getField();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.wantsToMoveFrom(Direction.up);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.getNeighbor(Direction.up);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.wantsToMoveHere(Direction.up, w);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.isOccupied();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.getMovable();
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.someoneMovesHere(Direction.up, w, c1);
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.getNeighbor(Direction.up);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f3.wantsToMoveHere(Direction.up, c1);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f2.setMovable(w);
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	w.setField(f2);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	for (int i = 0; i < Main.callNumber; i++) System.out.print("---");
        	callNumber++;
        	f1.setMovable(null);
        	callNumber--;
        	callNumber--;
        	callNumber--;
        	
        	break;
        	
        default:
        	System.out.println("�rv�nytelen sz�m");
        //A use-case-hez sz�ks�ges v�ltoz�k inicial�z�l�sa
    //    Write w = new Write();

        //Maga a use-case
        /*
        for(int i = 0; i < Main.callNumber; i++) System.out.print("---");
        System.out.print("Object of class: ");
        Main.callNumber++;
        w.foo();
        Main.callNumber--;

        Main.callNumber++;
        w.foo();
        Main.callNumber--;
         */
        //}
        }
        }
    }
}