import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {

    public static class ListManager {
        public static void addElement(List<Integer> list, int element) {
            list.add(element);
        }

        public static void removeElement(List<Integer> list, int element) {
            list.remove(Integer.valueOf(element));
        }

        public static int getSize(List<Integer> list) {
            return list.size();
        }
    }

    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 1);
        ListManager.addElement(list, 2);
        assertEquals(Arrays.asList(1, 2), list);
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListManager.removeElement(list, 2);
        assertEquals(Arrays.asList(1, 3), list);
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list));
        ListManager.addElement(list, 10);
        assertEquals(1, ListManager.getSize(list));
        ListManager.addElement(list, 20);
        assertEquals(2, ListManager.getSize(list));
        ListManager.removeElement(list, 10);
        assertEquals(1, ListManager.getSize(list));
    }
}
