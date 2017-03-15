package test;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class TestOverrideImpl implements TestOverride{
	public static void main(String[] args) {
		
		TestOverrideImpl i=new TestOverrideImpl();
		String businessId = null;
		List<String> businessIds = null;
		String oldAssignee = null;
		String newAssignee = null;
		String varName = null;
		System.out.println(null==varName);
		System.out.println(StringUtils.isNotBlank(""));
		i.changeAssignee(businessId, oldAssignee, newAssignee, null);
		i.changeAssignee(businessIds, oldAssignee, newAssignee, varName);
	}
	@Override
	public void changeAssignee(String businessId, String oldAssignee, String newAssignee, String varName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAssignee(List<String> businessIds, String oldAssignee, String newAssignee, String varName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAssignee(List<String> businessIds, String oldAssignee, String newAssignee, Set<String> varNames) {
		// TODO Auto-generated method stub
		
	}

}
