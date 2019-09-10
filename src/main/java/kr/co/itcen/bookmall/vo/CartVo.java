package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private Long book_count;
	private Long user_no;
	private Long book_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBook_count() {
		return book_count;
	}
	public void setBook_count(Long book_count) {
		this.book_count = book_count;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", book_count=" + book_count + ", user_no=" + user_no + ", book_no=" + book_no
				+ "]";
	}

}
