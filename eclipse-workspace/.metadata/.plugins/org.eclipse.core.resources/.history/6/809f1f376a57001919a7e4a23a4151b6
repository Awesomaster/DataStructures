import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class ListLinked implements List {
    private Link before;
    private Link after;

    public ListLinked() {
        after = new Link(null, null);
        before = new Link(null, after);
    }

    /**
     * isEmpty tells you if the list is empty
     * @return boolean This returns true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (before.successor==after);
    }

    /**
     * isBeforeFirst returns if the window is on before the list
     * @param windowLinked The window whose position we are checking
     * @return boolean Returns true if the window link is before the list
     */
    @Override
    public boolean isBeforeFirst(WindowLinked windowLinked) {
        return (windowLinked.link==before);
    }

    /**
     * isAfterLast returns if the window is after the list
     * @param windowLinked The windows whose position we are checking
     * @return boolean Returns true if the window link is after the list
     */
    @Override
    public boolean isAfterLast(WindowLinked windowLinked) {
        return (windowLinked.link==after);
    }

    /**
     * beforeFirst sets the windows position to be before the list
     * @param windowLinked The window that we want to change the position of
     */
    @Override
    public void beforeFirst(WindowLinked windowLinked) {
        windowLinked.link = before;
    }

    /**
     * afterLast sets the windows position to be before the list
     * @param windowLinked The window that we want to change the position of
     */
    @Override
    public void afterLast(WindowLinked windowLinked) {
        windowLinked.link = after;
    }

    /**
     * next moves the window to the next position in the list
     * @param windowLinked The window that we are using
     * @throws OutOfBounds Throws exception if we are trying to move past the link after the list
     */
    @Override
    public void next(WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)) {
        	throw new OutOfBounds("There are no more items in the list");
        } else {
        	windowLinked.link = windowLinked.link.successor;
        }
    }

    /**
     * previous moves the window to the previous position in the list
     * @param windowLinked The window we are using
     * @throws OutOfBounds Throws exception if we are trying to move before the link before the list
     */
    @Override
    public void previous(WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked)) {
        	throw new OutOfBounds("You cant go before 'before'");
        } else {
        	Link current = before.successor;
	    	Link prev = before;
	        while(windowLinked.link != current) {
	            prev = current;
	            current = current.successor;
	        }
	        windowLinked.link = prev;
        }
    }

    /**
     * insertAfter puts a link after the windowed link
     * @param o The object you wish to place in the link
     * @param windowLinked The window you are looking at
     * @throws OutOfBounds Throws exception if we are trying to insert after afterLast
     */
    @Override
    public void insertAfter(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)) {
        	throw new OutOfBounds("Cant add after 'after'");
        } else {
        	Link added = new Link(o, windowLinked.link.successor);
        	windowLinked.link.successor = added;
        }
    }

    /**
     * insertBefore puts a link before the windowed link
     * @param o The object you wish to place in the link
     * @param windowLinked The window you are looking at
     * @throws OutOfBounds Throws exception if we are trying to insert before beforeFirst
     */
    @Override
    public void insertBefore(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked)) {
        	throw new OutOfBounds("Cant add before 'before'");
        } else {
	        windowLinked.link.successor = new Link(windowLinked.link.item, windowLinked.link.successor);
	        if (isAfterLast(windowLinked)) {
	        	after = windowLinked.link.successor;
	        }
	        windowLinked.link.item = o;
	        windowLinked.link = windowLinked.link.successor; // Placing window back where it should be
        }
    }

    /**
     * examine gives you the object that the window is looking at
     * @param windowLinked The window you are looking at
     * @return Object The object the window is looking at
     * @throws OutOfBounds Throws exception if you are looking at a value outside of the list
     */
    @Override
    public Object examine(WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)||isBeforeFirst(windowLinked)) {
        	throw new OutOfBounds("You dont care what is not in the list");
        } else {
        	return windowLinked.link.item;
        }
    }

    /**
     * replace Changes the value of o of the window link
     * @param o The object you want to give to the link
     * @param windowLinked The window you are looking at
     * @return Object Returns the object that you are replacing
     * @throws OutOfBounds Throws exception if you are acting outside of the list
     */
    @Override
    public Object replace(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)||isBeforeFirst(windowLinked)) {
        	throw new OutOfBounds("Cannot replace with a value that isnt there");
        } else {
        	Object tempObject = windowLinked.link.item;
        	windowLinked.link.item = o;
        	return tempObject;
        }
    }

    /**
     * delete Removes a link from the list
     * @param windowLinked The window we are looking at and the link we are deleting
     * @return Object Returns the object from the link we are removing
     * @throws OutOfBounds Throws exception if you are acting outside of the list
     */
    @Override
    public Object delete(WindowLinked windowLinked) throws OutOfBounds {
    	if (isAfterLast(windowLinked)||isBeforeFirst(windowLinked)) {
        	throw new OutOfBounds("Cannot delete value that isnt there");
        } else {
        	Object tempObject = windowLinked.link.item;
        	if (windowLinked.link.successor == after) {
        		after = windowLinked.link;
        	}
        	windowLinked.link.item = windowLinked.link.successor.item;
    		windowLinked.link.successor = windowLinked.link.successor.successor;
        	return tempObject;
        }
    }
}
