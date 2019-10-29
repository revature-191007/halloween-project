package com.revature.services;

import com.revature.daos.CandyDao;
import com.revature.models.Candy;

public class CandyService {

	CandyDao candyDao = new CandyDao();
	
	public Candy save(Candy candy) {
		// Add some validation logic
		if (candy.getId() != 0) {
			System.out.println("Bad");  
		}
		
		Candy savedCandy = candyDao.save(candy);
		return savedCandy;
	}

}
