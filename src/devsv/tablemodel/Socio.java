
package devsv.tablemodel;

import java.math.BigDecimal;

public class Socio {
  private String nome;
  private String endereco;
  private boolean ativo;
  private BigDecimal mensalidade;

      public Socio() {
    }

    
  public Socio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the mensalidade
     */
    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    /**
     * @param mensalidade the mensalidade to set
     */
    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
    }
  
  
  
}
