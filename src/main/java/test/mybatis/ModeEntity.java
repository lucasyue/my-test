package test.mybatis;

import java.math.BigDecimal;
import java.util.Date;

public class ModeEntity {
	
	private String modeId;
	
	private String parentModeId; //父模式ID

    private String modeName;

    private String modeCode;

    private String modeType;

    private String modeStatus;

    private BigDecimal orgId;

    private String productManager;

    private String productDirector;

    private String modeDesc;
    
    private String capitalLogicDesc;

    private String profitAnalysis;

    private String survivalMechanism;

    private String tradeRivalsUnicode;

    private String tradeRivalsName;

    private String tradeRivalsDesc;

    private String bizGroup;

    private String isDeleted;

    private String createdById;

    private Date createdTime;

    private String lastModifiedById;

    private Date lastModifiedTime;
    
    /**
     * 以下为自定义属性
     */

	private String modeTypeStr; //模式类型名称
	
	private String modeStatusStr; //模式状态名称
	
	private String productManagerUserName; // 产品经理名称
	
	private String productDirectorUserName; // 产品总监名称
	
	private String companyName; // 模式对应子公司名称
	
	private String createByUserName; // 创建人名称

	/**
	 * modeId.
	 *
	 * @return the modeId
	 */
	public String getModeId() {
		return modeId;
	}

	/**
	 * modeId.
	 *
	 * @param modeId the modeId to set
	 */
	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	/**
	 * parentModeId.
	 *
	 * @return the parentModeId
	 */
	public String getParentModeId() {
		return parentModeId;
	}

	/**
	 * parentModeId.
	 *
	 * @param parentModeId the parentModeId to set
	 */
	public void setParentModeId(String parentModeId) {
		this.parentModeId = parentModeId;
	}

	/**
	 * modeName.
	 *
	 * @return the modeName
	 */
	public String getModeName() {
		return modeName;
	}

	/**
	 * modeName.
	 *
	 * @param modeName the modeName to set
	 */
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	/**
	 * modeCode.
	 *
	 * @return the modeCode
	 */
	public String getModeCode() {
		return modeCode;
	}

