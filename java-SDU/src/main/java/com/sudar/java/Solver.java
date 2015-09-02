package com.sudar.java;

import java.util.ArrayList;
import java.util.List;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.model.FilesList;
import com.sudar.java.model.Parameter;

public class Solver extends Thread {
	
	List<FileStream> fsl = new ArrayList<FileStream>();
	
	@Override
	public void run() {
		loadFiles();
		for (int i=0; i < fsl.size(); i++) {
			SDUThread_ tempSDU = new SDUThread_(fsl.get(i));
			tempSDU.start();
		}
	}
	
	private void loadFiles() {
		FilesList fl = LoadXmlToObject.getFilesList();
		for (int i = 0; i < fl.getFile().size(); i++) {
			/*if (fl.getFile().get(i).getStartCalc() != 0)*/ {
				//return fl.getFile().get(i);
				final Parameter parameter = fl.getFile().get(i).getParameter();
				FileStream fs = new FileStream();
				fs.setParameter(parameter);
				fs.setTetaNumber(0);
				fsl.add(fs);
			}
		}
	}
}
