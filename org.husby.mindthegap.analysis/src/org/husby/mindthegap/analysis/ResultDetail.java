package org.husby.mindthegap.analysis;

public class ResultDetail {

	public ResultDetail(User user, Detail detail1) {
		if(user==null || detail1==null){
			throw new EmptyResultDetailException();
		}
	}

	public static class EmptyResultDetailException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
}

