package test.jpa.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 *@author Kevin.yang
 *@since 2015年6月25日
 */
@Entity
@Table(name = "OC_SALE_AGENCY_PAY_ACCOUNT")
public class SaleAgencyPayAccount extends Account{

	private static final long serialVersionUID = 6393018890355061915L;
	@Column(name = "CHECK_STATE_")
	@PropertyDef(label = "审核状态")
	private int checkState;
	
	@Column(name = "VALID_")
	@PropertyDef(label = "是否有效")
	private boolean valid;
	
	@Column(name = "REMARK_")
	@PropertyDef(label = "备注/用途")
	private String remark;

	public int getCheckState() {
		return checkState;
	}

	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
