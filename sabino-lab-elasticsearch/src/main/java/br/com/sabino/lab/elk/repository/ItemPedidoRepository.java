package br.com.sabino.lab.elk.repository;

import br.com.sabino.lab.elk.dao.GenericDao;
import br.com.sabino.lab.elk.domain.ItemPedido;

import javax.ejb.Stateless;

@Stateless
public class ItemPedidoRepository extends GenericDao<ItemPedido, Long> {
}
