package test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
public static void main(String[] args) {
	String resource = "test/mybatis/mybatis-config.xml";
	InputStream inputStream;
	try {
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		String modeId = "0c531d47d1f1492589cc8c4bd4370881";
		try {
			SubmitDataMapper query = (SubmitDataMapper) session.getMapper(SubmitDataMapper.class);
			Pager<TblRskReportLog> pager = new Pager();
			List<TblRskReportLog> logList = query.querySubmitdataByPager(pager );

		  ModeEntity mode = (ModeEntity) session.selectOne("test.mybatis.ModeMapper.selectMode", modeId);
          mode.getModeId();
          mode = null;
          ModeMapper mapper = session.getMapper(ModeMapper.class);
          mode = mapper.selectMode2(modeId);
          mode = null;
          mode = mapper.selectMode(modeId);
          mode.getModeId();   
          mode = null;
          mode = mapper.selectMode3(modeId);
          mode.getModeId();
		} finally {
		  session.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
