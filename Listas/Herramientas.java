package Listas;

import java.util.Random;

/*
PAREJA DE "LOS GARCÍA"
* 
* INTEGRANTES:
* GARCÍA GACHUZO CONSTANZA
* GARCÍA CAMACHO JAIME
* 
* EJERCICIO: HERRAMIENTAS USANDO LISTA
* 
*/

public class Herramientas {

	public static void main(String[] args) {
		Nodo elem = null,elem2 = null,elem3=null,elem4=null;
		int valorDado = 0;
        boolean mesa = false, baston = false, cuerda = false;
        int contme=0,contba=0,contca=0,contbar=0,contcuer=0;
        Random r = new Random();	
        
        PilaMadera PilaM = new PilaMadera();
		PilaResina PilaR = new PilaResina();
		PilaHilo PilaH = new PilaHilo();
		
			for (int i = 0; i < 30+3; i++) {
	             valorDado = r.nextInt(3);
	             if (valorDado == 0) {
					int madera = (valorDado);	
					PilaM.apilar(madera);	
				}else {
					if (valorDado == 1) {
						int resina = (valorDado);
						PilaR.apilar(resina);	
					}else {
						if (valorDado == 2) {
							int hilo = (valorDado); 
							PilaH.apilar(hilo);	
						}
					}
				}					
			}
			System.out.println("Cantidad inicial de madera: "+PilaM.cantidad()+"");
			System.out.println("Cantidad inicial de resina: "+PilaR.cantidad()+"");
			System.out.println("Cantidad inicial de hilo: "+PilaH.cantidad()+"");
			
				if (PilaM.cantidad() >= 4) {
					for (int j = 0; j < 4; j++) {
						elem = PilaM.sacar();
						mesa = true;
					}						
				 contme++;
				}else {
					mesa = false;
				}
				
				for (int i = 0; i < 30; i++) {					
						if (mesa==true && PilaM.cantidad() >= 2) {
							for (int j = 0; j < 2; j++) {
								elem2 = PilaM.sacar();
								baston = true;
							}
							
							 contba++;
						}else {
							baston = false;
						}
					
						if (mesa == true && PilaH.cantidad()>=4 && PilaR.cantidad()>=1) {
							for (int j = 0; j < 4; j++) {
								elem3 = PilaH.sacar();
								cuerda = true;
							}							
							elem3 = PilaR.sacar();
							 contcuer++;
						}else {
							cuerda = false;
						}
					
					if (mesa == true && baston == true && cuerda == true) {
                        contca++;
                      }				
					
                        if (mesa == true && PilaM.cantidad()>=5) {
                        	for (int j = 0; j < 5; j++) {
                            	elem4 = PilaM.sacar();
							}
                        	 contbar++;
                        }
					
				}					
                    System.out.println("\nMesa adquirida "+"("+contme+")"); 
                    System.out.println("\nBaston adquirido "+"("+contba+")");
                    System.out.println("\nCuerda adquirida "+"("+contcuer+")"); 
                    System.out.println("\nCaña adquirida "+"("+contca+")"); 
                    System.out.println("\nBarco adquirido "+"("+contbar+")"); 
					System.out.println("\nCantidad final de madera: "+PilaM.cantidad()+"");
					System.out.println("Cantidad final de resina: "+PilaR.cantidad()+"");
					System.out.println("Cantidad final de hilo: "+PilaH.cantidad()+"");
	}

}
class ListaEnlazada {
	// Referencia el inicio
	private Nodo Inicio;
	// Referencia al final
	private Nodo Fin;
	private int NoElementos;
	
