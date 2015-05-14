/**
 *  Interpretador:
 *  Desenvolvido para a disciplina de Programação I da Universidade Federal da Fronteira Sul.
 *  Através da linguagem java, a classe Interpretador é usada para interpretar o código do arquivo.
 *  Para maiores informações do uso da linguagem GB consulte o manual.
 *  Link repositório: https://github.com/LeticiaGenadeze/Interpretador-GB
 *  Por João Barp <joaobarp@hotmail.com> e Leticia Genadeze <lety_genadeze@hotmail.com>
 * 
 */

class Interpretador {
    private String linhas[];
    private Matematica mat= new Matematica();
    private boolean[] valida = new boolean[200];
    private boolean[] valida2 = new boolean[200];
    private int[] linha = new int[200];
    private int[] volta =  new int[200];
    private int[] fim =  new int[200];
    private int escopoIf=0;
    private int escopoLaco=0;

    public void interpreta(String l[]) {
        valida[0]=true;
        valida2[0]=true;
        volta[0]=0;
        this.linhas = l;
        String palavra;
        //retira os espaços, menos em linhas que tem imprime
        for(int i=0; linhas[i] != null; i++){
            if(this.linhas[i].contains("#Imprime")==false) {
                linhas[i]=linhas[i].replaceAll(" ","") ;
                linhas[i]=linhas[i].replaceAll("\t","") ;
            }
        }

        for(int i = 0; i < this.linhas.length; i++) {
            if(this.linhas[i] != null) {
            	if(this.linhas[i].contains("#Imprime")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
            		  mat.imprime(this.linhas[i]);
                    }
            	}else if(this.linhas[i].contains("#Var")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                        mat.criaVar(this.linhas[i]);
                    }
                }else if(this.linhas[i].contains("#Se")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                        escopoIf++;
                        valida[escopoIf]=mat.leExp(this.linhas[i]);
                    }else{
                        escopoIf++;
                    }
                }else if(this.linhas[i].contains("#Le")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                        mat.scan(this.linhas[i]);
                    }
                }else if(this.linhas[i].contains("#Enquanto")==true){
                	if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                		if(volta[escopoLaco]==1){
                			
                			valida2[escopoLaco]=mat.leExp(this.linhas[i]);	
                		}else{
                            escopoLaco++;
                            linha[escopoLaco]=i-1;
                			 valida2[escopoLaco]=mat.leExp(this.linhas[i]);
                		}	
                	}else{
                        if(volta[escopoLaco]==1){
                            valida2[escopoLaco]=false;
                        }
                        
                        escopoLaco++;
                        valida2[escopoLaco]=false;
                	}
                }else if(this.linhas[i].contains("#Fimse")==true){
                    escopoIf--;
                }else if(this.linhas[i].contains("#Fimenquanto")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                        volta[escopoLaco]=1;
                        //fim[escopoLaco]=i;
                        i=linha[escopoLaco];
                    }else{
                        volta[escopoLaco]=0;
                        escopoLaco--;
                    }
                }else if(this.linhas[i].contains("=")==true){
                    if(valida[escopoIf]==true && valida2[escopoLaco]==true){
                        mat.atribuicao(this.linhas[i]);
                    }
                }else{
                    System.out.println("Nao foi possivel interpretar");
                }
            }
        }
    }
}