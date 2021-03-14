import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.ReentrantLock;
public class ListLock<E>  implements List{
    private List<E> list = new ArrayList<>();
    private static final ReentrantLock rl = new ReentrantLock();

    @Override
    public int size() {
        int s;
        rl.lock();
        s = list.size();
        rl.unlock();
        return s;
    }

    @Override
    public boolean isEmpty() {
        boolean check;
        rl.lock();
        check = list.isEmpty();
        rl.unlock();
        return check;
    }

    @Override
    public boolean contains(Object o) {
        rl.lock();
        boolean smth = list.contains(o);
        rl.unlock();
        return smth;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean add(Object o) {
        boolean check;
        rl.lock();
        check = list.add((E) o);
        rl.unlock();
        return check;
    }

    @Override
    public boolean remove(Object o) {
        boolean check;
        rl.lock();
        list.remove((E) o);
        check = true;
        rl.unlock();
        return check;
    }

    @Override
    public boolean addAll(Collection c) {
        rl.lock();
        boolean check = list.addAll(c);
        rl.unlock();
        return check;
    }

    @Override
    public boolean addAll(int i, Collection c) {
        rl.lock();
        boolean check =list.addAll(i, c);
        rl.unlock();
        return check;
    }

    @Override
    public void clear() {
        rl.lock();
        list.clear();
        rl.unlock();
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public Object set(int i, Object element) {
        return list.set(i, (E) element);
    }

    @Override
    public void add(int i, Object o) {
        rl.lock();
        list.add(i, (E) o);
        rl.unlock();
    }

    @Override
    public Object remove(int i) {
        return list.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        int index;
        rl.lock();
        index = list.indexOf((E) o);
        rl.unlock();
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index;
        rl.lock();
        index = list.lastIndexOf((E) o);
        rl.unlock();
        return index;
    }

    @Override
    public ListIterator listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator listIterator(int i) {
        return list.listIterator(i);
    }

    @Override
    public List subList(int i, int i1) {
        return list.subList(i, i1);
    }

    @Override
    public boolean retainAll(Collection c) {
        rl.lock();
        boolean check = list.retainAll(c);
        rl.unlock();
        return check;
    }

    @Override
    public boolean removeAll(Collection c) {
        rl.lock();
        boolean check = list.removeAll(c);
        rl.unlock();
        return check;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean check = false;
        rl.lock();
        check = list.containsAll(c);
        rl.unlock();
        return check;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
}
