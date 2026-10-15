
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.name = name;
        size = 0;
        log = null;
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        if (size == 0) {
            log = new LLNode<T>(element);
        } else {
            LLNode<T> hold = log;
            while (hold.getLink() != null) {
                hold = hold.getLink();
            }
            hold.setLink(new LLNode<T>(element));
        }
        size++;
    }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        if (size <= index && index >= 0) {
            System.out.println("Index out of bounds.");
        } else {
            int current = 0;
            LLNode<T> currentNode = log;
            while(true) {
                if (current == index) {
                    return currentNode.getInfo();
                } else {
                    current++;
                    currentNode = log.getLink();
                }
            }
        }

        return null;
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode<T> currentNode = log;

        for (int i = 0; i < size; i++) {
            if (currentNode.getInfo().equals(element)) {
                return i;
            } else {
                currentNode = currentNode.getLink();
            }
        }

        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
        return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        if (index >= size && index >= 0) {
            System.out.println("Invalid index.");
        }

        LLNode<T> currentNode = log;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getLink();
        }

        T retrn = currentNode.getInfo();
        currentNode.setInfo(element);

        return retrn;
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode<T> previous = log;
        LLNode<T> next = log;

        for (int i = 0; i < index; i++) {
            if (i == index-1) {
                next = next.getLink();
            } else {
                next = next.getLink();
                previous = next.getLink();
            }
        }
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        return null;
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        return false;
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = null;
        size = 0;
    }
}
