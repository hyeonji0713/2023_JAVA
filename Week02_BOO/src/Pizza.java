//2-
class Circle {
    protected int radius;
    String name;

    public Circle(String name, int r) {
        radius = r;
        this.name = name;
    }
}

class Pizza0 extends Circle {
    protected int size; 

    public Pizza0(String name) {
        super(name);
    }

    public Pizza0(String name, int size) {
        super("Pizza", size); 
        this.size = radius * radius; 
    }

    public void print() {
        System.out.println("피자 종류: " + name);
        System.out.println("피자 넓이: " + size);
    }
}

public class Pizza {
    public static void main(String[] args) {
        Pizza0 obj = new Pizza0("Pepperoni", 20);
        obj.print();
    }
}
