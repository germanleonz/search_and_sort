import Console;
import Quicksort;
import OrdenaMezcla;
import OrdenaInsercion;
import OrdenaSeleccion;

public class Permutaciones
{
	//ESTE PROGRAMA GENERA UN ARREGLO CON VALORES ALEATORIOS, IMPRIME EL ARREGLO, Y DEBE GENERAR PERMUTACIONES
	//LAS CUALES ORDENARA POR INSERCION Y POR SELECCION (O POR QUICKSORT Y MEZCLA) 
	public static void llenararreglo(int[] a)
	{
		for (int i=0; i<a.length; i++)
        	{
        		a[i]= (int)(Math.random()*100);
        	}
	}

	public static void copiaraenb(int[] a, int[] b)
	{
		for (int i=0; i<a.length;i++)
		{
			b[i]=a[i];
		}
	}

	public static void imprimirarreglo(int []a)
	{
		for (int i=0; i<a.length; i++)
        	{
                	System.out.print(a[i] + ", ");
            	}
		System.out.println();
	}

	public static void intercambiar(int[] a,int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void permutaciones (int N,int[] a, int i) 
		
	{
		if (i!=N)
		{
			int izq=0;
			int der=N-1;
			System.out.println("ORDENADO");
			imprimirarreglo(a);
			Quicksort.quicksort(a,izq,der);
			System.out.println("DESORDENADO");
			imprimirarreglo(a);				
	
			/*			
			int[]b =new int[a.length];
			copiaraenb(a,b);
			
			//Esta es la permutacion a ordenar por quicksort
			System.out.println("\nEsta es la permutacion a ordenar:");*/		
			
			/*
			System.out.println("\nPermutacion ordenada por quicksort:");		
			imprimirarreglo(a);
		
			//Esta es la permutacion a ordenar por mezclar
			OrdenaMezcla.ordenamezcla(b,izq,der);
			System.out.println("\nPermutacion ordenada por mezcla:");
			imprimirarreglo(b);
					
			int izq =0;
			int der= a.length-1;
			int[] b= new int[a.length];
			copiaraenb(a,b);		
			System.out.println("\nEsta es una permutacion:");			
			imprimirarreglo(a);		
			
			
			// Mido el tiempo del ordenamiento por Quicksort
			long tiempoInicio1 = System.currentTimeMillis();
			Quicksort.quicksort(a,izq,der); 
			long tiempoquicksort = System.currentTimeMillis() - tiempoInicio1;
			System.out.println("\nQuicksort: el programa tardo "+ tiempoquicksort + " milisegundos en ordenar esta permutacion");

			// Mido el tiempo del ordenamiento por mezcla
			long tiempoInicio2 = System.currentTimeMillis();
			OrdenaMezcla.ordenamezcla(b,izq,der); 
			long tiempomezcla = System.currentTimeMillis() - tiempoInicio2;
			System.out.println("\nMezcla: el programa tardo "+ tiempomezcla + " milisegundos en ordenar esta permutacion");*/ 	
	        
			int j=i; 
			while (j<N) 
			{
				intercambiar(a,i,j);
				permutaciones (N, a, i+1);
		                intercambiar(a,i,j);
		                j = j+1;
	                }
	        }	       			
	}

        public static void main (String[] args)
    	{
        	final int n = Console.readInt("\nIntroduzca el tamaño del arreglo: ");
        	int[] a = new int[n];
		int[] arregloauxiliar = new int[n];
		int numeropermuta = Console.readInt("\nIntroduzca el numero de permutaciones que desea: ");
		int izq=0;
		int der=n-1;
		int i=0;
		
		//Aqui procedemos a llenar las casillas del arreglo a con valores aleatorios
        	llenararreglo(a);

	      	System.out.println("\nEl arreglo original es: ");
		imprimirarreglo(a);

		permutaciones(n,a,numeropermuta);
 	}
}
