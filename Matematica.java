class Matematica {
	Var []variaveis;
	private int topo;


	public Matematica() {
		variaveis = new Var[1000];
		topo=0;
	}
	public void criaVar(String h){
		int aux;
		String var;
		aux=this.achar(String h);
		aux++;
		for(int i=aux;h.charAt(i) !=')';i++){
			var=var.concat(h.charAt(i));
		}
		if(this.verificaVar(var)==0){
			variaveis[topo].nome=var;
			topo++;
		}


	}

	public boolean verificaVar(String h){
		for(int i =0;i<topo;i++){
			if(h.equals(variaveis[i].nome)){
				return true;
			}
		}
		return false;
	}

	public int achar (String h){
		int i=0;
		int aux=0;
		for(i=0;i<h.length();i++){
    		aux=i;
    		if(h.charAt(i)=='('){
    			aux++;
    			break;
    		}
    	}
    	return aux;
	}

}