package com.inca.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

import com.inca.utils.StringHelper;


/**
 * @Enterprise:北京英克康健科技有限公司-创新事业部
 * @Package:com.inca.hps.sys
 * @Description:查询基本配置条件
 * @author:王开展
 * @date:2019/1/17
 * @version:v1.0
 */
public class BaseQuery  implements Serializable {

	private static final long serialVersionUID = -419082044616187719L;
	// 是否分页
	private String showPager = "false";

	private int pageIndex;
	
	private int pageSize;
	
	private String sortField;
	
	private String sortOrder;
	
	Class<?> entityClazz;

    /**
     * 查询关键字
     */
    private String keyword;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 排序 desc: 降序  asc：升序
     */
    private Direction orderBy;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Direction getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Direction orderBy) {
        this.orderBy = orderBy;
    }
    
    public int getPageIndex() {
		return pageIndex+1;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortField() {
		sortField = this.getOrderColum(getEntityClass(), sortField);
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getShowPager() {
		return showPager;
	}
	public void setShowPager(String showPager) {
		this.showPager = showPager;
	}
	
	public String addSortSql(){
		if (!StringUtils.isEmpty(this.getSortField())) {
			if ("desc".equals(sortOrder) == false) {
				sortOrder = "asc";
			}
			return  " order by " + this.getSortField() + " " + sortOrder;
		}
		return "";
	}
	
	public String addLimitSql(){
		int size = Integer.valueOf(pageSize);
		int start = Integer.valueOf(pageIndex);
		if(pageSize > 0){
			return " limit "+start*size+", "+ pageSize;
		}
		return "";
	}
	
	public String addSortAndLimitSql(){
		return addSortSql() + addLimitSql();
	}

	/**
	 * 获取数据库实体
	 * @return
	 */
	public Class<?> getEntityClass() {
		return null;
	}
	
	/**
	 * 获取数据库排序字段
	 * @param sortField
	 * @return
	 */
	public String getOrderColum(Class<?> clazz, String sortField) {
		if (clazz == null) {
			return sortField;
		}
		if (StringHelper.isEmpty(sortField)) {
            return sortField;
        }

        // 创建时间
        if (sortField.equals("createTime")) {
        	return "create_time";
        }
        
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field colum = fields[i];
            if (sortField.equals(colum.getName())) {
            	Column annotation = colum.getAnnotation(Column.class);
                return annotation.name();
            }
        }
        return sortField;
	}
}
