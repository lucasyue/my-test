package test.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <P> 分页对象 <P>
 * date: 2016-3-12 下午9:50:33
 * @author way8147
 * @version 1.0.0
 */
public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(Pager.class);
	
	private int pageNumber;//页码,从1开始
	
    private int pageSize;//每页多少条
    
    private int startRow;//开始记录数
    
    private int endRow;//结束记录数
	
    private int previousPage;// 上一页

    private int nextPage;// 下一页

    private int pageCount;//总页数
    
    private long total;//总记录数
    
    private int[] pageList;//页尺寸数组,eg:[10, 20, 50, 100]
    
    private boolean showPageNumber;//显示页码
    
    private boolean showPageSize;//显示页尺寸
    
    private boolean showPageInfo;//显示分页信息
    
    private boolean showReloadButton;//显示刷新按钮
    
    private boolean showButtonText;//显示按钮文本
    
    private boolean showButtonIcon;//显示按钮图标

    private List<T> rows = null; //行记录
    
    private boolean showPager = true;//是否分页
    
    private boolean showCount = true;//是否显示数量
    
    private Object conditionParam;//查询条件
    
    private String orderByClause;//排序语句：eg:username desc
    
    private String sort; //排序属性
    
    private String order; //排序
    
    public Pager(){}
    
    
    /**
     * @param pageNumber
     * @param pageSize
     */
    public Pager(int pageNumber, int pageSize) {
    	this.pageNumber = pageNumber;
    	this.pageSize = pageSize;
    }
    
    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRows() {
    	if (rows == null) {
    		return new ArrayList<T>();
    	}
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    
	public int getPageNum(String pageNumStr) {
        int pageNum = 1;
        try {
            if (pageNumStr != null) {
                pageNum = Integer.parseInt(pageNumStr);
            }
        } catch (NumberFormatException e) {
        }
        return pageNum <= 1 ? 1 : pageNum;
    }

    /**
     * @param total
     * @param pageSize
     * @param pageNumber
     */
    public void setPageInfo(int total, int pageSize, int pageNumber) {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        setTotal(total);// 总条数
        setPageSize(pageSize);// 每页条数
        setPageCount(total % pageSize == 0 ? total / pageSize : total / pageSize + 1);// 总页数
        setPageNumber(pageNumber);// 第几页
        setPreviousPage(pageNumber <= 1 ? -1 : pageNumber - 1);// 上一页
        setNextPage(pageNumber < pageCount ? pageNumber + 1 : -1);// 下一页
        setStartRow(1 + pageSize * (pageNumber - 1));// 开始条数
        setEndRow(pageNumber < pageCount ? pageNumber * pageSize : total);// 结束条数
    }

	/**
	 * pageNumber. 
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * pageNumber. 
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * pageSize. 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * pageSize. 
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * startRow. 
	 * @return the startRow
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * startRow. 
	 * @param startRow the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * endRow. 
	 * @return the endRow
	 */
	public int getEndRow() {
		return endRow;
	}

	/**
	 * endRow. 
	 * @param endRow the endRow to set
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/**
	 * total.
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.pageCount = (int) (total / this.pageSize + ((total % this.pageSize == 0) ? 0 : 1));
        } else {
            this.pageCount = (int) total;
        }
    }

	/**
	 * showPager. 
	 * @return the showPager
	 */
	public boolean isShowPager() {
		return showPager;
	}

	/**
	 * showPager. 
	 * @param showPager the showPager to set
	 */
	public void setShowPager(boolean showPager) {
		this.showPager = showPager;
	}

	/**
	 * conditionParam. 
	 * @return the conditionParam
	 */
	public Object getConditionParam() {
		return conditionParam;
	}

	/**
	 * conditionParam. 
	 * @param conditionParam the conditionParam to set
	 */
	public void setConditionParam(Object conditionParam) {
		this.conditionParam = conditionParam;
	}

	/**
	 * orderByClause. 
	 * @return the orderByClause
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * orderByClause. 
	 * @param orderByClause the orderByClause to set
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	

	/**
	 * sort.
	 *
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}


	/**
	 * sort.
	 *
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}


	/**
	 * order.
	 *
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}


	/**
	 * order.
	 *
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}


	/**
	 * pageList. 
	 * @return the pageList
	 */
	public int[] getPageList() {
		return pageList;
	}


	/**
	 * pageList. 
	 * @param pageList the pageList to set
	 */
	public void setPageList(int[] pageList) {
		this.pageList = pageList;
	}


	/**
	 * showPageNumber. 
	 * @return the showPageNumber
	 */
	public boolean isShowPageNumber() {
		return showPageNumber;
	}


	/**
	 * showPageNumber. 
	 * @param showPageNumber the showPageNumber to set
	 */
	public void setShowPageNumber(boolean showPageNumber) {
		this.showPageNumber = showPageNumber;
	}


	/**
	 * showPageSize. 
	 * @return the showPageSize
	 */
	public boolean isShowPageSize() {
		return showPageSize;
	}


	/**
	 * showPageSize. 
	 * @param showPageSize the showPageSize to set
	 */
	public void setShowPageSize(boolean showPageSize) {
		this.showPageSize = showPageSize;
	}


	/**
	 * showPageInfo. 
	 * @return the showPageInfo
	 */
	public boolean isShowPageInfo() {
		return showPageInfo;
	}


	/**
	 * showPageInfo. 
	 * @param showPageInfo the showPageInfo to set
	 */
	public void setShowPageInfo(boolean showPageInfo) {
		this.showPageInfo = showPageInfo;
	}


	/**
	 * showReloadButton. 
	 * @return the showReloadButton
	 */
	public boolean isShowReloadButton() {
		return showReloadButton;
	}


	/**
	 * showReloadButton. 
	 * @param showReloadButton the showReloadButton to set
	 */
	public void setShowReloadButton(boolean showReloadButton) {
		this.showReloadButton = showReloadButton;
	}


	/**
	 * showButtonText. 
	 * @return the showButtonText
	 */
	public boolean isShowButtonText() {
		return showButtonText;
	}


	/**
	 * showButtonText. 
	 * @param showButtonText the showButtonText to set
	 */
	public void setShowButtonText(boolean showButtonText) {
		this.showButtonText = showButtonText;
	}


	/**
	 * showButtonIcon. 
	 * @return the showButtonIcon
	 */
	public boolean isShowButtonIcon() {
		return showButtonIcon;
	}


	/**
	 * showButtonIcon. 
	 * @param showButtonIcon the showButtonIcon to set
	 */
	public void setShowButtonIcon(boolean showButtonIcon) {
		this.showButtonIcon = showButtonIcon;
	}


	public boolean isShowCount() {
		return showCount;
	}


	public void setShowCount(boolean showCount) {
		this.showCount = showCount;
	}
	
	

}
