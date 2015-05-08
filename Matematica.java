class Matematica {
	Var []variaveis;
	private int topo;


	public Matematica() {
		variaveis = new Var[2000];
		for(int i = 0; i < variaveis.length; i++){
            variaveis[i] = new Var();
        }
		topo=0;
	}
	public void criaVar(String h){
		int aux=0;
		String var;
		aux=this.achar(h,'(');
		var=retVar(')',h,aux);
		if(this.verificaVar(var)==-1){
			variaveis[topo].nome=var;
			topo++;
		}else{
			System.out.println("Var ja existe");
		}
		for(int i =0;i<topo;i++){
			System.out.println(variaveis[i].nome);
		}
	}

	


	public void atribuicao (String h) {
		String var_1,var_2,var_3;
		char tok;
		int aux=0;
		var_1=this.retVar('=',h,0);
		aux=this.achar(h,'=');
    	StringBuilder sb = new StringBuilder();
		for(int i=aux;h.charAt(i) != '+' && h.charAt(i) != '-' && h.charAt(i) != '*' && h.charAt(i) != '/' && h.charAt(i) != ';';i++){
			sb.append(h.charAt(i));
			aux=i;
		}
		var_2 = sb.toString();
		tok=h.charAt(aux+1);
		if(tok != ';'){
			var_3=this.retVar(';',h,aux+2);
		}
		
		System.out.println(var_1);
		System.out.println(var_2);
		System.out.println(var_3);
		System.out.println(tok);
		
	}
	
	public boolean ehVar (String h) {
		char a = h.charAt(0);
			if(a >= 'A' && a <'[' || a>='a' && a<'}'){
				return true;
			}
		return false;

	}

	public double operacao(double a, double b, char c){
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

		return a;
	}

	public int verificaVar(String h){
		for(int i =0;i<topo;i++){
			if(h.equals(variaveis[i].nome)){
				return i;
			}
		}
		return -1;
	}

	public int achar (String h,char c){
		int i=0;
		int aux=0;
		for(i=0;i<h.length();i++){
    		aux=i;
    		if(h.charAt(i)==c){
    			aux++;
    			break;
    		}
    	}
    	return aux;
	}


	public void imprime (String h) {
    	int i;
    	double var;
    	String vari;
    	int c;
    	int aux=0;
    	aux=this.achar(h,'(');
    	for(i=aux;h.charAt(i) != ')';i++){
    		if(h.charAt(i) != '$'){ 
    			if(h.charAt(i) == '\\'){
    				System.out.println("");
    			}else{
    				System.out.print(h.charAt(i));
    			}
    		}else{
    			vari=this.retVar(' ',h,i+1);
    			aux=this.verificaVar(vari);
    			if(aux>=0){
    				var=variaveis[aux].getValor();
    				System.out.print(var);
    			}else{
    				System.out.println("Var n existe");
    			}
    		}

    	}
    }

    public String retVar (char c,String h, int aux){
    	String var;
    	StringBuilder sb = new StringBuilder();
		for(int i=aux;h.charAt(i) != c;i++){
			sb.append(h.charAt(i));
		}
		var = sb.toString();
		return var;
    }




}
