/**
 * Exemplo de interpretador.
 */

class Interpretador {
    private String linhas[];

    public void interpreta(String l[]) {
        this.linhas = l;
        //retira os espaços, menos em linhas que tem imprime
        for(int i=0; i<this.linhas.length; i++){
            if(this.linhas[i].contains("#Imprime")==0) {
                linhas[i]=linhas[i].replaceAll(" ","") ;
            }
        }

        for(int i = 0; i < this.linhas.length; i++) {
            if(this.linhas[i] != NULL) {
            	if(this.linhas[i].contains("#Imprime")==1){
            		this.imprime(this.linhas[i]);
            	}
                // TODO: interpretar a linha
                System.out.println("Linha " + (i + 1) + ": " + this.linhas[i]);
            }
        }
    }


    public void imprime (String h) {
    	int i;
    	double var;
    	int c;
    	int aux;
    	String [5000]j;
    	for(i=0;i<h.length;i++){
    		aux=i;
    		if(h[i]=='('){
    			break;
    		}
    	}
    	for(i=0;h[aux] != ')';i++){
    		c++;
    		j[i]=h[aux];
    		aux++;
    	}
    	for(i=0;i<c;i++){
    		if(h[i] != '$'){
    			System.out.println(this.j[i]);
    		}else{
    			//verifica variavel.
    		}

    	}
    }

}
