import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MorseCodeTreeSTUDENTTest {

    @Test
    public void testInsertAndFetch() {
        MorseCodeTree tree = new MorseCodeTree();
        tree.insert(".-", "a");
        tree.insert("-...", "b");
        tree.insert("-.-.", "c");

        assertEquals("a", tree.fetch(".-"));
        assertEquals("b", tree.fetch("-..."));
        assertEquals("c", tree.fetch("-.-.")); 
    }

    @Test
    public void testToArrayList() {
        MorseCodeTree tree = new MorseCodeTree();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
            "h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w", "j", "", "b", "d", "x", "n", "c", "k", "y", "t", "z", "g", "q", "m", "o"
        ));

        assertEquals(expected, tree.toArrayList());
    }

    @Test
    public void testFetchNonExistentCode() {
        MorseCodeTree tree = new MorseCodeTree();
        assertNull(tree.fetch("xyz"));
    }

    @Test
    public void testFetchEmptyCode() {
        MorseCodeTree tree = new MorseCodeTree();
        assertEquals("", tree.fetch(""));
    }

    @Test
    public void testInsertDuplicateCode() {
        MorseCodeTree tree = new MorseCodeTree();
        tree.insert(".-", "a");
        tree.insert(".-", "b"); // Duplicate code, should overwrite the previous value

        assertEquals("b", tree.fetch(".-"));
    }
}