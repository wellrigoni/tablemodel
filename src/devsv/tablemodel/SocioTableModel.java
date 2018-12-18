/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devsv.tablemodel;

import java.math.BigDecimal;
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
    private static final int ATIVO = 2;
    private static final int MENSALIDADE = 3;
     
    //Array com os nomes das colunas.
    private String[] colunas = new String[] {"Nome", "Endereco","Ativo","Mensalidade"};
            
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
            case ATIVO:
                return Boolean.class;
            case MENSALIDADE:
                return BigDecimal.class;
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == ATIVO;
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
            case ATIVO:
                return socio.isAtivo();
            case MENSALIDADE:
                return socio.getMensalidade();
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
            case ATIVO:
                socio.setAtivo((Boolean) aValue);
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
    
    //Adciona uma lista de socios no final da lista
    public void addListaDeSocios(List<Socio> socios){
        //Pega o tamanho antigo da tabela, que servira como 
        //indice para o primeiro dos novos registros
        int indice = getRowCount();
        
        //Adciona os registros
        linhas.addAll(socios);
        
        //Notifica a mudança
        fireTableRowsInserted(indice, indice + socios.size());
    }
    
    //Remove todos os registros 
    public void limpar(){
        //Remove todos os elementos da lista
        linhas.clear();
        
        //Notifica a mudança
        fireTableDataChanged();
    }
    
    
    
}
