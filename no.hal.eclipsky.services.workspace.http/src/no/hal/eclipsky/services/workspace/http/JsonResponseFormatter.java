package no.hal.eclipsky.services.workspace.http;

import java.io.PrintWriter;

public class JsonResponseFormatter extends ResponseFormatter {
	
	public JsonResponseFormatter(PrintWriter printWriter) {
		super(printWriter);
	}
	
	// attributes

	@Override
	protected ResponseFormatter startAttributes() {
		pushDelimiter(", ");
		return this;
	}

	@Override
	protected ResponseFormatter endAttributes() {
		pop(1);
		return this;
	}

	private void attribute(String name, String s, boolean quote) {
		printWriter.write("\"" + name + "\": ");
		if (quote) {
			printWriter.write("\"");
		}
		printWriter.write(s);
		if (quote) {
			printWriter.write("\"");
		}
	}
	
	@Override
	public ResponseFormatter attributeUnescaped(String name, CharSequence cs) {
		attribute(name, cs.toString(), true);
		return this;
	}
	
	protected boolean noQuotes(Object o) {
		return o instanceof Number || o instanceof Boolean;
	}

	public ResponseFormatter attribute(String name, Object o) {
		writeDelimiter();
		if (noQuotes(o)) {
			attribute(name, o.toString(), false);
		} else {
			super.attribute(name, o);
		}
		return this;
	}

	@Override
	public CharSequence escape(CharSequence cs) {
		return escapeJson(cs);
	}

	public static CharSequence escapeJson(CharSequence cs) {
		// quotes,\, /, \r, \n, \b, \f, \t
		StringBuilder buffer = new StringBuilder(cs.length() + 20);
		for (int i = 0; i < cs.length(); ++i) {
			char c = cs.charAt(i);
			switch (c) {
			case '"': case '\\': case '/':
			case '\r': case '\n': case '\b': case '\f': case '\t':
				buffer.append("\\");
				buffer.append(c);
				break;
			default: buffer.append(c);
			}
		}
		return buffer;
	}
	
	// entities
	
	@Override
	public ResponseFormatter startEntity(String name) {
		writeDelimiter(popDelimiter());
		pushDelimiter(", \n");
		printWriter.write("{ ");
		attributeUnescaped("_type_", name);
		return this;
	}

	@Override
	public ResponseFormatter endEntity() {
		printWriter.write(" }");
		return this;
	}

	@Override
	protected ResponseFormatter startEntities(String name, boolean multi) {
		if (! contextStack.isEmpty()) {
			printWriter.write("\"" + name + "\": ");
		}
		if (multi) {
			printWriter.write("[");
			pushDelimiter("]");
		} else {
			pushDelimiter(null);
		}
		indent(1);
		pushDelimiter("\n");
		return this;
	}

	@Override
	protected ResponseFormatter endEntities() {
		pop(1);
		newline(-1);
		writeDelimiter(popDelimiter());
		return this;
	}
}
