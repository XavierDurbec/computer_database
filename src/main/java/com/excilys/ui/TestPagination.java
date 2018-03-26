package main.java.com.excilys.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



import main.java.com.excilys.mapper.MapperClass;
import main.java.com.excilys.model.*;
import main.java.com.excilys.persistence.ComputerDAO;
import main.java.com.excilys.service.Service;

public class TestPagination extends JFrame{
    //Notre Panneau de pagination
    private PaginationPanel paginationPanel;
    //Un observateur
    private PaginationObserver paginationObserver;
    //Le panneau qui va afficher les données et le panneau principal
    private JPanel dataLayer, contentPane;
    
    public TestPagination() throws SQLException{
        this.setTitle("Liste des computers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initComponents();
    }

    private void initComponents() throws SQLException {
    	
        dataLayer = new JPanel();       
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        /*
         * Construction de notre système de pagination pour la liste
         * fournie par la méthode getList()
         */
     //   paginationPanel = new PaginationPanel<Computer>(getList());
        //Instanciation avec classe anonyme de notre observateur
        paginationObserver = new PaginationObserver<Computer>(){

            /*
             * Implémentation de la méthode update de l'interface
             */
            public void update(List<Computer> data) {
                dataLayer.removeAll();
                dataLayer.repaint();
                dataLayer.setPreferredSize(new Dimension(360, data.size()*30));
                JLabel label;
                for(Computer st : data){
                    label = new JLabel(st.toString());
                    label.setPreferredSize(new Dimension(360, 25));
                    label.setBorder(BorderFactory.createEtchedBorder());
                    dataLayer.add(label);
                }
                dataLayer.repaint();
                dataLayer.updateUI();
            }
            
        };
        //Ajout de l'observateur
        paginationPanel.addPaginationObserver(paginationObserver);
        
        contentPane.add(new JScrollPane(dataLayer));
        contentPane.add(paginationPanel, BorderLayout.SOUTH);
        this.setContentPane(contentPane);
        paginationPanel.reset();
    }
    
    /*
     * Création d'une liste de données à paginer
     */

    
    public static void main(String[] args) throws SQLException{
        TestPagination testView = new TestPagination();
        testView.setVisible(true);
    }
}