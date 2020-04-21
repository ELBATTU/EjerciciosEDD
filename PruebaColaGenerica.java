/*
 * PAREJA DE "LOS GARCÍA"
 * 
 * INTEGRANTES:
 * GARCÍA GACHUZO CONSTANZA
 * GARCÍA CAMACHO JAIME
 * 
 * EJERCICIO: COLA CON DATOS GENÉRICOS
 * 
 * */

package Colas;

public class PruebaColaGenerica {

	public static void main(String[] args) {

		ColaGenerica<Double> CG = new ColaGenerica<Double>(5);
		try {
			System.out.println("==================================\n\nCOLA GENERICA DE DOUBLES\n");
			System.out.println("Agregamos 10.5");
			CG.encolar(10.5);
			System.out.println("Agregamos 2.5\n-----------------------");
			CG.encolar(2.5);
			/*System.out.println("Agregamos 3.5");
			CG.encolar(3.5);
			System.out.println("Agregamos 11.5");
			CG.encolar(11.5);
			System.out.println("Agregamos 1.5\n");
			CG.encolar(1.5);*/
			
			Double elem = CG.sacar();
			System.out.println("Sacamos "+elem);
			elem = CG.sacar();
			System.out.println("Sacamos "+elem+"\n"+"\n==================================");
			/*elem = CG.sacar();
			System.out.println("Sacamos "+elem);
			elem = CG.sacar();
			System.out.println("Sacamos "+elem);
			elem = CG.sacar();
			System.out.println("Sacamos "+elem);*/
		} catch (ExcepcionColaLlena e) {
			System.out.println(e.getMessage());
		} catch(ExcepcionColaVacia e) {
			System.out.println(e.getMessage());
		}
////////////////////////////////////////////////////////////////////////////////////
		
		ColaGenerica<String> CGS = new ColaGenerica<>(5);
		try {
			System.out.println("\nCOLA GENERICA DE STRINGS\n");
			System.out.println("Agregamos Hola");
			CGS.encolar("Hola");
			System.out.println("Agregamos Mi");
			CGS.encolar("Mi");
			System.out.println("Agregamos Nombre");
			CGS.encolar("Nombre");
			System.out.println("Agregamos Es");
			CGS.encolar("Es");
			System.out.println("Agregamos Jaime\n-----------------------");
			CGS.encolar("Jaime");			
			
			String elem = CGS.sacar();
			System.out.println("Sacamos "+elem);
			elem = CGS.sacar();
			System.out.println("Sacamos "+elem);
			elem = CGS.sacar();
			System.out.println("Sacamos "+elem);
			elem = CGS.sacar();
			System.out.println("Sacamos "+elem);
			elem = CGS.sacar();
			System.out.println("Sacamos "+elem+"\n"+"\n==================================");
		} catch (ExcepcionColaLlena e) {
			System.out.println(e.getMessage());
		} catch(ExcepcionColaVacia e) {
			System.out.println(e.getMessage());
		}
		
		ColaGenerica<Estudiante> CGE = new ColaGenerica<Estudiante>(5);
		try {
			System.out.println("\nCOLA GENERICA DE ESTUDIANTE\n");
			Estudiante e1 , e2;
			e1 = new Estudiante("Jaime","14141414");
			e2 = new Estudiante("Constanza","12121212");
			
			System.out.println("Agregamos Estudiante 1\n"+e1+"\n");
			CGE.encolar(e1);
			System.out.println("Agregamos Estudiante 2\n"+e2+"\n---------------");
			CGE.encolar(e2);
			
			Estudiante S = CGE.sacar();
			System.out.println("Sacamos Estudiante 1\n"+S+"\n");
			S = CGE.sacar();
			System.out.println("Sacamos Estudiante 2\n"+S+"\n\n==================================");
		} catch (ExcepcionColaLlena e) {
			System.out.println(e.getMessage());
		} catch(ExcepcionColaVacia e) {
			System.out.println(e.getMessage());
		}
	}
}
class ColaGenerica<T> {
	private T Esquina[];
	private int Frente;
	private int Siguiente;
	
	@SuppressWarnings("unchecked")
	
		public ColaGenerica(int N) {
			Esquina = (T[])new Object[N];
			//Posicion inicial de Siguiente
			Siguiente = 0;
			//Posicion inicial de Frente
			Frente = -1;
		}
		public boolean colaLlena() {
			if (Siguiente == Esquina.length) {
				return true;
			}else {
				return false;
			}
		}
		public void encolar(T Num) throws ExcepcionColaLlena {
			//Si la cola esta vacia se hace un reset
			if (colaVacia()) {
				//System.out.println("Reset");
				Frente = -1;
				Siguiente = 0;
			}
			if (colaLlena()) {
				throw new ExcepcionColaLlena();
			}
			Esquina[Siguiente] = Num;
			Siguiente++;
			//Cuando apenas agrege un elemento
			if (Siguiente == 1) {
				Frente = 0;
			}
		}
		public boolean colaVacia() {
			if (Frente == Siguiente) {
					return true;
			}else {
				if (Frente == -1) {
					return true;
				}else {
					return false;
				}
			}
		}
		public T sacar() throws ExcepcionColaVacia {
			if (colaVacia()) {
				throw new ExcepcionColaVacia();
			}
			T valor = Esquina[Frente];
			Frente++;
			return valor;
		}
		//Frente -1  0  1  2
		//Siguiente 1  2  3
}
class Estudiante{
	private String Nombre;
	private String NoControl;
		public Estudiante(String Nombre, String NoControl) {
			this.NoControl=NoControl;
			this.Nombre = Nombre;
		}
		public String toString() {
			return Nombre + "\n" + NoControl;
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