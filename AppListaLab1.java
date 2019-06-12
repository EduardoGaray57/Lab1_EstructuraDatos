import java.util.Scanner;
class AppListaLab1{
	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		int opciones;
		boolean salir=false;
		boolean tex=false;
		ListaCircular LC= new ListaCircular();
		LC.agregarAlFinal("pedro");
		LC.agregarAlFinal("juan");
		LC.agregarAlFinal("diego");
		LC.agregarAlFinal("carlos");
		LC.agregarAlFinal("alfredo");
		LC.agregarAlFinal("tomas");
		LC.agregarAlFinal("manuel");
		LC.agregarAlFinal("esteban");
		LC.agregarAlFinal("moises");
		LC.agregarAlFinal("david");
		LC.lista();
		while(!salir){
		System.out.println("Menu de acciones");
		System.out.println("1.Ingreso de datos nuevo");
		System.out.println("2.Ingreso de datos nuevo por una posicion especifica");
		System.out.println("3.Busqueda de elementos");
		System.out.println("4.Eliminar ultimo nodo");
		System.out.println("5.Eliminacion especifica");
		System.out.println("6.Modificar dato por posicion");
		System.out.println("7.Ordenar");
		System.out.println("8.Largo de la lista");
		System.out.println("9.Mostrar lista");
		System.out.println("10.Salir");
		opciones=teclado.nextInt();
			switch(opciones){
				case 1:										
					System.out.println("Ingrese dato");
					String valor=teclado.next();
					while(LC.comparar(valor)){						
						System.out.println("Valor ingresado esta repetido, porfavor ingrese un nuevo valor:");
						valor=teclado.next();							
					}					
						do{
							if(valor.matches("^[A-Za-z ]*$")){
								LC.agregarAlFinal(valor.toUpperCase());
								tex=true;
							}else{
								System.out.println("Ingrese un dato valido");
								valor=teclado.next();
								tex=false;
							}
						}while(!tex);														
					break;
				case 2:
					int posicion;
					String dato;
					System.out.println("Ingrese posicion");
					posicion=teclado.nextInt();
					System.out.println("Ingrese dato");
					dato=teclado.next().toUpperCase();
					while(LC.comparar(dato)){						
						System.out.println("Valor ingresado esta repetido, porfavor ingrese un nuevo valor:");
						dato=teclado.next();							
					}					
						do{
							if(dato.matches("^[A-Za-z ]*$")){
								LC.insertarPorPosicion(posicion, dato);
								tex=true;
							}else{
								System.out.println("Ingrese un dato valido");
								dato=teclado.next();
								tex=false;
							}
						}while(!tex);
					
					break;
				case 3:
					String busqueda;
					System.out.println("Ingrese valor de busqueda");
					busqueda=teclado.next().toUpperCase();
					if(!busqueda.matches("^[A-Za-z ]*$")){
						System.out.println("Ingrese solamente texto");
						busqueda= teclado.next().toUpperCase();
					}
					System.out.println("------------");					
					if(LC.buscar(busqueda)){
						System.out.println("Valor encontrado");
					}else{
						System.out.println("Valor no encontrado el valor de inicio es : "+LC.getInicio().getValor());						
					}
					break;
				case 4:
					LC.eliminarUltimo();
					break;
				case 5:
					String referencia;
					System.out.println("Ingrese un texto de especifico a eliminar para eliminar");
					referencia= teclado.next().toUpperCase();
					if(!referencia.matches("^[A-Za-z ]*$")){
						System.out.println("Ingrese solamente texto");
						referencia= teclado.next();
					}
					LC.removerPorReferencia(referencia);				
					break;
				case 6:
					int localizador;
					String texto;
					System.out.println("Ingrese la posicion que desee modifica");
					localizador= teclado.nextInt();
					while(localizador<0){
						System.out.println("Ingrese un valor positivo");
						localizador=teclado.nextInt();
					}
						System.out.println("Ingrese el nuevo texto");
						texto=teclado.next();
						while(LC.comparar(texto)){						
							System.out.println("Valor ingresado esta repetido, porfavor ingrese un nuevo valor:");
							texto=teclado.next();							
						}					
						do{
							if(texto.matches("^[A-Za-z ]*$")){
								LC.editarPorPosicion(localizador,texto.toUpperCase());
								tex=true;
							}else{
								System.out.println("Ingrese un dato valido");
								texto=teclado.next();
								tex=false;
							}
						}while(!tex);
					
					break;	
				case 7:
					LC.ordenar();
					LC.lista();
					break;
				case 8:
					System.out.println("largo solo verificando nodos");
					System.out.println("el largo es: "+LC.contar());
					break;
				case 9:
					LC.lista();
					break;
				case 10:
					salir=true;
					break;
			}			
		}
	}
}