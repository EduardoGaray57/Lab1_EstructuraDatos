class ListaCircular{
	private Nodo inicio;
	private Nodo ultimo;

	void ListaCircular(){
		inicio=null;
		ultimo=null;
	}
	// esVecia() es un metodo para verificar ue existe algun elemento en la lista
	boolean esVacia(){
		return inicio==null;
	}
	// agerga elementos al final de la lista
	void agregarAlFinal(String valor){
		Nodo nuevo= new Nodo();
		nuevo.setValor(valor.toUpperCase());
		if(esVacia()){
			inicio=nuevo;
			ultimo=nuevo;
			ultimo.setSgte(inicio);
		}else{			
				ultimo.setSgte(nuevo);
				nuevo.setSgte(inicio);
				ultimo=nuevo;						
		}
	}
	//agrega elemento en la posicion que se le entrege
	void insertarPorPosicion(int posicion, String valor){
		int cont=1;
			Nodo nuevo= new Nodo();
			Nodo aux= inicio;
			nuevo.setValor(valor);
			if(posicion==0){
				nuevo.setSgte(inicio);
				inicio=nuevo;
				ultimo.setSgte(inicio);
			}else{
				while(cont!=posicion){
					cont++;
					aux=aux.getSgte();
				}
				nuevo.setSgte(aux.getSgte());
				aux.setSgte(nuevo);
			}
	}
	//busca el elemento ingresado y debueve true o false si lo encuentra
	boolean buscar(String referencia){
		Nodo aux= inicio;
		boolean encontrado=false;
		do{
			if(referencia.equalsIgnoreCase(aux.getValor())){
				System.out.println(aux.getValor());
				System.out.println("---------");
				encontrado=true;
			}else{
				System.out.println(aux.getValor());
				System.out.println("---------");
				aux=aux.getSgte();
			}
		}while(aux != inicio && encontrado != true);
		return encontrado;
	}
	//se ingresa una posiicon y modeifa el dato en ella
	void editarPorPosicion(int posicion, String valor){
		if(posicion >= 0 && posicion<contar()){
			if(posicion == 0){
				inicio.setValor(valor);
			}else{
				Nodo aux= inicio;
				for (int i = 0;i < posicion ;i++ ) {
					aux=aux.getSgte();
				}
				aux.setValor(valor);
			}
		}
	}
	//se ingresa el dato a eliminar
	void removerPorReferencia(String referencia){
		if(buscar(referencia)){
			if(inicio.getValor().equalsIgnoreCase(referencia)){
				inicio=inicio.getSgte();
				ultimo.setSgte(inicio);

			}else{
				Nodo aux= inicio;
				while(!aux.getSgte().getValor().equalsIgnoreCase(referencia)){
					aux= aux.getSgte();
				}
				if(aux.getSgte() == ultimo){
					aux.setSgte(inicio);
					ultimo = aux;
				}else{
					Nodo sgte= aux.getSgte();
					aux.setSgte(sgte.getSgte());
				}
			}
		}
	}
	//elimina el dato en la posicio ingresada
	void removerPorPosicion(int posicion){
		if(posicion>=0 && posicion<contar()){
			if(posicion == 0){
				inicio= inicio.getSgte();
				ultimo.setSgte(inicio);
			}else{
				Nodo aux = inicio;
				for (int i = 0;i<posicion-1 ;i++ ) {
					aux=aux.getSgte();
				}
				if(aux.getSgte()== ultimo){
					aux.setSgte(inicio);
					ultimo=aux;
				}else{
					Nodo sgte = aux.getSgte();
					aux.setSgte(sgte.getSgte());
				}
			}
		}
	}
	//vacia la lista completa
	void eliminar(){
		inicio=null;
		ultimo=null;
	}
	//muestra la lista completa
	void lista(){
		if(!esVacia()){
			Nodo aux=inicio;
			int i=0;
			System.out.println("->");
			do{
				System.out.println(i+".[ "+aux.getValor() + " ]" + " ->");
				aux=aux.getSgte();
				i++;
			}while(aux != inicio);
		}
	}
	Nodo getInicio(){
		return inicio;
	}
	Nodo getUltimo(){
		return ultimo;
	}
	//elimina solamente el ultimo elemnto de la lista
	void eliminarUltimo(){
		Nodo aux= new Nodo();
		aux=inicio;
		while(aux.getSgte().getValor()!=ultimo.getValor()){
			aux=aux.getSgte();
		}
		if(aux.getSgte()==ultimo){
			aux.setSgte(inicio);
			ultimo=aux;
		}else{
			Nodo sgte=aux.getSgte();
			aux.setSgte(sgte.getSgte());
		}	
	}
	//me devuelve el largo de la lista
	int contar(){
		int contado=0;
		Nodo aux=inicio;
		while(aux!=getUltimo()){
			contado++;
			aux=aux.getSgte();
		}
		return contado+1;
	}
	//verfica si el dato ingresado esta repetido en la lista
	boolean comparar(String x){
		Nodo temp=inicio;
		boolean comp=false;
		do{
			if(x.equalsIgnoreCase(temp.getValor())){
				comp=true;
			}else{
				temp=temp.getSgte();
			}
		}while(temp != inicio && comp != true);
		return comp;
	}
	//ordena la lista de forma alfabetica
	void ordenar(){
		if(inicio!=null && ultimo!=null){
			Nodo aux;
			Nodo actual;
			String temp;
			aux=inicio;
			while(aux!=ultimo){
				actual=aux.getSgte();
				while(actual!=inicio){
					if(aux.getValor().compareTo(actual.getValor())>0){
						temp=aux.getValor();
						aux.setValor(actual.getValor());
						actual.setValor(temp);
					}
					actual=actual.getSgte();
				}
				aux=aux.getSgte();
			}
		}else{
			System.out.println("lista no inicialisada");
		}
	}
}