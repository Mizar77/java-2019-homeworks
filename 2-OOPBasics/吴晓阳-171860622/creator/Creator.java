package creator;

public interface Creator<T> {
    T create(Object... args);
}
