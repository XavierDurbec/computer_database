package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Computer;
import model.ListComputer;
import persistence.ComputerDAO;

class ComputerDAOTest {
	
	private ComputerDAO cdao;
	private ListComputer lc;
	

	@BeforeEach
	void  setUp() throws Exception {
		
		cdao = cdao.getInstance();
		cdao.selectListComputer();
		lc = cdao.selectListComputer();
		
		Computer c = new Computer(80,"MonOrdi",null,null,5);
	
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		lc = null;
		cdao.closeConnection();
		cdao = null;
		
	}

	@Test
	void testSelectListComputer() {
		
		
		
	}

	@Test
	void testSelectComputer() {
	}

	@Test
	void testCreateComputer() throws SQLException {
		

	
		
	}

	@Test
	void testDeleteComputer() throws SQLException {
		 
	//	 assertEquals(lc,lc);
		
		
	}

	@Test
	void testUpdateComputer() {
	}

	@Test
	void testCloseConnection() {
		
	}

}
