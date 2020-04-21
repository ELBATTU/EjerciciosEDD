/*
 * PAREJA DE "LOS GARCÍA"
 * 
 * INTEGRANTES:
 * GARCÍA GACHUZO CONSTANZA
 * GARCÍA CAMACHO JAIME
 * 
 * EJERCICIO: COLA CON DATOS ENTEROS
 * 
 * */
package Colas;

public class PruebaColaNunEntero {

	public static void main(String[] args) {
		int num = 0;
		
		ColaNumEntero Cl = new ColaNumEntero(3);
		//En las colas el primero en ingresar es el primero en salir
		try {
			System.out.println("Agregamos 1");
		Cl.encolar(1);
		System.out.println("Agregamos 2");
		Cl.encolar(2);
		//Sacar numero
		num = Cl.sacar();
		System.out.println("Sacamos: "+ num);
		//System.out.println(num);
		num = Cl.sacar();
		System.out.println("Sacamos: "+ num);
		//System.out.println(num);
		System.out.println("Agregamos 10");
		Cl.encolar(10);
		} catch (ExcepcionColaLlena e) {
			System.out.println(e.getMessage());
		}catch(ExcepcionColaVacia e) {
			System.out.println(e.getMessage());
		}
		
	}

}
class ColaNumEntero {
	private int Esquina[];
	private int Frente;
	private int Siguiente;
		public ColaNumEntero(int N) {
			Esquina = new int[N];
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
		public void encolar(int Num) throws ExcepcionColaLlena {
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
		public int sacar() throws ExcepcionColaVacia {
			if (colaVacia()) {
				throw new ExcepcionColaVacia();
			}
			int valor = Esquina[Frente];
			Frente++;
			return valor;
		}
		//Frente -1  0  1  2
		//Siguiente 1  2  3
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

