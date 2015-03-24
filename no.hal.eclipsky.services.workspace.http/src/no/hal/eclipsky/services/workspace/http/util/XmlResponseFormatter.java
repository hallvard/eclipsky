package no.hal.eclipsky.services.workspace.http.util;

import java.io.PrintWriter;

public class XmlResponseFormatter extends ResponseFormatter {

	public XmlResponseFormatter(PrintWriter printWriter) {
		super(printWriter);
	}

	// attributes

	@Override
	protected ResponseFormatter startAttributes() {
		pushDelimiter(" ");
		return this;
	}

	private void closeTag() {
		printWriter.write(">");
	}
	
	@Override
	protected ResponseFormatter endAttributes() {
		pop(1);
		closeTag();
		return this;
	}

	@Override
	public ResponseFormatter attributeUnescaped(String name, CharSequence cs) {
		writeDelimiter();
		printWriter.print(name + "=\"" + cs + "\"");
		return this;
	}
	
	@Override
	public CharSequence escape(CharSequence cs) {
		return escapeHtml(cs);
	}

	public static CharSequence escapeHtml(CharSequence cs) {
		StringBuilder buffer = new StringBuilder(cs.length() + 20);
		for (int i = 0; i < cs.length(); ++i) {
			char c = cs.charAt(i);
			switch (c) {
			case '<': buffer.append("&lt;"); break;
			case '>': buffer.append("&gt;"); break;
			case '&': buffer.append("&amp;"); break;
			case '"': buffer.append("&quot;"); break;
			default: buffer.append(c);
			}
		}
		return buffer;
	}

	// entitites
	
	private void startTag(String name, boolean closeTag) {
		writeDelimiter();
		printWriter.write("<" + name);
		pushName(name);
		indent(1);
		pushDelimiter("\n");
		if (closeTag) {
			closeTag();
		}
	}
	private ResponseFormatter endTag(boolean newlineBefore) {
		pop(1);
		indent(-1);
		if (newlineBefore) {
			newline(0);
		}
		printWriter.write("</" + popName() + ">");
		return this;
	}
	
	@Override
	public ResponseFormatter startEntity(String name) {
		startTag(name, false);
		return this;
	}

	@Override
	public ResponseFormatter endEntity() {
		endTag(false);
		return this;
	}

	@Override
	public ResponseFormatter startEntities(String name, boolean multi) {
		startTag(name, true);
		return null;
	}

	@Override
	public ResponseFormatter endEntities() {
		indent(-1);
		endTag(true);
		return this;
	}
}
