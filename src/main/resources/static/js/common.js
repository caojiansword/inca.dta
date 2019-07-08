function getCaptchaImgUrl() {
	var catpchaimgurl = "/scm/captcha/captcha";
	var url = catpchaimgurl + "?_r" + Math.random();
	return url;
}

function checkCaptcha(code){
	var res = false;
	$.ajax({
		url:url,
		data:{captcha:code},
		async: false,
		success:function(result){
			if(result.ok){
				res = true;
			} else{
				 res = false;
			}
		}
	})
	return res;
}