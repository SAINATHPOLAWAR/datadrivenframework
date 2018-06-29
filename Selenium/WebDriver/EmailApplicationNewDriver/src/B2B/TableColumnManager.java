package B2B;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableColumnManager {


	long customerid;
	long quoteheaderid;
	long handsetquoteid;
	long quoteheaderid1;
	
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getQuoteheaderid() {
		return quoteheaderid;
	}
	public void setQuoteheaderid(long quoteheaderid) {
		this.quoteheaderid = quoteheaderid;
	}
	public long getHandsetquoteid() {
		return handsetquoteid;
	}
	public void setHandsetquoteid(long handsetquoteid) {
		this.handsetquoteid = handsetquoteid;
	}
	
	public long getQuoteheaderid1() {
		return quoteheaderid1;
	}
	public void setQuoteheaderid1(long quoteheaderid) {
		this.quoteheaderid1 = quoteheaderid;
	}

}


