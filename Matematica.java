class Matematica {
	Var []variaveis;
	private int topo;


	public Matematica() {
		variaveis = new Var[2000];
		for(int i = 0; i < variaveis.length; i++){
            variaveis[i] = new Variavel();
        }
		topo=0;
	}
	public void criaVar(String h){
		int aux;
		String var;
		aux=this.achar(String h);
		aux++;
		var=retVar(")",h,aux);
		if(this.verificaVar(var)==0){
			variaveis[topo].nome=var;
			topo++;
		}else{
			System.out.println("Var ja existe");
		}
	}
	public void atribuicao (String h) {
		aux=0;
		String a[]= new String[6];
		a[0] = new String();
		a[1] = new String();
		a[2] = new String();
		a[3] = new String();
		a[4] = new String();
		a[5] = new String();
		for(int i=0;h.charAt(i) != '=';i++){
			a[0]=a[0].concat(h.charAt(i));
			aux=i;
		}
		aux++;
		a[1]=h.charAt(aux);
		aux++
		for(i=aux;h.charAt(i) != '+' || h.charAt(i) != '/' || h.charAt(i) != '*' || h.charAt(i) != '-' || h.charAt(i) != ';';i++){
				a[2]=a[2].concat(h.charAt(i));
				aux=i;
		}
		aux++;
		if(h.charAt(aux) == ';'){
			h[3]=';';
		}else{
			h[3]=h.charAt(aux);
			for(i=aux;h.charAt(i) != ';';i++){
				a[4]=a[4].concat(h.charAt(i));
				aux=i;
			}
			aux++;
			a[5]=h.charAt(aux);
		}

	}

	public double operacao(double a, double b, Char c){
		if(c == '+'){
			return (a+b);
		}
		if(c == '-'){
			return (a-b);
		}
		if(c == '*'){
			return (a*b);
		}
		if(c == '/'){
			return (a/b);
		}

	}

	public int verificaVar(String h){
		for(int i =0;i<topo;i++){
			if(h.equals(variaveis[i].nome)){
				return i;
			}
		}
		return 0;
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


	public void imprime (String h) {
    	int i;
    	double var;
    	int c;
    	int aux=0;
    	aux=aux.achar(String h);

    	for(i=aux;h.charAt(i) != ')';i++){
    		if(h.charAt(i) != '$'){ 
    			if(h.charAt(i) == '\\'){
    				System.out.println("");
    			}else{
    				System.out.print(h.charAt(i));
    			}
    		}else{
    			// $
    		}

    	}
    }

    public String retVar (Char c,String h, int aux){
    	String var;
		for(int i=aux;h.charAt(i) != c){
			var=var.concat(h.charAt(i));
		}
		return var;
    }


}
