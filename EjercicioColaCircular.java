/*
 * PAREJA DE "LOS GARCÍA"
 * 
 * INTEGRANTES:
 * GARCÍA GACHUZO CONSTANZA
 * GARCÍA CAMACHO JAIME
 * 
 * EJERCICIO: COLA CIRCULAR
 * 
 * */
package Colas;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioColaCircular {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double resultado = 0,elem=0,totalmulti=1,totalresta=0,totaldiv=1,n=0;
		int Op2 = 0,Operarios=0,num=0;
		boolean Opp = false;
		String Opr = "",tmp="";
		DecimalFormat df = new DecimalFormat("#.00");
		do {
			do {				
			try {
			System.out.println("Bienvenido a este programa!\nEscribe tu operacion"
			+ "\n1) Suma (+)\n2) Resta (-)\n3) Multiplicacion (*)\n4) Division (/)\n5) Salir");
			Op2 = sc.nextInt();	
			num = 1;
			}catch (InputMismatchException e) {
				System.out.println("\nError! Ingresa un valor numerico\n");
				num = 0;
				sc.next();
			}
			} while (num == 0);
			try {
			switch (Op2) {
			case 1:
				 Opr = "+";
				do {				
				try {
				System.out.println("¿Cuantos operandos desea ingresar?");
				Operarios = sc.nextInt();	
				num = 1;
				}catch (InputMismatchException e) {
					System.out.println("Error! Ingresa un valor numerico\n");
					num = 0;
					sc.next();
				}
				} while (num == 0);
				ColaCircular<Double> Cl = new ColaCircular<Double>(Operarios);
				for (int i = 0; i < Operarios; i++) {
						do {				
						try {
						System.out.println("Ingrese el operando "+(i+1));
						 n = sc.nextDouble();	
						 num = 1;
						}catch (InputMismatchException e) {
							System.out.println("Error! Ingresa un valor numerico\n");
							num = 0;
							sc.next();
						}
						} while (num == 0);
						Cl.encolar(n);
				}
				for (int i = 0; i < Operarios; i++) {
					elem = Cl.sacar();
					resultado = resultado + elem;	
					tmp = tmp + " "+ elem;
				}					
					System.out.println("El resultado es "+df.format(resultado));
					System.out.print("Notacion Polaca: "+Opr+" "+tmp);
					System.out.println("\n");					
				break;
			case 2:
				Opr = "-";
				do {				
					try {
					System.out.println("¿Cuantos operandos desea ingresar?");
					Operarios = sc.nextInt();	
					num = 1;
					}catch (InputMismatchException e) {
						System.out.println("Error! Ingresa un valor numerico\n");
						num = 0;
						sc.next();
					}
					} while (num == 0);
				ColaCircular<Double> Cl2 = new ColaCircular<Double>(Operarios);
					for (int i = 0; i < Operarios; i++) {
						do {				
							try {
							System.out.println("Ingrese el operando "+(i+1));
							 n = sc.nextDouble();	
							 num = 1;
							}catch (InputMismatchException e) {
								System.out.println("Error! Ingresa un valor numerico\n");
								num = 0;
								sc.next();
							}
						} while (num == 0);
						elem = n;
						Cl2.encolar(n);
						tmp = tmp + " "+elem;
					}
					for (int i = 0; i < Operarios; i++) {
						if (Cl2.colaLlena()) {
							totalresta = Cl2.sacar();
						}else {
							totalresta = totalresta - Cl2.sacar();
						}
					}
					System.out.println("El resultado es "+df.format(totalresta));
					System.out.print("Notacion Polaca: "+Opr+" "+tmp);
					System.out.println("\n");
				break;
			case 3:
				Opr = "*";
				do {				
					try {
					System.out.println("¿Cuantos operandos desea ingresar?");
					Operarios = sc.nextInt();	
					num = 1;
					}catch (InputMismatchException e) {
						System.out.println("Error! Ingresa un valor numerico\n");
						num = 0;
						sc.next();
					}
					} while (num == 0);
				if (Operarios == 0) {
					totalmulti = 0;
				}
				ColaCircular<Double> Cl3 = new ColaCircular<Double>(Operarios);
					for (int i = 0; i < Operarios; i++) {
						do {				
							try {
							System.out.println("Ingrese el operando "+(i+1));
							 n = sc.nextDouble();	
							 num = 1;
							}catch (InputMismatchException e) {
								System.out.println("Error! Ingresa un valor numerico\n");
								num = 0;
								sc.next();
							}
							} while (num == 0);
						Cl3.encolar(n);
					}			
					for (int i = 0; i < Operarios; i++) {
						elem = Cl3.sacar();
						totalmulti = totalmulti * elem;	
						tmp = tmp + " "+ elem;
					}
					
					System.out.println("El resultado es "+df.format(totalmulti));
					System.out.print("Notacion Polaca: "+Opr+" "+tmp);
					System.out.println("\n");
				break;
			case 4:
				Opr = "/";
				do {				
					try {
					System.out.println("¿Cuantos operandos desea ingresar?");
					Operarios = sc.nextInt();	
					num = 1;
					}catch (InputMismatchException e) {
						System.out.println("Error! Ingresa un valor numerico\n");
						num = 0;
						sc.next();
					}
					} while (num == 0);
				if (Operarios == 0) {
					totaldiv = 0;
				}
				ColaCircular<Double> Cl4 = new ColaCircular<Double>(Operarios);
					for (int i = 0; i < Operarios; i++) {
						do {				
							try {
							System.out.println("Ingrese el operando "+(i+1));
							 n = sc.nextDouble();	
							 num = 1;
							}catch (InputMismatchException e) {
								System.out.println("Error! Ingresa un valor numerico\n");
								num = 0;
								sc.next();
							}
							} while (num == 0);
						elem = n;
						Cl4.encolar(n);
						tmp = tmp + " "+elem;
					}
					for (int i = 0; i < Operarios; i++) {
						if (Cl4.colaLlena()) {
							totaldiv = Cl4.sacar();
						}else {			
							totaldiv = totaldiv / Cl4.sacar();						
						}
					}
					if (n == 0) {
						System.out.println("\nError!, division entre cero\n");
					}else {				
					System.out.println("El resultado es "+df.format(totaldiv));	
					System.out.print("Notacion Polaca: "+Opr+" "+tmp);
					}
					System.out.println("\n");				
				break;
				}
			} catch (ExcepcionColaLlena e) {
				System.out.println(e.getMessage());
			}catch (ExcepcionColaVacia e) {
				System.out.println(e.getMessage());
			}
		} while (Opp == true);
	}
}
class ColaCircular<T> {
	private int inicio;
	private int fin;
	private T[] cola;
	private boolean extraido;
	private boolean insertado;
	@SuppressWarnings("unchecked")
		    public ColaCircular(int tam){
		        cola=(T[])new Object[tam];
		        inicio=0;
		        fin=inicio;
		        extraido=true;
		        insertado=false;
		    }
		    public void encolar(T num)throws ExcepcionColaLlena{
		        if(!colaLlena()){
		            cola[fin]=num;
		            if(fin==cola.length-1) {
		                fin=0;
		            }else {
		                fin++;
		            extraido=false;
		            insertado=true;
		            }
		        }else{
		        	if (colaLlena()) {
						throw new ExcepcionColaLlena();
					}

		        }
		 
		    }
		    public T sacar()throws ExcepcionColaVacia{
		        if(!colaVacia()){
		            extraido=true;
		            insertado=false;
		            if(inicio==cola.length-1){
		                inicio=0;
		                return cola[cola.length-1];
		            }else{
		                inicio++;
		                return cola[inicio-1];
		            }
		        }else{
		        	if (colaVacia()) {
		        		System.out.println();
						throw new ExcepcionColaVacia();
					}
		        }
				return null;
		    }
		    public boolean colaVacia(){
		        if(inicio==fin) {
		            if(!insertado) {
		                return true;
		            }else {
		                return false;
		            }
		        }else {
		            return false;
		        }
		    }
		    
		    public boolean colaLlena(){
		        if(inicio==fin) {
		            if(!extraido) {
		                return true;
		            }else {
		                return false;
		            }
		        }else {
		            return false;
		        }
		    }
}
class ExcepcionColaLlena extends Exception {
	public ExcepcionColaLlena() {
		super("La Cola ya esta llena");
	}
}
class ExcepcionColaVacia extends Exception {
	public ExcepcionColaVacia() {
		super("La Cola esta vacia");
	}
}
