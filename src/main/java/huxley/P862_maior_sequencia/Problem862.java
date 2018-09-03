package huxley.P862_maior_sequencia;

import huxley.util.LinkedList;
import huxley.util.LinkedListNode;

import java.util.Scanner;

public class Problem862 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        String line;
        while (!(line = scan.nextLine()).equals("0")) {
            line = line.concat("\n");
            for (char c : line.toCharArray()) {
                if (c == '\n') { //se o caractere lido for um '\n' significa que a sequencia atual foi concluida e pode ser processada
                    int maiorSeq = 0, maiorSeqI = -1, maiorSeqF = -1, seqAt = 0, seqAtI = 0, seqAtF = 0;
                    /*maiorSeq guarda o tamanho da maior sequencia;
                     *maiorSeqI guarda o inicio da maior sequencia;
                     *maiorSeqF guarda o final da maior sequencia;
                     *seqAt guarda o tamanho da sequencia atual;
                     *seqAtI guarda o inicio da sequencia atual;
                     *seqAtF guarda o final da sequencia atual;
                     */
                    for (LinkedListNode<Integer> head = list.head; head != null; head = head.next) {
                        if (head.item == 0) { //checa se o elemento atual eh um elemento 0, ou seja, se ele deve ser um elemento da sequencia desejada
                            if (seqAt == 0) { //se a sequencia atual tiver tamanho 0, quer dizer que o elemento atual eh o inicio da sequencia atual
                                seqAtI = head.index;
                            }
                            seqAtF = head.index; //atualiza o final da sequencia atual para o elemento atual
                            ++seqAt; //incrementa/atualiza o tamanho da sequencia atual
                        }
                        if (head.item == 1 || head.index == list.tail.index){
                            if (seqAt > maiorSeq) { //caso a sequencia atual seja maior que a maior sequencia armazenada, a maior sequencia agora passa a ser a sequencia atual
                                maiorSeq = seqAt;
                                maiorSeqI = seqAtI;
                                maiorSeqF = seqAtF;
                            }
                            seqAt = 0; //zera o tamanho da sequencia atual, pois ela ja foi processada/comparada e deve ser reiniciada
                        }
                    }
                    System.out.printf("%d %d\n", maiorSeqI, maiorSeqF); //imprime o inicio e o final da maior sequencia

                    list.destroy(); //reseta a lista para o proximo caso/linha de teste
                } else {
                    list.addToEnd(c - '0'); //adiciona o numero lido ao final da lista
                }
            }
        }
    }
}
