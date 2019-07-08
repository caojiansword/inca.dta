$(function(){
})
function dialogCallback(){
}
function msg_success(msg1,title, timer, callback){
	msg_open(1,title,msg1,'',callback, timer)
	 if(typeof callback === "function") dialogCallback = callback
}
function msg_error(msg1,msg2,title, timer, callback){
	msg_open(2,title,msg1,msg2,callback, timer)
	if(typeof callback === "function")dialogCallback = callback
}
function msg_confirm(msg1,title, callback, timer){
	msg_open(3,title,msg1,'',callback, timer)
	if(typeof callback === "function")dialogCallback = callback
}
function msg_tip(msg1,title, timer, callback){
	msg_open(0,title,msg1,'',callback, timer)
	if(typeof callback === "function")dialogCallback = callback
}




mini.confirm=function(msg1, title, callback, timer){
	msg_open(3,title,msg1,'',callback, timer)
	if(typeof callback === "function")dialogCallback = callback
}
mini.alert=function(msg1, title, timer, callback){
	msg_open(0,title,msg1,'',callback, timer)
	if(typeof callback === "function")dialogCallback = callback
}

function msg_open(status,title,msg1,msg2,callback, timer){
	if(!title){
		title="提示"
	}
	if(status==1){
    	$(window.parent.document).find('.successDialog .title').html(title)
    	$(window.parent.document).find('.successDialog .msg1 span').html(msg1)
    	$(window.parent.document).find('.successDialog').show()
    }else if(status==2){
    	$(window.parent.document).find('.errorDialog .title').html(title)
    	$(window.parent.document).find('.errorDialog .msg1 span').html(msg1)
    	$(window.parent.document).find('.errorDialog .msg2').html(msg2)
    	$(window.parent.document).find('.errorDialog').show()
    }else if(status==3){
    	$(window.parent.document).find('.configDialog .title').html(title)
    	$(window.parent.document).find('.configDialog .msg1 span').html(msg1)
    	$(window.parent.document).find('.configDialog').show();
//        if(typeof  callback =="function"){
//            $(window.parent.document).find('.configDialog .confirmBtn').click(function (e) {
//            	e.stopPropagation();
//                callback();
//            });
//        }
    }else if(status==0){
    	$(window.parent.document).find('.tipDialog .title').html(title)
    	$(window.parent.document).find('.tipDialog .msg1 span').html(msg1)
    	$(window.parent.document).find('.tipDialog').show()
    }
	if(timer){
		var i=0;
		var t = setInterval(function(){
			i++;
			if(i * 1000 >= timer ){
				$(window.parent.document).find('.dialog').hide()
				clearInterval(t)
                if(typeof callback === "function"){
					callback();
				}
			}
		}, 1000)
	}
}
