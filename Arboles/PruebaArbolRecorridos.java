package Arboles;
/*
PAREJA DE "LOS GARCÍA"
* 
* INTEGRANTES:
* GARCÍA GACHUZO CONSTANZA
* GARCÍA CAMACHO JAIME
* 
* EJERCICIO: ARBOLES DE LA BARRANCA 2
* 
*/

public class PruebaArbolRecorridos {

	public static void main(String[] args) {
		ArbolConRecorridos bonsai = new ArbolConRecorridos();
		bonsai.insertar(new Nodo(10));
		if (bonsai.buscar(new Nodo(10))) {
			System.out.println("El 10 si se encuentra");
		}
		///////////////////////////////////////////////////
		Nodo AB;
		/////////////////////////////////////////////////////
		AB = new Nodo(0);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(5);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(15);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(4);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(16);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(8);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(11);
		bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		AB = new Nodo(1111);
		//bonsai.insertar(AB);
		if (bonsai.buscar(AB)) {
			System.out.println("El "+AB+" si se encuentra");
		}else {
			System.out.println("El "+AB+" no se encuentra");
		}
		//////////////////////////////////////////////////////
		System.out.println("---------------");
		System.out.println("PreOrder");
		System.out.println(bonsai.toStrignPreOrder());
		System.out.println("---------------");
		System.out.println("InOrder");
		System.out.println(bonsai.toStrignInOrder());
		System.out.println("---------------");
		System.out.println("PosOrder");
		System.out.println(bonsai.toStrignPosOrder());
		System.out.println("---------------");

	}

}
