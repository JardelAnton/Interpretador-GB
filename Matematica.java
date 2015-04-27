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
		aux=this.achar(h);
		aux++;
		var=retVar(')',h,aux);
		if(this.verificaVar(var)==0){
			variaveis[topo].nome=var;
			topo++;
		}else{
			System.out.println("Var ja existe");
		}
	}
	public void atribuicao (String h) {
		int aux=0;
		double a=0,b=0;
		int pos=0;
		int i;
		String temp[];
		for(i=0;h.charAt(i) != '=';i++){
			temp[0]=temp[0].concat(h.charAt(i));
			aux=i;
		}
		aux++;
		temp[1]=h.charAt(aux);
		aux++;
		for(i=aux;h.charAt(i) != '+' && h.charAt(i) != '/' && h.charAt(i) != '*' && h.charAt(i) != '-' ;i++){
				temp[2]=temp[2].concat(h.charAt(i));
				aux=i;
		}
		aux++;
		if(h.charAt(aux) == ';'){
			temp[3]=';';
		}else{
			temp[3]=h.charAt(aux);
			for(i=aux;h.charAt(i) != ';';i++){
				temp[4]=temp[4].concat(h.charAt(i));
				aux=i;
			}
			aux++;
			temp[5]=h.charAt(aux);
		}
		if(this.ehVar(temp[2])){
			pos=this.verificaVar(temp[2]);
			if(pos>=0){
				a=variaveis[pos].getValor();
			}else{
					System.out.println(temp[2]+"n existe");
				}
			
		}else{
			a=Double.parseDouble(temp[2]);
		}
		
		if(temp[3].charAt(1) != ';'){
			if(this.ehVar(temp[4])){
				pos=this.verificaVar(temp[4]);
				if(pos>=0){
					b=variaveis[pos].getValor();
				}else{
					System.out.println(temp[4]+"n existe");
				}
			}else{
				b=Double.parseDouble(temp[4]);
			}
		}else{
			b=0;
		}
		pos=this.verificaVar(temp[0]);
		if(temp[1].charAt(0)== '='){
			if (pos>=0){
				double x=this.operacao(a,b,a.charAt(1));
				variaveis.setValor(x);
			}
		}

	}

	public boolean ehVar (String h) {
		char a = h.charAt(1);
			if(a < 'A' || a > 'z'){
				return false;
			}
		return true;

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

	}

	public int verificaVar(String h){
		for(int i =0;i<topo;i++){
			if(h.equals(variaveis[i].nome)){
				return i;
			}
		}
		return -1;
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
    	String vari;
    	int c;
    	int aux=0;
    	aux=this.achar(h);

    	for(i=aux;h.charAt(i) != ')';i++){
    		if(h.charAt(i) != '$'){ 
    			if(h.charAt(i) == '\\'){
    				System.out.println("");
    			}else{
    				System.out.print(h.charAt(i));
    			}
    		}else{
    			vari=this.retVar(" ",h,i+1);
    			aux=this.verificaVar(vari);
    			if(aux>=0){
    				var=variaveis[aux].getValor();
    			}else{
    				System.out.println("Var n existe");
    			}
    		}

    	}
    }

    public String retVar (char c,String h, int aux){
    	String var;
		for(int i=aux;h.charAt(i) != c;i++){
			var=var.concat(h.charAt(i));
		}
		return var;
    }




}
