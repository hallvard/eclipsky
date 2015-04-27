package no.hal.eclipsky.services.sourceeditor;

import no.hal.emfs.AbstractStringContents;
import no.hal.emfs.util.StringAccumulator;

public class CharacterPosition {
	
	private int line = 0, column = 0, position = 0;
	
	@Override
	public String toString() {
		return position + "@" + line + "/" + column;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getPosition() {
		return position;
	}
	
	static class Accumulator implements StringAccumulator<CharacterPosition> {

		private AbstractStringContents upto;
		private boolean active = true;
		
		public Accumulator(AbstractStringContents upto) {
			this.upto = upto;
		}

		@Override
		public CharacterPosition accumulate(CharacterPosition acc, String content, AbstractStringContents context) {
			if (context == upto) {
				active = false;
			} else if (active) {
				char last = '\0';
				for (int i = 0; i < content.length(); i++) {
					char c = content.charAt(i);
					if (c == '\r' || (c == '\n' && last != '\r')) {
						acc.line++;
						acc.column = 0;
					} else {
						acc.column++;
					}
					acc.position++;
					last = c;
				}
			}
			return null;
		}
	}
}
