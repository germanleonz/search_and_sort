package algoritmosOrdenamiento;

public class OrdenaBurbuja {
    private static void llenarArreglo(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*100);
        }

    }

    private static void imprimirArreglo(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static void ordenaBurbuja(int[] a) {        
        int temp;
        for (int j = 0; j < a.length-1; j++) {
            int ult = a.length - j;
            for (int k = 0; k < ult-1; k++) {
                if (a[k+1] < a[k]) {
                    temp = a[k];
                    a[k] = a[k+1];
                    a[k+1] = temp;
                }
            }
        }
    }

    /**
     * Cliente para probar el ordenamiento por burbuja
     */
    public static void main(String[] args) {
        System.out.println("\nORDENAMIENTO POR BURBUJA (BUBBLE-SORT)");        
        int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
        int[] a = new int[N];

        //Genero valores aleatorio para llenar las casillas del arreglo "a"        
        llenarArreglo(a);

        //Imprimo el arreglo original
        System.out.println("\nEl arreglo original es:");
        imprimirArreglo(a);
        System.out.println();

        //Ordeno el arreglo utilizando ordenamiento por burbuja
        ordenaBurbuja(a);			

        //Imprimo el arreglo ordenado
        System.out.println("\nEl arreglo ordenado por burbuja es:");       
        imprimirArreglo(a);
        System.out.println("\n");
    }
}
