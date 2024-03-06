package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {

    private Node head; //head also first - referring to the first element
    private Node tail; //last - referring to the last element
    private int numElements;


    /**
     *
     * @return the number of elements in the LinkedList
     */
    public int size(){
        return numElements;
    }


    /**
     * Method that gets the specific position of the song in the list
     * @param pos The position of the song to get
     * @return the song got at the specific position
     * @throws IndexOutOfBoundsException exception if the position is invalid
     */
    public Song get(int pos){
        if(pos < 0 || pos >= numElements){
            throw new IndexOutOfBoundsException("Invalid position " + pos);
        }
        Node current = head;
        for(int i=0; i<pos; i++){
            current=current.getNext();

        }
        return current.song;
    }


    /**
     * Method that finds the index of the first occurrence of the specific song
     * @param song the song to get the index of
     * @return the index of the first occurrence of the song, returns -1 otherwise
     */
    public int indexOf(Song song){
    int pos=0;

    Node current = head;
    for(int i=0; i< numElements; i++){
        if(current.song!= null || current.song.equals(song)){
        return i;
        }
        current = current.next;
    }
    return -1;
    }


    /**
     * Method that adds a song to the end of the LinkedList
     * @param song the song that was added
     */
    public void add(Song song){
    Node newNode = new Node(song);
    if(numElements == 0){
        head = newNode;
    }else{
        tail.next = newNode;
    }
    tail.setNext(newNode);
    numElements++;
    }


    /**
     * Method to check if the link is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return numElements==0;
    }


    /**
     * Method that returns the tail of the list (end)
     * @return the song at the end of the list
     * @throws IllegalStateException if the list is empty
     */
    public Song tail(){
        if(isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return tail.song;
    }



    //Two methods

    //Your LinkedList should not allow any duplicate Songs, i.e. each value should be unique.
    // Two Songs are considered the same if they have the same title and the same artist.
    // You should include any appropriate method or methods to facilitate this, and the logic of your class should uphold this requirement throughout.


    /**
     * Method that checks if a song added is a duplicate of a song already in the list
     * @param song the song to check for the duplicates
     * @return true if the song is a duplicate, false otherwise
     */
    public boolean noDuplicates(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getArtist().equals(song.getArtist()) && current.song.getTitle().equals(song.getTitle())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    //remove method
    //Your list should contain a method called remove() that takes one parameter:
    //The Song to be removed (this should not be null)
    //The first instance of this Song should be removed from the list. The method should return a boolean indicating if the Song was removed.
    // Remove should be case-sensitive.


    /**
     * Method that removes a specific song from the list
     * @param removedSong the song to be removed
     * @return true if the song is removed, false if the song is not found
     * @throws IllegalArgumentException exception if the song to be removed is null
     */
    public boolean remove(Song removedSong){
        if(removedSong == null){
            throw new IllegalArgumentException("Song to be removed should not be null");
        }

        Node current = head;
        Node previous = null;

        while(current != null){
            if(current.song.equals(removedSong)){
                if(previous == null){ //if removedSong is the first node, update head
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext()); //update previous node's next pointer
                }
                if(current == tail){
                    tail = previous;
                }
                numElements--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }



    protected static class Node{
        Node next;
        Song song;

         Node(Song song){
            this.song = song;
            this.next = null;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }


    }
    }

    

