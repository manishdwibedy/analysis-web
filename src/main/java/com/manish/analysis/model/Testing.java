package com.manish.analysis.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.mapping.List;

import com.manish.analysis.util.HibernateUtil;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
 
 
        Query q = session.createQuery("From Material ");
                 
        List<Material> resultList = (List<Material>) q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Object next : resultList) {
            System.out.println("next employee: " + next);
        }
	}

}
