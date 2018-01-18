package com.sapient.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo1 {

	public static void main(String[] args) {

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");

		try {
			jsEngine.eval("print('Hello World!')");
			jsEngine.eval("print(parseInt('5')+parseInt('10'))");

		} catch (ScriptException e) {
			System.out.println(e.getMessage());
		}

	}

}
