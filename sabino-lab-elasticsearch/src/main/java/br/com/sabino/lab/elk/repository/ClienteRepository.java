package br.com.sabino.lab.elk.repository;

import br.com.sabino.lab.elk.dao.GenericDao;
import br.com.sabino.lab.elk.domain.Cliente;

import javax.ejb.Stateless;

@Stateless
public class ClienteRepository extends GenericDao<Cliente, Long> {
}
