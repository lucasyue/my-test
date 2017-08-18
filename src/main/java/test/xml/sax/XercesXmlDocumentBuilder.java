/*
 * This file is part of Dorado 7.x (http://dorado7.bsdn.org).
 * 
 * Copyright (c) 2002-2012 BSTEK Corp. All rights reserved.
 * 
 * This file is dual-licensed under the AGPLv3 (http://www.gnu.org/licenses/agpl-3.0.html) 
 * and BSDN commercial (http://www.bsdn.org/licenses) licenses.
 * 
 * If you are unsure which license is appropriate for your use, please contact the sales department
 * at http://www.bstek.com/contact.
 */

package test.xml.sax;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.bstek.dorado.core.Constants;
import com.bstek.dorado.core.io.Resource;
import com.bstek.dorado.core.xml.XmlDocumentBuilder;

/**
 * XML读取工具类的默认实现。
 * 
 * @author Benny Bao (mailto:benny.bao@bstek.com)
 * @since Feb 15, 2007
 */
public class XercesXmlDocumentBuilder implements XmlDocumentBuilder {
	private static final Log logger = LogFactory
			.getLog(XercesXmlDocumentBuilder.class);

	protected DocumentBuilder getDocumentBuilder()
			throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		factory.setValidating(false);
		factory.setSchema(null);
		
		return factory.newDocumentBuilder();
	}

	public Document newDocument() throws Exception {
		return getDocumentBuilder().newDocument();
	}

	public Document loadDocument(Resource resource) throws Exception {
		System.out.println(resource);
		if (logger.isDebugEnabled()) {
			logger.debug("Loading XML from " + resource);
		}

		InputStream in = resource.getInputStream();
		try {
			DocumentBuilder build = getDocumentBuilder();
			build.setEntityResolver(new EntityResolver() {
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					if (logger.isDebugEnabled()) {
						System.out.println("I'm asked to resolve: " + publicId + " / " + systemId);
					}
					return new InputSource(new ByteArrayInputStream(new byte[0]));
				}
			});
		    return build.parse(in);
		} finally {
			in.close();
		}
	}

	public Document loadDocument(Resource resource, String charset)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("Loading XML from " + resource);
		}

		if (StringUtils.isEmpty(charset)) {
			charset = Constants.DEFAULT_CHARSET;
		}

		InputStream in = resource.getInputStream();
		Reader reader = new InputStreamReader(in, charset);
		try {
			DocumentBuilder build = getDocumentBuilder();
			InputSource isource = new InputSource(reader);
			return build.parse(isource);
		} finally {
			reader.close();
			in.close();
		}
	}
}