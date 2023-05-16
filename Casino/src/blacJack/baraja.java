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
		String f="";
		
		for(int i=0; i<4; i++) {
			if(i==0) {
				f="T";
			}else if(i==1) {
				f="C";
			}else if(i==2) {
				f="D";
			}else if(i==3) {
				f="P";
			}
			carta fA = new carta(f, "A", 11);		barajas.add(fA);
			carta f2 = new carta(f, "2", 2);		barajas.add(f2);
			carta f3 = new carta(f, "3", 3);		barajas.add(f3);
			carta f4 = new carta(f, "4", 4);		barajas.add(f4);
			carta f5 = new carta(f, "5", 5);		barajas.add(f5);
			carta f6 = new carta(f, "6", 6);		barajas.add(f6);
			carta f7 = new carta(f, "7", 7);		barajas.add(f7);
			carta f8 = new carta(f, "8", 8);		barajas.add(f8);
			carta f9 = new carta(f, "9", 9);		barajas.add(f9);
			carta f10 = new carta(f, "10", 10);		barajas.add(f10);
			carta fJ = new carta(f, "J", 10);		barajas.add(fJ);	
			carta fQ = new carta(f, "Q", 10);		barajas.add(fQ);	
			carta fK = new carta(f, "K", 10);		barajas.add(fK);
		}
		
	
		
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
		
		/*try {
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
		}*/
	}
}
