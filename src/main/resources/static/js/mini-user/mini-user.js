/**
 * 公用js
 */
__UserJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}

var userbootPATH = __UserJSPath("mini-user.js");

//消息提示 showTips
document.write('<script src="' + userbootPATH + 'js/mini-tips.js" type="text/javascript"></script>');
document.write('<link href="' + userbootPATH + 'css/mini-tips.css" rel="stylesheet" type="text/css" />');

//mini-messagebox 消息框内容可换行
document.write('<link href="' + userbootPATH + 'css/mini-messagebox.css" rel="stylesheet" type="text/css" />');