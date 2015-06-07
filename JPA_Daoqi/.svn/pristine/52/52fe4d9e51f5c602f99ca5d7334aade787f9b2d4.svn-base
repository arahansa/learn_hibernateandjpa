package chap02_2.secondarytable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
@SecondaryTable(
	name="CONTENT", 
	pkJoinColumns=@PrimaryKeyJoinColumn(
			name="BOOK_ID_FPK", 
			referencedColumnName="BOOK_ID_PK")
)
public class Book {

	@Id
	@GeneratedValue
	@Column(name="BOOK_ID_PK")
	private int id;
	
	@Basic(fetch=FetchType.LAZY)
	@Lob
	@Column(table="CONTENT", name="PDF")
	protected byte[] pdf;

	
	
	public Book() {
	}
	
	
	public Book(byte[] pdf) {
		super();
		this.pdf = pdf;
	}


	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	
	
	
}
