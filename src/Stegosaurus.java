import java.util.function.Supplier;

public class Stegosaurus implements EggLayer<Stegosaurus> {

    private static int count = 0;
    String name;
    int no;

    Stegosaurus parent = null;

    public Stegosaurus() {
        this.no = ++Stegosaurus.count;
    }

    public Stegosaurus(Stegosaurus parent) {
        this();
        this.parent = parent;
    }

    @Override
    public Egg<Stegosaurus> lay() {
        Supplier<Stegosaurus> stegosaurusSupplier = () -> new Stegosaurus(this);
        return new Egg<Stegosaurus>(stegosaurusSupplier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "Stegosaurus: {" +
                " name: " +
                name +
                ", no: " +
                no +
                ", parent: " +
                (parent != null ? parent.getName() : null) +
                "}";
        return result;
    }

    public static void main(String[] args) {
        // Do Nothing
    }
}