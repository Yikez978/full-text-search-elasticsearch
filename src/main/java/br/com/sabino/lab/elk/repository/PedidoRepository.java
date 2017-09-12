package br.com.sabino.lab.elk.repository;

import br.com.sabino.lab.elk.dao.GenericDao;
import br.com.sabino.lab.elk.domain.Pedido;

import javax.ejb.Stateless;

@Stateless
public class PedidoRepository extends GenericDao<Pedido, Long> {
}
