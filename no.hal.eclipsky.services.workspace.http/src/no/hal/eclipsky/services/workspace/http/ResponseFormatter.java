package no.hal.eclipsky.services.workspace.http;

import java.io.PrintWriter;
import java.util.Stack;

public abstract class ResponseFormatter {

	protected int indentLevel = 0;
	protected String indentString = "\t";
	
	protected final PrintWriter printWriter;

	public ResponseFormatter(PrintWriter printWriter) {
		super();
		this.printWriter = printWriter;
	}

	// general formatting
	
	protected void indent(int indentLevel, String indentString) {
		for (int i = 0; i < indentLevel; i++) {
			printWriter.print(indentString);
		}
	}
	
	public void indent(int indent) {
		indentLevel += indent;
	}

	public ResponseFormatter indent() {
		indent(indentLevel, indentString);
		return this;
	}

	public ResponseFormatter newline(int indent) {
		newline();
		indent(indent);
		indent();
		return this;
	}

	public ResponseFormatter newline() {
		printWriter.println();
		return this;
	}
	
	public CharSequence escape(CharSequence cs) {
		return cs;
	}

	// stack of delimiters
	
	protected Stack<Object> contextStack = new Stack<Object>();

	protected void pushDelimiter(Object delimiter) {
		contextStack.push(delimiter);
	}

	protected Object popDelimiter() {
		return contextStack.pop();
	}
	
	protected void writeDelimiter(Object delimiter) {
		if (delimiter != null) {
			String delimiterString = String.valueOf(delimiter);
			printWriter.write(delimiterString);
			if (delimiterString.endsWith("\n")) {
				indent();
			}
		}
	}

	protected void writeDelimiter() {
		if (! contextStack.empty()) {
			writeDelimiter(contextStack.peek());
		}
	}
	
	protected void pushName(String name) {
		contextStack.push(name);
	}

	protected String popName() {
		return String.valueOf(contextStack.pop());
	}	

	protected void pop(int n) {
		while (n-- > 0) {
			contextStack.pop();
		}
	}

	// attributes
	
	protected abstract ResponseFormatter startAttributes();
	protected abstract ResponseFormatter endAttributes();
	
	public abstract ResponseFormatter attributeUnescaped(String name, CharSequence cs);
	
	public ResponseFormatter attribute(String name, Object o) {
		return attributeUnescaped(name, escape(String.valueOf(o)));
	}
	
	// entities
	
	protected String toAttributeName(Object o) {
		return o.toString();
	}

	protected abstract ResponseFormatter startEntity(String name);
	public abstract ResponseFormatter endEntity();

	public ResponseFormatter entity(String name, Object... attributeNameValuePairs) {
		startEntity(name);
		startAttributes();
		for (int i = 0; i < attributeNameValuePairs.length; i += 2) {
			attribute(toAttributeName(attributeNameValuePairs[i]), attributeNameValuePairs[i + 1]);
		}
		endAttributes();
		return this;
	}

	protected abstract ResponseFormatter startEntities(String name, boolean multi);
	protected abstract ResponseFormatter endEntities();
}
