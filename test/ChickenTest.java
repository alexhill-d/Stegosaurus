import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChickenTest {
    @Test
    void test01() {
        Chicken grandmother = new Chicken();
        grandmother.setName("grandmother");
        Egg<Chicken> mother_egg = grandmother.lay();
        Chicken mother = mother_egg.hatch();
        mother.setName("mother");
        Egg<Chicken> child_egg = mother.lay();
        Chicken child = child_egg.hatch();
        child.setName("child");
        System.out.println("1:" + grandmother);
        System.out.println("2:" + mother);
        System.out.println("3:" + child);
        assertSame(null, grandmother.parent);
        assertSame(grandmother, mother.parent);
        assertSame(mother, child.parent);
    }

    @Test
    void test02CannotHatchTwice() {
        Chicken mother =  new Chicken();
        mother.setName("mother");
        Egg<Chicken> child_egg = mother.lay();
        Chicken child = child_egg.hatch();
        child.setName("child");
        // Hatched twice - throw Exception
        assertThrows(IllegalStateException.class, () -> child_egg.hatch());
    }

    @Test
    void test03SistersAreGood() {
        Chicken mother = new Chicken();
        mother.setName("mother");
        Egg<Chicken> child1_egg = mother.lay();
        Chicken child1 = child1_egg.hatch();
        child1.setName("child1");
        Egg<Chicken> child2_egg = mother.lay();
        Chicken child2 = child2_egg.hatch();
        child2.setName("child2");
        System.out.println("1:" + mother);
        System.out.println("2:" + child1);
        System.out.println("2:" + child2);
        assertSame(null, mother.parent);
        assertSame(mother, child1.parent);
        assertSame(mother, child2.parent);
    }
}