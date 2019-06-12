class Nodo{
	private String Valor;
	private Nodo sgte;

	void Nodo(){
		this.Valor=null;
		this.sgte=null;
	}
	String getValor(){
		return Valor;
	}
	void setValor(String valor){
		this.Valor=valor;
	}
	Nodo getSgte(){
		return sgte;
	}
	void setSgte(Nodo next){
		this.sgte=next;
	}
}