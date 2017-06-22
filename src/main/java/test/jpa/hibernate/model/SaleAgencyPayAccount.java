package test.jpa.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 *@author Kevin.yang
 *@since 2015年6月25日
 */
@Entity
@Table(name = "OC_SALE_AGENCY_PAY_ACCOUNT1")
public class SaleAgencyPayAccount{
	
	@Id
	@PropertyDef(label = "主键")
	@Column(name = "ID_")
	private String id;
	
	@Column(name = "REMARK_")
	@PropertyDef(label = "备注/用途")
	private String remark;
	@ManyToMany(mappedBy="saleAgencyPayAccounts")
	private Set<Product> products ;
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
