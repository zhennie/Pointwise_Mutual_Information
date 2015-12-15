package me.ash.pmi.word_pair.pmi;

/**
 * Created by ash on 10/31/15.
 */
public interface PMIAnalyzer<T> {
    public double probabilityOf(T t);
    public double probabilityOf(T t1, T t2);
    public double PmiOf(T t1, T t2);
}
