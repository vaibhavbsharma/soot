package soot.toolkits.scalar;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraySparseSetTest {

  @Test
  public void testBug11() {
    ArraySparseSet<String> ars1 = new ArraySparseSet<>();
    ars1.add("a");
    ars1.add("b");

    ArraySparseSet<String> ars2 = new ArraySparseSet<>();
    ars2.add("b");
    ars2.add("a");

    Assert.assertEquals(ars1, ars2);
    Assert.assertEquals(ars1.hashCode(), ars2.hashCode());
  }

  @Test
  public void testBug12() {
    ArraySparseSet<String> ars1 = new ArraySparseSet<>();
    ars1.add("a");
    ars1.add("b");

    ArrayPackedSet<String> aps =
        new ArrayPackedSet<>(new CollectionFlowUniverse<>(Arrays.asList("a", "b")));
    aps.add("b");
    aps.add("a");

    Assert.assertEquals(ars1, aps);
    Assert.assertEquals(ars1.hashCode(), aps.hashCode());
  }
}
