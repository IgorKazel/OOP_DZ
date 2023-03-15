import java.util.ArrayList;

public class Closet extends BaseItem {
    private int size;
    private ArrayList<Item> storage;
    private boolean isOpen;

    public Closet(String name, int size){
        this.name = name;
        this.size = size;
        this.storage = new ArrayList<>();
        this.isOpen = false;
        System.out.println("Новый " + name + " на " + size + " мест");
    }

    public int getSize(){
        return size;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public void openDoor() {
        isOpen = true;
    }

    public void closeDoor() {
        isOpen = false;
    }

    public void addItem(Item item) {
        if (storage.size() < size){
            storage.add(item);
            System.out.println(item.getName() + " положена в " + name);
        } else {
            System.out.println("Нет места в " + name);
        }
    }

    public void getItem(Item item) {
        if (storage.contains(item)) {
            storage.remove(item);
            System.out.println(item.getName() + " взята из " + name);
        } else {
            System.out.println("Нет " + item.getName() + " в " + name);
        }
    }

    public void printAllItem() {
        System.out.println("Все вещи в " + name + ":");
        for (int i = 0; i < storage.size(); i++) {
            System.out.println(storage.get(i).getName());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else if (this.getName().equals(((Closet) obj).getName()) && this.getSize() == ((Closet) obj).getSize()) {
            return true;
        } else {
            return false;
        }
    }
}
