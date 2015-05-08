/**
 * Exemplo de interpretador.
 */

class Interpretador {
    private String linhas[];
    private Matematica mat= new Matematica();

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
            		mat.imprime(this.linhas[i]);
            	}else if(this.linhas[i].contains("#Var")==true){
                    mat.criaVar(this.linhas[i]);
                }else if(this.linhas[i].contains("#Se")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("#Le")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("#Enquanto")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("#Fimse")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("#Fimenquanto")==true){
                    //mat.criaVar(this.linhas[i])
                }else if(this.linhas[i].contains("=")==true){
                    mat.atribuicao(this.linhas[i]);
                }else{
                    System.out.println("Nao foi possivel interpretar");
                }
            }
        }
    }
}