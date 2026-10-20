package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Success_DecreasesTorpedoCount() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        store.fire(2);

        assertEquals(3, store.getTorpedoCount());
    }

    @Test
    void fire_Failure_ReturnsFalse() {
        TorpedoStore store = new TorpedoStore(1, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
    }

    @Test
    void fire_MoreThanAvailable_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1, 0.0);

        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void isEmpty_AfterFiringAll_ReturnsTrue() {
        TorpedoStore store = new TorpedoStore(1, 0.0);

        store.fire(1);

        assertTrue(store.isEmpty());
    }
}