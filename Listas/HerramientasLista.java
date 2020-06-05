package Nodos;
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

public class HerramientasLista {

	public static void main(String[] args) {
		int elem = 0,elem2 = 0,elem3=0,elem4=0,valorDado=0;
        boolean mesa = false, baston = false, cuerda = false;
        int contme=0,contba=0,contca=0,contbar=0,contcuer=0;
        Random r = new Random();
        PilaMadera PilaM = new PilaMadera();
		PilaResina PilaR = new PilaResina();
		PilaHilo PilaH = new PilaHilo();
			for (int i = 0; i < 30; i++) {
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
		
			if (PilaM.cantidad()>= 4) {
				for (int j = 0; j < 4; j++) {
					elem = PilaM.sacar();
					mesa = true;
				}
				 contme++;
			}else {
				mesa = false;
			}
		
		for (int i = 0; i < 30; i++) {					
				if (mesa==true && PilaM.cantidad()>= 2) {
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
					elem3 += PilaR.sacar();
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

class PilaMadera {
    
    private Nodo UltimoValorIngresado;
    private int tamanyo = 0;
    
    public PilaMadera(){
        UltimoValorIngresado = null;
        tamanyo = 0;
    }
    
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
    
    public void apilar(int nodo){
        Nodo nuevo_nocdo = new Nodo(nodo);
        nuevo_nocdo.siguiente = UltimoValorIngresado;
        UltimoValorIngresado = nuevo_nocdo;
        tamanyo++;
    }        
    
    public int sacar(){
        int auxiliar = UltimoValorIngresado.informacion;
        UltimoValorIngresado = UltimoValorIngresado.siguiente;
        tamanyo--;
        return auxiliar;
    }
    
    public int cantidad(){
        return tamanyo;
    }
}
class PilaResina {
	
	private Nodo UltimoValorIngresado;
	private int tamanyo = 0;
	
	public PilaResina(){
		UltimoValorIngresado = null;
		tamanyo = 0;
	}
	
	public boolean PilaVacia(){
		return UltimoValorIngresado == null;
	}
	
	public void apilar(int nodo){
		Nodo nuevo_nocdo = new Nodo(nodo);
		nuevo_nocdo.siguiente = UltimoValorIngresado;
		UltimoValorIngresado = nuevo_nocdo;
		tamanyo++;
	}        
	
	public int sacar(){
		int auxiliar = UltimoValorIngresado.informacion;
		UltimoValorIngresado = UltimoValorIngresado.siguiente;
		tamanyo--;
		return auxiliar;
	}
	
	public int cantidad(){
		return tamanyo;
	}
}
class PilaHilo {
	
	private Nodo UltimoValorIngresado;
	private int tamano = 0;
	
	public PilaHilo(){
		UltimoValorIngresado = null;
		tamano = 0;
	}
	
	public boolean PilaVacia(){
		return UltimoValorIngresado == null;
	}
	
	public void apilar(int nodo){
		Nodo nuevo_nocdo = new Nodo(nodo);
		nuevo_nocdo.siguiente = UltimoValorIngresado;
		UltimoValorIngresado = nuevo_nocdo;
		tamano++;
	}        
	
	public int sacar(){		
		int auxiliar = UltimoValorIngresado.informacion;
		UltimoValorIngresado = UltimoValorIngresado.siguiente;
		tamano--;
		return auxiliar;
	}
	
	public int cantidad(){
		return tamano;
	}
}
class Nodo {
    int informacion;
    Nodo siguiente;
    
    public Nodo(int valor){
        informacion = valor;
        siguiente = null;
    }
}