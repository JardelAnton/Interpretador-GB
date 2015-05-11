import java.util.Scanner;
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
			variaveis[topo].setValor(0.0);
			topo++;
		}else{
			System.out.println("Var ja existe");
		}
		//for(int i =0;i<topo;i++){
		//	System.out.println(variaveis[i].nome);
		//}
	}

	public void atribuicao (String h) {
		String var_1,var_2,var_3;
		Character tok;
		int aux=0;
		int pqp;
		double a=0,b=0,c=0;
		var_1=this.retVar('=',h,0);
		aux=this.achar(h,'=');
    	StringBuilder sb = new StringBuilder();
		for(int i=aux;h.charAt(i) != '+' && h.charAt(i) != '-' && h.charAt(i) != '*' && h.charAt(i) != '/' && h.charAt(i) != ';' && h.charAt(i) != '%';i++){
			sb.append(h.charAt(i));
			aux=i;
		}
		var_2 = sb.toString();
		tok= new Character (h.charAt(aux+1));
		pqp=(int)tok;
		if(pqp != 59){
			pqp=2;
			var_3=this.retVar(';',h,aux+2);
		}else{
			pqp=1;
			var_3="";
		}
		if(pqp == 2){
			a=this.pegaValor(var_2);
			b=this.pegaValor(var_3);
		}else{
			a=this.pegaValor(var_2);
		}
		aux=verificaVar(var_1);
		if (aux != -1) {
			c=this.operacao(a,b,tok);
			variaveis[aux].setValor(c);
		}else{
			System.out.println("Var n existe");
		}

		//System.out.println(var_1);
		//System.out.println(var_2);
		//System.out.println(var_3);
		//System.out.println(tok);
		//System.out.println(a);
		
	}

	public double pegaValor(String h){
		int aux;
		double a=0;
		if(this.ehVar(h)){
				aux=verificaVar(h);
				if (aux!=-1){
					a=variaveis[aux].getValor();
				}else{
					System.out.println(" Var n existe ");
				}
			}else{
				a=Double.parseDouble(h);
			}
			return a;
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
		if(c == '%'){
			return (a%b);
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
    	int i,j,g=1;
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
    				g=vari.length();
    				i=i+g;
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

    public void scan(String h){
    	int aux=0;
		String var;
		aux=this.achar(h,'(');
		var=retVar(')',h,aux);
		//System.out.println(var);
		aux=verificaVar(var);
		Scanner scanner = new Scanner(System.in);
		double valor = scanner.nextDouble(); 
		//System.out.println(valor);
		//System.out.println(aux);
		if(aux==-1) {
			this.criaVar(h);
			variaveis[topo-1].setValor(valor);
		}else{
			variaveis[aux].setValor(valor);
		}
    }

    public boolean leExp(String h){
    	boolean x;
    	String var_1,var_2,var_3;
		String boo;
		char tok;
		int aux,con=0;
		double a,b,c;
		aux=this.achar(h,'(');
		StringBuilder sb = new StringBuilder();
		for(int i=aux;h.charAt(i) != '=' && h.charAt(i) != '<' && h.charAt(i) != '>' && h.charAt(i) != '#';i++){
			sb.append(h.charAt(i));
			aux=i;
		}
		var_1 = sb.toString();
		sb = new StringBuilder();
		sb.append(h.charAt(aux+1));
		sb.append(h.charAt(aux+2));
		boo = sb.toString();
		sb = new StringBuilder();
		aux++;
		for(int i=aux+2;h.charAt(i) != '+' && h.charAt(i) != '-' && h.charAt(i) != '*' && h.charAt(i) != '/'&& h.charAt(i) != ')';i++){
			sb.append(h.charAt(i));
			aux=i;
		}
		var_2 = sb.toString();
		tok=h.charAt(aux+1);
		aux++;
		if (h.charAt(aux)==')') {
			con=1;
			var_3="";
		}else{
			var_3=this.retVar(')',h,aux+1);
			con=2;
		}
		if (con==2) {
			a=this.pegaValor(var_1);
			b=this.pegaValor(var_2);
			c=this.pegaValor(var_3);
			b=this.operacao(b,c,tok);
			x=this.ler(a,b,boo);
		}else{
			a=this.pegaValor(var_1);
			b=this.pegaValor(var_2);
			x=this.ler(a,b,boo);
		}
		/*
		System.out.println(var_1);
		System.out.println(boo);
		System.out.println(var_2);
		System.out.println(tok);
		System.out.println(var_3);
		System.out.println("");
		System.out.println("");
		*/
		return x;
    }
	public boolean ler(double a, double b, String tok){
		if(tok.equals("==")){
			if(a==b){
				return true;
			}else{
				return false;
			}
		}
		if(tok.equals("#=")){
			if(a!=b){
				return true;
			}else{
				return false;
			}
		}
		if(tok.equals(">>")){
			if(a>b){
				return true;
			}else{
				return false;
			}
		}
		if(tok.equals("<<")){
			if(a<b){
				return true;
			}else{
				return false;
			}
		}
		if(tok.equals("<=")){
			if(a<=b){
				return true;
			}else{
				return false;
			}
		}
		if(tok.equals(">=")){
			if(a>=b){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}