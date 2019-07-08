function showImportDialog(){
	 var importFileDialog = mini.get("#importFileDialog");
	 document.getElementsByName("importFile")[0].value=null;
	   importFileDialog.show();
       }
$(function(){
	if($("#importFileForm").length < 1){
		createImportDialog()
	}
})
function createImportDialog(){
	var $div = document.createElement("div");
	  document.body.appendChild($div);
 	  var $form = '<div id="importFileDialog" class="mini-window" title="导入" style="width:300px;"  showModal="true" allowResize="false" allowDrag="true" ><form id="importFileForm" method="post" align="center" enctype="multipart/form-data"><div align="left"><input type="file"  name="importFile" /></div><br /> <br /> <a class="blue-btn" onclick="importExcel()">确定</a></form></div>';
 	  mini.append($div, $form);
 	 mini.parse($form)
}
        
function importExcel(){
	var _columns = getExportColumns();
	var data = new FormData(document.getElementById("importFileForm"));
	 var implService = getImportServiceName();
	 var className = getImportTableClassName();
	 var pattern = getDatePattern();
	 var docId = getImportDocId();
	 var imlType = getImportType();
	 data.append("datePattern", pattern)
	 data.append("implService", implService)
	 data.append("columns", _columns)
	 data.append("className", className)
	 data.append("docId", docId)
	 data.append("imlType", imlType)
	 if (document.getElementsByName("importFile")[0].value.indexOf(".xlsx") < 0) {
		 mini.alert("请选中需要导入的文件");
		 return;
	 }
	 var importFileDialog = mini.get("importFileDialog");
   	 importFileDialog.hide();
	 $.ajax({
		 url:"/common/SCMEXP001/import",
		 type:"post",
		 data: data,
		 cache: false,  
         contentType: false,  
         processData: false, 
         success:function(result){
        	 importCallBack(result)
         }
	 })
}

function exportExcel() {
	 msg_confirm("确定导出记录？", "确定？",
		        function () {
		            	export_excel("/common/SCMEXP001/export");
		        });
}

function export_excel(url) {
	var _columns = getExportColumns();
    var _notNullColumns = getNotNullColumns();
    var comment = getHeaderComment();
    var options = getExportOptions();
    var sumSql = getExportSumSql();
    var implService = getImportServiceName();
    var sumColumns = getExportSumColumns();
    DownLoad(url, { type: "excel", columns: _columns, notNullColumns : _notNullColumns, 
    	comment :  comment, option : options, sumSql : sumSql, sumColumns : sumColumns, implService : implService });

}
function exportTemplate(){
	export_excel("/common/SCMEXP001/exportTemplate")
} 
function getExportSumSql(){
	return "";
} 
function getExportSumColumns(){
	return "";
}
function getImportServiceName(){
	return "";
}
function getImportDocId(){
	return -1;
} 
function getImportType(){
	return null;
} 
//获取不为空字段
function getNotNullColumns(){
	return "";
}

function getHeaderComment(){
	return "";
}
function getDatePattern(){
	return "";
}
function getExportOptions(){
	return "";
}
function importCallBack(result){
	if(!result.ok){
		 mini.alert(result.msg);
		 var newWindowObi = window.open("about:blank");
		 console.log(newWindowObi)
		 if(newWindowObi){
			 newWindowObi.document.title="导入错误日志"
			 newWindowObi.document.write(result.msg);
		 }
	 }else{
   	 console.log("importExcel success ...")
   	 var importFileDialog = mini.get("importFileDialog");
   	 importFileDialog.hide();
   	 mini.alert("导入完成");
	 }
}
function getExportColumns(){
	var exportGrid = getExportMiniGrid();
    var columns = exportGrid.columns;
    var _columns = getExportGridColumns(columns);
    return mini.encode(_columns);
}

function getExportGridColumns(columns) {
    var cols = [];
    for (var i = 0; i < columns.length; i++) {
        var column = columns[i];
        if(!column.visible) continue;
        if(!column.field) continue;
        if(!column.header) continue;
        var col = { header: column.header, field: column.field, type: column.type };
        if (column.columns) {
            col.columns = getExportGridColumns(column.columns);
        }
        cols.push(col);
    }
    return cols;
}

function DownLoad(url, fields) {
    var submitfrm = document.createElement("form");
    submitfrm.action = url;
    submitfrm.method = "post";
    document.body.appendChild(submitfrm);
    if (fields) {
        for (var p in fields) {
            var input = mini.append(submitfrm, "<input type='hidden' name='" + p + "'>");
            var v = fields[p];
            if (typeof v != "string") v = mini.encode(v);
            input.value = v;
        }
        var input1 = mini.append(submitfrm, "<input type='hidden' name='sql'>");
        if($regetFlag){
    		$regetFlag=false;
    		input1.value = $regetSql;
    	}else{
    		input1.value = getExportSql();
    	}
        var input2 = mini.append(submitfrm, "<input type='hidden' name='filename'>");
        input2.value = getExportFileName();
    }

    submitfrm.submit();
    setTimeout(function () {
        submitfrm.parentNode.removeChild(submitfrm);
    }, 1000);
}

function getExportSql(){
	var exportGrid = getExportMiniGrid();
	var result = exportGrid.getResultObject();
	return result.sql;
}

var $regetFlag=false;//是否重新获取导出sql(sql需要重新拼一些条件)
var $regetSql;//重新获取的导出sql
/**
 * 重新获取导出sql(sql需要重新拼一些条件)
 * @param url  请求路径 （数组参数需要拼在url里）
 * @param params  参数对象{sql:sql,...}
 */
function reGetSql(url,params){
	$regetFlag=false;
	var sql=getExportSql();
	if(params==null){
		params={sql:sql};
	}else{
		params.sql=sql;
	}
	
	$.ajax({  
         type : "post",  
         url : url,  
         data : params,  
         async : false,  
         success : function(res){  
        	 if(res.ok){
     			$regetSql=res.data;
     			$regetFlag=true;
     		 }
         }  
    });
}

function getExportFileName(){
	return $("title").text();
}
function getExportMiniGrid(){
	return grid;
}