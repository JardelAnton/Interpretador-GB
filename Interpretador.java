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
                linhas[i]=linhas[i].trim();
            }
        }

        for(int i = 0; i < this.linhas.length; i++) {
            if(this.linhas[i] != NULL) {
                // TODO: interpretar a linha
                System.out.println("Linha " + (i + 1) + ": " + this.linhas[i]);
            }
        }
    }


    public void imprime (String h) {

    }

}
