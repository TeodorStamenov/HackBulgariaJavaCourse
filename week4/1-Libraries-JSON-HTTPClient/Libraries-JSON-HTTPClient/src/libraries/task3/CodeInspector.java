package libraries.task3;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.theme.ThemeRDark;

public class CodeInspector {

	public static void main(String[] args) {
//		File file = new File("D:\\JavaTraining\\Core-Java-2-master\\week4\\Libraries-JSON-HTTPClient\\Libraries-JSON-HTTPClient\\src\\libraries\\task2\\JToaster.java");
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// the SyntaxHighlighter parser
				SyntaxHighlighterParser parser = new SyntaxHighlighterParser(
						new BrushXml());
				// turn HTML script on
				parser.setHtmlScript(true);
				// set HTML Script brushes
				parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(),
						new BrushJScript(), new BrushPhp()));

				// initialize the highlighter and use RDark theme
				SyntaxHighlighter highlighter = new SyntaxHighlighter(parser,
						new ThemeRDark());
				// set the line number count from 10 instead of 1
				highlighter.setFirstLine(1);
				// set to highlight line 13, 27, 28, 38, 42, 43 and 53
				highlighter.setHighlightedLineList(Arrays.asList(23, 24, 25,
						26, 27, 28));
				try {
					highlighter.setContent(new File(args[0]));
				} catch (IOException ex) {
					Logger.getLogger(CodeInspector.class.getName()).log(
							Level.SEVERE, null, ex);
				}

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(highlighter);
				frame.setLocationByPlatform(true);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
