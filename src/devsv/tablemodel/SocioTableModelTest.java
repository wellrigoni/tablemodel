/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devsv.tablemodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author wellington.rigoni
 */
public class SocioTableModelTest extends javax.swing.JFrame {
    private JTable tblSocios;
    private SocioTableModel tableModel;
    
    /**
     * Creates new form SocioTableModelTest
     */
    public SocioTableModelTest() {
        super("SocioTableModelTest");
        initialize();
    }
    
    private void initialize (){
        setSize(400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new JScrollPane(getTblSocios()));
    }
    private JTable getTblSocios(){
        if(tblSocios == null){
            tblSocios = new JTable();
            tblSocios.setModel(getTableModel());
            tblSocios.setDefaultRenderer(BigDecimal.class, new MensalidadeCellRenderer());
        }
        return tblSocios;
    }
    
    private SocioTableModel getTableModel(){
        if(tableModel ==null){
            tableModel = new SocioTableModel(criaSocios());
        }
        return tableModel;
    }
    
    //cria lista com 5 socios meramente ilustrativos
    private List<Socio> criaSocios (){
        List<Socio> socios = new ArrayList<Socio>();
        for (int i =1; i <= 5; i++){
            Socio socio= new Socio();
            socio.setNome("Nome"+ i);
            socio.setEndereco("Endereco"+ i);
            socio.setAtivo(true);
            socio.setMensalidade(new BigDecimal(i *10));
            socios.add(socio);
        }
        return socios;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SocioTableModelTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SocioTableModelTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SocioTableModelTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SocioTableModelTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SocioTableModelTest().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
