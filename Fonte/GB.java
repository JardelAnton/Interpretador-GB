/**
 * Para executar, rode o seguinte comando no terminal:
 * java GB ./teste.gb
 *
 * 
 */

import java.util.Scanner;
import java.io.*;

class GB {
    public static void main(String args[]) throws Exception {
        File f;
        Scanner s;
        Interpretador b;
        String linhas[] = new String[2000]; // arquivo pode ter, no máximo, 2000 linhas.

        // args[0] conterá o caminho para o arquivo que serah interpretado.
        f = new File(args[0]);

        // Mandamos o Scanner ler a partir do arquivo.
        s = new Scanner(f);
        // Instanciamos o interpretador.
        b = new Interpretador();

        // Lemos todas as linhas do arquivo para dentro do
        // vetor "linhas".
        int i = 0;
        while(s.hasNext()) {
            linhas[i] = s.nextLine();
            i++;
        }
        /*
        for(i=0; linhas[i] != null; i++){
            if(linhas[i].contains("#Imprime")==false) {
                linhas[i]=linhas[i].replaceAll(" ","") ;
            }
        }
 
         for(int x = 0; linhas[x] != null; x++) {
            System.out.println(linhas[x]);
        }
        */

        // Inicializamos o interpretador com o vetor de linhas. A partir
        // desse ponto, o objeto "b" irá interpretar o código lido do arquivo.
        b.interpreta(linhas);
    }
}
