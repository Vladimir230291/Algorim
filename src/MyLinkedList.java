class MyLinkedList {
       private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    private Node head;


    public void add (int data){
        Node node = new Node(data);
        if(head == null){
            head = node;

        } else {
            Node last = findLast();
            last.next = new Node(data);

        }
    }
    public int get(int index){
        if (index < 0 || head == null){
            throw new IndexOutOfBoundsException(index);
        }
        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index){
            current = current.next;
            currentIndex++;
        }

        if (currentIndex == index && current != null){
            return current.data;
            }
        throw new IndexOutOfBoundsException(index);
        }

    private Node findLast(){
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        return current;
    }

    public int getFirst(){
        return get(0);
    }
    public int pop(int index){
        if (index < 0 || head == null){
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0){
            int pop = head.data;
            head = head.next;
            return pop;
        }
        Node prev = head;
        int currentIndex = 1;
        while (prev.next != null){
            if (currentIndex == index){
                int pop = prev.next.data;
                prev.next = prev.next.next;
                return pop;
            }
            prev = prev.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst(){
        return pop(0);
    }

    /**
     * Получение размера
     * @return
     */
    public int size(){
        int size = 0;
        Node current = head;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * Проверка наличия элемента
     * @param value
     * @return
     */
    public boolean contains(int value){
        Node current = head;
        while (current != null){
            if (current.data == value){
                return true;
            }
            current = current.next;

        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null){
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        // Удаляем если размер отсортированного списка меньше 1 элемента
            int length = result.length();
            if (length > 4){
                result.delete(length - 4, length);
            }
        result.append("]");
        return result.toString();
    }
}
