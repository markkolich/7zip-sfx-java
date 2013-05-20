/**
 * Copyright (c) 2013 Mark S. Kolich
 * http://mark.koli.ch
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.kolich.sevenzip.example;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class StartHere {
	
	private final File workingDir_;
	private final File tempDir_;
	
	public StartHere(File root, File temp){
		workingDir_ = root;
		tempDir_ = temp;
	}
	
	/**
	 * The working directory, where the application was
	 * started from.
	 * @return
	 */
	public File getWorkingDir(){
		return workingDir_;
	}
	
	/**
	 * The temp directory, where the launcher extracted
	 * your app and JRE to on the users' system.
	 * @return
	 */
	public File getTempDir(){
		return tempDir_;
	}

	public static void main(String[] args)
		throws Exception {
		
		File root;
		try {
			root = new File(args[0]);
		} catch ( Exception e ) {
			root = new File(".");
		}
		
		File temp;
		try {
			temp = new File(args[1]);
		} catch ( Exception e ) {
			temp = new File(".");
		}
		
		final StartHere sh = new StartHere(root, temp);		
		Runnable worker = new Runnable() {
		    @Override
			public void run() {
		    	showMessageDialog(sh);
		    	System.exit(0);
		    }
		};
		SwingUtilities.invokeLater(worker);
		
	}
	
	private static void showMessageDialog(StartHere sh) {
		try {
			JOptionPane.showMessageDialog(new JFrame(),
				"A java app launched by 7zip SFX!\n\n" +
				"My working directory is:\n" +
				sh.getWorkingDir().getCanonicalPath() +
				"\n\nAnd I've been extracted to temp directory:\n" +
				sh.getTempDir().getCanonicalPath() );
		} catch (IOException e) {
			e.printStackTrace( System.err );
		}
	}
	
}
