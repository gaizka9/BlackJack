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
		
		int o=0, crupierValor=0, jugadorValor=0, banca=1000, bote=0, suikeis, apuesta;
		String segJug ;
		boolean sigMano = false;
		boolean doblar = false;
		boolean SiNo = false;
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
		
		ArrayList b = (ArrayList) a.clone(); 
		
		do {
			if(a.size()<16) {
				a.clear();
				a = (ArrayList) b.clone(); 
			}
			
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
			
			
			crupierValor = cartasCrupier(o, crupierValor, a);
			
			System.out.println("Tus cartas: ");
			jugadorValor = cartasJugador(o, jugadorValor, a);
			
			jugadorValor = cartasJugador(o, jugadorValor, a);
			System.out.println("[" + jugadorValor + "]");
			doblar=false;
			
			if(jugadorValor==21) {
				crupierValor = cartasCrupier(o, crupierValor, a);
				System.out.println("[" + crupierValor + "]");
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
					
					try {
						suikeis=sc.nextInt();
						
						switch(suikeis){
						case 1:
							jugadorValor = cartasJugador(o, jugadorValor, a);
							System.out.println("[" + jugadorValor + "]");
							
							if(jugadorValor>21) {
								System.out.println("Te has pasado");
								sigMano=true;
							}else {
								sigMano=false;
							}
							break;
							
						case 2:
							do {
								crupierValor = cartasCrupier(o, crupierValor, a);
								System.out.println("[" + crupierValor + "]");
							}while(crupierValor<17);
							
							banca = ganancias(banca, bote, crupierValor, jugadorValor);
							
							sigMano=true;
							break;
							
						case 3:
							banca=banca-apuesta;
							bote=bote+apuesta;
							
							jugadorValor = cartasJugador(o, jugadorValor, a);
							System.out.println("[" + jugadorValor + "]");
							
							if(jugadorValor>21) {
								System.out.println("Te has pasado");
							}else {
								do {
									crupierValor = cartasCrupier(o, crupierValor, a);
									System.out.println("[" + crupierValor + "]");
								}while(crupierValor<17);
								
								banca = ganancias(banca, bote, crupierValor, jugadorValor);						}
							
							sigMano=true;
							break;	
						default: 
							System.out.println("Esa opcion no es valida");
							System.out.println("Apuesta anulada");
							banca=banca+apuesta;
							sigMano=true;
							break;
						}
					}catch(Exception e){
						System.out.print("Error");
						sigMano=true;
					}
				}while(sigMano!=true);
			}

			System.out.println("Tu banca: " + banca);
			if(banca==0) {
				System.out.println("Has perdido todo tu dinero puto ludopata");
				ronda=true;
			}else {
				do {
					System.out.println("Jugar otra ronda? (S/N)");
					segJug=sc.next();
				
					if(segJug.equalsIgnoreCase("S")) {
						ronda=false;
						SiNo=true;
					}else if(segJug.equalsIgnoreCase("N")){
						ronda=true;
						SiNo=true;
					}else {
						SiNo=false;
					}
				}while(SiNo!=true);
			}
			
		}while(ronda!=true);
		sc.close();
	}
	
	public static int ganancias(int ganancias, int bote, int crupierValor, int jugadorValor) {
		if(crupierValor>21) {
			System.out.println("Has ganado");
			ganancias=ganancias+bote*2;
		}else {
			if(jugadorValor<crupierValor) {
				System.out.println("Has perdido");
			}else if(jugadorValor>crupierValor) {
				System.out.println("Has ganado");
				ganancias=ganancias+bote*2;
			}else if(jugadorValor==crupierValor) {
				System.out.println("Empate");
				ganancias=ganancias+bote;
			} 
		}
		return ganancias;
	}
	
	public static int cartasCrupier(int o, int crupierValor, ArrayList<carta> a) {
		o = (int)(Math.random()* a.size()-1 + 0);
		System.out.println("Carta del crupier: " + a.get(o));
		crupierValor=crupierValor+a.get(o).getValor();
		a.remove(o);
		return crupierValor;
		
	}
	
	public static int cartasJugador(int o, int jugadorValor, ArrayList<carta> a) {
		o = (int)(Math.random()* a.size()-1 + 0);
		System.out.println(a.get(o));
		jugadorValor=jugadorValor+a.get(o).getValor();
		a.remove(o);
		return jugadorValor;
		
	}
}
