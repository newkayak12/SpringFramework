package com.kh.spring.common;

public class PageBar {
	
	public static String pageBar(int cPage, int totalData, int numPerPage, int pageBarSize, String url) {
		
		
		
		int totalPage = (int) Math.ceil((double) totalData/numPerPage);
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize -1;
		
		String pageBar ="<ul class='pagination justify-content-center pagination-sm'>";
		
		if(pageNo==1) {
			
			pageBar+="<li class='page-item disable'> <a href='#' class='page-link' tableindex='-1'>이전</a></li>";
		} else {
			pageBar+="<li class='page-item'> <a class='page-link' href='javascript:fn_page("+(pageNo-1)+")'>이전</a></li>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			
			if(pageNo==cPage) {
				pageBar += "<li class='page-item active'> <a class='page-link'>"+pageNo+"</a></li>";
				
			} else {
				
				pageBar += "<li class='page-item'> <a class='page-link' href='javascript:fn_page("+pageNo+")'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			
			pageBar+="<li class='page-item disable'> <a href='#' class='page-link'> 다음 </a></li>";
		} else {
			pageBar+="<li class='page-item'> <a class='page-link' href='javascript:fn_page("+pageNo+")'>다음</a></li>";
		}
		
		pageBar +="</ul><script>const fn_page=(e)=>{location.assign('"+url+"?cPage='+e)}</script>";
		
		return pageBar;
	}
	
}
