/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devsv.tablemodel;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wellington.rigoni
 */
public class MensalidadeCellRenderer extends DefaultTableCellRenderer{
   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
           boolean  isSelected, boolean  hasFocus, int row, int column){
       Object val = table.getValueAt(row, column);
       //verifica se o valor é do tipo esperado
       if(val instanceof BigDecimal){
           //faz casting para BigDecimal
           BigDecimal mensalidade = (BigDecimal) val;
           //formata o valor e seta como o texto do renderer
           NumberFormat nf = NumberFormat.getCurrencyInstance();
           setText(mensalidade != null ? nf.format(mensalidade): "");
       }
       return this;
   }
}
