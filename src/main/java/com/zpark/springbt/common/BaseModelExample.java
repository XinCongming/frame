package com.zpark.springbt.common;

/**
 * 扩展MyBatis自动生成的Example，添加分页功能
 */
public class BaseModelExample {
    //开始记录索引
    protected Integer rowIndex;
    //每页显示的数量
    protected Integer pageSize;

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
