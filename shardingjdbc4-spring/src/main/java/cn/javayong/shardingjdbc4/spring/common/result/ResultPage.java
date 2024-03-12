package cn.javayong.shardingjdbc4.spring.common.result;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultPage<T> implements Serializable {

    private static final long serialVersionUID = -8080399458717111600L;

    private long total;

    private List<T> data;

    public ResultPage() {
        total = 0;
        data = new ArrayList<T>();
    }

    public ResultPage(List<T> rows) {
        this.init(rows);
    }

    private void init(List<T> rows) {
        if (rows instanceof Page) {
            Page<T> page = (Page) rows;
            this.total = page.getTotal();
            this.data = page.getResult();
        }

    }

    public long getTotal() {
        return total;
    }

    public ResultPage setTotal(long total) {
        this.total = total;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public ResultPage setData(List<T> data) {
        this.data = data;
        return this;
    }
}
