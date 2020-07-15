package com.jhta.page.utill;

public class PageUtill {
	private int pageNum;
	private int startRow;//������
	private int endRow;//����
	private int totalpageCount;//��ü������ ����
	private int startPageNum;
	private int endPageNum;
	private int rowBlockCount;//���������� ������ ���� ���� 10���� ���̰ڴ�.
	private int pageBlockCount;//�� �������� ������ ���� ����
	private int totalRowCount;//��ü�� ����
	public PageUtill() {
		
	}
	public PageUtill(int pageNum, int totalRowCount, int rowBlockCount,int pageBlockCount) {
		this.pageNum=pageNum;
		this.totalRowCount=totalRowCount;
		this.rowBlockCount=rowBlockCount;
		this.pageBlockCount=pageBlockCount;
		
		startRow=(pageNum-1)*rowBlockCount+1;
		endRow=startRow+rowBlockCount-1;
		totalpageCount=(int)Math.ceil(totalRowCount/(double)rowBlockCount);
		
		startPageNum=(pageNum-1)/pageBlockCount*pageBlockCount+1;
		endPageNum=startPageNum+pageBlockCount-1;
		if (totalpageCount<endPageNum) {
			endPageNum=totalpageCount;
			
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getTotalpageCount() {
		return totalpageCount;
	}
	public void setTotalpageCount(int totalpageCount) {
		this.totalpageCount = totalpageCount;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getRowBlockCount() {
		return rowBlockCount;
	}
	public void setRowBlockCount(int rowBlockCount) {
		this.rowBlockCount = rowBlockCount;
	}
	public int getPageBlockCount() {
		return pageBlockCount;
	}
	public void setPageBlockCount(int pageBlockCount) {
		this.pageBlockCount = pageBlockCount;
	}
	public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	@Override
	public String toString() {
		return "PageUtill [pageNum=" + pageNum + ", startRow=" + startRow + ", endRow=" + endRow + ", totalpageCount="
				+ totalpageCount + ", startPageNum=" + startPageNum + ", endPageNum=" + endPageNum + ", rowBlockCount="
				+ rowBlockCount + ", pageBlockCount=" + pageBlockCount + ", totalRowCount=" + totalRowCount + "]";
	}
	

}
