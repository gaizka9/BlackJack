package blacJack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class baraja {

	public static void main(String[] args) {
						
		carta tA = new carta("T", "A", 11);		
		carta t2 = new carta("T", "2", 2);		
		carta t3 = new carta("T", "3", 3);		
		carta t4 = new carta("T", "4", 4);		
		carta t5 = new carta("T", "5", 5);		
		carta t6 = new carta("T", "6", 6);		
		carta t7 = new carta("T", "7", 7);		
		carta t8 = new carta("T", "8", 8);		
		carta t9 = new carta("T", "9", 9);		
		carta t10 = new carta("T", "10", 10);	
		carta tJ = new carta("T", "J", 10);			
		carta tQ = new carta("T", "Q", 10);			
		carta tK = new carta("T", "K", 10);		
		
		
		carta cA = new carta("C", "A", 11);			
		carta c2 = new carta("C", "2", 2);		
		carta c3 = new carta("C", "3", 3);		
		carta c4 = new carta("C", "4", 4);		
		carta c5 = new carta("C", "5", 5);		
		carta c6 = new carta("C", "6", 6);		
		carta c7 = new carta("C", "7", 7);		
		carta c8 = new carta("C", "8", 8);		
		carta c9 = new carta("C", "9", 9);		
		carta c10 = new carta("C", "10", 10);	
		carta cJ = new carta("C", "J", 10);			
		carta cQ = new carta("C", "Q", 10);			
		carta cK = new carta("C", "K", 10);		
		
		
		carta dA = new carta("D", "A", 11);		
		carta d2 = new carta("D", "2", 2);		
		carta d3 = new carta("D", "3", 3);		
		carta d4 = new carta("D", "4", 4);		
		carta d5 = new carta("D", "5", 5);		
		carta d6 = new carta("D", "6", 6);		
		carta d7 = new carta("D", "7", 7);		
		carta d8 = new carta("D", "8", 8);		
		carta d9 = new carta("D", "9", 9);		
		carta d10 = new carta("D", "10", 10);		
		carta dJ = new carta("D", "J", 10);			
		carta dQ = new carta("D", "Q", 10);				
		carta dK = new carta("D", "K", 10);			
		
		
		carta pA = new carta("P", "A", 11);		
		carta p2 = new carta("P", "2", 2);		
		carta p3 = new carta("P", "3", 3);		
		carta p4 = new carta("P", "4", 4);			
		carta p5 = new carta("P", "5", 5);		
		carta p6 = new carta("P", "6", 6);		
		carta p7 = new carta("P", "7", 7);		
		carta p8 = new carta("P", "8", 8);		
		carta p9 = new carta("P", "9", 9);		
		carta p10 = new carta("P", "10", 10);	
		carta pJ = new carta("P", "J", 10);			
		carta pQ = new carta("P", "Q", 10);			
		carta pK = new carta("P", "K", 10);			
	
		
		try {
			FileOutputStream fos = new FileOutputStream("carta.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);	

			//Baraja 1				//Baraja 2				//Baraja 3				//Baraja 4				
			oos.writeObject(tA);	oos.writeObject(tA);	oos.writeObject(tA);	oos.writeObject(tA);	
			oos.writeObject(t2);	oos.writeObject(t2);	oos.writeObject(t2);	oos.writeObject(t2);	
			oos.writeObject(t3);	oos.writeObject(t3);	oos.writeObject(t3);	oos.writeObject(t3);	
			oos.writeObject(t4);	oos.writeObject(t4);	oos.writeObject(t4);	oos.writeObject(t4);	
			oos.writeObject(t5);	oos.writeObject(t5);	oos.writeObject(t5);	oos.writeObject(t5);	
			oos.writeObject(t6);	oos.writeObject(t6);	oos.writeObject(t6);	oos.writeObject(t6);	
			oos.writeObject(t7);	oos.writeObject(t7);	oos.writeObject(t7);	oos.writeObject(t7);	
			oos.writeObject(t8);	oos.writeObject(t8);	oos.writeObject(t8);	oos.writeObject(t8);	
			oos.writeObject(t9);	oos.writeObject(t9);	oos.writeObject(t9);	oos.writeObject(t9);	
			oos.writeObject(t10);	oos.writeObject(t10);	oos.writeObject(t10);	oos.writeObject(t10);	
			oos.writeObject(tJ);	oos.writeObject(tJ);	oos.writeObject(tJ);	oos.writeObject(tJ);	
			oos.writeObject(tQ);	oos.writeObject(tQ);	oos.writeObject(tQ);	oos.writeObject(tQ);	
			oos.writeObject(tK);	oos.writeObject(tK);	oos.writeObject(tK);	oos.writeObject(tK);	

			oos.writeObject(cA);	oos.writeObject(cA);	oos.writeObject(cA);	oos.writeObject(cA);	
			oos.writeObject(c2);	oos.writeObject(c2);	oos.writeObject(c2);	oos.writeObject(c2);	
			oos.writeObject(c3);	oos.writeObject(c3);	oos.writeObject(c3);	oos.writeObject(c3);	
			oos.writeObject(c4);	oos.writeObject(c4);	oos.writeObject(c4);	oos.writeObject(c4);	
			oos.writeObject(c5);	oos.writeObject(c5);	oos.writeObject(c5);	oos.writeObject(c5);	
			oos.writeObject(c6);	oos.writeObject(c6);	oos.writeObject(c6);	oos.writeObject(c6);	
			oos.writeObject(c7);	oos.writeObject(c7);	oos.writeObject(c7);	oos.writeObject(c7);	
			oos.writeObject(c8);	oos.writeObject(c8);	oos.writeObject(c8);	oos.writeObject(c8);	
			oos.writeObject(c9);	oos.writeObject(c9);	oos.writeObject(c9);	oos.writeObject(c9);	
			oos.writeObject(c10);	oos.writeObject(c10);	oos.writeObject(c10);	oos.writeObject(c10);	
			oos.writeObject(cJ);	oos.writeObject(cJ);	oos.writeObject(cJ);	oos.writeObject(cJ);	
			oos.writeObject(cQ);	oos.writeObject(cQ);	oos.writeObject(cQ);	oos.writeObject(cQ);	
			oos.writeObject(cK);	oos.writeObject(cK);	oos.writeObject(cK);	oos.writeObject(cK);	
			
			oos.writeObject(dA);	oos.writeObject(dA);	oos.writeObject(dA);	oos.writeObject(dA);	
			oos.writeObject(d2);	oos.writeObject(d2);	oos.writeObject(d2);	oos.writeObject(d2);	
			oos.writeObject(d3);	oos.writeObject(d3);	oos.writeObject(d3);	oos.writeObject(d3);	
			oos.writeObject(d4);	oos.writeObject(d4);	oos.writeObject(d4);	oos.writeObject(d4);	
			oos.writeObject(d5);	oos.writeObject(d5);	oos.writeObject(d5);	oos.writeObject(d5);	
			oos.writeObject(d6);	oos.writeObject(d6);	oos.writeObject(d6);	oos.writeObject(d6);	
			oos.writeObject(d7);	oos.writeObject(d7);	oos.writeObject(d7);	oos.writeObject(d7);	
			oos.writeObject(d8);	oos.writeObject(d8);	oos.writeObject(d8);	oos.writeObject(d8);	
			oos.writeObject(d9);	oos.writeObject(d9);	oos.writeObject(d9);	oos.writeObject(d9);	
			oos.writeObject(d10);	oos.writeObject(d10);	oos.writeObject(d10);	oos.writeObject(d10);	
			oos.writeObject(dJ);	oos.writeObject(dJ);	oos.writeObject(dJ);	oos.writeObject(dJ);	
			oos.writeObject(dQ);	oos.writeObject(dQ);	oos.writeObject(dQ);	oos.writeObject(dQ);	
			oos.writeObject(dK);	oos.writeObject(dK);	oos.writeObject(dK);	oos.writeObject(dK);	
			
			oos.writeObject(pA);	oos.writeObject(pA);	oos.writeObject(pA);	oos.writeObject(pA);	
			oos.writeObject(p2);	oos.writeObject(p2);	oos.writeObject(p2);	oos.writeObject(p2);	
			oos.writeObject(p3);	oos.writeObject(p3);	oos.writeObject(p3);	oos.writeObject(p3);	
			oos.writeObject(p4);	oos.writeObject(p4);	oos.writeObject(p4);	oos.writeObject(p4);	
			oos.writeObject(p5);	oos.writeObject(p5);	oos.writeObject(p5);	oos.writeObject(p5);	
			oos.writeObject(p6);	oos.writeObject(p6);	oos.writeObject(p6);	oos.writeObject(p6);	
			oos.writeObject(p7);	oos.writeObject(p7);	oos.writeObject(p7);	oos.writeObject(p7);	
			oos.writeObject(p8);	oos.writeObject(p8);	oos.writeObject(p8);	oos.writeObject(p8);	
			oos.writeObject(p9);	oos.writeObject(p9);	oos.writeObject(p9);	oos.writeObject(p9);	
			oos.writeObject(p10);	oos.writeObject(p10);	oos.writeObject(p10);	oos.writeObject(p10);	
			oos.writeObject(pJ);	oos.writeObject(pJ);	oos.writeObject(pJ);	oos.writeObject(pJ);	
			oos.writeObject(pQ);	oos.writeObject(pQ);	oos.writeObject(pQ);	oos.writeObject(pQ);	
			oos.writeObject(pK);	oos.writeObject(pK);	oos.writeObject(pK);	oos.writeObject(pK);
			
			
			//Baraja 5				//Baraja 6				//Baraja 7				//Baraja 8				
			oos.writeObject(tA);	oos.writeObject(tA);	oos.writeObject(tA);	oos.writeObject(tA);	
			oos.writeObject(t2);	oos.writeObject(t2);	oos.writeObject(t2);	oos.writeObject(t2);	
			oos.writeObject(t3);	oos.writeObject(t3);	oos.writeObject(t3);	oos.writeObject(t3);	
			oos.writeObject(t4);	oos.writeObject(t4);	oos.writeObject(t4);	oos.writeObject(t4);	
			oos.writeObject(t5);	oos.writeObject(t5);	oos.writeObject(t5);	oos.writeObject(t5);	
			oos.writeObject(t6);	oos.writeObject(t6);	oos.writeObject(t6);	oos.writeObject(t6);	
			oos.writeObject(t7);	oos.writeObject(t7);	oos.writeObject(t7);	oos.writeObject(t7);	
			oos.writeObject(t8);	oos.writeObject(t8);	oos.writeObject(t8);	oos.writeObject(t8);	
			oos.writeObject(t9);	oos.writeObject(t9);	oos.writeObject(t9);	oos.writeObject(t9);	
			oos.writeObject(t10);	oos.writeObject(t10);	oos.writeObject(t10);	oos.writeObject(t10);	
			oos.writeObject(tJ);	oos.writeObject(tJ);	oos.writeObject(tJ);	oos.writeObject(tJ);	
			oos.writeObject(tQ);	oos.writeObject(tQ);	oos.writeObject(tQ);	oos.writeObject(tQ);	
			oos.writeObject(tK);	oos.writeObject(tK);	oos.writeObject(tK);	oos.writeObject(tK);	

			oos.writeObject(cA);	oos.writeObject(cA);	oos.writeObject(cA);	oos.writeObject(cA);	
			oos.writeObject(c2);	oos.writeObject(c2);	oos.writeObject(c2);	oos.writeObject(c2);	
			oos.writeObject(c3);	oos.writeObject(c3);	oos.writeObject(c3);	oos.writeObject(c3);	
			oos.writeObject(c4);	oos.writeObject(c4);	oos.writeObject(c4);	oos.writeObject(c4);	
			oos.writeObject(c5);	oos.writeObject(c5);	oos.writeObject(c5);	oos.writeObject(c5);	
			oos.writeObject(c6);	oos.writeObject(c6);	oos.writeObject(c6);	oos.writeObject(c6);	
			oos.writeObject(c7);	oos.writeObject(c7);	oos.writeObject(c7);	oos.writeObject(c7);	
			oos.writeObject(c8);	oos.writeObject(c8);	oos.writeObject(c8);	oos.writeObject(c8);	
			oos.writeObject(c9);	oos.writeObject(c9);	oos.writeObject(c9);	oos.writeObject(c9);	
			oos.writeObject(c10);	oos.writeObject(c10);	oos.writeObject(c10);	oos.writeObject(c10);	
			oos.writeObject(cJ);	oos.writeObject(cJ);	oos.writeObject(cJ);	oos.writeObject(cJ);	
			oos.writeObject(cQ);	oos.writeObject(cQ);	oos.writeObject(cQ);	oos.writeObject(cQ);	
			oos.writeObject(cK);	oos.writeObject(cK);	oos.writeObject(cK);	oos.writeObject(cK);	
			
			oos.writeObject(dA);	oos.writeObject(dA);	oos.writeObject(dA);	oos.writeObject(dA);	
			oos.writeObject(d2);	oos.writeObject(d2);	oos.writeObject(d2);	oos.writeObject(d2);	
			oos.writeObject(d3);	oos.writeObject(d3);	oos.writeObject(d3);	oos.writeObject(d3);	
			oos.writeObject(d4);	oos.writeObject(d4);	oos.writeObject(d4);	oos.writeObject(d4);	
			oos.writeObject(d5);	oos.writeObject(d5);	oos.writeObject(d5);	oos.writeObject(d5);	
			oos.writeObject(d6);	oos.writeObject(d6);	oos.writeObject(d6);	oos.writeObject(d6);	
			oos.writeObject(d7);	oos.writeObject(d7);	oos.writeObject(d7);	oos.writeObject(d7);	
			oos.writeObject(d8);	oos.writeObject(d8);	oos.writeObject(d8);	oos.writeObject(d8);	
			oos.writeObject(d9);	oos.writeObject(d9);	oos.writeObject(d9);	oos.writeObject(d9);	
			oos.writeObject(d10);	oos.writeObject(d10);	oos.writeObject(d10);	oos.writeObject(d10);	
			oos.writeObject(dJ);	oos.writeObject(dJ);	oos.writeObject(dJ);	oos.writeObject(dJ);	
			oos.writeObject(dQ);	oos.writeObject(dQ);	oos.writeObject(dQ);	oos.writeObject(dQ);	
			oos.writeObject(dK);	oos.writeObject(dK);	oos.writeObject(dK);	oos.writeObject(dK);	
			
			oos.writeObject(pA);	oos.writeObject(pA);	oos.writeObject(pA);	oos.writeObject(pA);	
			oos.writeObject(p2);	oos.writeObject(p2);	oos.writeObject(p2);	oos.writeObject(p2);	
			oos.writeObject(p3);	oos.writeObject(p3);	oos.writeObject(p3);	oos.writeObject(p3);	
			oos.writeObject(p4);	oos.writeObject(p4);	oos.writeObject(p4);	oos.writeObject(p4);	
			oos.writeObject(p5);	oos.writeObject(p5);	oos.writeObject(p5);	oos.writeObject(p5);	
			oos.writeObject(p6);	oos.writeObject(p6);	oos.writeObject(p6);	oos.writeObject(p6);	
			oos.writeObject(p7);	oos.writeObject(p7);	oos.writeObject(p7);	oos.writeObject(p7);	
			oos.writeObject(p8);	oos.writeObject(p8);	oos.writeObject(p8);	oos.writeObject(p8);	
			oos.writeObject(p9);	oos.writeObject(p9);	oos.writeObject(p9);	oos.writeObject(p9);	
			oos.writeObject(p10);	oos.writeObject(p10);	oos.writeObject(p10);	oos.writeObject(p10);	
			oos.writeObject(pJ);	oos.writeObject(pJ);	oos.writeObject(pJ);	oos.writeObject(pJ);	
			oos.writeObject(pQ);	oos.writeObject(pQ);	oos.writeObject(pQ);	oos.writeObject(pQ);	
			oos.writeObject(pK);	oos.writeObject(pK);	oos.writeObject(pK);	oos.writeObject(pK);
			// cierro los recursos abiertos
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Despu�s lee los datos del Fecha desde fechas.dat y 
		
		try {
			FileInputStream fis = new FileInputStream("carta.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// convierte los bytes le�dos en un objeto de la clase Fecha
			t2 = (carta) ois.readObject(); 
			t3 = (carta) ois.readObject(); 
			
			// muestra el valor del Fecha le�do por pantalla.
			System.out.println("carta 1 leido "+t2);
			System.out.println("carta 2 leido "+t3);
			// cierro los recursos abiertos
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no est� creado
			System.out.println("Error archivo carta.dat No encontrado.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error Clase No Encontrada");
		}
	}
}
