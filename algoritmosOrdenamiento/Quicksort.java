/**
 * Archivo: 	Quicksort.java
 *
 * Descripcion: Implementacion en Java del algoritmo de ordenamiento
 *              por Quicksort (tomado del Hume)
 *
 * Autor: 		German Leon
 */

package algoritmosOrdenamiento;

public class Quicksort
{
    private static void llenararreglo(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random()*a.length);
        }
    }

    private static void imprimirarreglo(int []a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static void quicksort(int[] a, int izq, int der) {
        int puestopivote = (izq + der) / 2;
		//Poner pivote al principio del arreglo				
		int temp = a[izq];
		a[izq] = a[puestopivote];
		a[puestopivote] = temp;
		
		int ultimopeq = izq;
		int temp1 = 0;
		for ( int i = izq+1; i <= der; i++) {
			if (a[i] < a[izq]) {
		    	ultimopeq++;
		       	temp1 = a[ultimopeq];
				a[ultimopeq] = a[i];
				a[i] = temp1;
			}
		}
		// Poner pivote en entre parte menor y parte mayor
		temp = a[izq];
		a[izq] = a[ultimopeq];
		a[ultimopeq] = temp;

		puestopivote = ultimopeq;
		//Ordenar parte izquierda
		if (izq < (puestopivote - 1)) {
		        quicksort(a, izq, puestopivote-1);
		}		
		//Ordenar parte derecha
		if ((puestopivote + 1) < der) {
		        quicksort(a, puestopivote+1, der);
		}
	}
	
    public static void main(String[] args)
    {
        System.out.println("\nORDENAMIENTO POR QUICKSORT");
		int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
    	int[] a = new int[N];
		int izq = 0;
		int der = N-1;

        //Genero valores aleatorios para llenar las casillas del arreglo "a"
		llenararreglo(a);

        //Imprimo el arreglo original
        System.out.println("\nEl arreglo original es:");
        imprimirarreglo(a);
		System.out.println();

		//Ordeno el arreglo utilizando Quicksort
		quicksort(a, izq, der);
		
		//Imprimo el arreglo ordenado
		System.out.println("\nEl arreglo ordenado por Quicksort es:");       
        imprimirarreglo(a);
		System.out.println("\n");
    }
}
