package huxley.P263_intersecao_listas;

import huxley.LinkedList;
import huxley.LinkedListNode;

import java.io.InputStream;
import java.util.Scanner;

public class Problem263 {
    private static InputStream buffer = System.in;

    Problem263() {}

    Problem263(InputStream buffer) {
        Problem263.buffer = buffer;
    }

    public static void main(String args[]) {
        int n; //variavel que sera usada para ler os inteiros da entrada
        LinkedList<Integer> list1 = new LinkedList<>(), list2 = new LinkedList<>(); //cria as 2 listas que armazenarao 20 elementos, cada uma
        LinkedList<Integer> interseccao = new LinkedList<>(); //cria a lista que armazenara os elementos que estao presentes em ambas as listas, a interseccao

        Scanner scan = new Scanner(buffer);

        int i;
        for (i = 0; i < 20; i++) {
            n = scan.nextInt();
            list1.addToBegin(n); //armazena os 20 primeiros valores em list1
        }
        for (i = 0; i < 20; i++) {
            n = scan.nextInt();
            list2.addToBegin(n); //armazena os 20 valores seguintes em list2
        }

        LinkedListNode<Integer> head1, head2; //ponteiros auxiliares para percorrer as listas 1 e 2, sem que elas percam a referencia para suas cabecas
        for(head1 = list1.head; head1 != null; head1 = head1.next) { //percorre a list1 completamente
            for(head2 = list2.head; head2 != null; head2 = head2.next) { //percorre a list2 completamente
                if (head1.item == head2.item && !interseccao.contains(head1.item)) {//caso o elemento atual da list1 seja igual ao elemento atual da list2 e este elemento ainda NAO esteja presente na lista INTERSECCAO, entao este elemento sera adicionado a lista INTERSECCAO
                    interseccao.addToBegin(head1.item);
                }
            }
        }

        interseccao.sort(); //ordena a lista INTERSECCAO

        System.out.print(interseccao.toString().replaceAll(",", System.lineSeparator())); //imprime a lista INTERSECCAO
    }
}
