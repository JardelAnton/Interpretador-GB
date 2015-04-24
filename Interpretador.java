/**
 * Exemplo de interpretador.
 */

class Interpretador {
    private String linhas[];
    private Matematica mat;

    public void interpreta(String l[]) {
        this.linhas = l;
        //retira os espaços, menos em linhas que tem imprime
        for(int i=0; linhas[i] != null; i++){
            if(this.linhas[i].contains("#Imprime")==false) {
                linhas[i]=linhas[i].replaceAll(" ","") ;
            }
        }

        for(int i = 0; i < this.linhas.length; i++) {
            if(this.linhas[i] != null) {
            	if(this.linhas[i].contains("#Imprime")==true){
            		this.imprime(this.linhas[i]);
            	}
                // TODO: interpretar a linha
               
            }
        }
    }


    public void imprime (String h) {
    	int i;
    	double var;
    	int c;
    	int aux=0;
    	String []j;
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

}






