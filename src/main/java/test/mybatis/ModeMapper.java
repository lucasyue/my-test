package test.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ModeMapper {
	@Select(value = { "select * from TBL_RSK_MODE where mode_id = #{modeId}" })
	public ModeEntity selectMode2(String modeId);
	
	public ModeEntity selectMode(@Param("modeId") String modeId);
	
	public ModeEntity selectMode3(@Param("modeId") String modeId);

	public List<ModeEntity> queryModeAndSubModeList(Map<String, Object> paramMap);

	public List<ModeEntity> getSubmodeListByPidInYp(@Param("modeId") String modeId, @Param("meetingId") String meetingId);
}