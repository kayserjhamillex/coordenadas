import java.util.*; //para poder pedir valores
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.InputMismatchException; // No olvides importar la excepción
import googlemaps.latandlog; //Aqui importo una clase  

class Main {
  public static void googlemaps() {
    
  }
  public static void main(String[] args) {
    ArrayList<latandlog> lista = new ArrayList<latandlog>();
		Scanner escaner = new Scanner(System.in);

    boolean pedido = true;
    while(pedido){
      latandlog o = new latandlog();
      System.out.println("\nIngrese una coordenada ");
      System.out.print("latitud: ");
      o.lat = escaner.nextLine();
      System.out.print("longitud: ");
      o.lonj = escaner.nextLine();
      lista.add(o);
      System.out.println("¿Desea ingresar una coordenada mas? 0(parar) 1(seguir) ");
      int seguir = escaner.nextInt();
      escaner.nextLine();
      if(seguir == 0){
        pedido = false;
        escaner.close();
      }
    }

    String urlBase = "https://www.keene.edu/campus/maps/tool/?coordinates=";
    String intermedio = "%2C%20";
    String nuevaCoor = "%0A";
    for(int concatenar = 0; lista.size() > concatenar; concatenar++){
      if(concatenar==0){
        urlBase = urlBase + lista.get(concatenar).lat + intermedio + lista.get(concatenar).lonj;
      }
      if(concatenar>0){
        urlBase = urlBase + nuevaCoor + lista.get(concatenar).lat + intermedio + lista.get(concatenar).lonj;
      }
    }
    System.out.println("\n!Genial¡ ya se genero la url\n");
    System.out.println(urlBase);
  }
}