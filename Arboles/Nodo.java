package Arboles;

public class Nodo {
	public Nodo Izquierda;
	public Nodo Derecha;
	public int Data;
		public Nodo(int Data) {
			this.Data=Data;
			Izquierda=null;
			Derecha=null;
		}
		public int getData() {
			return Data;
		}
		public void setData(int data) {
			this.Data = data;
		}
		public String toString() {
			return ""+Data;
		}
}
