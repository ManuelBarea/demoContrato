package com.contrato.demo.utils;

import org.springframework.util.StringUtils;

public class Utils {

	public static String convertToLike(String criterio) {
		
		 String like = null;
		 
		 if(!StringUtils.isEmpty(criterio)) {
			 like = "%" + criterio.toUpperCase() + "%";
		 }
		return like;
	}
	
}
