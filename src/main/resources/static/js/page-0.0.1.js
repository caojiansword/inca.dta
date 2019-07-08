$(function(){
	if($("#pagecount").length < 1){
		$("body").append('<div id="pagecount"></div>')
	}
})
var nowPage = 1; //当前页码
var total,pageSize,totalPage,totalNums,pageTxt;
function getData(curPage){
	if(getMiniGrid()){
		getMiniGrid().gotoPage (curPage-1, getPageSize() );
	}else{
		gotoPage(curPage-1, getPageSize() );
	}
	upPage();
}
function setTotalRecord(num){
	totalNums = num;
	totalPage = num/getPageSize();
	totalPage = Math.ceil(totalPage)
	if(getMiniGrid()){
		nowPage = getMiniGrid().pageIndex + 1;
	}
	upPage()
}
function gotoPage(){
	
}
function initPageCount(){
	nowPage = 1;
	upPage();
}
function getMiniGrid(){
	try{
		return grid;
	}catch(e){
		return null;
	}
}
function setPageSize(size){
		pageSize = size;
}
function getPageSize(){
	if(!pageSize){
		if(getMiniGrid()){
			pageSize = getMiniGrid().pageSize;
		}
	}
	if(pageSize){
		return pageSize;
	}else{
		return 20;
	}
}

	function showTableDataList(data) {

			for (var i = data.length - 1; i >= 0; i--) {
				
				upPage(data);
			}

	}
	var listNum = 3; //每页显示<ul>数
	var PageNum = 5; //分页链接接数(5个)
	var strF='...';
	var strG='<span class="r01sp">到</span><input type="text" class="pageTxt"/><span class="r01sp">页</span><input type="button" value="确定"  class="pageBtn"/>'
	function upPage(){
		if(!totalPage || totalPage<1){
			document.getElementById("pagecount").innerHTML =""
			return ;
		}
		var PageNum_2 = PageNum % 2 == 0 ? Math.ceil(PageNum / 2) + 1 : Math.ceil(PageNum / 2)
		var PageNum_3 = PageNum % 2 == 0 ? Math.ceil(PageNum / 2) : Math.ceil(PageNum / 2) + 1
		var strC = "",startPage,endPage;
		if (PageNum >= totalPage) {
			startPage = 1;
			endPage = totalPage
		} else if (nowPage < PageNum_2) {
			startPage = 1;
			endPage = totalPage > PageNum ? PageNum + 1 : totalPage
		}
		//首页
		else {
			startPage = nowPage + PageNum_3 >= totalPage ? totalPage - PageNum : nowPage - PageNum_2 + 1;
			var t = startPage + PageNum;
			endPage = t > totalPage ? totalPage : t
		}
		for (var i = startPage; i <= endPage; i++) {
			if (i == nowPage) strC += '<a href="###" style="color:#64A5FF;border:1px solid #64A5FF;" onclick="changPage(' + i + ');" >' + i + '</a>'
			else strC += '<a href="###" onclick="changPage(' + i + ');">' + i + '</a>'
		}

		strE2 = "共" + totalPage + "页";
		if(startPage==1 && endPage<totalPage){
			
			strF='<i></i><a href="###"  onclick="changPage(' + totalPage + ');" >'+totalPage+'</a>';
			document.getElementById("pagecount").innerHTML = "<span class='l ltotalPage'>总共<span class='colorB'>"+totalNums+"</span>条数据</span><span style='line-height:30px;float:right' class='rightSp'>" + strE2 +strG+ "</span>"+"<span style='margin-right:8px;'  class='leftSp'>" +'<span><a href="javascript:void(0)"  onclick="preChange()" class="pre">上一页</a></span>' + strC +strF+'<span><a href="javascript:void(0)"  onclick="nextChange()" class="next">下一页</a></span>'+"</span>"
		}else if(endPage==totalPage){
			if(endPage<=6){
				strF=''
				document.getElementById("pagecount").innerHTML ="<span class='l ltotalPage'>总共<span class='colorB'>"+totalNums+"</span>条数据</span><span  class='rightSp'>" + strE2 +strG+ "</span>"+ "<span class='leftSp'>"+'<span><a href="javascript:void(0)"  onclick="preChange()" class="pre">上一页</a></span>'+ strF+ strC+ '<span><a href="javascript:void(0)"  onclick="nextChange()" class="next">下一页</a></span>'+"</span>"
			}else{
				strF='<i></i>'
				document.getElementById("pagecount").innerHTML ="<span class='l ltotalPage'>总共<span class='colorB'>"+totalNums+"</span>条数据</span><span class='rightSp'>" + strE2 +strG+ "</span>"+ "<span  class='leftSp'>"+'<span><a href="javascript:void(0)"  onclick="preChange()" class="pre">上一页</a></span><a onclick="changPage(' + 1 + ')">1</a>'+ strF+ strC+ '<span><a href="javascript:void(0)"  onclick="nextChange()" class="next">下一页</a></span>'+"</span>"
			}
		}else{
			strF='<i></i>'
			document.getElementById("pagecount").innerHTML ="<span class='l ltotalPage'>总共<span class='colorB'>"+totalNums+"</span>条数据</span><span style='line-height:30px;float:right' class='rightSp'>" + strE2 + strG+"</span>"+ "<span style='margin-right:8px;'  class='leftSp'>"+'<span><a href="javascript:void(0)"  onclick="preChange()" class="pre">上一页</a></span>'+ strF+ strC +strF+ '<span><a href="javascript:void(0)"  onclick="nextChange()" class="next">下一页</a></span>'+"</span>"
		}
		if(nowPage==1){
			$('.pre').addClass('commonNoclick')
		}
		if(nowPage==totalPage){
			$('.next').addClass('commonNoclick')
		}
		$('.nowpage').html(nowPage);
		$('.totalpage').html(totalPage);
		$('.pageBtn').click(function(){
			pageTxt = parseInt($('.pageTxt').val());//注：文本框中值转成数字！！！
			var reg = /^\d+$/;//验证输入的是否为数字
			if(!reg.test(pageTxt)){
				$('.pageTxt').val("")
			}else{
				if(pageTxt>totalPage){
					pageTxt==totalPage
					changPage(totalPage)
				}else if(pageTxt<1){
					changPage(1)
				}else{
					changPage(pageTxt)
				}
			}
		})
	}
	
	function preChange(){
		if(!$('#pagecount a.pre').hasClass('commonNoclick')){
			changPage(nowPage-1)
		}
	}
	function changPage(e) {
				console.log(e+'```'+totalPage)
				if(e==0){
					nowPage==0
				}else if(e==(totalPage+1)){

					nowPage==totalPage+1
				}else{
					nowPage = e;
				}
				getData(nowPage)
	}
	function nextChange(){
		if(!$('#pagecount a.next').hasClass('commonNoclick')){
			changPage(nowPage+1)
		}
	}
	function CommonQuery(){
		this.pageIndex = 0;
		this.pageSize = 20;
		this.sortField;
		this.sortOrder;
	}