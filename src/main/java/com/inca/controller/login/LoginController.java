package com.inca.controller.login;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONArray;
import com.inca.identifycode.Captcha;
import com.inca.identifycode.GifCaptcha;
import com.inca.service.LoginService;
import com.inca.utils.BASE64Util;
import com.inca.utils.Md5Util;


@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	LoginService loginservice;

	/**
	 * 登录操作
	 **/
	@RequestMapping(value = "submitlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitlogin(HttpServletRequest request, String username, String basepassword,
			String verification, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("用户名：" + username + "----" + "base64加密密码：" + basepassword + "----" + "验证码：" + verification);
		String password = null;
		// 转化成小写字母
		verification = verification.toLowerCase();// toLowerCase()
													// 方法用于将大写字符转换为小写。
		String v = (String) session.getAttribute("_code");// 表示得到 域中的对象
															// 返回的是OBJ类型
		// 读取一次后把验证码清空，这样每次登录都必须获取验证码
		session.removeAttribute("_come");
		System.out.println("用户输入验证码:" + verification + "--------" + "动态生成的验证码：" + v);
		if (username.equals("") || username == "") {
			map.put("result", "1");
		} else if (basepassword.equals("") || basepassword == "") {
			map.put("result", "2");
		} else if (verification.equals("") || verification == "") {
			map.put("result", "3");
		} else if (!verification.equals(v)) {
			map.put("result", "5");
			return map;
		} else {
			System.out.println("使用base64解密后密码：" + BASE64Util.decode(basepassword));
			String passwordjie = BASE64Util.decode(basepassword);
			try {
				System.out.println("md5加密以后的结果:" + Md5Util.md5(passwordjie));
				password = Md5Util.md5(passwordjie);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("md5加密异常：");
				e.printStackTrace();
			}
			int h = loginservice.selectByUserNameAndPassword(username, password);
			if (h == 1) {
				map.put("result", "0");
				System.out.println("登录成功。6666666666。。。。。。。。。。。");
			} else {
				map.put("result", "4");
			}
		}
		request.getSession().setAttribute("loginName", username);
		return map;
	}

	HttpSession session;// 全局变量

	// 登录
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, Model model) {
		// 当前设置session 存验证码 注意：我们要在服务器数据发送到客户端之前设置session 否则会报错
		session = request.getSession();
		return "login/login";
	}
	// 登录
	@RequestMapping(value = "")
	public String defaultLogin(HttpServletRequest request, Model model) {
		// 当前设置session 存验证码 注意：我们要在服务器数据发送到客户端之前设置session 否则会报错
		session = request.getSession();
		return "login/login";
	}

	/**
	 * 获取验证码（Gif版本）
	 *
	 * @param response
	 */
	@RequestMapping(value = "getGifCode", method = RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/**
			 * gif格式动画验证码 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146, 33, 4);
			// 输出
			captcha.out(response.getOutputStream());
			// 存入Session
			session.setAttribute("_code", captcha.text().toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取验证码异常：" + e.getMessage());
		}
	}

	
}
