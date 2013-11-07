import Console;

public class OrdenaStrings
{
	private static void llenararreglo(String[] a)
	{
        	System.out.println("\nIntroduzca los nombres de los estudiantes:");		
		for (int i=0; i<a.length; i++) 
		{
			a[i]=Console.readString("a["+i+"]:");
		}
    	}

	private static void imprimirarreglo(String []a)
    	{
        	for (int i=0; i<a.length; i++)
            	{
            	    System.out.print(a[i] + ", ");
            	}
    	}

	private static void intercambiar(String[] a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void ordenaseleccion(String[] a)
	{        
		int menor=0;
	    	for(int i=0; i<(a.length-1);i++)
		{
			menor=i;
			for(int j=i+1; j<a.length; j++)
			{
				if ((a[j].compareTo(a[menor]))<0)
				menor=j;
			}
			if (menor!=i)
			{
				intercambiar(a,i,menor);
			}
		}
	}
	
	public static void main(String[] args)
	{
	        System.out.println("\nORDENAMIENTO POR SELECCION");
		int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
	        String[] a= new String[N];
		
		//Genero valores aleatorio para llenar las casillas del arreglo "a"        
		llenararreglo(a);

		//Imprimo el arreglo original
        	System.out.println("\nEl arreglo original es:");
        	imprimirarreglo(a);
		System.out.println();

		//Ordeno el arreglo utilizando ordenamiento por seleccion
		ordenaseleccion(a);			
	
		//Imprimo el arreglo ordenado
		System.out.println("\nEl arreglo ordenado por seleccion es:");       
        	imprimirarreglo(a);
		System.out.println("\n");
	}
}
