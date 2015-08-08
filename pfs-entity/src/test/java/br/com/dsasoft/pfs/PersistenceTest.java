package br.com.dsasoft.pfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.dsasoft.pfs.model.Account;

@RunWith(JUnit4.class)
public class PersistenceTest {
	
	@PersistenceContext
	EntityManagerFactory emf;
	
	private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "pfs_db";
    private static final String IP = "localhost"; //"192.168.0.1";
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "root";


//	@Test
	public void helloJunit() {
		System.out.println("\n\n\n \tHello JUnit \n\n\n");
	}
	
	@Test
	public void jdbcConnection() throws Exception{
		Connection conn = null;
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            System.out.println("[ConnectionManager]: Success " + !conn.isClosed());
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new Exception(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new Exception(errorMsg, e);
        }
	}

	@Test
	public void persistenceContext() {
		// Map<String, String> pfsMap = new LinkedHashMap<String, String>();
		//
		// pfsMap.put(Persistence.PERSISTENCE_PROVIDER, "org.hibernate.ejb.HibernatePersistence");
		// pfsMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		// pfsMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/pfs_db");
		// pfsMap.put("javax.persistence.jdbc.user", "root");
		// pfsMap.put("javax.persistence.jdbc.password", "root");

		emf = Persistence.createEntityManagerFactory("pfs-entity");
		
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();

		Query query = em.createQuery("select a from AccountEntity a");

		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) query.getResultList();

		for (Account a : accounts)
			System.out.println(a);

//		em.getTransaction().commit();
		
	}
}
