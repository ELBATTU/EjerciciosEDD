import java.util.Random;
import java.util.Scanner;
/*
PAREJA DE "LOS GARCÍA"
* 
* INTEGRANTES:
* GARCÍA GACHUZO CONSTANZA
* GARCÍA CAMACHO JAIME
* 
* EJERCICIO: LISTA DOBLE ENLAZADA
* 
*/
public class EjercicioLista {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		ListaDobleEnlazada L = new ListaDobleEnlazada();
		String Respuesta = "",tmp="";
		int Valor = 0, Res = 0,num =0,tam=0;
		boolean cara = false, cruz = false;
		System.out.println("-------------------------------------------------------------");
		System.out.println("Bienvenido a este programa que calcula tu numero de la suerte");
		System.out.println("-------------------------------------------------------------\n");
		for (int i = 0; i < 5; i++) {
			System.out.println("Por favor dame un numero entero:");
			Valor = sc.nextInt();
			L.agregarAlInicio(new NodoGen<Integer>(Valor,1));
		}
		do {
			System.out.println("Deseas agregar otro? S/N");
			Respuesta = sc.next();			
			if (Respuesta.compareToIgnoreCase("S") == 0) {
				System.out.println("Por favor dame un numero entero:");
				Valor = sc.nextInt();
				L.agregarAlInicio(new NodoGen<Integer>(Valor,1));
			}		
		} while (Respuesta.compareToIgnoreCase("S") == 0);
			tam = L.getNoElementos()-1;
			System.out.println("Tus numeros\n");
			System.out.println(L.toStringReverse());
			System.out.println(L);
			System.out.println("\nProcesando...");
			System.out.println("\nSe lanzo la moneda "+tam+" veces");
			for (int i = 0; i < tam; i++) {
			num = r.nextInt(2)+1;			
			if (num == 1) {
				cara = true;
				cruz = false;
				L.eliminarAlInicio();
			}else {
				if (num == 2) {
					cara = false;
					cruz = true;
					L.eliminarAlFin();
				}
	   	    }
		}			
			System.out.println("Tu numero de la suerte es: "+L);
			
		
	}

}
class ListaDobleEnlazada{
	// Referencia el inicio
			private NodoGen Inicio;
			// Referencia al final
			private NodoGen Fin;
			private int NoElementos;
			
				public ListaDobleEnlazada() {
					Inicio = null;
					Fin = null;
					NoElementos = 0;
				}
				
				public int getNoElementos() {
					return NoElementos;
				}
				
				public void agregarAlInicio(NodoGen AG) {
					// Cuando no tengo Nodos o la lista esta vacia
					 if (Inicio == null) {
						Inicio = AG;
						Fin = AG;
						NoElementos++;
					}else {
						//Mi lista al menos tiene  un Nodo
						AG.Siguiente = Inicio;
						Inicio.Anterior = AG;
						Inicio = AG;
						NoElementos++;
					}
				}
				
				public void agregarAlFin(NodoGen AG) {
					// Cuando no tengo Nodos o la lista esta vacia
					if (Fin == null) {
						Fin = AG;
						Inicio = AG;
						NoElementos++;
					}else {
						//Mi lista al menos tiene  un Nodo
						Fin.Siguiente=AG;
						AG.Anterior = Fin;
						Fin = AG;
						NoElementos++;
					}
				}
				
				public boolean buscarElemento(NodoGen AB) {
					//El nodo no es nulo
					if (AB != null) {
						if (Inicio != null) {
							if (Inicio.getData() == AB.getData()) {
								return true;
							}
						}
						if (Fin != null) {
							if (Fin.getData() == AB.getData()) {
								return true;
							}
						}
						//Si el elmento a buscar no esta ni en el inicio o fin
						
						NodoGen ref = Inicio;
						boolean Encontrado = false;
						while ((ref != null)&& !Encontrado) {
							//Esto es cierto el nodo fue encontrado
							//System.out.println("=>"+ref);
							//System.out.println("=>"+AB);
							if (ref.getData() == AB.getData()) {
								Encontrado = true;
							}
							ref = ref.Siguiente;
							
						}
						return Encontrado;
					}
					return false; // Si AB es nulo no tengo nada que busar
					
				}
				
				public NodoGen eliminarAlInicio() {
					if (Inicio == null) {
						return null;
					}else {
						NodoGen Ret = Inicio;
						
					Inicio = Inicio.Siguiente;
					Inicio.Anterior = null;
					Ret.Siguiente = null;
					Ret.Anterior = null;
					NoElementos--;
					return Ret;
					}
				}
				
