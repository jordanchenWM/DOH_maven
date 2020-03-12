package internal.server.util;

public class Usage {
	
	public static void main(String[] args) {
		System.out.println(Usage.getUsage());
	}
	
	public static String getUsage() {
		Runtime rt = Runtime.getRuntime();
		long t = rt.totalMemory() / 1024 /1024;
		long f = rt.freeMemory() / 1024 /1024;
		String s = String.format("Total: %s, Free: %s", t, f);
		
		 System.out.println("MB: " + (double) f / 1024 / 1024);
	       
		//MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();

		return s;
	}
}
