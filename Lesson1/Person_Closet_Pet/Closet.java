import java.util.ArrayList;

public class Closet {
    private String name;
    private int size;
    private ArrayList<String> storage;
    private boolean isOpen;

    public Closet(String name, int size){
        this.name = name;
        this.size = size;
        this.storage = new ArrayList<>();
        this.isOpen = false;
        System.out.println("Новый " + name + " на " + size + " мест");
    }

    public void openDoor() {
        if (isOpen) {
            System.out.println("Двери " + name + " и так окрыты");
        } else {
            isOpen = true;
            System.out.println("Двери " + name + " окрыты");
        }
    }

    public void closeDoor() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Двери " + name + " закрыты");
        } else {
            System.out.println("Двери " + name + " и так закрыты");
        }
    }

    public void addItem(String item) {
        if (isOpen) {
            if (storage.size() < size){
                storage.add(item);
                System.out.println(item + " положена в " + name);
            } else {
                System.out.println("Нет места в " + name);
            }
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }

    public void getItem(String item) {
        if (isOpen) {
            if (storage.contains(item)) {
                storage.remove(item);
                System.out.println(item + " взята из " + name);
            } else {
                System.out.println("Нет " + item + " в " + name);
            }
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }

    public void printAllItem() {
        if (isOpen) {
            System.out.println("Все вещи в " + name + ":");
            System.out.println(storage.toString());
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }
}
