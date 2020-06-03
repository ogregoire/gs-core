package net.geertvos.gvm.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.geertvos.gvm.bridge.NativeMethodWrapper;
import net.geertvos.gvm.core.Type;

/**
 * Represents a program that can be executed by the GVM. A program contains
 * functions and string constants.
 * 
 * @author geertvos
 *
 */
public class GVMProgram {

	private final String name;
	private final List<GVMFunction> functions = new ArrayList<GVMFunction>();
	private List<String> stringConstants = new ArrayList<String>();
	private List<NativeMethodWrapper> nativeWrappers = new ArrayList<NativeMethodWrapper>();
	private Map<String,Type> types = new HashMap<String,Type>();

	public GVMProgram(String name) {
		this.name = name;
	}

	public void addFunction(GVMFunction f, int index) {
		functions.add(index, f);
	}

	public void addString(String s, int index) {
		stringConstants.add(index, s);
	}

	public int addString(String s) {
		if (!stringConstants.contains(s))
			stringConstants.add(s);
		return stringConstants.indexOf(s);
	}

	public int findString(String s) {
		return stringConstants.indexOf(s);
	}
	
	public String getString(int i) {
		return stringConstants.get(i);
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the main function for this program.
	 * 
	 * @return
	 */
	public GVMFunction getMain() {
		return functions.get(0);
	}

	public GVMFunction getFunction(int i) {
		return functions.get(i);
	}

	public List<NativeMethodWrapper> getNativeWrappers() {
		return nativeWrappers;
	}

	public boolean add(GVMFunction arg0) {
		return functions.add(arg0);
	}

	public int add(NativeMethodWrapper method) {
		nativeWrappers.add(method);
		return nativeWrappers.indexOf(method);
	}

	public List<String> getStringConstants() {
		return stringConstants;
	}

	public int addFunction(GVMFunction function) {
		functions.add(function);
		return functions.indexOf(function);
	}

	public int getFunctionIndex(GVMFunction function) {
		return functions.indexOf(function);
	}

	public void setNatives(List<NativeMethodWrapper> natives) {
		this.nativeWrappers = natives;
	}

	public List<GVMFunction> getFunctions() {
		return functions;
	}

	public Type getType(Type type) {
		return types .get(type);
	}
	
	public void registerType(Type type) {
		this.types.put(type.getName(), type);
	}

}
