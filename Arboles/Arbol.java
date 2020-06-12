package Arboles;

public class Arbol {
	private Nodo Raiz;
		public Arbol() {
			Raiz = null;
		}
		//Metodo a envolver
		private void insertarDesde(Nodo n, Nodo Desde) {
			
			if (Desde.getData()== n.getData()) {
				return;
			}
			if (n.getData() > Desde.getData()) {
				//Colocar a la derech
				if (Desde.Derecha==null) {
					Desde.Derecha=n;
					return;
				}else {
					insertarDesde(n,Desde.Derecha);
					return;
				}
			}else {
				//Colocar a la izquierda
				if (Desde.Izquierda==null) {
					Desde.Izquierda=n;
					return;
				}else {
					insertarDesde(n,Desde.Izquierda);
					return;
				}
			}
		}
		
		//Metodo que envuelve a wrapper
		public void insertar(Nodo n) {
			//Esto pasa cuando la raiz es nula, es decir es el primer elemento

			if (Raiz == null) {
				Raiz = n;
				return; //Terminar el metodo
			}
			///////////////////////
			//Si llego aqui la raiz no es nula
			
			insertarDesde(n,Raiz);
		}
		
		public boolean buscar(Nodo n) {
			return buscarDesde(n,Raiz);
		}
		
		private boolean buscarDesde(Nodo n,Nodo Desde) {
			if (Desde == null) {
				return false;
			}
			// CUando el nodo es el encontrado
			if (Desde.getData()== n.getData()) {
				return true;
			}
			if (n.getData() > Desde.getData()) {
				//Derecha
				return buscarDesde(n,Desde.Derecha);
			}else {
				//Izquierda
				return buscarDesde(n,Desde.Izquierda);
			}

		}
}
