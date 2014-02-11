package com.utils;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;


public class SortedPage<K> {
	
	private List<K> listOfK;
	
	private Map<String, Object> params;
	
	private static final String LOCATION = "SortedPage";
	
	public static final String SORT_KEY = "sort";
	
	public static final String SORT_DIR_KEY = "dir";
	
	public static final String DEFAULT_SORT_DIR = "Asc";
	
	public static final String PARAM_LIMIT = "limit";
	
	public static final String PARAM_PAGE = "page";
	
	public static final String PARAM_START = "start";
	
	public SortedPage(List<K> listOfK, 
						Map<String, Object> params) {
		super();
		this.listOfK = listOfK;
		this.params = params;
	}

	public List<K> getList() throws  Exception{
		
		List<K> uiListOfK = new ArrayList<K>();
		int start = 0;
		int limit = 0;
		int page = 0;
		
		/*Check if param is not null*/
		if (this.params == null && CollectionUtils.isEmpty(this.listOfK)){
			throw new  Exception("") ; 
		}
		
		start = this.params.containsKey(PARAM_START)? Integer.parseInt(this.params.get(PARAM_START).toString()):0;
		limit = this.params.containsKey(PARAM_LIMIT)? Integer.parseInt(this.params.get(PARAM_LIMIT).toString()):this.listOfK.size();
		if ( limit <= 0 )
		{
		    page = 1;
		}
		else
		{
		    page =  this.params.containsKey(PARAM_PAGE)? Integer.parseInt(this.params.get(PARAM_PAGE).toString()):((start/limit)+1);
		}
		
		/* Sorting Mechanism	 */
		if (params.containsKey(SORT_KEY) && params.containsKey(SORT_DIR_KEY)){
			if (StringUtils.equalsIgnoreCase(DEFAULT_SORT_DIR, params.get(SORT_DIR_KEY).toString())){
			 
				CollectionUtilsExt.sortCollection(this.listOfK, true, params.get(SORT_KEY).toString());
			}
			else{
				CollectionUtilsExt.sortCollection(this.listOfK, false, params.get(SORT_KEY).toString());
			}
		}
										
		Pageable<K> pageableListOfK = new Pageable<K>(this.listOfK);
		pageableListOfK.setPageSize(limit);
		pageableListOfK.setPage(page);
		uiListOfK = (ArrayList<K>) pageableListOfK.getListForPage();
		
		return uiListOfK;
	}
}