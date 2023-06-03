
public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
        System.out.println("Вывод: " + list);
        System.out.println("Размер: " + list.size());
        System.out.println("Получение элемента с удалением :" + list.pop(1));
        System.out.println("Размер: " + list.size());
        System.out.println("Получение элемента: " + list.get(3));;
        System.out.println("Получение первого элемента: " + list.getFirst());
        System.out.println("Вывод: " + list);
        System.out.println("Проверка наличия искомого элемента: " + list.contains(6));


    }
}
