package main.java.com.excilys.ui;

import java.util.List;


public interface PaginationObserver<T> {

    public void update(List<T> data);

}
