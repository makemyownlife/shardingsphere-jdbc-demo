package cn.javayong.shardingjdbc4.spring.common.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

public class PageDataInfo<T> {

    /**
     * 总页数
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private long total;


    /**
     * 数据列表
     */
    private List<T> dataList;


    public PageDataInfo() {
    }


    public PageDataInfo(long total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }

    public static <T> PageDataInfo<T> of(long total, List<T> dataList) {
        return new PageDataInfo<>(total, dataList);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

}
