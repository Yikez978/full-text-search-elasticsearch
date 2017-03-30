package br.com.sabino.lab.elk.domain;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SequenceGenerator(name = "ITEM_PEDIDO_SEQ", sequenceName = "ITEM_PEDIDO_SEQ", allocationSize = 1)
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_PEDIDO_SEQ")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private Long idProduto;
    @Column
    private Long quantidade;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (idProduto != null)
            result += "idProduto: " + idProduto;
        if (quantidade != null)
            result += ", quantidade: " + quantidade;
        return result;
    }
}