package blacJack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class baraja {

	public static void main(String[] args) {
		
		ArrayList<carta> barajas = new ArrayList<carta>();
		int baraja=8;
		
		carta tA = new carta("T", "A", 11);		barajas.add(tA);
		carta t2 = new carta("T", "2", 2);		barajas.add(t2);
		carta t3 = new carta("T", "3", 3);		barajas.add(t3);
		carta t4 = new carta("T", "4", 4);		barajas.add(t4);
		carta t5 = new carta("T", "5", 5);		barajas.add(t5);
		carta t6 = new carta("T", "6", 6);		barajas.add(t6);
		carta t7 = new carta("T", "7", 7);		barajas.add(t7);
		carta t8 = new carta("T", "8", 8);		barajas.add(t8);
		carta t9 = new carta("T", "9", 9);		barajas.add(t9);
		carta t10 = new carta("T", "10", 10);	barajas.add(t10);
		carta tJ = new carta("T", "J", 10);		barajas.add(tJ);	
		carta tQ = new carta("T", "Q", 10);		barajas.add(tQ);	
		carta tK = new carta("T", "K", 10);		barajas.add(tK);
		
		
		carta cA = new carta("C", "A", 11);		barajas.add(cA);	
		carta c2 = new carta("C", "2", 2);		barajas.add(c2);
		carta c3 = new carta("C", "3", 3);		barajas.add(c3);
		carta c4 = new carta("C", "4", 4);		barajas.add(c4);
		carta c5 = new carta("C", "5", 5);		barajas.add(c5);
		carta c6 = new carta("C", "6", 6);		barajas.add(c6);
		carta c7 = new carta("C", "7", 7);		barajas.add(c7);
		carta c8 = new carta("C", "8", 8);		barajas.add(c8);
		carta c9 = new carta("C", "9", 9);		barajas.add(c9);
		carta c10 = new carta("C", "10", 10);	barajas.add(c10);
		carta cJ = new carta("C", "J", 10);		barajas.add(cJ);
		carta cQ = new carta("C", "Q", 10);		barajas.add(cQ);
		carta cK = new carta("C", "K", 10);		barajas.add(cK);
		
		
		carta dA = new carta("D", "A", 11);		barajas.add(dA);
		carta d2 = new carta("D", "2", 2);		barajas.add(d2);
		carta d3 = new carta("D", "3", 3);		barajas.add(d3);
		carta d4 = new carta("D", "4", 4);		barajas.add(d4);
		carta d5 = new carta("D", "5", 5);		barajas.add(d5);
		carta d6 = new carta("D", "6", 6);		barajas.add(d6);
		carta d7 = new carta("D", "7", 7);		barajas.add(d7);
		carta d8 = new carta("D", "8", 8);		barajas.add(d8);
		carta d9 = new carta("D", "9", 9);		barajas.add(d9);
		carta d10 = new carta("D", "10", 10);	barajas.add(d10);
		carta dJ = new carta("D", "J", 10);		barajas.add(dJ);
		carta dQ = new carta("D", "Q", 10);		barajas.add(dQ);
		carta dK = new carta("D", "K", 10);		barajas.add(dK);
		
		
		carta pA = new carta("P", "A", 11);		barajas.add(pA);
		carta p2 = new carta("P", "2", 2);		barajas.add(p2);
		carta p3 = new carta("P", "3", 3);		barajas.add(p3);
		carta p4 = new carta("P", "4", 4);		barajas.add(p4);
		carta p5 = new carta("P", "5", 5);		barajas.add(p5);
		carta p6 = new carta("P", "6", 6);		barajas.add(p6);
		carta p7 = new carta("P", "7", 7);		barajas.add(p7);
		carta p8 = new carta("P", "8", 8);		barajas.add(p8);
		carta p9 = new carta("P", "9", 9);		barajas.add(p9);
		carta p10 = new carta("P", "10", 10);	barajas.add(p10);
		carta pJ = new carta("P", "J", 10);		barajas.add(pJ);
		carta pQ = new carta("P", "Q", 10);		barajas.add(pQ);
		carta pK = new carta("P", "K", 10);		barajas.add(pK);	
	
		
		try {
			FileOutputStream fos = new FileOutputStream("carta.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);	

				for(int i=0; i<baraja; i++) {
					for(int j=0; j<barajas.size(); j++) {
						oos.writeObject(barajas.get(j));
					}
				}
			
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
