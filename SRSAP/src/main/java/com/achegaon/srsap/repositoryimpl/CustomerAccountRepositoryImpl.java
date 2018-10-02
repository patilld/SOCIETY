package com.achegaon.srsap.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.repositorycustom.CustomerAccountRepositoryCustom;

/**
 * The CustomerAccountRepositoryImpl for CustomerAccountRepositoryCustom implementation
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 02-09-2018 $
 * 
 */

@Repository
@Transactional(readOnly = true)
public class CustomerAccountRepositoryImpl implements CustomerAccountRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<CustomerAccount> searchCustomerBySearchCriteria(Integer cacId, String cdeFirstName, String cdeLastName) {

		String queryString = "FROM CustomerAccount c WHERE c.cacId IS NOT NULL";
		
		if(cacId != null && cacId.intValue() > 0) {
			queryString = queryString + " AND cacId = " + cacId;
		}
		
		if(cdeFirstName != null && !cdeFirstName.isEmpty()) {
			queryString = queryString + " AND c.customerDetail.cdeFirstName = '" + cdeFirstName + "'";
		}
		
		if(cdeLastName != null && !cdeFirstName.isEmpty()) {
			queryString = queryString + " AND c.customerDetail.cdeLastName = '" + cdeLastName + "'";
		}
		
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}
}
