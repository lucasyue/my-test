package test;

import java.util.List;
import java.util.Set;

public interface TestOverride {
	void changeAssignee(String businessId, String oldAssignee,String newAssignee, String varName);
	
	void changeAssignee(List<String> businessIds, String oldAssignee,String newAssignee, String varName);

	void changeAssignee(List<String> businessIds, String oldAssignee, String newAssignee, Set<String> varNames);

}
