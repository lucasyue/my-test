package test.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 *@author Kevin.yang
 *@since 2015年6月25日
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "OC_ACCOUNT")
public class Account implements Serializable{

	private static final long serialVersionUID = -5266226525008355203L;

	@Id
	@PropertyDef(label = "主键")
	@Column(name = "ID_")
	private String id;
	
	@PropertyDef(label = "户名")
	@Column(name = "ACCOUNT_NAME_")
	private String accountName;
	
	@PropertyDef(label = "账号")
	@Column(name = "ACCOUNT_NUMBER_")
	private String accountNumber;
	
	@PropertyDef(label = "开户行")
	@Column(name = "OPENING_BANK_")
	private String openingBank;
	
	@PropertyDef(label = "大额支付号")
	@Column(name = "LARGE_PAY_NUMBER_")
	private String largePayNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public String getLargePayNumber() {
		return largePayNumber;
	}

	public void setLargePayNumber(String largePayNumber) {
		this.largePayNumber = largePayNumber;
	}

	
	
	
	
	
}
