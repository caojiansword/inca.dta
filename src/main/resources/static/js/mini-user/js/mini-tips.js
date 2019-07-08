
//消息提示 showTips

/**
 * 成功消息提示
 * message 提示消息 如：保存成功
 */
function showSuccessTips(message){
	mini.showTips({
        content: "<div style='width:200px;height:120px;font-size:14px;'><b>成功</b> <br/><p class='sucP'>"+message+"</p></div>",
        state: "success",
        x: "right",
        y: "bottom",
        timeout: 3000
    });
}


/**
 * 消息提示
 * @param title  标题
 * @param message  提示消息
 * @param state  状态  //default|success|info|warning|danger
 */
function showTips(title,message,state){
	mini.showTips({
        content: "<div style='width:200px;height:120px;font-size:14px;'><b>"+title+"</b> <br/><p class='sucP'>"+message+"</p></div>",
        state: state,
        x: "right",
        y: "bottom",
        timeout: 3000
    });
}