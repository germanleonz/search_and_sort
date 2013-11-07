/**
 * Archivo: OrdenaSeleccion.java
 *
 * Descripcion: Implementacion en Java/JML del algoritmo de ordenamiento
 *              por seleccion
 *
 * Autor: German Leon
 */

package algoritmosOrdenamiento;

public class OrdenaSeleccion
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

    public static void intercambiar(int[] a, int i, int j)
    {
        int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
    }

    public static void ordenaSeleccion(int[] a)
    {
        int menor = 0;
		for(int i = 0; i < (a.length-1); i++) 
		{
            menor = i;
            for(int j = i+1; j < a.length; j++)
            {
                if (a[j] < a[menor]) {
					intercambiar(a, i, menor);
				}
            }
		}
    }

    /**
      * Cliente para probar el ordenamiento por seleccion
      */
    public static void main(String[] args)
    {
        System.out.println("\nORDENAMIENTO POR SELECCION");
		int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
		int[] a = new int[N];
		
		//Genero valores aleatorio para llenar las casillas del arreglo "a"        
		llenararreglo(a);

		//Imprimo el arreglo original
		System.out.println("\nEl arreglo original es:");
		imprimirarreglo(a);
		System.out.println();

		//Ordeno el arreglo utilizando ordenamiento por seleccion
		ordenaSeleccion(a);			
	
		//Imprimo el arreglo ordenado
		System.out.println("\nEl arreglo ordenado por seleccion es:");       
		imprimirarreglo(a);
		System.out.println("\n");
    }
}
