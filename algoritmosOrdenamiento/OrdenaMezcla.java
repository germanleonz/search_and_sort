/**
 * Archivo: OrdenaMezcla.java
 *
 * Descripcion: Implementacion en Java/JML del algoritmo de ordenamiento
 *              por mezcla
 *
 * Autor: German Leon
 */

package algoritmosOrdenamiento;

public class OrdenaMezcla
{
    private static void llenararreglo(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random()*a.length);
        }
    }	

    private static void imprimirarreglo(int []a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + ", ");
        }
    }

    public static void mezclar(int[] a, int izq, int m, int der)
    {
        //COMO PRECONDICION LA PARTE DE O A LA MITAD DEBE ESTAR ORDENADA Y LA PARTE DE
        //LA MITAD A N DEBE ESTAR ORDENADA
        int[] temp = new int[der+1];
        int point1 = izq;
        int point2 = m + 1;
        int point3 = izq;

        while (point3 <= der)
        {
            if ( (point1 < (m+1)) && ((point2 > der) || (a[point1] <= a[point2]) ))
            {
                temp[point3] = a[point1];
                point1++;
            }
            else	//Guardo un elemento del subarreglo derecho
            {
                temp[point3] = a[point2];
                point2++;
            }
            point3++;
        }
		
        for (int i = izq; i <= der; i++)
        {
            a[i] = temp[i];	//Guardo los valores ordenados del arreglo original
        }
    }

    public static void ordenaMezcla(int[] a, int izq, int der)
    {
    	if (izq < der)
		{
            int m = (izq + der) / 2;
            ordenaMezcla(a, izq, m); //Ordena la primera mitad del arreglo original [0...n/2)
            ordenaMezcla(a, m+1, der); //Ordena la segunda mitad del arreglo original [n/2...n)
            mezclar(a, izq, m, der);  // Une los dos subarreglos en uno principal, el cual será el arreglo original ordenado
		}
    }

    /**
     * Programa cliente para probar el algoritmo de ordenamiento por mezcla
     */
    public static void main(String[] args)
    {
    	System.out.println("\nORDENAMIENTO POR MEZCLA");
		int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
       	int[] a = new int[N];
		int izq = 0;
		int der = N - 1;
	
		//Genero valores aleatorio para llenar las casillas del arreglo "a"        
		llenararreglo(a);

		//Imprimo el arreglo original
       	System.out.println("\nEl arreglo original es:");
       	imprimirarreglo(a);

		//Ordeno el arreglo utilizando ordenamiento por mezcla (Merge-sort)
		ordenaMezcla(a,izq,der);			
		
		//Imprimo el arreglo ordenado
		System.out.println("\n\nEl arreglo ordenado es:");       
       	imprimirarreglo(a);
		System.out.println("\n");
    }
}
