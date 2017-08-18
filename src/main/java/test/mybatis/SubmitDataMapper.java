package test.mybatis;

import java.util.List;

public interface SubmitDataMapper {
	public List<TblRskReportLog> querySubmitdataByPager(Pager<TblRskReportLog> pager);
}