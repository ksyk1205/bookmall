package kr.co.itcen.bookmall.vo;

public class Order_BookVo {
	private Long no;
	private Long book_no;
	private Long book_count;
	private Long order_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getBook_count() {
		return book_count;
	}
	public void setBook_count(Long book_count) {
		this.book_count = book_count;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	@Override
	public String toString() {
		return "Order_BookVo [no=" + no + ", book_no=" + book_no + ", book_count=" + book_count + ", order_no="
				+ order_no + "]";
	}

}
