package com.sapient.js;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo2 {

	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		try {
			jsEngine.eval(new FileReader("myscript.js"));
			Invocable invocable=(Invocable) jsEngine;
			
			Object res=invocable.invokeFunction("multiply", 10,2);
			System.out.println(res);
			
		} catch (FileNotFoundException | ScriptException | NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
