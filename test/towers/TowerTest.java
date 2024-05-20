package towers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    @Test
    public void pushPop1() throws EmptyTowerException, TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        tower.push(3);
        assertEquals(3, tower.pop());
    }

    @Test
    public void pushPop2() throws EmptyTowerException, TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        tower.push(3);
        assertEquals(3, tower.pop());
        assertThrows(EmptyTowerException.class, () -> tower.pop());
    }

    @Test
    public void pushPop3() throws EmptyTowerException, TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        tower.push(3);
        tower.push(2);
        tower.push(1);
        assertEquals(1, tower.pop());
        assertEquals(2, tower.pop());
        assertEquals(3, tower.pop());
        assertThrows(EmptyTowerException.class, () -> tower.pop());
    }

    @Test
    public void testToString() throws EmptyTowerException, TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        tower.push(3);
        assertEquals("3", tower.toString());
        tower.push(2);
        assertEquals("3-2", tower.toString());
        tower.push(1);
        assertEquals("3-2-1", tower.toString());
        tower.push(0);
        assertEquals("3-2-1-0", tower.toString());
    }

    @Test
    public void testTowerOrder() throws TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        tower.push(3);
        assertThrows(TowerOrderException.class, () -> tower.push(4));

    }

    @Test
    public void testChainPush() throws TowerOrderException {
        Tower<Integer> left = new Tower<>();
        left.push(8).push(7).push(6).push(5).push(4).push(3).push(2).push(1);
        assertEquals("8-7-6-5-4-3-2-1", left.toString());
    }


    @Test
    public void size() throws EmptyTowerException, TowerOrderException {
        Tower<Integer> tower = new Tower<>();
        assertEquals(0, tower.size());
        tower.push(4);
        assertEquals(1, tower.size());
        tower.push(3);
        assertEquals(2, tower.size());
        tower.push(2);
        tower.push(1);
        assertEquals(4, tower.size());
    }
}

