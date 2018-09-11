package huxley.util;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Random rand = new Random();

    @Test
    void initialize() {
        for (int i = 0; i < 100; i++) {
            int element = rand.nextInt();
            Tree tree = new Tree(element);
            assertEquals(element, tree.item, "Elemento na raiz da árvore não é o mesmo adicionado");
            assertNull(tree.left);
            assertNull(tree.right);
        }
    }

    @Test
    void formTreeAndIsBinarySearchTree() {

        String str = "(5()())";
        Tree tree = Tree.formTree(str);
        assertTrue(tree.isBinarySearchTree(), "Falhou ao verificar que é uma árvore de busca binária");
        assertEquals(5, tree.item, "Elemento na raiz da árvore não é o mesmo adicionado");
        assertNull(tree.right);
        assertNull(tree.left);

        tree.left = Tree.formTree("(3(2(1()())()) (4()()))");
        assertEquals(3, tree.left.item, "Elemento no topo da sub-árvore esquerda não é o mesmo adicionado");
        assertEquals(2, tree.left.left.item, "Elemento não é o esperado");
        assertEquals(4, tree.left.right.item, "Elemento no topo da sub-árvore direita não é o mesmo adicionado");
        assertNull(tree.left.right.right, "Elemento não é folha");
        assertNull(tree.left.right.left, "Elemento não é folha");
        assertTrue(tree.isBinarySearchTree());

        tree.right = Tree.formTree("(1()())");
        assertFalse(tree.isBinarySearchTree(), "Falhou ao verificar que não é uma árvore de busca binária");

        tree = Tree.formTree("(5 (64()()) (10()()))");
        assertFalse(tree.isBinarySearchTree());

        tree = Tree.formTree("(7 (7()()) (7()()))");
        assertFalse(tree.isBinarySearchTree());

        tree = Tree.formTree("(10 (1()()) (2()()))");
        assertFalse(tree.isBinarySearchTree());

        assertThrows(Exception.class, () -> Tree.formTree("(5()(412"),
                "Não disparou exceção ao tentar fazer uma tree com string inválida");

        assertTrue(tree.isBinarySearchTree(null));
    }

    @Test
    void contains() {
        Tree tree = Tree.formTree("(5 (3 (2 (0 (-500()()) (1()())) ()) (4 ()())) (8 (6()()) (10 () (2540()()))))");
        assertTrue(tree.isBinarySearchTree());
        assertTrue(tree.contains(5) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(3) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(2) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(1) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(4) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(8) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(6) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(10) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(0) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(-500) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(2540) != -1, "Falhou em encontrar o elemento");
        assertTrue(tree.contains(0) != -1, "Falhou em encontrar o elemento");
        assertEquals(tree.contains(69), -1, "Encontrou um elemento que não existe");
        assertEquals(tree.contains(73), -1, "Encontrou um elemento que não existe");
        assertEquals(tree.contains(-5), -1, "Encontrou um elemento que não existe");
        assertEquals(tree.contains(-55), -1, "Encontrou um elemento que não existe");
        assertEquals(tree.contains(7845), -1, "Encontrou um elemento que não existe");

        tree = Tree.formTree("(10 (5()())(5()()))");
        assertFalse(tree.isBinarySearchTree());
        assertTrue(tree.contains(5) != -1);
    }
}
