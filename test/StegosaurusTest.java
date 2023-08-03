import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StegosaurusTest {
    @Test
    void test01() {
        Stegosaurus grandmother = new Stegosaurus();
        grandmother.setName("grandmother");
        Egg<Stegosaurus> mother_egg = grandmother.lay();
        Stegosaurus mother = mother_egg.hatch();
        mother.setName("mother");
        Egg<Stegosaurus> child_egg = mother.lay();
        Stegosaurus child = child_egg.hatch();
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
        Stegosaurus mother =  new Stegosaurus();
        mother.setName("mother");
        Egg<Stegosaurus> child_egg = mother.lay();
        Stegosaurus child = child_egg.hatch();
        child.setName("child");
        // Hatched twice - throw Exception
        assertThrows(IllegalStateException.class, () -> child_egg.hatch());
    }

    @Test
    void test03SistersAreGood() {
        Stegosaurus mother = new Stegosaurus();
        mother.setName("mother");
        Egg<Stegosaurus> child1_egg = mother.lay();
        Stegosaurus child1 = child1_egg.hatch();
        child1.setName("child1");
        Egg<Stegosaurus> child2_egg = mother.lay();
        Stegosaurus child2 = child2_egg.hatch();
        child2.setName("child2");
        System.out.println("1:" + mother);
        System.out.println("2:" + child1);
        System.out.println("2:" + child2);
        assertSame(null, mother.parent);
        assertSame(mother, child1.parent);
        assertSame(mother, child2.parent);
    }
}