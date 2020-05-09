/*
 * PAREJA DE "LOS GARCÍA"
 * 
 * INTEGRANTES:
 * GARCÍA GACHUZO CONSTANZA
 * GARCÍA CAMACHO JAIME
 * 
 * EJERCICIO: NODO CON DATOS STRING
 * 
 * */
package Nodos;

import java.util.Scanner;
public class EjercicioNodoString {

	public static void main(String[] args) {

		String Valor = "";
		NodoString Inicial = null;
		NodoString SigNod = null;
		NodoString NodActual = null;
		NodoString ref = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido vamos a guardar 10 cadenas :)\n");
		for (int i = 0; i < 10; i++) {
			System.out.println("ingresa la cadena "+(i+1));
			Valor = sc.next();
			if (Inicial == null) {
				Inicial = new NodoString(null,Valor);
				NodActual = Inicial;
			}else {
				SigNod = new NodoString(null,Valor);
				NodActual.Siguiente = SigNod;
				NodActual = SigNod;
			}
		}
		ref = Inicial;
		while (ref != null) {
			System.out.println("Valor "+ref);
			ref = ref.Siguiente;
			}
	}
}
class NodoString {
	public NodoString Siguiente;
	private String Data;
		 public NodoString(NodoString Sig, String Data) {
			 this.Siguiente=Sig;
			 this.Data=Data;
		 }
		public String getData() {
			return Data;
		}
		public void setData(String data) {
			this.Data = data;
		}
		public String toString() {
			return "Data: "+Data;
		}
}
