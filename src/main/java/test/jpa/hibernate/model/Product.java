package test.jpa.hibernate.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.bstek.dorado.annotation.PropertyDef;

/**
 *@author Kevin.yang
 *@since 2015年6月24日
 */
@Entity
@Table(name = "OC_PRODUCT1")
public class Product implements Serializable{
	@Id
	@PropertyDef(label = "主键")
	@Column(name = "ID_", length = 36)
	private String id;
	private static final long serialVersionUID = 5773138859004823750L;
	//========================================
	/**
	 * 产品基本信息
	 */
	@PropertyDef(label = "产品简称")
	@Column(name = "PRODUCT_SHORT_NAME_")
	private String productShortName;
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)  
	@JoinTable(name = "OC_PRODUCT_SAPA1", joinColumns ={@JoinColumn(name = "PRODUCT_ID_", insertable = false, updatable = false)}, inverseJoinColumns = { @JoinColumn(name = "SALE_AGENCY_PAY_ACCOUNT_ID_", insertable = false, updatable = false)}) 	
	@Fetch(FetchMode.SUBSELECT)
	@PropertyDef(label = "销售机构缴款账户")
	private Set<SaleAgencyPayAccount> saleAgencyPayAccounts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductShortName() {
		return productShortName;
	}
	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}
	public Set<SaleAgencyPayAccount> getSaleAgencyPayAccounts() {
		return saleAgencyPayAccounts;
	}
	public void setSaleAgencyPayAccounts(Set<SaleAgencyPayAccount> saleAgencyPayAccounts) {
		this.saleAgencyPayAccounts = saleAgencyPayAccounts;
	}
	

}