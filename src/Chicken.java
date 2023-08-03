import java.util.function.Supplier;

interface EggLayer<T extends EggLayer<T>> {
    Egg<T> lay();
}



class Egg<T extends EggLayer<T>> {
    Supplier<T> supplier;
    Class<T> clazz;
    boolean hatched = false;

    public Egg(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T hatch() {
        if (hatched) {
            throw new IllegalStateException("Egg already hatched");
        } else {
            hatched = true;
            return supplier.get();
        }
    }
}
public class Chicken implements EggLayer<Chicken> {

    private static int count = 0;
    String name;
    int no;

    Chicken parent = null;

    public Chicken() {
        this.no = ++Chicken.count;
    }

    public Chicken(Chicken parent) {
        this();
        this.parent = parent;
    }

    @Override
    public Egg<Chicken> lay() {
        Supplier<Chicken> chickenSupplier = () -> new Chicken(this);
        return new Egg<Chicken>(chickenSupplier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "Chicken: {" +
                " name: " +
                name +
                ", no: " +
                no +
                ", parent: " +
                (parent != null ? parent.getName() : null) +
                "}";
        return result;
    }
}



