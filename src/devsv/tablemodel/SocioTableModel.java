/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devsv.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wellington.rigoni
 */
public class SocioTableModel extends AbstractTableModel{
    //Lista de Sócios a serem exibidos na tabela
    private List<Socio> linhas;
    private static final int NOME =0;
    private static final int ENDERECO = 1;
     
    //Array com os nomes das colunas.
    private String[] colunas = new String[] {"Nome", "Endereco"};
            
    //Cria um SocioTableModel sem nenhuma linha
    public SocioTableModel(){
        linhas = new ArrayList<Socio>();
    }
    
    //Cria um SocioTableModel contendo a lista recebida por parametro
    public SocioTableModel(List<Socio> listaDeSocios){
        linhas = new ArrayList<Socio>(listaDeSocios);
    }
    
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case NOME:
                return String.class;
            case ENDERECO:
                return String.class;
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
         //Pega o sócio referente a linha especificada
        Socio socio = linhas.get(rowIndex);
       
        switch (columnIndex){
            case NOME:
                return socio.getNome();
            case ENDERECO:
                return socio.getEndereco();
            default:
                throw new IndexOutOfBoundsException("column index out of bounds");
                
                            
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
         //Pega o sócio referente a linha especificada
        Socio socio = linhas.get(rowIndex);
       
        switch (columnIndex){
            case NOME:
                socio.setNome((String) aValue);
                break;
            case ENDERECO:
                socio.setEndereco((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("column index out of bounds");
        }
        fireTableCellUpdated(rowIndex,columnIndex);// Notifica a atualização da célula
    }
    
    //Retorna o sócio referente a linha especificada 
    public Socio getSocio(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    //Adiciona o sócio especificado ao modelo
    public void addSocio(Socio socio){
        //Adiciona o registro
        linhas.add(socio);
        
        //Pega a quantidade de registros e subtrai 1 para 
        //achar o ultimo indice. Asubtração é necessária
        //pois os indices comecam em 0
        int ultimoIndice = getRowCount() -1;
        //Notifica mudança 
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    //Remove o sócio da linha especificada.
    public void removeSocio(int indiceLinha){
        //Remove o registro
        linhas.remove(indiceLinha);
        //notifica mudancas
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    
}