				public NodoGen eliminarAlFin() {
					if (Fin == null) {
						return null;
					}else {					
						NodoGen eliminar = Fin;
						Fin = Fin.Anterior;
						Fin.Siguiente = null;					
						eliminar.Siguiente = null;
						eliminar.Anterior = null;
						NoElementos--;
						return eliminar;
					}
				}
				
				public NodoGen eliminarPorNodo(NodoGen AB) {
					if (AB == null) {
						return null;
					}
					
					if (Fin == null) {
						return null;
					}else { 
						//////////////////////////
						if (Inicio.getData() == AB.getData()) {
							return eliminarAlInicio();
						}
						//////////////////////////////////////
						//////////////////////////
						if (Fin.getData() == AB.getData()) {
							return eliminarAlFin();
						}
						//////////////////////////////////////
						NodoGen RefRojo = Inicio;
						NodoGen RefAzul = null;
						NodoGen RefElim = null;
						boolean Encontrado = false;
						while ((RefRojo != null)&& !Encontrado) {
							if (RefRojo.getData() == AB.getData()) {
								Encontrado = true;
								RefElim = RefRojo;
								NoElementos--;
							}
							RefRojo = RefRojo.Siguiente;
						}
						if (Encontrado) {
						RefRojo = RefElim.Anterior;
						RefAzul = RefElim.Siguiente;
						
						RefRojo.Siguiente = RefAzul;
						RefAzul.Anterior = RefRojo;
						
						RefElim.Siguiente = null;
						RefElim.Anterior=null;
						}
						return RefElim;
					}
				}
				
				public NodoGen porIndice(int p) {
					if (Inicio == null) {
						return null;
					}
					if (p >= NoElementos) {
						return null;
					}
					if (p < 0) {
						return null;
					}
					int i = 0;
					NodoGen Ref = Inicio;
					for (; i < p; i++) {
						Ref = Ref.Siguiente;
					}
					switch (Ref.getTipo()) {
					case 1:
						Ref = new NodoGen<Integer>((int)Ref.getData(),1);
						break;
					case 2:
						Ref = new NodoGen<Double>((double)Ref.getData(),2);
						break;
					case 3:
						Ref = new NodoGen<String>(""+Ref.getData(),3);
						break;
					case 4:
						Ref = new NodoGen<Float>((float)Ref.getData(),4);
						break;
					case 5:
						Ref = new NodoGen<Boolean>((boolean)Ref.getData(),5);
						break;
					case 6:
						Ref = new NodoGen<Character>((char)Ref.getData(),6);
						break;
					case 7:
						Ref = new NodoGen<Short>((short)Ref.getData(),7);
						break;
					case 8:
						Ref = new NodoGen<Long>((long)Ref.getData(),8);
						break;
					default:
						//Ref = new NodoGenListaDobEnlaz(Ref.getData(),10);
					}
					return Ref;
				}
				
				public String toString() {
					String tmp = "";
					if (Inicio == null) {
						return "";
					}
					NodoGen ref = Inicio;
					while(ref != null) {
						tmp = tmp + " " + ref.toString();
						ref = ref.Siguiente;
					}
					return tmp;
				}
				public String toStringReverse() {
					String tmp = "";
					if (Fin == null) {
						return "";
					}
					NodoGen ref = Fin;
					while(ref != null) {
						tmp = tmp + " " + ref.toString();
						ref = ref.Anterior;
					}
					return tmp;
				}
				
}
class NodoGen<T>{
	public NodoGen Anterior;
	public NodoGen Siguiente;
	private int Tipo;
	private T Data;
	/*
	 * Si tipo = 1 entonces es un int
	 * Si tipo = 2 entonces es un double
	 * Si tipo = 3 entonces es un String
	 * Si tipo = 4 entonces es un float
	 * Si tipo = 5 entonces es un boolean
	 * Si tipo = 6 entonces es un char
	 * Si tipo = 7 entonces es un short
	 * Si tipo = 8 entonces es un long
	 * Si tipo = 10 entonces es un personalizado
	 * */
		public NodoGen(T Data, int Tipo) {
			this.Tipo = Tipo;
			this.Data = Data;
			Anterior = null;
			Siguiente = null;
		}
		public T getData() {
			return Data;
		}
		public void setData(T Data) {
			this.Data = Data;
		}
		public String toString() {
			return ""+Data;
		}
		public int getTipo() {
			return Tipo;
		}
}
