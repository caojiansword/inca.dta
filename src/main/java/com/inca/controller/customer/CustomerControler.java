package com.inca.controller.customer;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.service.CustomerService;
import com.inca.service.OptionNewService;
import com.inca.utils.OptionMap;
import com.inca.utils.excel.ExcelController;


@Controller
@RequestMapping(CustomerControler.FUNC_PATH)
public class CustomerControler extends ExcelController<CustomerView>{
    public static final String FUNC_PATH = "/DTA001";
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OptionNewService optionNewService;
	@Autowired
	CustomerView customerView;
	@ModelAttribute("funcPath")
    public String funcPath() {
        return FUNC_PATH;
    }
	@ModelAttribute("type")
	public String getTypes() throws Exception {
		return OptionMap.getOptions("customertype");
	}
	@ModelAttribute("status")
	public String getStatus() throws Exception {
		return OptionMap.getOptions("status");
	}
   @RequestMapping("/customer")
    public String main() {
        return "customer/home";
    }
	@RequestMapping(value="/search")
	@ResponseBody
	public  List<CustomerView> search(String keyword,String type,String status){
		List<CustomerView> customers = customerService.getCustomerList();
		if(!StringUtils.isEmpty(keyword)){
			//编码 名称精确匹配
			//customers=customers.stream().filter(p->p.getCustomerName().equals(keyword)||p.getCustomerCode().equals(keyword)).collect(Collectors.toList());
			//模糊匹配
			customers = customerService.getCustomerListByKeyWord(keyword);
		}
		// 客户类型
		if (!StringUtils.isEmpty(type)) {
			Integer typeInt = Integer.valueOf(type);
			if (customers != null) {
				customers = customers.stream().filter(p -> typeInt.equals(p.getType())).collect(Collectors.toList());
			}
		}
		// 状态
		if (!StringUtils.isEmpty(status)) {
			Integer statusInt = Integer.valueOf(status);
			if (customers != null) {
				customers = customers.stream().filter(p -> statusInt.equals(p.getStatus()))
						.collect(Collectors.toList());
			}
		}
		return customers;
	}
	/*
	 * 客户管理页面添加用户
	 */
	@RequestMapping(value="/addsure")
	@ResponseBody
	public  Map<String, Object> insertuser(String json){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (json != null) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String customerCode = jsonObject.getString("customerCode");
				String customerName = jsonObject.getString("customerName");
				String domain = jsonObject.getString("domain");
				Integer type = jsonObject.getInteger("type");
				String orgCode = jsonObject.getString("orgCode");
				Integer status = jsonObject.getInteger("status");
				String phoneNo = jsonObject.getString("phoneNo");
				Integer id = jsonObject.getInteger("id");
				Customer customer = new Customer();
				customer.setCustomerCode(customerCode);
				customer.setCustomerName(customerName);
				customer.setDomain(domain);
				customer.setType(type);
				customer.setOrgCode(orgCode);
				customer.setStatus(status);
				customer.setPhoneNo(phoneNo);
				customer.setCreateTime(new Date());
				customer.setOnlineDate(null);
				customer.setStopDate(null);
				//根据客户id判断是新增 还是修改
				if (id != null) {
					customer.setId(id);
					int h = customerService.updateCustomer(customer);
					map.put("success", h > 0 ? true : false);
					map.put("msg", h > 0 ? "修改成功" : "修改失败");
					return map;
				} else {
					int h = customerService.addCustomer(customer);
					map.put("success", h > 0 ? true : false);
					map.put("msg", h > 0 ? "保存成功" : "保存失败");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "保存失败:" + e.getMessage());
		}
		return map;
	}
	
	
	/*
	 * delleteuser 删除用户
	 */
	@RequestMapping(value="/delleteuser")
	@ResponseBody
	public Map<String, Object> deleteuser(Integer[] ids){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int h = 0;
			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					h = customerService.deleteCustomer(id);
				}
			}
			map.put("success", h > 0 ? true : false);
			map.put("msg", h > 0 ? "删除成功" : "删除失败");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "删除失败:" + e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="/findCustomserById")
	@ResponseBody
	public  CustomerView findCustomerById(Integer id){
		CustomerView customers = customerService.getCustomerById(id);
		return customers;
	}
	/*
	 * updatesure 客户管理编辑
	 * 
	 */
	@RequestMapping(value="/updatesure")
	@ResponseBody
	public Map<String, Object> updateuser(Customer customer){
		  Map<String, Object> map = new HashMap<String, Object>();

		  int h =customerService.updateCustomer(customer);
			if (h==1) {
				map.put("result", "1");
			}else{
				map.put("result", "2");
			}
		  return map;
	}
	
	/*
	 * doOnline 确定
	 * 
	 */
	@RequestMapping(value = "/doOnline")
	@ResponseBody
	public Map<String, Object> doOnline(Integer[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int h = 0;
			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					CustomerView customer = customerService.getCustomerById(id);
					h = customerService.doEnableCustomer(customer);
					map.put("success", h > 0 ? true : false);
					map.put("msg", h > 0 ? "确定成功" : "确定失败");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "确定失败:" + e.getMessage());
		}
		return map;
	}
	/*
	 * doStop 停用
	 * 
	 */
	@RequestMapping(value = "/doStop")
	@ResponseBody
	public Map<String, Object> doStop(Integer[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int h = 0;
			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					CustomerView customer = customerService.getCustomerById(id);
					h = customerService.doStopCustomer(customer);
					map.put("success", h > 0 ? true : false);
					map.put("msg", h > 0 ? "停用成功" : "停用失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "停用失败:" + e.getMessage());
		}
		return map;
	}
	
	/* 
	* Description: 用于导出Model
	* @return
	*/
	@Override
	public CustomerView getEntity() {
		return customerView;
	}

	/* 
	* Description: 用于导入实体
	* @return
	*/
	@Override
	public Class<CustomerView> getClazz() {
		return CustomerView.class;
	}
}