		public ListaEnlazada() {
			Inicio = null;
			Fin = null;
			NoElementos = 0;
		}
		public int getNoElementos() {
			return NoElementos;
		}
		public void agregarAlInicio(Nodo AG) {
			// Cuando no tengo Nodos o la lista esta vacia
			 if (Inicio == null) {
				Inicio = AG;
				Fin = AG;
				NoElementos++;
			}else {
				//Mi lista al menos tiene  un Nodo
				AG.Siguiente = Inicio;
				Inicio = AG;
				NoElementos++;
			}
		}
		public void agregarAlFin(Nodo AG) {
			// Cuando no tengo Nodos o la lista esta vacia
			if (Fin == null) {
				Fin = AG;
				Inicio = AG;
				NoElementos++;
			}else {
				//Mi lista al menos tiene  un Nodo
				Fin.Siguiente=AG;
				Fin = AG;
				NoElementos++;
			}
		}
		public boolean buscarElemento(Nodo AB) {
			//El nodo no es nulo
			if (AB != null) {
				Nodo ref = Inicio;
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
		public Nodo eliminarAlInicio() {
			if (Inicio == null) {
				return null;
			}else {
			Nodo Ret = Inicio;
			Inicio = Inicio.Siguiente;
			Ret.Siguiente = null;
			NoElementos--;
			return Ret;
			}
		}
		public Nodo eliminarAlFin() {
			if (Fin == null) {
				return null;
			}else {
				Nodo Ref = Inicio;
				boolean Encontrado = false;
				while ((Ref != null)&& !Encontrado) {
					if (Ref.Siguiente == Fin) {
						Encontrado = true;
					}
					if (!Encontrado) {
						Ref = Ref.Siguiente;
					}					
				}
				NoElementos--;
				Nodo eliminar = Fin;
				Fin = Ref;
				Ref.Siguiente = null;
				return eliminar;
			}
		}
		public Nodo eliminarPorNodo(Nodo AB) {
			if (AB == null) {
				return null;
			}
			
			if (Fin == null) {
				return null;
			}else { 
				Nodo RefRojo = Inicio;
				Nodo RefAzul = null;
				Nodo RefElim = null;
				boolean Encontrado = false;
				while ((RefRojo != null)&& !Encontrado) {
					if (RefRojo.getData() == AB.getData()) {
						Encontrado = true;
						RefElim = RefRojo;
						NoElementos--;
					}
					if (!Encontrado) {
						RefAzul = RefRojo;
						RefRojo = RefRojo.Siguiente;
					}else {
						RefAzul.Siguiente= RefRojo.Siguiente;
						RefElim.Siguiente = null;
					}										
				}
				return RefElim;
			}
		}
		public Nodo porIndice(int p) {
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
			Nodo Ref = Inicio;
			for (; i < p; i++) {
				Ref = Ref.Siguiente;
			}
			Ref = new Nodo(null,Ref.getData());
			return Ref;
		}
		public String toString() {
			String tmp = "";
			if (Inicio == null) {
				return "";
			}
			Nodo ref = Inicio;
			while(ref != null) {
				tmp = tmp + "\n" + ref.toString();
				ref = ref.Siguiente;
			}
			return tmp;
		}
		
}

///////////////////////////////////////////////


class Nodo {
	public Nodo Siguiente;
	private int Data;
		 public Nodo(Nodo Sig, int Data) {
			 this.Siguiente=Sig;
			 this.Data=Data;
		 }
		public int getData() {
			return Data;
		}
		public void setData(int data) {
			this.Data = data;
		}
		public String toString() {
			return "Data: "+Data;
		}
}


////////////////////////////////////////////////////////


class PilaMadera{
	private int indice;
	ListaEnlazada L = new ListaEnlazada();
	
		//Coinstructor
		public PilaMadera() {
		// n es la cantidad de elementos que puede guardar mi pila
			L = new ListaEnlazada();
			indice = 0;
		}
		
		public int cantidad() {
			return indice - 1;
	}
		
		public void apilar(int num){		
			L.agregarAlFin(new Nodo(null,num));
			indice ++;
	}
		
		public Nodo sacar() {
		Nodo esacar;
		esacar = L.eliminarAlFin();
		indice --;
		return esacar;
	}
		
		public int capacidad() {
		
		return L.getNoElementos();
		}
}

///////////////////////////////////////////////////////


class PilaHilo{
	private int indice;
	ListaEnlazada L = new ListaEnlazada();
	
	//Coinstructor
	public PilaHilo() {
		// n es la cantidad de elementos que puede guardar mi pila
		L = new ListaEnlazada();
		indice = 0;
	}
	
	public int cantidad() {
		return indice - 1;
	}
	
	public void apilar(int num){		
		L.agregarAlFin(new Nodo(null,num));
		indice ++;
	}
	
	public Nodo sacar() {
		Nodo esacar;
		esacar = L.eliminarAlFin();
		indice --;
		return esacar;
	}
	
	public int capacidad() {
		
		return L.getNoElementos();
	}
}

//////////////////////////////////////////////////


class PilaResina{
	private int indice;
	ListaEnlazada L = new ListaEnlazada();
	
	//Coinstructor
	public PilaResina() {
		// n es la cantidad de elementos que puede guardar mi pila
		L = new ListaEnlazada();
		indice = 0;
	}
	
	public int cantidad() {
		return indice - 1;
	}
	
	public void apilar(int num){		
		L.agregarAlFin(new Nodo(null,num));
		indice ++;
	}
	
	public Nodo sacar() {
		Nodo esacar;
		esacar = L.eliminarAlFin();
		indice --;
		return esacar;
	}
	
	public int capacidad() {
		
		return L.getNoElementos();
	}
}
