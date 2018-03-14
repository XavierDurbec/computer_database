package main;

import java.sql.SQLException;

import ui.TestPagination;

public class Begin {

	
    public static void main(String[] args) throws SQLException{
        TestPagination testView = new TestPagination();
        testView.setVisible(true);
    }
	
}
