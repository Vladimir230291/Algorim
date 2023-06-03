package Lesson_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
    private class Node {
        private int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);

        }
        private void add(Node current, int value) {
            if (value < current.value) {
                if(current.left == null){
                    current.left = new Node(value);
                } else {
                    add(current.left, value);
                }
                } else if (value > current.value) {
                   if(current.right == null){
                    current.right = new Node(value);
                } else {
                    add(current.right, value);
                }

        }
    }

    private boolean contains(int value) {
        return findNode(root, value) != null;
    }
    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            return findNode(current.left, value);
        } else if (value > current.value) {
            return findNode(current.right, value);
        } else {
            return current;
        }
    }
    public void remove(int value) {
        root = removeNode(root, value);


    }
//    метод который удаляет моду и возвращает ту ноду, которая будет вместо нее
    private Node removeNode(Node current, int value) {
        if (current == null)
            return null;
        if (value < current.value){
            current.left = removeNode(current.left, value);
            return current; 
        } else if (value> current.value) {
            current.right = removeNode(current.right, value);
            return current;
        }
//        1.У удоляемого узла нет дочерних узлов
        if (current.left == null && current.right == null) {
            return null;
        }
//        2.У узла один дочерний узел
        if (current.left != null && current.right == null) {
            return current.left;
        }
        if (current.right != null && current.left == null) {
            return current.right;
        }
//        3.У узла два дочерних узла
//        Ищем минимальный элемент в правом поддереве
        Node smallestNodeOnTheRight = findFirstNode(current.right);
        int smallestValueOnTheRight = smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight;
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }
        private Node findFirstNode(Node current) {
        if (current.left != null){
            return findFirstNode(current.left);
        }
        return current;
    }
    public int findFirst() {
        if (root == null){
            throw new IllegalArgumentException("Список пуст");
        }
        return findFirstNode(root).value;
    }
//    Поиск в глубину DFS
//    Поиск в ширину BFS
    public List<Integer> dfs() {
        if (root == null){
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return List.copyOf(result);

    }
    private void dfs(Node current, List<Integer> result) {
//        in-order
        if (current.left != null) {
            dfs(current.left, result);
        }
        result.add(current.value);
        if (current.right != null) {
            dfs(current.right, result);
        }
    }
    public List<Integer> bfs() {
        if (root == null){
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            result.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

        }
        return result;

    }
}


