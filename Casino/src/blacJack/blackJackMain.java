package blacJack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class blackJackMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		carta f = new carta();
		
		int o, crupierValor=0, jugadorValor=0, banca=1000, bote=0, suikeis, apuesta;
		String segJug ;
		boolean sigMano = false;
		boolean doblar = false;
		boolean dividir = false;
		boolean ronda = false;
		ArrayList<carta> a = new ArrayList<carta>();
		
				
		try {
			FileInputStream fis = new FileInputStream("carta.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (fis.available() > 0) {
				f = (carta) ois.readObject();
				a.add(f);
			}

			ois.close();
			fis.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error archivo no encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error de Entrada / Salida");
		} catch (InputMismatchException cnfe) {
			System.out.println("Error. Zenbaki bat sartu behar duzu");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error Clase No Encontrada");
		}
		
		
		do {
			bote=0;
			jugadorValor=0;
			crupierValor=0;
			
			System.out.println("Tu banca: " + banca);
			System.out.println("Cuanto quieres apostar?");
			apuesta=sc.nextInt();
			while(apuesta>banca) {
				System.out.println("No tienes tanto dinero");
				System.out.println("Cuanto quieres apostar?");
				apuesta=sc.nextInt();
			}
			banca=banca-apuesta;
			bote=bote+apuesta;
			
			o = (int)(Math.random()* a.size()-1 + 0);
			System.out.println("Primera carta del crupier: " + a.get(o));
			crupierValor=crupierValor+a.get(o).getValor();
			a.remove(o);
			
			o = (int)(Math.random()* a.size()-1 + 0);
			System.out.println("Tus cartas: ");
			System.out.println(a.get(o));
			jugadorValor=jugadorValor+a.get(o).getValor();
			a.remove(o);
			o = (int)(Math.random()* a.size()-1 + 0);
			System.out.println(a.get(o));
			jugadorValor=jugadorValor+a.get(o).getValor();
			a.remove(o);
			System.out.println(jugadorValor);
			doblar=false;
			
			if(jugadorValor==21) {
				o = (int)(Math.random()* a.size()-1 + 0);
				System.out.println("Carta del crupier: " + a.get(o));
				crupierValor=crupierValor+a.get(o).getValor();
				a.remove(o);
				System.out.println(crupierValor);
				if(crupierValor==21) {
					System.out.println("Empate");
				}else {
					System.out.println("Black Jack!!!!");
					banca=banca+bote/2+bote*2;
					sigMano=true;
				}
			}else {
				do {
					System.out.println("1- Pedir carta");
					System.out.println("2- Plantarse");
					if(doblar!=true && apuesta<=banca) {
						System.out.println("3- Doblar apuesta");
						doblar=true;
					}
					
						System.out.println("4- Dividir cartas");
						dividir=true;
					
					
					
					suikeis=sc.nextInt();
					switch(suikeis){
					case 1:
						o = (int)(Math.random()* a.size()-1 + 0);
						System.out.println(a.get(o));
						jugadorValor=jugadorValor+a.get(o).getValor();
						System.out.println(jugadorValor);
						a.remove(o);
						if(jugadorValor>21) {
							System.out.println("Te has pasado");
							sigMano=true;
						}else {
							sigMano=false;
						}
						break;
						
					case 2:
						do {
							o = (int)(Math.random()* a.size()-1 + 0);
							System.out.println("Carta del crupier: " + a.get(o));
							crupierValor=crupierValor+a.get(o).getValor();
							a.remove(o);
							System.out.println(crupierValor);
						}while(crupierValor<17);
						
						if(crupierValor>21) {
							System.out.println("Has ganado");
							banca=banca+bote*2;
						}else {
							if(jugadorValor<crupierValor) {
								System.out.println("Has perdido");
							}else if(jugadorValor>crupierValor) {
								System.out.println("Has ganado");
								banca=banca+bote*2;
							}else if(jugadorValor==crupierValor) {
								System.out.println("Empate");
								banca=banca+bote;
							} 
						}
						sigMano=true;
						break;
						
					case 3:
						banca=banca-apuesta;
						bote=bote+apuesta;
						
						o = (int)(Math.random()* a.size()-1 + 0);
						System.out.println(a.get(o));
						jugadorValor=jugadorValor+a.get(o).getValor();
						System.out.println(jugadorValor);
						a.remove(o);
						
						if(jugadorValor>21) {
							System.out.println("Te has pasado");
						}else {
							do {
								o = (int)(Math.random()* a.size()-1 + 0);
								System.out.println("Carta del crupier: " + a.get(o));
								crupierValor=crupierValor+a.get(o).getValor();
								a.remove(o);
								System.out.println(crupierValor);
							}while(crupierValor<17);
							
							if(crupierValor>21) {
								System.out.println("Has ganado");
								banca=banca+bote*2;
							}else {
								if(jugadorValor<crupierValor) {
									System.out.println("Has perdido");
								}else if(jugadorValor>crupierValor) {
									System.out.println("Has ganado");
									banca=banca+bote*2;
								}else if(jugadorValor==crupierValor) {
									System.out.println("Empate");
									banca=banca+bote;
								} 
							}
						}
						
						sigMano=true;
						break;	
					default: 
						System.out.println("Esa opcion no es valida");
					}
				}while(sigMano!=true);
			}

			System.out.println("Tu banca: " + banca);
			if(banca==0) {
				System.out.println("Has perdido todo tu dinero puto ludopata");
				ronda=true;
			}else {
				System.out.println("Jugar otra ronda? (S/N)");
				segJug=sc.next();
				if(segJug.equalsIgnoreCase("S")) {
					ronda=false;
				}else {
					ronda=true;
				}
			}
			
		}while(ronda!=true);
		sc.close();
	}
}
