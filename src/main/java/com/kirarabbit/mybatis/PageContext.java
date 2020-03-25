package com.kirarabbit.mybatis;


/**
 * 实现描述：分页上下文, 用于分页逻辑的解耦
 *
 * @author kira 2015-09-08
 */
public class PageContext {

    private static final ThreadLocal<Page> context = new ThreadLocal<Page>();

    /**
     * 清除线程分页数据
     */
    public static void clear() {
        PageContext.context.remove();
    }

    /**
     * 获取线程分页信息（需要查询totalRows）
     *
     * @return
     */
    public static Page getCountTotalRowsPage() {
        Page page = PageContext.context.get();
        page.setCountTotalRows(true);
        return page;
    }

    /**
     * 获取线程分页信息
     */
    public static Page getPage() {
        return PageContext.context.get();
    }

    /**
     * 设置线程分页信息
     */
    public static void setPage(Page page) {
        PageContext.context.set(page);
    }
}