	/**
	 * modeCode.
	 *
	 * @param modeCode the modeCode to set
	 */
	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}

	/**
	 * modeType.
	 *
	 * @return the modeType
	 */
	public String getModeType() {
		return modeType;
	}

	/**
	 * modeType.
	 *
	 * @param modeType the modeType to set
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	/**
	 * modeStatus.
	 *
	 * @return the modeStatus
	 */
	public String getModeStatus() {
		return modeStatus;
	}

	/**
	 * modeStatus.
	 *
	 * @param modeStatus the modeStatus to set
	 */
	public void setModeStatus(String modeStatus) {
		this.modeStatus = modeStatus;
	}

	/**
	 * orgId.
	 *
	 * @return the orgId
	 */
	public BigDecimal getOrgId() {
		return orgId;
	}

	/**
	 * orgId.
	 *
	 * @param orgId the orgId to set
	 */
	public void setOrgId(BigDecimal orgId) {
		this.orgId = orgId;
	}

	/**
	 * productManager.
	 *
	 * @return the productManager
	 */
	public String getProductManager() {
		return productManager;
	}

	/**
	 * productManager.
	 *
	 * @param productManager the productManager to set
	 */
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}

	/**
	 * productDirector.
	 *
	 * @return the productDirector
	 */
	public String getProductDirector() {
		return productDirector;
	}

	/**
	 * productDirector.
	 *
	 * @param productDirector the productDirector to set
	 */
	public void setProductDirector(String productDirector) {
		this.productDirector = productDirector;
	}

	/**
	 * modeDesc.
	 *
	 * @return the modeDesc
	 */
	public String getModeDesc() {
		return modeDesc;
	}

	/**
	 * modeDesc.
	 *
	 * @param modeDesc the modeDesc to set
	 */
	public void setModeDesc(String modeDesc) {
		this.modeDesc = modeDesc;
	}

	/**
	 * capitalLogicDesc.
	 *
	 * @return the capitalLogicDesc
	 */
	public String getCapitalLogicDesc() {
		return capitalLogicDesc;
	}

	/**
	 * capitalLogicDesc.
	 *
	 * @param capitalLogicDesc the capitalLogicDesc to set
	 */
	public void setCapitalLogicDesc(String capitalLogicDesc) {
		this.capitalLogicDesc = capitalLogicDesc;
	}

	/**
	 * profitAnalysis.
	 *
	 * @return the profitAnalysis
	 */
	public String getProfitAnalysis() {
		return profitAnalysis;
	}

	/**
	 * profitAnalysis.
	 *
	 * @param profitAnalysis the profitAnalysis to set
	 */
	public void setProfitAnalysis(String profitAnalysis) {
		this.profitAnalysis = profitAnalysis;
	}

	/**
	 * survivalMechanism.
	 *
	 * @return the survivalMechanism
	 */
	public String getSurvivalMechanism() {
		return survivalMechanism;
	}

	/**
	 * survivalMechanism.
	 *
	 * @param survivalMechanism the survivalMechanism to set
	 */
	public void setSurvivalMechanism(String survivalMechanism) {
		this.survivalMechanism = survivalMechanism;
	}

	/**
	 * tradeRivalsUnicode.
	 *
	 * @return the tradeRivalsUnicode
	 */
	public String getTradeRivalsUnicode() {
		return tradeRivalsUnicode;
	}

	/**
	 * tradeRivalsUnicode.
	 *
	 * @param tradeRivalsUnicode the tradeRivalsUnicode to set
	 */
	public void setTradeRivalsUnicode(String tradeRivalsUnicode) {
		this.tradeRivalsUnicode = tradeRivalsUnicode;
	}

	/**
	 * tradeRivalsName.
	 *
	 * @return the tradeRivalsName
	 */
	public String getTradeRivalsName() {
		return tradeRivalsName;
	}

	/**
	 * tradeRivalsName.
	 *
	 * @param tradeRivalsName the tradeRivalsName to set
	 */
	public void setTradeRivalsName(String tradeRivalsName) {
		this.tradeRivalsName = tradeRivalsName;
	}

	/**
	 * tradeRivalsDesc.
	 *
	 * @return the tradeRivalsDesc
	 */
	public String getTradeRivalsDesc() {
		return tradeRivalsDesc;
	}

	/**
	 * tradeRivalsDesc.
	 *
	 * @param tradeRivalsDesc the tradeRivalsDesc to set
	 */
	public void setTradeRivalsDesc(String tradeRivalsDesc) {
		this.tradeRivalsDesc = tradeRivalsDesc;
	}

	/**
	 * bizGroup.
	 *
	 * @return the bizGroup
	 */
	public String getBizGroup() {
		return bizGroup;
	}

	/**
	 * bizGroup.
	 *
	 * @param bizGroup the bizGroup to set
	 */
	public void setBizGroup(String bizGroup) {
		this.bizGroup = bizGroup;
	}

	/**
	 * isDeleted.
	 *
	 * @return the isDeleted
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * isDeleted.
	 *
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * createdById.
	 *
	 * @return the createdById
	 */
	public String getCreatedById() {
		return createdById;
	}

	/**
	 * createdById.
	 *
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	/**
	 * createdTime.
	 *
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * createdTime.
	 *
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * lastModifiedById.
	 *
	 * @return the lastModifiedById
	 */
	public String getLastModifiedById() {
		return lastModifiedById;
	}

	/**
	 * lastModifiedById.
	 *
	 * @param lastModifiedById the lastModifiedById to set
	 */
	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	/**
	 * lastModifiedTime.
	 *
	 * @return the lastModifiedTime
	 */
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * lastModifiedTime.
	 *
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	/**
	 * modeTypeStr.
	 *
	 * @return the modeTypeStr
	 */
	public String getModeTypeStr() {
		return modeTypeStr;
	}

	/**
	 * modeTypeStr.
	 *
	 * @param modeTypeStr the modeTypeStr to set
	 */
	public void setModeTypeStr(String modeTypeStr) {
		this.modeTypeStr = modeTypeStr;
	}

	/**
	 * modeStatusStr.
	 *
	 * @return the modeStatusStr
	 */
	public String getModeStatusStr() {
		return modeStatusStr;
	}

	/**
	 * modeStatusStr.
	 *
	 * @param modeStatusStr the modeStatusStr to set
	 */
	public void setModeStatusStr(String modeStatusStr) {
		this.modeStatusStr = modeStatusStr;
	}

	/**
	 * productManagerUserName.
	 *
	 * @return the productManagerUserName
	 */
	public String getProductManagerUserName() {
		return productManagerUserName;
	}

	/**
	 * productManagerUserName.
	 *
	 * @param productManagerUserName the productManagerUserName to set
	 */
	public void setProductManagerUserName(String productManagerUserName) {
		this.productManagerUserName = productManagerUserName;
	}

	/**
	 * productDirectorUserName.
	 *
	 * @return the productDirectorUserName
	 */
	public String getProductDirectorUserName() {
		return productDirectorUserName;
	}

	/**
	 * productDirectorUserName.
	 *
	 * @param productDirectorUserName the productDirectorUserName to set
	 */
	public void setProductDirectorUserName(String productDirectorUserName) {
		this.productDirectorUserName = productDirectorUserName;
	}

	/**
	 * companyName.
	 *
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * companyName.
	 *
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * createByUserName.
	 *
	 * @return the createByUserName
	 */
	public String getCreateByUserName() {
		return createByUserName;
	}

	/**
	 * createByUserName.
	 *
	 * @param createByUserName the createByUserName to set
	 */
	public void setCreateByUserName(String createByUserName) {
		this.createByUserName = createByUserName;
	}

}
