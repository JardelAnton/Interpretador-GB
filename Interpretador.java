/**
 * Exemplo de interpretador.
 */

class Interpretador {
    private String linhas[];
    private Matematica mat= new Matematica();
    private boolean[] valida = new boolean[200];
    private int escopoIf=0;

    public void interpreta(String l[]) {
        valida[escopoIf]=true;
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
                    if(valida[escopoIf]==true){
            		  mat.imprime(this.linhas[i]);
                    }
            	}else if(this.linhas[i].contains("#Var")==true){
                    if(valida[escopoIf]==true){
                        mat.criaVar(this.linhas[i]);
                    }
                }else if(this.linhas[i].contains("#Se")==true){
                    if(valida[escopoIf]==true){
                        escopoIf++;
                        valida[escopoIf]=mat.leExp(this.linhas[i]);
                    }else{
                        escopoIf++;
                    }
                }else if(this.linhas[i].contains("#Le")==true){
                    if(valida[escopoIf]==true){
                        mat.scan(this.linhas[i]);
                    }
                }else if(this.linhas[i].contains("#Enquanto")==true){
                     if(valida[escopoIf]==true){
                     //mat.criaVar(this.linhas[i])
                     }
                }else if(this.linhas[i].contains("#Fimse")==true){
                    escopoIf--;
                }else if(this.linhas[i].contains("#Fimenquanto")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("=")==true){
                    if(valida[escopoIf]==true){
                        mat.atribuicao(this.linhas[i]);
                    }
                }else{
                    System.out.println("Nao foi possivel interpretar");
                }
            }
        }
    }
}