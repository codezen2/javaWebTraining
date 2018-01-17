package bankservice;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.sapient.service.ISer;
import com.sapient.service.SimpleSer;
import com.sapient.service2.CompoundSer;
import com.sapient.service2.Iser2;

public class Activator extends AbstractUIPlugin {

	private ServiceRegistration register;
	
	public Activator() {
	}
	public void start(BundleContext context) throws Exception {
		// super.start(context);
		ISer ser= new SimpleSer();
		context.registerService(ISer.class.getName(),ser,null);
		
		System.out.println("Simple Interest Api is Registered");
		
		Iser2 ser2= new CompoundSer();		
		context.registerService(Iser2.class.getName(),ser2,null);
		System.out.println("Compund Interest Api is Registered");
		System.out.println("Bundle Started");
	}

	public void stop(BundleContext context) throws Exception {
		
		register.unregister();
		super.stop(context);
		System.out.println("Bundle Stopped");

	}
}
