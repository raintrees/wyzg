package com.wyzg.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author raintrees
 * @date 2019/10/26 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 数据总条数
     */
    private Long total;
    /**
     * 数据总页数
     */
    private Long totalPage;
    /**
     * 当前页面的数据
     */
    private List<T> items;
}
