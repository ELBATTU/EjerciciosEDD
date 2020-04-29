import java.util.Random;
/*
  PAREJA DE "LOS GARCÍA"
 * 
 * INTEGRANTES:
 * GARCÍA GACHUZO CONSTANZA
 * GARCÍA CAMACHO JAIME
 * 
 * EJERCICIO: HERRAMIENTAS
 * 
  */
public class Herramientas {

	public static void main(String[] args) {
		
		int elem = 0,elem2 = 0,elem3=0,elem4=0,valorDado=0;
        boolean mesa = false, baston = false, cuerda = false;
        int contme=0,contba=0,contca=0,contbar=0,contcuer=0;
	Random r = new Random();		
        PilaMadera PilaM = new PilaMadera(31);
		PilaResina PilaR = new PilaResina(31);
		PilaHilo PilaH = new PilaHilo(31);
		
        
					try {			
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
							//Concatenar elem con +=           
								
						}
					} catch (DesbordamientoDePila e) {
						System.out.println(e.getMessage());
					}
					

					System.out.println("Cantidad inicial de madera: "+PilaM.cantidad()+"");
					System.out.println("Cantidad inicial de resina: "+PilaR.cantidad()+"");
					System.out.println("Cantidad inicial de hilo: "+PilaH.cantidad()+"");
					
					try {
						if (PilaM.cantidad() >= 4) {
							for (int j = 0; j < 4; j++) {
								elem = PilaM.sacar();
								mesa = true;
							}						
						/*elem = PilaM.sacar();
						elem = PilaM.sacar();
						elem = PilaM.sacar();
						elem = PilaM.sacar();*/
						 contme++;
						//System.out.print(elem+"m ");

						}else {
							mesa = false;
						}
					} catch (SubDesbordamientoDePila e) {
						System.out.println(e.getMessage());
					}
					
 					for (int i = 0; i < 30; i++) {					
					try {
						if (mesa==true && PilaM.cantidad() >= 2) {
							for (int j = 0; j < 2; j++) {
								elem2 = PilaM.sacar();
								baston = true;
							}
							//elem2 = PilaM.sacar();
							//elem2 = PilaM.sacar();
							 contba++;
							//System.out.print(elem2+"b ");
						}else {
							baston = false;
						}
					} catch (SubDesbordamientoDePila e) {
						System.out.println(e.getMessage());
					}
					
					try {
						if (mesa == true && PilaH.cantidad()>=4 && PilaR.cantidad()>=1) {
							for (int j = 0; j < 4; j++) {
								elem3 = PilaH.sacar();
								cuerda = true;
							}
							/*elem3 = PilaH.sacar();
							elem3 += PilaH.sacar();
							elem3 += PilaH.sacar();
							elem3 += PilaH.sacar();*/							
							elem3 += PilaR.sacar();
							 contcuer++;
							//System.out.print(elem3+"cu ");
						}else {
							cuerda = false;
						}
						
					} catch (SubDesbordamientoDePila e) {
						System.out.println(e.getMessage());
					}
					
					if (mesa == true && baston == true && cuerda == true) {
                        contca++;
                      }				
					
					try {
                        if (mesa == true && PilaM.cantidad()>=5) {
                        	for (int j = 0; j < 5; j++) {
                            	elem4 = PilaM.sacar();
							}
                        	/*elem4 = PilaM.sacar();
                        	elem4 = PilaM.sacar();
                        	elem4 = PilaM.sacar();
                        	elem4 = PilaM.sacar();
                        	elem4 = PilaM.sacar();*/
                        	 contbar++;
                        	//System.out.print(elem4+"ba ");
                        }
					} catch (SubDesbordamientoDePila e) {
						System.out.println(e.getMessage());
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


class PilaMadera{
		public int length;
		private int Esquina[];
		private int indice;
		
			//Coinstructor
			public PilaMadera(int n) {
			// n es la cantidad de elementos que puede guardar mi pila
				Esquina = new int [n];
				indice = 0;
			}
			
			public int cantidad() {
				return indice - 1;
		}
			
			public void apilar(int num)throws DesbordamientoDePila {
			/*if (llena()) {
				throw new DesbordamientoDePila();
			}*/
			if (this.llena()) {
				throw new DesbordamientoDePila();
			}
				Esquina[indice] = num;
				indice ++;
		}
			
			public int sacar()throws SubDesbordamientoDePila {
			if (vacia()) {
				throw new SubDesbordamientoDePila();
			}
			int esacar;
			esacar = Esquina[indice -1];
			indice --;
			//indice --;
			//esacar = Esquina[indice];
			return esacar;
		}
			
			public boolean vacia() {
			
			if (indice == 0) {
				return true;
			}else {
				return false;
		}
	}
			
			public boolean llena() {
			
			if (indice == Esquina.length) {
				return true;
			}else {
				return false;
		}
	}
			
			public int capacidad() {
			
			return Esquina.length;
			}
		}

class PilaResina{
		private int Esquina[];
		private int indice;
		//Coinstructor
		public PilaResina(int n) {
		// n es la cantidad de elementos que puede guardar mi pila
		Esquina = new int [n];
		indice = 0;
		}
		
		public int cantidad() {
		return indice - 1;
		}
		
		public void apilar(int num)throws DesbordamientoDePila {
		/*if (llena()) {
			throw new DesbordamientoDePila();
		}*/
		if (this.llena()) {
			throw new DesbordamientoDePila();
		}
		Esquina[indice] = num;
		indice ++;
	}
		
		public int sacar()throws SubDesbordamientoDePila {
		if (vacia()) {
			throw new SubDesbordamientoDePila();
	}
		
		int esacar;
		esacar = Esquina[indice -1];
		indice --;
		//indice --;
		//esacar = Esquina[indice];
		return esacar;
	}
		
		public boolean vacia() {
		
		if (indice == 0) {
			return true;
		}else {
			return false;
	}
}
		
		public boolean llena() {
		
		if (indice == Esquina.length) {
			return true;
		}else {
			return false;
	}
}
		
		public int capacidad() {
		
		return Esquina.length;
	}
}

class PilaHilo{
		private int Esquina[];
		private int indice;
		//Coinstructor
		public PilaHilo(int n) {
		// n es la cantidad de elementos que puede guardar mi pila
		Esquina = new int [n];
		indice = 0;
		}
		
		public int cantidad() {
		return indice - 1;
		}
		
		public void apilar(int num)throws DesbordamientoDePila {
		/*if (llena()) {
			throw new DesbordamientoDePila();
		}*/
		if (this.llena()) {
			throw new DesbordamientoDePila();
	}
		
		Esquina[indice] = num;
		indice ++;
	}
		
		public int sacar()throws SubDesbordamientoDePila {
		if (vacia()) {
			throw new SubDesbordamientoDePila();
	}
		int esacar;
		esacar = Esquina[indice -1];
		indice --;
		//indice --;
		//esacar = Esquina[indice];
		return esacar;
	}
		
		public boolean vacia() {
		
		if (indice == 0) {
			return true;
		}else {
			return false;
	}
}
		
		public boolean llena() {
		
		if (indice == Esquina.length) {
			return true;
		}else {
			return false;
	}
}
		
		public int capacidad() {
		
		return Esquina.length;
	}
}

class DesbordamientoDePila extends Exception{
		public DesbordamientoDePila() {
				super("\nNo puedo apilar mas elementos");
		}
}
class SubDesbordamientoDePila extends Exception{
		public SubDesbordamientoDePila() {
			super("\nNo puedo sacar elementos de una pila vacia");
		}
}
