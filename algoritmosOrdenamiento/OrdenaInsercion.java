/**
 * Archivo: OrdenaInsercion.java
 *
 * Descripcion: Implementacion en Java/JML del algoritmo de ordenamiento
 *              por insercion
 *
 * Autor: German Leon
 */

package algoritmosOrdenamiento;

public class OrdenaInsercion {
    private static void llenarArreglo(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random()*a.length);
        }
    }	

    private static void imprimirArreglo(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + ", ");
        }
    }

    public static void ordenaInsercion(int[] a)
    {
        for (int k = 1; k < a.length; k++)
        {
            int temp = a[k];
            int l;
            for (l = k; l != 0 && temp < a[l-1]; l--) {
                a[l] = a[l-1];
            }
            a[l] = temp;
        }
    }

    /**
     * Cliente para probar el ordenamiento por insercion
     */
    public static void main(String[] args)
    {
        System.out.println("\nORDENAMIENTO POR INSERCION");
        int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
        int[] a = new int[N];

        //Genero valores aleatorios para llenar las casillas del arreglo "a"
        llenarArreglo(a);

        //Imprimo el arreglo original
        System.out.println("\nEl arreglo original es:");
        imprimirArreglo(a);   
        System.out.println();

        //Ordeno el arreglo utilizando ordenamiento por insercion
        ordenaInsercion(a);			

        //Imprimo el arreglo ordenado
        System.out.println("\nEl arreglo ordenado por inserción es:");       
        imprimirArreglo(a);
        System.out.println("\n");
    }
}
