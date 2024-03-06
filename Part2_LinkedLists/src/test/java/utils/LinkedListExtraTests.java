package utils;

import business.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {


    /**
     * Testing for no Duplicates with an empty list
     */
    @Test
    public void testNoDuplicates_EmptyList() {
        LinkedList list = new LinkedList(); // creating an empty LinkedList
        Song song = new Song("In my Room", "Troye Sivan"); //creating new instance of the Song class

        //uses the noDuplicates method to ensure it returns false for the empty list
        assertFalse(list.noDuplicates(song));
    }


    /**
     * Testing to remove a song from an empty list
     */
    @Test
    public void removeFromEmptyList() {
        LinkedList list = new LinkedList();
        Song song = new Song("King of Everything", "Madison Beer");

        //uses the remove method to ensure it returns false as it's an empty list
        assertFalse(list.remove(song));
    }


    /**
     * Testing to remove a song from the start of the list
     */
    @Test
    public void removeFromStart() {
        LinkedList list = new LinkedList(); //creates a LinkedList with two songs
        Song song1 = new Song("Heavy", "Powers");
        Song song2 = new Song("Girl in new york", "Nessa Barrett");

        //adds songs to the list
        list.add(song1);
        list.add(song2);


        assertTrue(list.remove(song1)); // remove method used to remove the first song
        assertEquals(1, list.size());
        assertEquals(song2, list.get(0)); //updates the position of song2 in the list
    }


    /**
     * Testing to remove a song from the end of the list
     */
    @Test
    public void removeFromEnd() {
        LinkedList list = new LinkedList();
        Song song1 = new Song("want that too", "Tate Mcrae");
        Song song2 = new Song("Gorgeous", "Mansionz");

        list.add(song1);
        list.add(song2);

        assertTrue(list.remove(song2)); //remove method to remove the last song
        assertEquals(1, list.size());
        assertEquals(song1, list.get(0));
    }

    /**
     * Testing to remove a song from the middle of the list
     */
    @Test
    public void removeFromMiddle() {
        LinkedList list = new LinkedList();
        Song song1 = new Song("Saola", "Beat Connection");
        Song song2 = new Song("Sides of Me", "Masego");
        Song song3 = new Song("I cant stop me", "Twice");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        assertTrue(list.remove(song2)); //remove method used to remove the middle song
        assertEquals(2, list.size());
        assertEquals(song1, list.get(0));
        assertEquals(song3, list.get(1));
    }

    /**
     * Testing to remove the only song from the list with one element
     */
    @Test
    public void removeFromListWithOneElement() {
        LinkedList list = new LinkedList();
        Song song = new Song("Yebo/Sema", "Masego");

        list.add(song);

        assertTrue(list.remove(song)); //remove method removes the only song
        assertTrue(list.isEmpty()); //leaves the list empty
    }

    /**
     * Testing to try and remove a non-existing song from the list
     */
    @Test
    public void removeNonExistingSong() {
        LinkedList list = new LinkedList(); //LinkedList with one song and one existing song
        Song song1 = new Song("Messy", "Renee Rapp");
        Song song2 = new Song("Snow Angel", "Renee Rapp");

        //adds the first song to the list
        list.add(song1);

        assertFalse(list.remove(song2)); //ensures that the remove method returns false as it trys to remove a non-existing song
        assertEquals(1, list.size());
        assertEquals(song1, list.get(0));
    }





}
