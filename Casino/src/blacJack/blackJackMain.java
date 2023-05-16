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
		int contC=0, contJ=0;
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
			contJ=0;
			contC=0;
			
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
			
			System.out.println("Carta del crupier: ");
			o = (int)(Math.random()* a.size()-1 + 0);
			contC = contC + As(o, a);
			crupierValor = cartasJugadorCrupier(o, crupierValor, a);
			
			System.out.println("Tus cartas: ");
			o = (int)(Math.random()* a.size()-1 + 0);
			contJ = contJ + As(o, a);
			jugadorValor = cartasJugadorCrupier(o, jugadorValor, a);
			
			o = (int)(Math.random()* a.size()-1 + 0);
			contJ = contJ + As(o, a);
			jugadorValor = cartasJugadorCrupier(o, jugadorValor, a);
			System.out.println("[" + jugadorValor + "]");
			doblar=false;
			
			if(jugadorValor==21) {
				System.out.println("Carta del crupier: ");
				o = (int)(Math.random()* a.size()-1 + 0);
				crupierValor = cartasJugadorCrupier(o, crupierValor, a);
				
				System.out.println("[" + crupierValor + "]");
				if(crupierValor==21) {
					System.out.println("Empate");
					banca=banca+apuesta;
				}else {
					System.out.println("Black Jack!!!!");
					banca=banca+bote/2+bote*2;
					sigMano=true;
				}
			}else {
				do {
					System.out.println("1- Pedir carta");
					System.out.println("2- Plantarse");
					if(!doblar && apuesta<=banca) {
						System.out.println("3- Doblar apuesta");
						doblar=true;
					}
					
					try {
						suikeis=sc.nextInt();
						
						switch(suikeis){
						case 1:
							o = (int)(Math.random()* a.size()-1 + 0);
							contJ = contJ + As(o, a);
							jugadorValor = cartasJugadorCrupier(o, jugadorValor, a);
							
							while(jugadorValor>21 && contJ>0) {
								jugadorValor=jugadorValor-10;
								contJ--;
							}
							
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
								System.out.println("Carta del crupier: ");
								o = (int)(Math.random()* a.size()-1 + 0);
								contC = contC + As(o, a);
								crupierValor = cartasJugadorCrupier(o, crupierValor, a);
								
								while(crupierValor>21 && contC>0) {
									crupierValor=crupierValor-10;
									contC--;
								}
								
								System.out.println("[" + crupierValor + "]");
							}while(crupierValor<17);
							
							banca = ganancias(banca, bote, crupierValor, jugadorValor);
							
							sigMano=true;
							break;
							
						case 3:
							banca=banca-apuesta;
							bote=bote+apuesta;
							
							o = (int)(Math.random()* a.size()-1 + 0);
							contJ = contJ + As(o, a);
							jugadorValor = cartasJugadorCrupier(o, jugadorValor, a);
							
							while(jugadorValor>21 && contJ>0) {
								jugadorValor=jugadorValor-10;
								contJ--;
							}
							
							System.out.println("[" + jugadorValor + "]");
							
							if(jugadorValor>21) {
								System.out.println("Te has pasado");
							}else {
								do {
									System.out.println("Carta del crupier: ");
									o = (int)(Math.random()* a.size()-1 + 0);
									contC = contC + As(o, a);
									crupierValor = cartasJugadorCrupier(o, crupierValor, a);
									
									while(crupierValor>21 && contC>0) {
										crupierValor=crupierValor-10;
										contC--;
									}
									
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
						System.out.println("Error");
						banca=banca+apuesta;
						sigMano=true;
					}
				}while(!sigMano);
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
				}while(!SiNo);
			}
			
		}while(!ronda);
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
	
	
	public static int cartasJugadorCrupier(int o, int jugadorCrupierValor, ArrayList<carta> a) {
		System.out.println(a.get(o));
		jugadorCrupierValor=jugadorCrupierValor+a.get(o).getValor();
		a.remove(o);
		return jugadorCrupierValor;
	}
	
	
	public static int As(int as, ArrayList<carta> a) {
		if(a.get(as).getNumero().equals("A")) {
			return 1;
		}else {
			return 0;
		}
	}
	
}
