package jrk.shop.utils;

import java.util.List;

public class PageBean<T> {
	// ��ǰҳ��
	private Integer page;
	// ÿҳ��ʾ��¼��
	private Integer limit;
	// �ܼ�¼��
	private Integer totalCount;
	// ��ҳ��
	private Integer totalPage;
	// ��ʾ�������������
	private List<T> list;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
