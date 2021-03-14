import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MapSemaphore<K, V> extends HashMap<K, V> implements Map<K, V> {
    private static final Semaphore sem = new Semaphore(1);

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        boolean b = false;
        try {
            sem.acquire();
            b = super.containsKey(key);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean b = false;
        try {
            sem.acquire();
            b = super.containsValue(value);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public V get(Object key) {
        V k = null;
        try {
            sem.acquire();
            k = super.get(key);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public V put(K key, V value) {
        V k = null;
        try {
            sem.acquire();
            k = super.put(key, value);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public V remove(Object key) {
        V k = null;
        try {
            sem.acquire();
            k = super.remove(key);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            sem.acquire();
            super.putAll(m);
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            sem.acquire();
            super.clear();
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> k = null;
        try {
            sem.acquire();
            k = super.keySet();
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public Collection<V> values() {
        Collection<V> k = null;
        try {
            sem.acquire();
            k = super.values();
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> k = null;
        try {
            sem.acquire();
            k = super.entrySet();
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert k != null;
        return k;
    }
}