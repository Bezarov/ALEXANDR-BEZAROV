package homework_nr_14;

import homework_nr_13.Numbers;

import java.io.Serializable;

public class GenericsClass<T extends Comparable<T>, V extends Animal & Serializable, K extends Numbers> {
    T t;
    V v;
    K k;
    public GenericsClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }
    public T getT() {
        return t;
    }
    public V getV() {
        return v;
    }
    public K getK() {
        return k;
    }
    public static String getNamesOfClasses(T t, V v, K k){
        return t.getClass().getSimpleName() + v.getClass().getSimpleName() + k.getClass().getSimpleName();
    }
}
