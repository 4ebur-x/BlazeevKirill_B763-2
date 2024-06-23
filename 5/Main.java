/*
Тумутов Амгалан Б763-2
Вариант А
2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
*/

import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String [] args){
        Payment payment = new Payment();
        payment.addItem("Хлеб", 60);
        payment.addItem("Яйца", 89);
        payment.addItem("Молоко", 85);

        payment.displayItems();
        System.out.println("Итоговая цена: " + payment.getTotalPrice() + " Руб.");


    }

}
class Payment {

    private List<Item> items;

    public Payment() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, int price) {
        Item newItem = new Item(name, price);
        items.add(newItem);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.price;
        }
        return totalPrice;
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("Продукт: " + item.name + " | Цена: " + item.price+ " Руб.");
        }
    }

    private class Item {
        private String name;
        private int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
